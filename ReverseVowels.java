/*Given a string s, reverse only all the vowels in the 
string and return it.

The vowels are 'a', 'e', 'i', 'o', and 'u', and they can 
appear in both lower and upper cases, more than once.

Sample Input-1:
---------------
hello

Sample Output-1:
----------------
holle

Sample Input-2:
----------------
Keshavmemorial

Sample Output-2:
----------------
Kashivmomerael
 */
import java.util.*;
class ReverseVowels{
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        String str=sc.nextLine();
        char[] ch=str.toCharArray();
        reverse(ch);
        String res=new String (ch);
        System.out.println(res);
    }
    public static void reverse(char[] ch){
       List<Character> vowels = new ArrayList<>(Arrays.asList('a', 'e', 'i', 'o', 'u','A','E','I','O','U'));
       int start=0,end=ch.length-1;
       while(start<=end){
           if(vowels.contains(ch[start])&& vowels.contains(ch[end])){
               swap(ch,start,end);
               start+=1;
               end-=1;
           }
           else if(vowels.contains(ch[start])&&!vowels.contains(ch[end])){
               end-=1;
           }
           else{
               start+=1;
           }
       }
    }
    public static void swap(char[] ch,int start,int end){
        char temp=ch[start];
        ch[start]=ch[end];
        ch[end]=temp;
    }
}