package memSQL;

import java.util.Scanner;
import java.util.TreeMap;

/**
 * codeforce 859E
 * @author weitao92
 *
 */
public class desk {
	
	public static void main(String agrs[])
	{
		Scanner in = new Scanner(System.in);
		
		int n = in.nextInt();
		TreeMap<Integer,Integer> map = new TreeMap<Integer, Integer>();
		long result = 1;
		for(int i = 0; i < n; i++)
		{
			long temp = result;
			result = result * 2;
			int current = in.nextInt();
			int want = in.nextInt();
			
			
			
			if(map.containsKey(current))
			{
				result -= map.get(current);
				//System.out.println(result);
				//continue;
			}
			if(map.containsKey(want))
			{
				result -= map.get(want);
			}
			
			if(map.containsKey(current))
			{
				map.put(current, (int)temp);
			}
			else
			{
				map.put(current, (int)temp);
			}
			
			if(map.containsKey(want))
			{
				map.put(want, (int)temp);
			}
			else
			{
				map.put(want, (int)temp);
			}
			
			if(result >= 1000000007)
			{
				result = result % 1000000007;
			}
		}
		
		System.out.println(result);
	}

}
