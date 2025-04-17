/*An 8th standard student has been assigned a task as part of punishment for his mistake.

The task is, there is an input string STR(without any space) and an array of 
strings words[]. Print all the pairs of indices [s, e] where s, e are starting 
index and ending index of every string in words[] in the input string STR.

Note: Print the pairs[s, e] in sorted order.
(i.e., sort them by their first coordinate, and in case of ties sort them by 
their second coordinate).

Input Format
------------
Line-1: string STR(without any space)
Line-2: space separated strings, words[]

Output Format
-------------
Print the pairs[s, e] in sorted order.


Sample Input-1:
---------------
thekmecandngitcolleges
kmec ngit colleges
1
Sample Output-1:
----------------
3 6
10 13
14 21


Sample Input-2:
---------------
xyxyx
xyx xy

Sample Output-2:
----------------
0 1
0 2
2 3
2 4

Explanation: 
------------
Notice that matches can overlap, see "xyx" is found at [0,2] and [2,4].


Sample Input-3:
---------------
kmecngitkmitarecsecolleges
kmit ngit kmec cse

Sample Output-3:
----------------
0 3
4 7
8 11
15 17
 */
import java.util.*;
class IndexPairs{
    static class TrieNode{
        TrieNode[] child=new TrieNode[26];
        boolean isend=false;
    }
    static TrieNode root=new TrieNode();
    static void insert(String s){
        TrieNode curr=root;
        int level,length=s.length(),index;
        for(level=0;level<length;level++){
            index=s.charAt(level)-'a';
            if(curr.child[index]==null){
                curr.child[index]=new TrieNode();
            }
            curr=curr.child[index];
        }
        curr.isend=true;
    }
    public void search(String str,int start,List<int[]> res){
        TrieNode curr=root;
        for(int i=start;i<str.length();i++){
            int id=str.charAt(i)-'a';
            if(curr.child[id]==null){
                break;
            }
            curr=curr.child[id];
            if(curr.isend){
                res.add(new int[]{start,i});
            }
        }
    }
    public static void main(String[] args){
        Scanner scan=new Scanner(System.in);
        String str=scan.nextLine();
        String[] strs=scan.nextLine().split(" ");
        for(String word:strs){
            insert(word);
        }
        List<int[]> res=new ArrayList<>();
        for(int i=0;i<str.length();i++){
            search(str,i,res);
        }
        res.sort((a,b)->a[0]!=b[0]?a[0]-b[0]:a[1]-b[1]);
        for(int[] pair:res){
            System.out.println(pair[0]+" "+pair[1]);
        }
    }
}
