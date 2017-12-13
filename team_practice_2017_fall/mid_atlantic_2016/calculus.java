package mid_atlantic_2016;

import java.util.Scanner;

public class calculus {

	public static void main(String args[])
	{
		Scanner in = new Scanner(System.in);
		
		int n = in.nextInt();
		int[] layers = new int[n];
		int[] first = new int[n];
		
		for(int i = 0; i < n; i++)
		{
			first[i] = in.nextInt();
			
		}
		layers[0] = first[n-1];
		in.close();
		
		int[] current = first;
		int index = 0;
		for(int i = 0; i < n; i++)
		{
			int[] newOne = new int[current.length - 1];
			for(int j = 0; j < current.length - 1; j++)
			{
				newOne[j] = current[j + 1] - current[j];
			}
			
			layers[i + 1] = newOne[newOne.length - 1];
			if(constant(newOne))
			{
				index = i + 1;
				break;
			}
			else
			{
				current = newOne;
			}
		}
		
		int result = 0;
		for(int i = index; i >= 0; i--)
		{
			result += layers[i];
		}
		
		System.out.println(index + " " + result);
	}
	
	private static boolean constant(int[] newOne)
	{
		int value = newOne[0];
		for(int i = 0; i < newOne.length; i++)
		{
			if(newOne[i] != value)
			{
				return false;
			}
		}
		
		return true;
	}
}
