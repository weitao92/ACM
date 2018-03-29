package memSQL;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;
/**
 * codeforce 859A
 * @author weitao92
 *
 */
public class contest {
	
	public static void main(String args[])
	{
		Scanner in = new Scanner(System.in);
		
		int K = in.nextInt();
		ArrayList<Integer> list = new ArrayList<Integer>();
		
		for(int i = 0; i < K; i++)
		{
			list.add(in.nextInt());
		}
		
		Collections.sort(list);
		int max = list.get(list.size() - 1);
		
		if(max <= 25)
		{
			System.out.println("0");
		}
		else
		{
			System.out.println(max - 25);
		}
	}

}
