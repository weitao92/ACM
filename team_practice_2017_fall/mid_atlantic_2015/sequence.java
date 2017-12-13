package mid_atlantic_2015;

import java.util.Scanner;

public class sequence {
	
	public static void main(String args[])
	{
		Scanner in = new Scanner(System.in);
		
		while(in.hasNext())
		{
			int[] list = new int[4];
			for(int i = 0; i < 4; i++)
			{
				list[i] = in.nextInt();
			}
			
			if(list[0] == -1 && list[1] == -1)
			{
				System.exit(0);
			}
			
			boolean arithmatic = false;
			int diff = -1;
			double multi = -1;
			for(int i = 1; i < 4; i++)
			{
				if(list[i] != -1)
				{
					if(list[i-1] != -1)
					{
						double tm = (double)list[i] / list[i-1];
						int td = list[i] - list[i-1];
						

						if(tm % 1 != 0)
						{
							arithmatic = true;
							//break;
						}
						
							if(diff == -1)
							{
								diff = td;
							}
							else
							{
								if(td != diff)
								{
									arithmatic = false;
									//break;
								}
							}
							
							if(multi == -1)
							{
								multi = tm;
							}
							else
							{
								if(tm != multi)
								{
									arithmatic = true;
									//break;
								}
							}
						
						
						
					}
					else
					{
						if(i-2 >= 0)
						{
							double tm = Math.sqrt((double)list[i] / list[i-2]);
							double td = (list[i] - list[i-2])/2.0;
							if(tm % 1 != 0)
							{
								arithmatic = true;
								//break;
							}
							else if(td % 1 != 0)
							{
								arithmatic = false;
								//break;
							}
							
							if(diff == -1)
							{
								diff = (int)td;
							}
							else
							{
								if(td != diff)
								{
									arithmatic = false;
									//break;
								}
							}
							
							if(multi == -1)
							{
								multi = tm;
							}
							else
							{
								if(tm != multi)
								{
									arithmatic = true;
									//break;
								}
							}
							
						}
					}
				}
			}
			
			if(arithmatic)
			{
				
				int result = 0;
				for(int i = 0; i < 4; i++)
				{
					if(list[i] == -1)
					{
						if(i > 0)
						{
							list[i] = list[i-1] + diff;
							result = list[i];
							break;
						}
						else
						{
							list[i] = list[i+1] - diff;
							result = list[i];
							break;
						}
					}
				}
				
				if(list[3] - list[2] == list[2] - list[1] && list[2] - list[1] == list[1] - list[0])
				{
					if(result > 0)
					{
						System.out.println(result);
					}
					else
					{
						System.out.println("-1");
					}
				}
				else
				{
					System.out.println("-1");
				}
			}
			else
			{
				int result = 0;
				for(int i = 0; i < 4; i++)
				{
					if(list[i] == 0)
					{
						System.out.println("-1");
						System.exit(0);
					}
					
					if(list[i] == -1)
					{
						if(i > 0)
						{
							list[i] = list[i-1] * (int)multi;
							result = list[i];
							if(list[i] == 0)
							{
								System.out.println("-1");
								System.exit(0);
							}
							break;
						}
						else
						{
							list[i] = list[i+1] / (int)multi;
							result = list[i];
							if(list[i] == 0)
							{
								System.out.println("-1");
								System.exit(0);
							}
							break;
						}
					}
				}
				
				
				if(list[3] / (double)list[2] == 
						list[2] / (double)list[1] && list[2] / (double)list[1] 
								== list[1] / (double)list[0])
				{
					if(result > 0)
					{
						System.out.println(result);
					}
					else
					{
						System.out.println("-1");
					}
				}
				else
				{
					System.out.println("-1");
				}
			}
		}
	}

}
