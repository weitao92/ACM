package NAQ_2017;

import java.util.Arrays;
import java.util.Scanner;

/**
 * https://naq17.kattis.com/problems/canonical
 * @author weitao92
 *
 */
public class coinSystem {
    
    public static void main(String args[])
    {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        
        int[] coins = new int[n];
        for(int i = 0; i < n; i++)
        {
            coins[i] = in.nextInt();
        }
        
        int sum = coins[n-1] + coins[n-2];
        
        int[] table = new int[sum];
        Arrays.fill(table, Integer.MAX_VALUE);
        for(int target = 0; target <= sum - 1; target++)
        {
            int g = greedy(target, coins);
             
            if(target == 0)
            {
                table[0] = 0;
                continue;
            }
         
            
            for (int j=0; j<n; j++)
            {
                  if (coins[j] <= target)
                  {
                      int sub_res = table[(int) (target-coins[j])];
                      if (sub_res != Integer.MAX_VALUE && sub_res + 1 < table[target])
                          table[target] = sub_res + 1;
                  }
            }
            
            
            if(g != table[target])
            {
                System.out.println("non-canonical");
                System.exit(0);
            }
        }
        System.out.println("canonical");
    }
    
    private static int greedy(int target, int[] coins)
    {
        int result = 0;
        
        for(int i = coins.length - 1; i >= 0; i--)
        {
            if(target == 0)
            {
                break;
            }
            int coin = coins[i];
            int div = target / coin;
            if(div > 0)
            {
                result += div;
                target = target % coin;
            }
            else
            {
                continue;
            }
        }
        
        return result;
    }
}
