package practice1;

import java.util.LinkedList;
import java.util.Scanner;

public class gcd {
	
	public static void main(String args[])
	{
		Scanner in = new Scanner(System.in);
		int m = in.nextInt();
		int n = in.nextInt();
		in.close();
		GCD(m,n);
	}
	
	private static void GCD(int m, int n)
	{
		int previous;
		int current;
		
		if(m >= n)
		{
			previous = m;
			current = n;
		}
		else
		{
			previous = n;
			current = m;
		}
		
		LinkedList<Integer> queue = new LinkedList<Integer>();
		while(current != 0)
		{
			int q = previous / current;
			queue.addLast(q);
			int r = previous % current;
			previous = current;
			current = r;
		}
		
		System.out.println("The gcd of " + m + " and " + n + " is: " + previous);
		queue.removeLast();
		int first = 1;
		int second = 0 - queue.removeLast();
		
		while(!queue.isEmpty())
		{
			int q = queue.removeLast();
			int temp = second;
			second = first + second * (0 - q);
			first = temp;
		}
		
		int bigger, smaller;
		if(m >= n)
		{
			bigger = m;
			smaller = n;
		}
		else
		{
			bigger = n;
			smaller = m;
		}
		
		System.out.println(previous + " = " + first + " * " + bigger + " + " + second + " * " + smaller);
	}

}
