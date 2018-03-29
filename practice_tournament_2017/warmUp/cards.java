package warmUp;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Scanner;

public class cards {
	
	public static void main(String args[])
	{
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		in.close();
		int length = (int) Math.pow(2, n-1);
		int[][] result = new int[n][length];
		LinkedList<Integer> bag = new LinkedList<Integer>();
		for(int i = 1; i < (int)Math.pow(2, n); i++)
		{
			bag.addLast(i);
		}
		
		if(n == 1)
		{
			System.out.println(1);
			System.exit(0);
		}
		else if(n == 2)
		{
			System.out.println("3 1");
			System.out.println("2 1");
			System.exit(0);
		}
		else
		{
			int last = bag.removeLast();
			for(int i = 0; i < n; i++)
			{
				result[i][0] = bag.removeFirst();
				result[i][length-1] = last;
			}
			
			int arr[] = new int[n];
			for(int i = 0; i < n; i++)
			{
				arr[i] = i;
			}
	        LinkedList<Integer> combos = printCombination(arr, n, 2);
	        int[] indexs = new int[n];
	        Arrays.fill(indexs, 1);
	        for(int i = 0; i < n*(n-1)/2; i++)
	        {
	        	int num = bag.removeFirst();
	        	for(int j = 0; j < 2; j++)
	        	{
	        		int index = combos.removeFirst();
	        		result[index][indexs[index]++] = num;
	        	}      	
	        }
	        int initial = n;
	        
	        if(n >= 4)
	        {
	        	for(int q = 3; q < n; q++)
	        	{
	        		long count = factorial(n)/(factorial(q)*factorial(n-q));
	        		count = count * q / n;
	        		/**
	        		int count = q;
	        		int diff = q;
	        		for(int z = 1; z <= n-1-q; z++)
	        		{
	        			count += diff;
	        			diff++;
	        		}
	        		**/
	        		int arr1[] = new int[n];
	    			for(int x = 0; x < n; x++)
	    			{
	    				arr1[x] = x;
	    			}
	    	        LinkedList<Integer> combos1 = printCombination(arr1, n, q);
	    	        //System.out.println(combos1.size());
	    	        int[] indexss = new int[n];
	    	        Arrays.fill(indexss, initial);
	    	        for(int y = 0; y < n*count/q; y++)
	    	        {
	    	        	int num1 = bag.removeFirst();
	    	        	for(int j = 0; j < q; j++)
	    	        	{
	    	        		//System.out.println(q);
	    	        		int index1 = combos1.removeFirst();
	    	        		//System.out.println(index1);
	    	        		//System.out.println(indexss[index1]);
	    	        		result[index1][indexss[index1]++] = num1;
	    	        	}      	
	    	        }
	    	        initial += count;
	        	}
	        }
		}
		
		StringBuilder result1 = new StringBuilder();
		for(int i = 0; i < n; i++)
		{
			for(int j = 0; j < length; j++)
			{
				result1.append(result[i][j] + " ");
			}
			result1.append("\n");
		}
		System.out.print(result1);
	}
	
	static void combinationUtil(int arr[], int n, int r, int index,
            int data[], int i, LinkedList<Integer> result)
	{
		// Current combination is ready to be printed, print it
		//LinkedList<Integer> result = new LinkedList<Integer>();
		if (index == r)
		{
		for (int j=0; j<r; j++)
		//System.out.print(data[j]+" ");
			result.addLast(data[j]);
		//System.out.println("");
		return;
		}
		
		// When no more elements are there to put in data[]
		if (i >= n)
		return;
		
		// current is included, put next at next location
		data[index] = arr[i];
		combinationUtil(arr, n, r, index+1, data, i+1, result);
		
		// current is excluded, replace it with next (Note that
		// i+1 is passed, but index is not changed)
		combinationUtil(arr, n, r, index, data, i+1, result);
	}
	
	// The main function that prints all combinations of size r
	// in arr[] of size n. This function mainly uses combinationUtil()
	static LinkedList<Integer> printCombination(int arr[], int n, int r)
	{
		// A temporary array to store all combination one by one
		int data[]=new int[r];
		LinkedList<Integer> result = new LinkedList<Integer>();
		// Print all combination using temprary array 'data[]'
		combinationUtil(arr, n, r, 0, data, 0, result);
		return result;
	}
	
	private static long factorial(int n)
	{
		long result = 1;
		for(int i = 1; i <= n; i++)
		{
			result *= i;
		}
		return result;
	}
	
}
