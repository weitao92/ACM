package ACPC2017;

import java.util.*;

public class music {
	
	static String[] sample = {"A", "A#", "B", "C", "C#", "D", "D#", "E", "F", "F#", "G", "G#"};
	public static void main(String args[])
	{
		//sample = {"A", "A#", "B", "C", "C#", "D", "D#", "E", "F", "F#", "G", "G#"};
		
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		HashSet<String> set = new HashSet<String>();
		for(int i = 0; i < n; i++)
		{
			set.add(in.next());
		}
		
		ArrayList<String> result1 = new ArrayList<String>();
		for(int i = 0; i < 12; i++)
		{
			String[] current = cal(i);
			HashSet<String> s = new HashSet<String>();
			for(String j : current)
			{
				s.add(j);
			}
			
			boolean result = true;
			for(String t : set)
			{
				if(!s.contains(t))
				{
					result = false;
					break;
				}
			}
			
			if(result)
			{
				result1.add(sample[i]);
			}
			
		}
		
		if(result1.size() == 0)
		{
			System.out.println("none");
		}
		else
		{
			StringBuilder sb = new StringBuilder();
			for(String s : result1)
			{
				sb.append(s + " ");
			}
			System.out.println(sb);
		}
	}
	
	private static String[] cal(int start)
	{
		String[] result = new String[8];
		result[0] = sample[start];
		result[1] = sample[(start + 2)%12];
		result[2] = sample[(start + 4)%12];
		result[3] = sample[(start + 5)%12];
		result[4] = sample[(start + 7)%12];
		result[5] = sample[(start + 9)%12];
		result[6] = sample[(start + 11)%12];
		result[7] = sample[(start + 12)%12];
		return result;
	}

}
