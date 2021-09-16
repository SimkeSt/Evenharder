import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
 
public class stasamisuseskrivio {	
	static BufferedReader dicc=new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter ajd=new BufferedWriter(new OutputStreamWriter(System.out));
	public static void main(String[] args) throws IOException {
		int num=Integer.parseInt(dicc.readLine());
		while (num>0) {
			ajd.write(lajna()+"\n");
			num--;
		}
		ajd.close();
		dicc.close();
	}
	public static int lajna() throws IOException {
		int i;
		int j;
		int n;
		n=Integer.parseInt(dicc.readLine());
		int[] arr = new int[n+1];
		int[][] dinarr=new int[n+1][n+1];
		String[] s=dicc.readLine().split(" ");
		for (i=1;i<=n;i++)
			arr[i]=Integer.parseInt(s[i-1]);
		for (i=2;i<=n;i++)
		{
			int brr=0;
			for (j=i;j<=n;j++)
				dinarr[i][j]=1000000;
			for (j=i-1;j>=1;j--)
				if (j+arr[j]>=i)
					dinarr[i][j+arr[j]]=Math.min(dinarr[i][j+arr[j]],dinarr[j][i-1]+brr++);
			for (j=i+1;j<=n;j++)
				dinarr[i][j] = Math.min(dinarr[i][j],dinarr[i][j-1]);
			//for (int q = 0; q < dp.length; q++) { 
				//for (int w = 0; w < dp[q].length; w++) { 
					//System.out.print(dp[q][w] + " "); } 
				//System.out.println(); 
				//}
		}
		return dinarr[n][n];
	}
}
