package warmUp;

import java.util.ArrayList;
import java.util.Scanner;

public class tax {
	
	public static void main(String args[])
	{
		Scanner in = new Scanner(System.in);
		int num = in.nextInt();
		int year = 0;
		int[] accounts = new int[9];
		ArrayList<Integer> opened = new ArrayList<Integer>();
		in.nextLine();
		
		for(int i = 0; i < num; i++)
		{
			String line = in.nextLine();
			//System.out.println(line);
			String[] elements = line.split(" ");
			String first = elements[0];
			if(first.equals("opens"))
			{
				int account = Integer.parseInt(elements[2]) - 1;
				opened.add(account);
				year = Integer.parseInt(elements[4]);
			}
			else if(first.equals("contributes"))
			{
				int contribute = Integer.parseInt(elements[1]);
				int account = Integer.parseInt(elements[4]) - 1;
				year = Integer.parseInt(elements[6]);
				accounts[account] += contribute;
			}
			else
			{
				int deduction = Integer.parseInt(elements[1]);
				year = Integer.parseInt(elements[3]);
				
				int real = 0;
				for(int j : opened)
				{
					real += Math.min(4000, accounts[j]);
					accounts[j] -= Math.min(4000, accounts[j]);
				}
				
				if(real != deduction)
				{
					System.out.println("you should have deducted " + real + " in " + year);
					System.exit(0);
				}
			}
		}
		System.out.println("ok");
		in.close();
	}

}
