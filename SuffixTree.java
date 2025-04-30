//implement SuffixTree logic
import java.util.*;

class SuffixTrie 
{	
	static final int NUM_CHARS = 26;
	// SuffixTrie node
	static class SuffixTrieNode
	{
		SuffixTrieNode[] children = new SuffixTrieNode[NUM_CHARS];
	
		// isEndOfWord is true if the node represents end of a word
		boolean isEndOfWord;
		
		SuffixTrieNode()
		{
			isEndOfWord = false;
			for (int i = 0; i < NUM_CHARS; i++)
				children[i] = null;
		}
	};
	
	static SuffixTrieNode root;
	
	// If not present, inserts word into SuffixTrie
	// If the word is prefix of SuffixTrie node, just marks leaf node
	static void insert(String word)
	{
        
	}
	
	// To check if current node is leaf node or not
	static boolean isLeafNode(SuffixTrieNode root) 
	{
        return false;
		
	}
 
	// print SuffixTrie
	static void print(SuffixTrieNode root, char[] str, int level) 
	{
		
	}

	public static void main(String args[])
	{
		
	}	
}