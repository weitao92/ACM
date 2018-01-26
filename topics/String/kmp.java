package String;

import java.util.Scanner;

public class kmp {
	
	public static void main(String args[])
	{
		Scanner in = new Scanner(System.in);
		
		int n = in.nextInt();
		String[] keys = new String[n];
		
		for(int i = 0; i < n; i++)
		{
			String key = in.next();
			keys[i] = key;
		}
		
		String target = in.next();
		in.close();
		
		int result = 0;
		
		for(String key : keys)
		{
			result += KMPSearch(key, target);
		}
		
		System.out.println(result);
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
                lps[i] = len; // store the length of prefix and suffix
                i++;
            }
            else  // (pat[i] != pat[len])
            {
                // This is tricky. Consider the example.
                // AAACAAAA and i = 7. The idea is similar 
                // to search step.
                if (len != 0)
                {
                    len = lps[len-1];//len is the number of prefix, not index, index is len - 1.
 
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
