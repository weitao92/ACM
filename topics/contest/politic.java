package contest;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.Scanner;

public class politic {
	
	public static void main(String args[])
	{
		Scanner scan = new Scanner(System.in);
		
		int n = scan.nextInt();
		int m = scan.nextInt();
		LinkedList <String> candidates = new LinkedList<String>();
		HashMap <String, LinkedList<String>> normals = 
				new LinkedHashMap<String, LinkedList<String>>();
		
		for(int i = 0; i < n; i++)
		{
			candidates.add(scan.next());
		}
		
		for(int i = 0; i < m; i++)
		{
			String fan = scan.next();
			String choice = scan.next();

			if(normals.containsKey(choice))
			{
				normals.get(choice).add(fan);
			}
			else
			{
				LinkedList <String> list = new LinkedList<String>();
				list.add(fan);
				normals.put(choice, list);
			}

		}
		

		for(String candidate : candidates)
		{
			if(normals.containsKey(candidate))
			{
				LinkedList <String> temp = normals.get(candidate);
				for(String supporter : temp)
				{
					System.out.println(supporter);
				}
				
				normals.remove(candidate);
			}
		}
		
		for(String newCandidate : normals.keySet())
		{
			for(String supporter : normals.get(newCandidate))
			{
				System.out.println(supporter);
			}		
		}
		
		scan.close();
		
	}
}