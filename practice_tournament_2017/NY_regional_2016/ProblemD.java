package NY_regional_2016;

import java.util.*;

public class ProblemD {
    
    static class node
    {
        long p;
        long q;
        
        public node(long a, long b)
        {
            p = a;
            q = b;
        }
    }

    
    public static void main(String args[])
    {
        Scanner in = new Scanner(System.in);
        
        int n = in.nextInt();
        
        for(int i = 1; i <= n; i++)
        {
            in.next();
            long index = in.nextLong();
            
            node result = find(index);
            System.out.println(i + " " + result.p + "/" + result.q);
        }
    }
    
    private static node find(long index)
    {
        if(index == 1)
        {
            return new node(1,1);
        }
        node pre = find (index / 2);
        node current;
        if(index % 2 == 0)
        {
            current = new node(pre.p, pre.p + pre.q);
        }
        else
        {
            current = new node(pre.p + pre.q, pre.q);
        }
        
        return current;
    }
}