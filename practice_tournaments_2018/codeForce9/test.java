package codeForce9;

public class test {
	
	public static void main(String args[])
	{
		StringBuilder sb = new StringBuilder();
		sb.append("100000\n");
		//System.out.println(100000);
		for(int i = 1; i < 100000; i++)
		{
			sb.append(i+1);
			sb.append(" ");
		}
		sb.append(1);
		System.out.print(sb);
	}

}
