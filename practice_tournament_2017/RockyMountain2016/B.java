package RockyMountain2016;

import java.util.Scanner;

/**
 * https://open.kattis.com/problems/election
 * @author weitao92
 *
 */
public class B {

    public static void main(String[] args) {
//      System.out.println(combination(50,2));
        Scanner scan = new Scanner(System.in);
        int T = scan.nextInt();
        StringBuilder ans = new StringBuilder();
        
        for (int i = 0; i < T; i++) {
            int N = scan.nextInt();
            int v1 = scan.nextInt();
            int v2 = scan.nextInt();
            int w = scan.nextInt();
            
            int votesLeft = N - (v1 + v2);
            if (votesLeft == 0 && v2 >= v1) {
                ans.append("RECOUNT!\n");
            }
            else if ((double)v2/N >= .50) { // win% = 0
                ans.append("RECOUNT!\n");
            }
            else if ((double)v1/N > .50) { // win% = 1
                ans.append("GET A CRATE OF CHAMPAGNE FROM THE BASEMENT!\n");
            }
            else {
                int require = N/2 +1;
                int min = require - v1;
                double result = 0;
                
                for(int j = min; j <= votesLeft; j++)
                {
                    double temp = combination(votesLeft, j);
                    result += temp;
                    
                }
                double p = result / Math.pow(2, votesLeft);
                if(p > (w/100.0))
                {
                    ans.append("GET A CRATE OF CHAMPAGNE FROM THE BASEMENT!\n");
                }
                else {
                    ans.append("PATIENCE, EVERYONE!\n");
                }
                
            }
        }
        System.out.print(ans);

    }
    
    private static double combination(double a, double b)
    {
        double first = 1;
        double temp = a - b;
        double bigger;
        double smaller;
        if(temp >= b)
        {
            bigger = temp;
            smaller = b;
        }
        else
        {
            bigger = b;
            smaller = temp;
        }
        
        
        for(double i = bigger + 1; i <= a; i++)
        {
            first *= i;
        }
        
        double second = 1;
        for(double i = 1; i <= smaller; i++)
        {
            second *= i;
        }
        
        return first / second;
    }

}

