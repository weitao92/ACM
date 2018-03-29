package NCPC2017;

import java.util.*;

public class ProblemB {
    
    static class player implements Comparable<player>
    {
        double A;
        double B;
        String name;
        
        public player(double a, double b, String n)
        {
            A = a;
            B = b;
            name = n;
        }

        @Override
        public int compareTo(player arg0) {
            return Double.compare(B, arg0.B);
        }
    }

    public static void main(String args[])
    {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        player[] list = new player[n];
        ArrayList<player> sorted = new ArrayList<player>();
        for(int i = 0; i < n; i++)
        {
            String name = in.next();
            double A = in.nextDouble();
            double B = in.nextDouble();
            player p = new player(A,B,name);
            list[i] = p;
            sorted.add(p);
        }
        
        Collections.sort(sorted);
        
        double min = Double.MAX_VALUE;
        String f = new String();
        String s = new String();
        String t = new String();
        String fourth = new String();
        
        for(int i = 0; i < n; i++)
        {
            player first = list[i];
            int num = 0;
            double result = first.A;
            player[] second = new player[3];
            for(int j = 0; j < 4 && num < 3; j++)
            {
                if(sorted.get(j).name.equals(first.name))
                {
                    continue;
                }
                else
                {
                    second[num] = sorted.get(j);
                    num++;
                    result += sorted.get(j).B;
                }
            }
            
            if(result < min)
            {
                f = first.name;
                s = second[0].name;
                t = second[1].name;
                fourth = second[2].name;
                min = result;
            }
        }
        
        StringBuilder sb = new StringBuilder();
        sb.append(min + "\n");
        sb.append(f + "\n");
        sb.append(s + "\n");
        sb.append(t + "\n");
        sb.append(fourth + "\n");
        System.out.print(sb);
    }
}