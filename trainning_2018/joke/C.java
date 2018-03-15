package joke;
import java.util.ArrayDeque;
import java.util.Scanner;

public class C {
	
	public static void main(String args[])
	{
		Scanner in = new Scanner(System.in);
		ArrayDeque<Integer> stack = new ArrayDeque<Integer>();
		int q = in.nextInt();
		for(int i = 0; i < q; i++)
		{
			String command = in.next();
			
			if(command.equals("a"))
			{
				int target = in.nextInt();
				stack.addLast(target);
			}
			else
			{
				stack.removeLast();
			}
		}
		StringBuilder sb = new StringBuilder();
		while(!stack.isEmpty())
		{
			sb.append(stack.removeLast() + "\n");
		}
		System.out.print(sb);
	}

}
