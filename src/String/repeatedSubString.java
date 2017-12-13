package String;

import java.util.HashSet;
import java.util.Scanner;

public class repeatedSubString {
	
	public static void main(String args[])
	{
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		
		for(int i = 0; i < n; i++)
		{
			String s = in.next();
			HashSet<String> set = new HashSet<String>();
			
			for(int j = 1; j < s.length(); j++)
			{
				for(int k = 0; k <= s.length() - j; k++)
				{
					String sub = s.substring(k, k + j);
					set.add(sub);
				}
			}
			
			int result = 0;
			for(String c : set)
			{
				if(KMPSearch(c, s) >= 2)
				{
					result++;
				}
			}
			
			System.out.println(result);
		}
		
		in.close();
	}
	
	static int KMPSearch(String pat, String txt)
    {
		int occurance = 0;
        int M = pat.length();
        int N = txt.length();
 
        // create lps[] that will hold the longest
        // prefix suffix values for pattern
        int lps[] = new int[M];
        int j = 0;  // index for pat[]
 
        // Preprocess the pattern (calculate lps[]
        // array)
        computeLPSArray(pat,M,lps);
 
        int i = 0;  // index for txt[]
        while (i < N)
        {
        	if(occurance >= 2)
        	{
        		break;
        	}
        	
            if (pat.charAt(j) == txt.charAt(i))
            {
                j++;
                i++;
            }
            if (j == M)
            {
                occurance++;
                j = lps[j-1];
            }
 
            // mismatch after j matches
            else if (i < N && pat.charAt(j) != txt.charAt(i))
            {
                // Do not match lps[0..lps[j-1]] characters,
                // they will match anyway
                if (j != 0)
                    j = lps[j-1];
                else
                    i = i+1;
            }
        }
        
        return occurance;
    }
 
    static void computeLPSArray(String pat, int M, int lps[])
    {
        // length of the previous longest prefix suffix
        int len = 0;
        int i = 1;
        lps[0] = 0;  // lps[0] is always 0
 
        // the loop calculates lps[i] for i = 1 to M-1
        while (i < M)
        {
            if (pat.charAt(i) == pat.charAt(len))
            {
                len++;
                lps[i] = len;
                i++;
            }
            else  // (pat[i] != pat[len])
            {
                // This is tricky. Consider the example.
                // AAACAAAA and i = 7. The idea is similar 
                // to search step.
                if (len != 0)
                {
                    len = lps[len-1];
 
                    // Also, note that we do not increment
                    // i here
                }
                else  // if (len == 0)
                {
                    lps[i] = len;
                    i++;
                }
            }
        }
    }

}
