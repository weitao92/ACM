package probability;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

/**
 * https://pcs.cs.cloud.vt.edu/contests/66/problems/B
 * @author weitao92
 *
 */
public class B {
	
	static boolean ss = false;
	static StringBuilder sb = new StringBuilder();
	static ArrayList<String> temp = new ArrayList<String>();
	static ArrayList<String> out = new ArrayList<String>();
	public static void main(String args[])
	{
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		ArrayList<String> list = new ArrayList<String>();
		for(int i = 0; i < n; i++)
		{
			list.add(in.next());
			temp.add("");
			out.add("");
		}
		Collections.sort(list);

		shuffle(list, 0);
		System.out.print(sb);
	}
	
	private static void shuffle(ArrayList<String> list, int index)
	{
		if(index == list.size()-1)
		{
			//ss = true;
			for(String s : list)
			{
				sb.append(s + " ");
			}
			sb.append("\n");
			return;
		}
		
		Collections.copy(out, list);
		Collections.copy(temp, list);
		for(int i = index; i < list.size(); i++)
		{
			//int temp = 0;
			//if(ss)
			Collections.copy(list, temp);
			Collections.swap(list, index, i);
			Collections.copy(temp, list);
			//if(index != i)
			{
				shuffle(list, index+1);
			}
			Collections.copy(list, out);
			Collections.swap(list, index, i);
		}
		Collections.copy(temp, list);
	}

}
