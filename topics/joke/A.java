package joke;
import java.util.*;

public class A {
	
	public static void main(String args[])
	{
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		int q = in.nextInt();
		int[] arr = new int[n];
		for(int i = 0; i < n; i++)
		{
			arr[i] = in.nextInt();
		}
		StringBuilder sb = new StringBuilder();
		for(int i = 0; i < q; i++)
		{
			int target = in.nextInt();
			if(Arrays.binarySearch(arr, target) >= 0)
			{
				sb.append("yes\n");
			}
			else
			{
				sb.append("no\n");
			}
		}
		System.out.print(sb);
	}

}
