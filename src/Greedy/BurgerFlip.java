package Greedy;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class BurgerFlip {
	
	public static void main(String args[])
	{
		Scanner in = new Scanner(System.in);
		int num = in.nextInt();
		ArrayList<Integer> list = new ArrayList<Integer>();
		for(int i = 0; i < num; i++)
		{
			list.add(in.nextInt());
		}
		in.close();
		
		Collections.sort(list);
		int n = num;
		int sum = 0;
		for(int i : list)
		{
			sum += i*n;
			n--;
		}
		
		float result = (float)sum/num;
		System.out.println(String.format("%.3f", result));
	}

}
