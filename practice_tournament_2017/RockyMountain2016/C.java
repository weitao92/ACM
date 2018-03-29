package RockyMountain2016;

import java.util.*;

/**
 * https://open.kattis.com/problems/password
 * @author weitao92
 *
 */
public class C {
    
    public static void main(String args[])
    {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        
        double[] arr = new double[n];
        
        for(int i = 0; i < n; i++)
        {
            in.next();
            arr[i] = in.nextDouble();
        }
        
        Arrays.sort(arr);
        
        double result = 0;
        int index = 1;
        for(int i = n-1; i >= 0; i--)
        {
            result += index * arr[i];
            index++;
        }
        
        System.out.println(result);
    }

}
