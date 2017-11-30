import java.util.Scanner;
public class bf
{
	private int D[],num;
	public static final int max = 999;

	public bf(int num)
	{
		this.num = num;
		D = new int[num+1];
	}

	public void bfevaluation(int src,int A[][])
	{
		int node,sn,dn;
		for(node = 1;node <=num;node++)
		{
			D[node] = max;
		}

		D[src] = 0;

		for(node=1;node<=num-1;node++)
		{
			for(sn=1;sn<=num;sn++)
			{
				for(dn=1;dn<=num;dn++)
				{
					if(A[sn][dn]!=max)
					{
						if(D[dn]>D[sn]+A[sn][dn])
						{
							D[dn] = D[sn] + A[sn][dn];
						}
					}
				}
			}
		}

		for(sn=1;sn<=num;sn++)
		{
			for(dn=1;dn<=num;dn++)
			{
				if(A[sn][dn]!=max)
				{
					if(D[dn]>D[sn] + A[sn][dn])
					{
						System.out.println("\nGraph containg negative edge cycle\n");
					}
				}
			}
		}

		for(int vertex = 1; vertex <=num ; vertex++)
		{
			System.out.println("Distance of source " + src + " to " + vertex + " is " + D[vertex]);
		}
	}

	public static void main(String[] args) 
	{
		int num = 0,src,sn,dn;

		Scanner in = new Scanner(System.in);
		System.out.println("Enter the number of vertices : ");
		num = in.nextInt();
		int A[][] = new int[num+1][num+1];
		System.out.println("Enter the adjacency matrix\n");
		for(sn=1;sn<=num;sn++)
		{
			for(dn=1;dn<=num;dn++)
			{
				A[sn][dn] = in.nextInt();
				if(sn==dn)
				{
					A[sn][dn] = 0;
					continue;
				}
				if(A[sn][dn]==0)
					A[sn][dn] = max;
			}
		}

		System.out.println("\nEnter the source vertex : ");
		src = in.nextInt();
		bf b = new bf(num);
		b.bfevaluation(src,A);
		in.close();
	}
}