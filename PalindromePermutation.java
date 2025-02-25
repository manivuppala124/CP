/*AlphaCipher is a string formed from another string by rearranging its letters

You are given a string S.
Your task is to check, can any one of the AlphaCipher is a palindrome or not.

Input Format:
-------------
A string S

Output Format:
--------------
Print a boolean value.


Sample Input-1:
---------------
carrace

Sample Output-1:
----------------
true


Sample Input-2:
---------------
code

Sample Output-2:
----------------
false */
import java.util.*;
public class PalindromePermutation{
    public static boolean check(String s){
        int n=s.length();
        int bitmask=0;
        for(int i=0;i<n;i++){
            char ch=s.charAt(i);
            bitmask=bitmask^(1<<(ch-'a'));
        }
        return ((bitmask==0)||(bitmask&(bitmask-1))==0);
    }
    public static void main(String[] args){
        Scanner scan=new Scanner(System.in);
        String s=scan.nextLine();
        System.out.println(check(s));
    }
}