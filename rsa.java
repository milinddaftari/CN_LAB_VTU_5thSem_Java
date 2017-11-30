import java.util.Scanner;
import java.util.Random;
import java.math.BigInteger;

public class rsa
{
	private BigInteger p,q,N,phi,e,d;
	private int bitlength = 1024;
	private Random r;

	public rsa()
	{
		r = new Random();
		p=BigInteger.probablePrime(bitlength,r);
		q=BigInteger.probablePrime(bitlength,r);
		e=BigInteger.probablePrime(bitlength/2,r);
		N = p.multiply(q);
		phi = (p.subtract(BigInteger.ONE).multiply(q.subtract(BigInteger.ONE)));
		while(phi.gcd(e).compareTo(BigInteger.ONE) > 0 && e.compareTo(phi) < 0)
			e.add(BigInteger.ONE);
		d = e.modInverse(phi);
	}

	public rsa(BigInteger e , BigInteger d , BigInteger N)
	{
		this.e = e;
		this.d = d;
		this.N = N;
	}

	public static void main(String args[])
	{
		rsa rsa = new rsa();
		Scanner in = new Scanner(System.in);
		System.out.println("\n Enter Plain Text ");
		String teststr = in.nextLine();
		System.out.println("\n Encryption String : " + teststr);
		System.out.println("\n String in bytes " + bytesToString(teststr.getBytes()));

		byte[] encrypted = rsa.encrypt(teststr.getBytes());
		System.out.println("\n Encrypted string is " + bytesToString(encrypted));

		byte[] decrypted = rsa.decrypt(encrypted);
		System.out.println("\n Decrypted String in bytes " + bytesToString(decrypted));
		System.out.println("\n Decrypted String " + new String(decrypted));
	}

	private static String bytesToString(byte[] m)
	{
		String test = " ";
		for(byte b : m)
			test = test + Byte.toString(b);
		return test;
	}

	public byte[] encrypt(byte[] m)
	{
		return(new BigInteger(m).modPow(e,N).toByteArray());
	}

	public byte[] decrypt(byte[] m)
	{
		return(new BigInteger(m).modPow(d,N).toByteArray());
	}
}