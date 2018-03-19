package String;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Scanner;

/**
 * codeforce 432/D
 * @author weitao92
 *
 */
public class prefixAndSuffix {
	
	public static void main(String args[])
	{
		Scanner in = new Scanner(System.in);
		String text = in.next();
		in.close();
		int size = text.length();
		int[] lps = new int[size];
		computeLPSArray(text,size,lps);
		
		int num = 1;
		int prefix = lps[size-1];
		int[] count = KMPSearch(lps);
		ArrayDeque<Integer> queue = new ArrayDeque<Integer>();
		queue.add(size);
		while(prefix != 0)
		{
			queue.addFirst(prefix);
			prefix = lps[prefix - 1];
			num++;
		}
		System.out.println(num);
		while(!queue.isEmpty())
		{
			int fix = queue.removeFirst();
			System.out.println(fix + " " + count[fix-1]);
		}
	}
	
	static int[] KMPSearch(int[] lps)
    {
		int[] count = new int[lps.length];
		Arrays.fill(count, 1);
        for(int i = lps.length - 1; i > 0; i--)
        {
        	if(lps[i] > 0)
        	{
        		count[lps[i] - 1] += count[i];
        	}
        }
        
        return count;
    }
	
	static void computeLPSArray(String pat, int M, int lps[])
    {
        int len = 0;
        int i = 1;
        lps[0] = 0;
 
        while (i < M)
        {
            if (pat.charAt(i) == pat.charAt(len))
            {
                len++;
                lps[i] = len;
                i++;
            }
            else
            {
                if (len != 0)
                {
                    len = lps[len-1];
                }
                else
                {
                    lps[i] = len;
                    i++;
                }
            }
        }
    }

}
