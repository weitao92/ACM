package warmUp2;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class wolf {
    
    static class card implements Comparable<card>
    {
        int rank;
        char c;
        int diff;
        
        public card(int r, char ca)
        {
            rank = r;
            c = ca;
        }

        @Override
        public int compareTo(card o) {
            if(diff == o.diff)
            {
                return Integer.compare(rank, o.rank);
            }
            else
            {
                return Integer.compare(diff, o.diff);
            }
        }
        
        public boolean equals(Object o)
        {
            card another = (card)o;
            
            return rank == another.rank && c == another.c;
        }
    }
    
    public static void main(String args[])
    {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        if(n < 26)
        {
            System.out.println("impossible");
            System.exit(0);
        }
        else if(n > 26)
        {
        	System.out.println("possible");
            System.exit(0);
        }
        else
        {
            ArrayList<card> opponent = new ArrayList<card>();
            for(int i = 1; i <= 13; i++)
            {
                opponent.add(new card(i, 'C'));
                opponent.add(new card(i, 'D'));
                opponent.add(new card(i, 'H'));
                opponent.add(new card(i, 'S'));
            }
            ArrayList<card> mine = new ArrayList<card>();
            for(int i = 0; i < n; i++)
            {
                int rank = in.nextInt();
                char c = in.next().charAt(0);
                mine.add(new card(rank, c));
            }
            
            opponent.removeAll(mine);
            //System.out.println(mine.size() + " " + opponent.size());
            
            int c1 = 0;
            int c2 = 0;
            int d1 = 0;
            int d2 = 0;
            int h1 = 0;
            int h2 = 0;
            int s1 = 0;
            int s2 = 0;

            for(int i = 0; i < mine.size(); i++)
            {
                if(mine.get(i).c == 'C')
                {
                    c1++;
                    if(mine.get(i).rank > c2)
                    {
                    	c2 = mine.get(i).rank;
                    }
                }
            }

            for(int i = 0; i < mine.size(); i++)
            {
                if(mine.get(i).c == 'D')
                {
                    d1++;
                    if(mine.get(i).rank > d2)
                    {
                    	d2 = mine.get(i).rank;
                    }
                }
            }
            
            for(int i = 0; i < mine.size(); i++)
            {
                if(mine.get(i).c == 'H')
                {
                    h1++;
                    if(mine.get(i).rank > h2)
                    {
                    	h2 = mine.get(i).rank;
                    }
                }
            }
            
            for(int i = 0; i < mine.size(); i++)
            {
                if(mine.get(i).c == 'S')
                {
                    s1++;
                    if(mine.get(i).rank > s2)
                    {
                    	s2 = mine.get(i).rank;
                    }
                }
            }
            
            if(c2 > c1 && d2 > d1 && h2 > h1 && s2 > s1)
            {
            	System.out.println("possible");
            	System.exit(0);;
            }
            else
            {
            	System.out.println("impossible");
            	System.exit(0);;
            }
            
        }
    }

}