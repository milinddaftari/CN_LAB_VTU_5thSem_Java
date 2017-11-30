import java.net.*;
import java.io.*;

public class contentclient
{
	public static void main(String ar[])throws IOException
	{
		Socket sock = new Socket("127.0.0.1",9000);
		System.out.println("Enter the file name");
		BufferedReader keyread = new BufferedReader(new InputStreamReader(System.in));
		String fname = keyread.readLine();
		OutputStream ostream = sock.getOutputStream();
		PrintWriter pwrite = new PrintWriter(ostream,true);
		pwrite.println(fname);
		InputStream istream = sock.getInputStream();
		BufferedReader sr = new BufferedReader(new InputStreamReader(istream));
		String str;
		while((str=sr.readLine())!=null)
		{
			System.out.println(str);
		}
		
		sr.close();
		pwrite.close();
		keyread.close();
	}
}
