package RockyMountain2016;

import java.util.*;

/**
 * https://open.kattis.com/problems/traffic
 * @author weitao92
 *
 */
public class F {
    
    public static void main(String args[])
    {
        Scanner in = new Scanner(System.in);
        int i1 = in.nextInt();
        int i2 = in.nextInt();
        
        int n1 = in.nextInt();
        int[] p1 = new int[n1];
        for(int i = 0; i < n1; i++)
        {
            p1[i] = in.nextInt();
        }
        
        int n2 = in.nextInt();
        int[] p2 = new int[n2];
        for(int i = 0; i < n2; i++)
        {
            p2[i] = in.nextInt();
        }
        
        if(n1 == 0 && n2 == 0)
        {
            System.out.println("safe and sound");
            System.exit(0);
        }
        else if(n1 == 0)
        {
            if(i1 < i2)
            {
                System.out.println("safe and sound");
                System.exit(0);
            }
            else
            {
                int length2 = p2[n2-1] + 1;
                //int length2 = p2[n2-1];
                
                int[] s2 = new int[length2];
                int first1 = p2[0];
                for(int i = 0; i <= first1; i++)
                {
                    s2[i] = i2;
                }
                
                //int index1 = first + 1;
                for(int i = 0; i < n2 - 1; i++)
                {
                    int time = p2[i];
                    if(i % 2 == 0)
                    {
                        int next = p2[i+1];
                        for(int j = time + 1; j <= next; j++)
                        {
                            s2[j] = s2[j-1] + 1;
                        }
                    }
                    else
                    {
                        int next = p2[i+1];
                        int value = s2[time];
                        for(int j = time+1; j <= next; j++)
                        {
                            s2[j] = value;
                        }
                    }   
                }
                
                for(int i = 0; i < length2; i++)
                {
                    if(Math.abs(s2[i] - i1) < 5)
                    {
                        System.out.println("bumper tap at time " + i);
                        System.exit(0);
                    }
                }
                
                if(n2 % 2 == 0)
                {
                    System.out.println("safe and sound");
                    System.exit(0);
                }
                else
                {
                    int value = s2[length2 - 1];
                    int diff = i1 - value -4;
                    int bump = length2 - 1 + diff;
                    System.out.println("bumper tap at time " + bump);
                    System.exit(0);
                }
            }
        }
        else if(n2 == 0)
        {
            if(i2 < i1)
            {
                System.out.println("safe and sound");
                System.exit(0);
            }
            else
            {
                int length1 = p1[n1-1] + 1;
                //int length2 = p2[n2-1];
                
                int[] s1 = new int[length1];
                int first = p1[0];
                for(int i = 0; i <= first; i++)
                {
                    s1[i] = i1;
                }
                
                //int index1 = first + 1;
                for(int i = 0; i < n1 - 1; i++)
                {
                    int time = p1[i];
                    if(i % 2 == 0)
                    {
                        int next = p1[i+1];
                        for(int j = time + 1; j <= next; j++)
                        {
                            s1[j] = s1[j-1] + 1;
                        }
                    }
                    else
                    {
                        int next = p1[i+1];
                        int value = s1[time];
                        for(int j = time+1; j <= next; j++)
                        {
                            s1[j] = value;
                        }
                    }   
                }
                
                for(int i = 0; i < length1; i++)
                {
                    if(Math.abs(s1[i] - i2) < 5)
                    {
                        System.out.println("bumper tap at time " + i);
                        System.exit(0);
                    }
                }
                
                if(n1 % 2 == 0)
                {
                    System.out.println("safe and sound");
                    System.exit(0);
                }
                else
                {
                    int value = s1[length1 - 1];
                    int diff = i2 - value - 4;
                    int bump = length1 - 1 + diff;
                    System.out.println("bumper tap at time " + bump);
                    System.exit(0);
                    
                }
            }
        }
        
        int length1 = p1[n1-1] + 1;
        //int length2 = p2[n2-1];
        
        int[] s1 = new int[length1];
        int first = p1[0];
        for(int i = 0; i <= first; i++)
        {
            s1[i] = i1;
        }
        
        //int index1 = first + 1;
        for(int i = 0; i < n1 - 1; i++)
        {
            int time = p1[i];
            if(i % 2 == 0)
            {
                int next = p1[i+1];
                for(int j = time + 1; j <= next; j++)
                {
                    s1[j] = s1[j-1] + 1;
                }
            }
            else
            {
                int next = p1[i+1];
                int value = s1[time];
                for(int j = time+1; j <= next; j++)
                {
                    s1[j] = value;
                }
            }   
        }
        
        int length2 = p2[n2-1] + 1;
        //int length2 = p2[n2-1];
        
        int[] s2 = new int[length2];
        int first1 = p2[0];
        for(int i = 0; i <= first1; i++)
        {
            s2[i] = i2;
        }
        
        //int index1 = first + 1;
        for(int i = 0; i < n2 - 1; i++)
        {
            int time = p2[i];
            if(i % 2 == 0)
            {
                int next = p2[i+1];
                for(int j = time + 1; j <= next; j++)
                {
                    s2[j] = s2[j-1] + 1;
                }
            }
            else
            {
                int next = p2[i+1];
                int value = s2[time];
                for(int j = time+1; j <= next; j++)
                {
                    s2[j] = value;
                }
            }   
        }
        
        int small = length1 <= length2 ? length1 : length2;
        for(int i = 0; i < small; i++)
        {
            if(Math.abs(s1[i] - s2[i]) < 5)
            {
                System.out.println("bumper tap at time " + i);
                System.exit(0);
            }
        }
        
        int v1 = s1[small-1];
        int v2 = s2[small-1];
        if(v1 < v2)
        {
            if(small == length1)
            {
                if(n1%2 == 0)
                {
                    System.out.println("safe and sound");
                    System.exit(0);
                }
                else
                {
                    int value = s1[length1-1];
                    //System.out.println(value);
                    for(int i = length1; i < length2; i++)
                    {
                        value++;
                        if(Math.abs(value - s2[i]) < 5)
                        {
                            System.out.println("bumper tap at time " + i);
                            System.exit(0);
                        }
                    }
                    
                    if(n2%2 == 1)
                    {
                        System.out.println("safe and sound");
                        System.exit(0);
                    }
                    else
                    {
                        int value1 = value;
                        int value2 = s2[length2-1];
                        
                            int diff = value2 - value1 - 4;
                            int bump = length2-1 + diff;
                            System.out.println("bumper tap at time " + bump);
                            System.exit(0);
                        
                    }
                }
            }
            else
            {
                if(n2 % 2 == 1)
                {
                    System.out.println("safe and sound");
                    System.exit(0);
                }
                else
                {
                    int value = s2[length2-1];
                    for(int i = length2; i < length1; i++)
                    {
                        if(Math.abs(value - s1[i]) < 5)
                        {
                            System.out.println("bumper tap at time " + i);
                            System.exit(0);
                        }
                    }
                    
                    if(n1 % 2 == 0)
                    {
                        System.out.println("safe and sound");
                        System.exit(0);
                    }
                    else
                    {
                        int value1 = s1[length1 - 1];
                        int diff = value - value1 - 4;
                        int bump = length1-1 + diff;
                        System.out.println("bumper tap at time " + bump);
                        System.exit(0);
                    }
                }
            }
        }
        else
        {
            if(small == length1)
            {
                if(n1%2 == 1)
                {
                    //System.out.println(v1 + " " + v2);
                    System.out.println("safe and sound");
                    System.exit(0);
                }
                else
                {
                    int value = s1[length1-1];
                    for(int i = length1; i < length2; i++)
                    {
                        if(Math.abs(value - s2[i]) < 5)
                        {
                            System.out.println("bumper tap at time " + i);
                            System.exit(0);
                        }
                    }
                    
                    if(n2 % 2 == 0)
                    {
                        System.out.println("safe and sound");
                        System.exit(0);
                    }
                    else
                    {
                        int value1 = s2[length2-1];
                        int diff = value - value1 - 4;
                        int bump = length2-1 + diff;
                        System.out.println("bumper tap at time " + bump);
                        System.exit(0);
                    }
                }
                
            }
            else
            {
                if(n2%2 == 0)
                {
                    System.out.println("safe and sound");
                    System.exit(0);
                }
                else
                {
                    int value = s2[length2-1];
                    for(int i = length2; i < length1; i++)
                    {
                        value++;
                        if(Math.abs(s1[i] - value) < 5)
                        {
                            System.out.println("bumper tap at time " + i);
                            System.exit(0);
                        }
                    }
                    
                    if(n1 % 2 == 1)
                    {
                        System.out.println("safe and sound");
                        System.exit(0);
                    }
                    else
                    {
                        int value1 = s1[length1-1];
                        //System.out.println(value + " " + value1);
                        int diff = value1 - value - 4;
                        int bump = length1-1 + diff;
                        System.out.println("bumper tap at time " + bump);
                        System.exit(0);
                    }
                }
            }
        }
        
    }

}