package NCPC2017;

import java.util.*;

public class ProblemJ {
    
    public static void main(String args[])
    {
        Scanner in = new Scanner(System.in);
        int left = in.nextInt();
        int right = in.nextInt();
        if(left == 0 && right == 0)
        {
            System.out.print("Not a moose");
            System.exit(0);
        }
        if(left == right)
        {
            System.out.print("Even " + left*2);
        }
        else
        {
            int bigger = left > right ? left : right;
            System.out.print("Odd " + bigger*2);
        }
    }

}
