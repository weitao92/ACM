package String;

import java.util.ArrayList;
import java.util.Scanner;

public class suffixTree {
	
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
	      
	        return true;
	    }
	}

	public static void main(String args[])
	{
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		Trie trie = new Trie();
		ArrayList<String> targets = new ArrayList<String> ();
		
		for(int i = 0; i < n; i++)
		{
			String s = in.next();
			targets.add(s);
		}
		
		String text = in.next();
		in.close();
		int length = text.length();
		
		for(int i = 0; i < length; i++)
		{
			String sub = text.substring(i, length);
			trie.insert(sub);
		}
		
		
		
		
		
	}


}
