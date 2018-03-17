package RockyMountain2016;

import java.util.*;

public class niceNumber {
	
	static class bit
	{
		int value;
		int start;
		int end;
		
		public bit(int v, int s, int e)
		{
			value = v;
			start = s;
			end = e;
		}
	}
	
	public static void main(String args[])
	{
		Scanner in = new Scanner(System.in);
		int t = in.nextInt();
		
		for(int i = 0; i < t; i++)
		{
			String next = in.next();
			StringBuilder sb = new StringBuilder(next);
			ArrayDeque<bit> queue = new ArrayDeque<bit>();
			for(int j = 0; j < next.length(); j++)
			{
				int c = Character.getNumericValue(next.charAt(j));
				bit b = new bit(c, j, j);
				queue.addLast(b);
			}
			if(queue.size() == 1)
			{
				System.out.println(next);
				continue;
			}
			
			while(true)
			{
				int size1 = queue.size();
				if(size1 == 1)
				{
					break;
				}
				ArrayDeque<bit> newQueue = new ArrayDeque<bit>();
				while(!queue.isEmpty())
				{
					bit current = queue.removeLast();
					if(queue.peekLast() != null && current.value == queue.peekLast().value)
					{
						bit prev = queue.removeLast();
						newQueue.addFirst(new bit(current.value*2,prev.start,current.end));
					}
					else
					{
						newQueue.addFirst(current);
					}
				}
				
				queue = newQueue;
				int size2 = queue.size();
				if(size1 == size2)
				{
					break;
				}
			}
			
			/**
			for(bit b : queue)
			{
				System.out.print(b.value);
			}
			System.out.println();
			**/
			
			int mask = 1;
			while(queue.size() != 1)
			{
				mask *= 2;
				ArrayDeque<bit> newOne = new ArrayDeque<bit>();
				while(!queue.isEmpty())
				{
					
					bit current = queue.removeLast();
					if(current.value != mask)
					{
						newOne.addFirst(current);
					}
					else
					{
						bit newTwo = new bit(2*mask,current.start, current.end + 1);
						if(mask <= 8)
						{
							sb.insert(current.start, mask);
						}
						else
						{
							int temp = mask / 8;
							StringBuilder s = new StringBuilder();
							for(int x = 0; x < temp; x++)
							{
								s.append("8");
							}
							sb.insert(current.start, s);
						}
						
						for(bit b : newOne)
						{
							b.start += 1;
							b.end += 1;
						}
						newOne.addFirst(newTwo);
					}	
				}
				queue = newOne;
				//System.out.println(sb);
				while(true)
				{
					int size1 = queue.size();
					if(size1 == 1)
					{
						break;
					}
					ArrayDeque<bit> newQueue = new ArrayDeque<bit>();
					while(!queue.isEmpty())
					{
						bit current = queue.removeLast();
						if(queue.peekLast() != null && current.value == queue.peekLast().value)
						{
							bit prev = queue.removeLast();
							newQueue.addFirst(new bit(current.value*2,prev.start,current.end));
						}
						else
						{
							newQueue.addFirst(current);
						}
					}
					
					queue = newQueue;
					int size2 = queue.size();
					if(size1 == size2)
					{
						break;
					}
				}
				/**
				for(bit b : queue)
				{
					System.out.print(b.value);
				}
				System.out.println();
				**/
			}

			System.out.println(sb);
		}
	}

}
