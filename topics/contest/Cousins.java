package contest;

import java.util.ArrayDeque;
import java.util.Scanner;

public class Cousins {
	
	public static void main(String args[])
	{
		Scanner scan = new Scanner(System.in);
		while(true)
		{
			int num = scan.nextInt();
			int target = scan.nextInt();

			
			if(num == 0 && target == 0)
			{
				System.exit(0);
			}
			scan.nextLine();
			
			int root = scan.nextInt();
			ArrayDeque<child> queue = new ArrayDeque<child> ();
			queue.add(new child(root, 0));
			int currentLevel = 1;
			int first = scan.nextInt();
			if(first == target || num == 1 || num == 2)
			{
				System.out.println(0);
				continue;
			}
			queue.add(new child(first, 1));
			int prev = first;
			boolean found = false;
			
			for(int i = 1; i < num - 1; i++)
			{
				int current = scan.nextInt();
				if(current == target)
				{
					found = true;
				}
				child currentChild = new child(current, currentLevel);
				//System.out.println(current + ":" + currentLevel);
				
				if(currentChild.nextTo(prev))
				{
					queue.add(currentChild);
					prev = current;
				}
				else
				{
					queue.poll();
					queue.add(currentChild);
					prev = current;
					
					if(queue.peek().level == currentLevel)
					{
						if(found && target != current)
						{
							queue.pollLast();
							break;
						}
						else
						{
							currentLevel++;
							currentChild.level++;
						}
					}
				}
			}
			
			while(queue.peek().level != currentLevel)
			{
				queue.poll();
			}

			child previous = queue.peek();
			//boolean consective = false;
			ArrayDeque<child> temp = new ArrayDeque<child>();	
			int run = 1;
			boolean include = false;
			
			for(child c : queue)
			{
				//System.out.println(c.index + ":" + c.level);
				if(c.index == target)
				{
					include = true;
				}
							
				if(c.nextTo(previous.index))
				{
					//consective = true;
					run++;
				}
				else
				{
					//consective = false;
					run = 1;
					if(c.index != target)
					{
						include = false;
					}
				}
				
				if(!include)
				{
					temp.add(c);
				}
				

				if(c.index == target)
				{
					include = true;
					if(run != 1)
					{
						for(int i = 1; i < run; i++)
						{
							temp.poll();
						}
					}
				}
				
				previous = c;
			}
			
			System.out.println(temp.size());
			scan.nextLine();
			
			scan.close();
		
		}
	}
	
	private static class child
	{
		int index;
		int level;
		
		public child(int index, int level)
		{
			this.index = index;
			this.level = level;
		}
		
		public boolean nextTo(int temp)
		{
			return (index == temp + 1) || (index == temp - 1);
		}
	}

}