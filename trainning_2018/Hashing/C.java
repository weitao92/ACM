package Hashing;

import java.util.*;

public class C {
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
	            index = key.charAt(level) - 'a';
	      
	            if (pCrawl.children[index] == null)
	                return false;
	      
	            pCrawl = pCrawl.children[index];
	        }
	      
	        return (pCrawl.isLeaf);
	    }
	}

	public static void main(String args[])
	{
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		HashSet<Integer> set = new HashSet<Integer>();
		Trie trie = new Trie();
		
		for(int i = 0; i < n; i++)
		{
			String s = in.next();
			trie.insert(s);
			set.add(s.length());
		}
		
		String target = in.next();
		in.close();
		int result = 0;
		
		for(int length : set)
		{			
			for(int i = 0; i <= target.length() - length; i++)
			{
				String newOne = target;
				String sub = newOne.substring(i, i + length);
				
				if(trie.search(sub))
				{
					result++;
				}
			}
		}		
		System.out.println(result);	
	}
}
