package codeForce1;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * codeForce 861C
 * @author weitao92
 *
 */
public class typo {
	
	static class Trie {
	     
	    // Alphabet size (# of symbols)
	    static final int ALPHABET_SIZE = 26;
	     
	    // trie node
	    static class TrieNode
	    {
	        TrieNode[] children = new TrieNode[ALPHABET_SIZE];
	      
	        // isLeaf is true if the node represents
	        // end of a word
	        boolean isLeaf;
	         
	        TrieNode(){
	            isLeaf = false;
	            for (int i = 0; i < ALPHABET_SIZE; i++)
	                children[i] = null;
	        }
	    };
	    
	    public Trie()
	    {
	    	root = new TrieNode();
	    }
	      
	    static TrieNode root; 
	     
	    // If not present, inserts key into trie
	    // If the key is prefix of trie node, 
	    // just marks leaf node
	    void insert(String key)
	    {
	        int level;
	        int length = key.length();
	        int index;
	      
	        TrieNode pCrawl = root;
	      
	        for (level = 0; level < length; level++)
	        {
	        	char c = key.charAt(level);
	            index = c - 'a';
	            //System.out.println(c);
	            if (pCrawl.children[index] == null)
	                pCrawl.children[index] = new TrieNode();
	      
	            pCrawl = pCrawl.children[index];
	        }
	      
	        // mark last node as leaf
	        pCrawl.isLeaf = true;
	    }
	      
	    // Returns true if key presents in trie, else false
	    boolean search(String key)
	    {
	        int level;
	        int length = key.length();
	        int index;
	        TrieNode pCrawl = root;
	      
	        for (level = 0; level < length; level++)
	        {
	        	char c = key.charAt(level);
	        	if(c == ' ')
	        	{
	        		return false;
	        	}
	        	else
	        	{
	            index = c - 'a';
	      
	            if (pCrawl.children[index] == null)
	                return false;
	      
	            pCrawl = pCrawl.children[index];
	        	}
	        }
	      
	        return true;
	    }
	}

	
	public static void main(String agrs[])
	{
		Scanner in = new Scanner(System.in);
		
		String target = in.next();
		in.close();
		
		char[] c = {'b','c','d','f','g','h','j','k','l','m','n','p','q','r','s','t','v','w','x','y','z'};
		Trie trie = new Trie();
		for(int i = 0; i < 21; i++)
		{
			StringBuilder result = new StringBuilder();
			char c1 = c[i];
			result.append(c1);
			for(int j = 0; j < 21; j++)
			{
				if(result.length() >= 2)
				{
					result.deleteCharAt(1);
				}
				char c2 = c[j];
				result.append(c2);
				
				
				for(int k = 0; k < 21; k++)
				{
					char c3 = c[k];
					if(c3 == c2 && c2 == c1)
					{
						continue;
					}
					else
					{
						result.append(c3);
						//System.out.println(result);
						trie.insert(result.toString());
						result.deleteCharAt(result.length() - 1);
					}
				}
			}
		}
		//System.out.println(size);
		
		while(true)
		{
			ArrayList<Integer> index = new ArrayList<Integer>();
			
			for(int i = 0; i <= target.length() - 3; i++)
			{
				String sub = target.substring(i, i + 3);
				if(trie.search(sub))
				{
					//System.out.println(sub);
					index.add(i + 2);
				}
			}
			
			if(index.size() == 0)
			{
				System.out.println(target);
				System.exit(0);
			}
			else
			{
				int gap = 0;
				int previous = 0;
				for(int i : index)
				{
					if(i - previous == 1)
					{
						//previous = i;
						continue;
					}
					else
					{
						target = target.substring(0,i+gap) + " " + target.substring(i+gap, target.length());
						gap++;
						previous = i;
					}
				}
			}
		}
	}
}
