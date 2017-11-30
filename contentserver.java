import java.io.*;
import java.net.*;
public class contentserver
{
	public static void main(String ar[])throws Exception
	{
		ServerSocket ss = new ServerSocket(9000);
		System.out.println("Server ready for connection");
		Socket socket = ss.accept();
		System.out.println("Connection is successfull and waiting for chatting ");
		InputStream istream = socket.getInputStream();
		BufferedReader fileread = new BufferedReader(new InputStreamReader(istream));
		String fname = fileread.readLine();
		BufferedReader contentRead = new BufferedReader(new FileReader(fname));
		OutputStream ostream = socket.getOutputStream();
		PrintWriter pwrite = new PrintWriter(ostream,true);
		String str;
		while((str = contentRead.readLine())!=null)
		{
			pwrite.println(str);
		}
		socket.close();
		ss.close();
		pwrite.close();
		fileread.close();
		contentRead.close();
	}
}
