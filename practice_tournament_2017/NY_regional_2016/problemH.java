package NY_regional_2016;

import java.util.*;

public class problemH {
    
    public static void main(String args[])
    {
        Scanner in = new Scanner(System.in);
        
        int n = in.nextInt();
        StringBuilder sb = new StringBuilder();
        for(int i = 1; i <= n; i++)
        {
            in.next();
            int l = in.nextInt();
            long[] arr = new long[l];
            for(int j = 0; j < l; j++)
            {
                arr[j] = in.nextLong();
            }
            
            ArrayDeque<Long> stack = new ArrayDeque<Long>();
            
            stack.addLast(arr[0]);
            Long min = Long.MAX_VALUE;
            
            for(int j = 1; j < l; j++)
            {
                long current = arr[j];
                while(!stack.isEmpty() && current < stack.peekLast())
                {
                    long removed = stack.pollLast();
                    if(removed < min)
                    {
                        min = removed;
                    }
                }
                
                if(current <= min)
                {
                    stack.addLast(current);
                }
                
            }
            
            long result = 0;
            
            for(int j = 0; j < l; j++)
            {
                if(stack.isEmpty())
                {
                    result += l - j;
                    break;
                }
                if(arr[j] != stack.peekFirst())
                {
                    result++;
                }
                else
                {
                    stack.removeFirst();
                }
            }
           
            sb.append(i + " " + result + "\n");
        }
        System.out.print(sb);
    }

}

