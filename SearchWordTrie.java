/*You are working on strings, list of words are given as source and 
list of words are given as target, you need to find words from target list are present in the source list or not.
if a word is present then print true otherwise print false. 

NOTE: Use Trie Datastructure

Input Format:
-------------
Line-1: A single integer N
Line-2: List contains N space separated words of source list.
Line-3: A single integer M
Line-4: List contains contain M space separated words of target list.

Output Format:
---------------
Line-1: List contains true or false

Sample Input-1:
---------------
5
abc def ghi jkl mno
4
abc fed ghi lkj

Sample Output-1: 
----------------
[true,false,true,false]

Sample Input-2:
---------------
10
a b c d e f g h i j
5
abc d ef g j

Sample Output-2:
----------------
[false, true, false, true, true] */
import java.io.*;
class SearchWordTrie
{
    static class TrieNode {
        TrieNode[] children;
        boolean isEndOfWord;
        TrieNode() {
            children = new TrieNode[26];
            isEndOfWord = false;
        }
    }
    TrieNode root;
    Trie() {
        root = new TrieNode();
    }
    void insert(String word) {
        TrieNode current = root;
        for (char ch : word.toCharArray()) {
            int index = ch - 'a';
            if (current.children[index] == null) {
                current.children[index] = new TrieNode();
            }
            current = current.children[index];
        }
        current.isEndOfWord = true;
    }
    
    //if any supporting functionalities, should go here
    
    List search(String[] word) {
        //implement your code here and return list of boolean values
    }
    
}
class SearchList 
{
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Trie trie = new Trie();
        int n = scanner.nextInt();
		scanner.nextLine();
		String[] word= scanner.nextLine().split(",");
        for (int i = 0; i < n; i++) {
            trie.insert(word[i]);
        }
        int m = scanner.nextInt();
		scanner.nextLine();
		String[] words = scanner.nextLine().split(",");
		System.out.println(trie.search(words));
    }
}
