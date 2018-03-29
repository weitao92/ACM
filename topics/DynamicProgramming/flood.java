package DynamicProgramming;
import java.util.*;


public class flood
{
    static class paint implements Comparable<paint>
    {
        long start;
        long end;

        public paint(long s, long e)
        {
            start = s;
            end = e;
        }

        public int compareTo(paint another)
        {
            if(end == another.end)
            {
                return Long.compare(start, another.start);
            }
            return Long.compare(end, another.end);
        }
    }

    public static void main(String args[])
    {
            Scanner in = new Scanner(System.in);
            int n = in.nextInt();
            ArrayList<paint> paints = new ArrayList<paint>();
            for(int i = 0; i < n; i++)
            {
                paint current = new paint(in.nextLong(),in.nextLong());
                paints.add(current);
            }
            Collections.sort(paints);
            Long[] results = new Long[n+1];
            results[0] = 0l;
            for(int i = 1; i <= n; i++)
            {
                paint current = paints.get(i-1);
                Long if_not = results[i-1];
                paint temp = new paint(current.start, current.start);
                int index = Collections.binarySearch(paints, temp);
                if(index < 0)
                {
                    index = -index-1;
                    index--;
                }
               
                index++;

                Long if_in = results[index] + (current.end - current.start);
                results[i] = if_not.compareTo(if_in) >= 0 ? if_not : if_in;
            }

            System.out.println(results[n]);
    }
}