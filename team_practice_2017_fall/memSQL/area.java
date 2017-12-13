package memSQL;

import java.util.PriorityQueue;
import java.util.Scanner;

/**
 * codeforce 859B
 * 
 * @author weitao92
 *
 */
public class area {

	
	public static void main(String agrs[])
	{
		Scanner in = new Scanner(System.in);
		double area = in.nextDouble();
		
		double length = Math.sqrt(area);
		double floor = Math.floor(length);
		double ceil = floor + 1;
		PriorityQueue<Double> queue = new PriorityQueue<Double>();
		
		if(floor * floor >= area)
		{
			queue.add(4 * floor);
		}
		
		if(floor * ceil >= area)
		{
			queue.add((floor+ceil)*2);
		}
		
		if(floor * (ceil + 1) >= area)
		{
			queue.add((floor+ceil + 1)*2);
		}
		
		queue.add(ceil * 4);
		
		double res = queue.poll();
		long result = (long)res;
		System.out.println(result);
	}
}
