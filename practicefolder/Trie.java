import java.util.Arrays;
public class Trie {
    static class Node{
        Node[] children;
        boolean eow;
        public Node(){
            children=new Node[26];
            Arrays.fill(children,null);
            eow=false;
        }
    }
    public static Node root=new Node();
    public static int count=0;
    public static void insert(String word){
        Node curr=root;
        for(int i=0;i<word.length();i++){
            int idx=word.charAt(i)-'a';
            if(curr.children[idx]==null){
                curr.children[idx]=new Node();
            }
            if(i==word.length()-1){
                curr.children[idx].eow=true;
            }
            curr=curr.children[idx];
            count++;
        }
    }
    public static boolean search(String key){
        Node curr=root;
        for(int i=0;i<key.length();i++){
            int idx=key.charAt(i)-'a';
            if(curr.children[idx]==null){
                return false;
            }
            curr=curr.children[idx];
        }
        return curr.eow;
    }
    public static boolean wordBreak(String key){
        if(key.length()==0){
            return true;
        }
        for(int i=1;i<=key.length();i++){
            String firstpart=key.substring(0, i);
            String secondpart=key.substring(i);
            if(search(firstpart)&&wordBreak(secondpart)){
                return true;
            }
        }
        return false;
    }
    public static boolean startsWith(String prefix){
        if(prefix.length()==0){
            return true;
        }
        Node curr=root;
        for(int i=0;i<prefix.length();i++){
            int idx=prefix.charAt(i)-'a';
            if(curr.children[idx]==null){
                return false;
            }
            curr=curr.children[idx];
        }
        return true;
    }
    public static int countUniqueNodes(Node root){
        if(root==null){
            return 0;
        }
        int count=0;
        for(Node child:root.children){
            if(child!=null){
                count+=countUniqueNodes(child);
            }
        }
        return count+1;
    }
    public static String ans="";
    public static void longestWord(Node root,StringBuilder temp){
        if(root==null){
            return;
        }
        for(int i=0;i<26;i++){
            if(root.children[i]!=null&&root.children[i].eow==true){
                temp.append((char)(i+'a'));
                if(temp.length()>ans.length()){
                    ans=temp.toString();
                }
                longestWord(root.children[i], temp);
                temp.deleteCharAt(temp.length()-1);
            }
        }
    }
    public static void main(String[] args) {
        // String[] words={"i","like","sam","samsung","mobile"};
        // String keyword="ilikesam";
        // for(String word:words){
        //     insert(word);
        // }
        // System.out.println(search("that"));
        // System.out.println(wordBreak(keyword));
        // System.out.println(startsWith("moon"));
        // String word="ababa";
        // for(int i=0;i<word.length();i++){
        //     insert(word.substring(i));
        // }
        // System.out.println(countUniqueNodes(root));
        String[] words={"a","app","ap","appl","apply","banana","apple"};
        for(String word:words){
            insert(word);
        }
        longestWord(root,new StringBuilder());
        System.out.println(ans);
    }
}
