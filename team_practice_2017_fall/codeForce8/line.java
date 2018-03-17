package codeForce8;

import java.util.*;


public class line {

	static ArrayDeque<Long> left = new ArrayDeque<Long>();
	static ArrayDeque<Long> right = new ArrayDeque<Long>();
	
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		long n = in.nextLong();
		long k = in.nextLong();
		long m = in.nextLong();
		long result = n * m;

		ArrayDeque<Long> queue = new ArrayDeque<Long>();
		for(long i = 0; i < n; i++)
		{
			queue.addLast(in.nextLong());
		}
		in.close();
		
		ArrayDeque<Long> temp = new ArrayDeque<Long>();
		while(true)
		{
		
			long prev = 0;
			long length = 0;
			Iterator<Long> it = queue.iterator();
			while(it.hasNext())
			{
				long current = it.next();
				temp.addLast(current);
				
				if(current != prev)
				{
					length = 1;
					prev = current;
				}
				else
				{
					length++;
				}
				
				if(length == k)
				{
					//prev = 0;
					length = 0;
					//result -= k*m;
					for(int i = 0; i < k; i++)
					{
						temp.removeLast();
					}
				}
			}
			if(temp.size() == queue.size())
			{
				break;
			}
			else
			{
				queue = temp;
				temp = new ArrayDeque<Long>();
			}
		}
		
		//long leftOver = 0;
		//long last = 0;
		while(true)
		{
			if(queue.size() == 0)//handled
			{		
				System.out.println(0);
				System.exit(0);
			}
			if(queue.size() <= k)
			{
				boolean same = true;
				Iterator<Long> it = queue.iterator();
				long first = it.next();
				while(it.hasNext())
				{
					if(it.next() != first)
					{
						same = false;
						break;
					}
				}
				
				if(!same)
				{
					
					handle(queue,m,k,result);
				}
				else
				{
					long size = (queue.size() * m) % k;
					if(size == 0)
					{
						System.out.println("0");
						System.exit(0);
					}
					else
					{
						queue = new ArrayDeque<Long>();
						for(int i = 0; i < size; i++)
						{
							queue.add(first);
						}
						handle(queue,1,k,result);
					}
				}
			}
			else
			{
				if(queue.peekFirst() == queue.peekLast())//handled.
				{
					long target = queue.removeLast();
					queue.removeFirst();
					long length1 = 2;
					
					while(queue.peekLast() == target)
					{
						length1++;
						queue.removeLast();
					}
					if(length1 == k)
					{
						//result -= k * (m-1);
						//last = target;
						//leftOver++;
						left.addLast(target);
						for(int i = 0; i < k - 1; i++)
						{
							right.addFirst(target);
						}
						continue;
					}
					else
					{
						long diff = k - length1;
						long removed = 0;
						boolean success = true;
						for(long i = 0; i < diff; i++)
						{
							if(queue.peekFirst() != target)
							{
								//result += leftOver * k;
								removed = i;	
								success = false;
								break;
							}
							else
							{
								queue.removeFirst();
							}
						}
						if(success)
						{
							//result -= k * m;
							//last = target;
							//leftOver++;
							for(int i = 0; i <= diff; i++)
							{
								left.addLast(target);
							}
							for(int i = 0; i < length1 - 1; i++)
							{
								right.addFirst(target);
							}
							continue;
						}
						else
						{
							queue.addFirst(target);
							for(int i = 0; i < removed; i++)
							{
								queue.addFirst(target);
							}
							for(int i = 0; i < length1 - 1; i++)
							{
								queue.addLast(target);
							}
							handle(queue, m, k, result);
						}
					}
				}
				else
				{
					handle(queue, m, k, result);
				}
			}
		}

	}
	
	private static void handle(ArrayDeque<Long> leftOver, long m, long k, long result)
	{
		ArrayDeque<Long> finalOne = new ArrayDeque<Long>();
		result = leftOver.size() * m + left.size() + right.size();
		if(m == 1)
		{		
			finalOne.addAll(left);
			finalOne.addAll(leftOver);
			finalOne.addAll(right);
			
		}
		else
		{
			finalOne.addAll(left);
			finalOne.addAll(leftOver);
			finalOne.addAll(leftOver);
			finalOne.addAll(right);
		}
		
		//result += left.size();
		//result += right.size();
		ArrayDeque<Long> temp = new ArrayDeque<Long>();
		while(true)
		{
		
			long prev = 0;
			long length = 0;
			Iterator<Long> it = finalOne.iterator();
			while(it.hasNext())
			{
				long current = it.next();
				temp.addLast(current);
				
				if(current != prev)
				{
					length = 1;
					prev = current;
				}
				else
				{
					length++;
				}
				
				if(length == k)
				{
					//prev = 0;
					length = 0;
					result -= k;
					for(int i = 0; i < k; i++)
					{
						temp.removeLast();
					}
				}
			}
			if(temp.size() == finalOne.size())
			{
				break;
			}
			else
			{
				finalOne = temp;
				temp = new ArrayDeque<Long>();
			}
		}
		
		System.out.println(result);
		System.exit(0);
	}

}
