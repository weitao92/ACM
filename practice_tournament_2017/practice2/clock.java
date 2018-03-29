package practice2;

import java.math.BigInteger;
import java.util.ArrayDeque;
import java.util.Collections;
import java.util.Scanner;
import java.util.ArrayList;

public class clock {
	
	public static void main(String args[])
	{
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		StringBuilder result = new StringBuilder();
		
		while(n != 0)
		{
			int[] oneDay = new int[n];
			simulate(n, oneDay);
			BigInteger answer = BigInteger.valueOf(1);// unit is 1 day.
			
			for(int i = 0; i < n; i++) 
	        {  
	            long count = 1;
	            int det = oneDay[i];
	            if(det == i)
	            {
	            	continue;
	            }
	            
	            while(det != i)
	            {
	            	//BigInteger one = new BigInteger("1");
	            	count++;
	            	//System.out.println(count);
	            	det = oneDay[det];
	            }
	            
	            
	            
	            answer = answer.divide(BigInteger.valueOf(count).gcd(answer))
                        .multiply(BigInteger.valueOf(count));
	        }  
			
			result.append(n + " balls cycle after " + answer + " days.\n");
			//System.out.println(n + " balls cycle after " + answer + " days.");
			n = in.nextInt();
		}
		
		System.out.print(result);
		in.close();
	}
	
	static void simulate(int n, int[] oneDay)
	{
		ArrayDeque<Integer> queue = new ArrayDeque<Integer>();
		ArrayList<Integer> min = new ArrayList<Integer>();
		ArrayList<Integer> five = new ArrayList<Integer>();
		ArrayList<Integer> hour = new ArrayList<Integer>();
		
		
		for(int i = 0; i < n; i++)
		{
			queue.addLast(i);
		}
		
		for(int j = 0; j < 1440; j++)// simulate for one day.
		{
			int num = queue.removeFirst();
			
			if(min.size() == 4)
			{
				Collections.reverse(min);
				queue.addAll(min);
				min.clear();
				/**
				for(int i = 3; i >= 0; i--)  
	            {  
	                queue.addLast(min.remove(i));
	            } 
	            **/
				if(five.size() == 11) 
	            {  
					Collections.reverse(five);
					queue.addAll(five);
					five.clear();
					/**
	                for(int i = 10; i >= 0; i--)  
	                {  
	                    queue.addLast(five.remove(i)); 
	                }  
	                **/
	                if(hour.size() == 11)
	                {  
	                	Collections.reverse(hour);
	    				queue.addAll(hour);
	    				hour.clear();
	    				/**
	                    for(int i = 10; i >= 0; i--)  
	                    {  
	                        queue.addLast(hour.remove(i)); 
	                    }  
	                    **/
	                    queue.add(num);
	                }  
	                else  
	                {
	                    hour.add(num);  
	                }
	            }  
	            else  
	            {
	                five.add(num);  
	            }
			}
			else
			{
				min.add(num);
			}
		}
		
		for(int i = 0; i < n; i++)
		{
			oneDay[i] = queue.removeFirst(); //store for one day.
		}
		
	}
	
	
}