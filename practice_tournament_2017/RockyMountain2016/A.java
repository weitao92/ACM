package RockyMountain2016;
import java.util.*;

/**
 * https://open.kattis.com/problems/fizzbuzz
 * @author weitao92
 *
 */
public class A {
    
    public static void main(String args[])
    {
        Scanner in = new Scanner(System.in);
        int x = in.nextInt();
        int y = in.nextInt();
        int n = in.nextInt();
        
        for(int i = 1; i <= n; i++)
        {
            if(i % x == 0 && i % y == 0)
            {
                System.out.println("FizzBuzz");
            }
            else if(i % x == 0)
            {
                System.out.println("Fizz");
            }
            else if(i % y == 0)
            {
                System.out.println("Buzz");
            }
            else
            {
                System.out.println(i);
            }
        }
    }

}
