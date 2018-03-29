package RockyMountain2016;

import java.util.*;

/**
 * https://open.kattis.com/problems/flowshop
 * @author weitao92
 *
 */
public class G {
    
    static int[][] t;
    static int[][] c;
    public static void main(String args[])
    {
        Scanner in = new Scanner(System.in);
        int m = in.nextInt();
        int n = in.nextInt();
        int[][] mat = new int[m][n];
        
        for(int i = 0; i < m; i++)
        {
            for(int j = 0; j < n; j++)
            {
                mat[i][j] = in.nextInt();
            }
        }
        
        long[][] result = new long[m][n];
        result[0][0] = mat[0][0];
        for(int i = 1; i < n; i++)
        {
            result[0][i] = result[0][i-1] + mat[0][i];
        }
        
        //System.out.println(result[0][n-1]);
        
        for(int i = 1; i < m; i++)
        {
            for(int j = 0; j < n; j++)
            {
                if(j == 0)
                {
                    result[i][j] = result[i-1][j] + mat[i][j];
                }
                else
                {
                    result[i][j] = Math.max(result[i-1][j], result[i][j-1]) + mat[i][j];
                }
            }
        }
        
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < m; i++)
        {
            sb.append(result[i][n-1] + " ");
        }
        sb.substring(0, sb.length()-1);
        System.out.print(sb);
    }

}
