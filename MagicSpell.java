/*In the ancient land of Palindoria, wizards write magical spells as strings of lowercase letters. However, for a spell to be effective, each segment of the spell must read the same forward and backward.

Given a magical spell 'spell', your task is to partition it into sequences of valid magical spell segments. 

Your goal is to help the wizard discover all valid combinations of magical spell segmentations.

Sample Input-1:
---------------
aab
  
Sample Output-1:  
----------------
[[a, a, b], [aa, b]]

Sample Input-2:
--------------- 
a
  
Sample Output-2:  
----------------
[[a]]

Spell Constraints:
------------------
- The length of the spell is between 1 and 16 characters.  
- The spell contains only lowercase English letters.  
 */
import java.util.*;
public class MagicSpell{
    public static List<List<String>> magicSpell(String s){
        List<List<String>> res=new ArrayList<>();
        List<String> temp=new ArrayList<>();
        backtrack(s,temp,0,res);
        return res;
    }
    public static boolean isPalindrome(String s){
        return s.equals(new StringBuilder(s).reverse().toString());
    }
    public static void backtrack(String s,List<String> temp,int idx,List<List<String>> res){
        if(idx>s.length()){
            return;
        }
        if(idx==s.length()){
            res.add(new ArrayList<>(temp));
            return;
        }
        for(int i=idx+1;i<=s.length();i++){
            String sub=s.substring(idx,i);
            if(isPalindrome(sub)){
                temp.add(sub);
                backtrack(s,temp,i,res);
                temp.remove(temp.size()-1);
            }
        }
    }
    public static void main(String[] args){
        Scanner scan=new Scanner(System.in);
        String s=scan.next();
        System.out.println(magicSpell(s));
    }
}
