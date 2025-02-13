/*A string is good if there are no repeated characters.
Given a string s, return the number of good substrings of length three in s.
Note that if there are multiple occurrences of the same substring, every occurrence should be counted.
A substring is a contiguous sequence of characters in a string.

Sample Input-1:
---------------
xyzzaz

Sample Output-1:
----------------
1

Explanation: 
------------
There are 4 substrings of size 3: "xyz", "yzz", "zza", and "zaz". 
The only good substring of length 3 is "xyz".

Sample Input-2:
---------------
aababcabc

Sample Output-2:
----------------
4

Explanation: 
------------
There are 7 substrings of size 3: "aab", "aba", "bab", "abc", "bca", "cab", and "abc".
The good substrings are "abc", "bca", "cab", and "abc". */
/*import java.util.*;
class GoodStrings{
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        String str=sc.nextLine();
        System.out.println(goodString(str));
    }
    public static int goodString(String str){
        int c=0;
        for(int i=0;i<=str.length()-3;i++){
            String temp=str.substring(i,i+3);
            if(isgood(temp)){
                c+=1;
            }
        }
        return c;
    }
    public static  boolean isgood(String temp){
        return temp.charAt(0)!=temp.charAt(1) && temp.charAt(1)!=temp.charAt(2) && temp.charAt(0)!=temp.charAt(2);
    }
    
} */
import java.util.Scanner;

public class GoodStrings {

    /**
     * This method returns the number of "good" substrings of length 3
     * in the given string s. A substring is "good" if all its characters
     * are distinct (no repeats).
     *
     * @param s The input string
     * @return The number of substrings of length 3 that have no repeated characters
     */
    public static int countGoodSubstringsOfSizeThree(String s) {
        // We'll keep a counter to track how many valid substrings we find.
        int count = 0;

        // We can only form a 3-character substring if s.length() >= 3.
        // We'll iterate until s.length() - 3 + 1 => s.length() - 2.
        for (int i = 0; i < s.length() - 2; i++) {
            // Extract the substring from i to i+3 (exclusive of i+3).
            // This will be exactly 3 characters long.
            String sub = s.substring(i, i + 3);

            // Alternatively, we could directly check characters without forming a substring:
            // char c1 = s.charAt(i), c2 = s.charAt(i+1), c3 = s.charAt(i+2);

            // Check if the three characters in sub are distinct.
            // We can do this by checking pairwise inequality.
            if (sub.charAt(0) != sub.charAt(1) &&
                sub.charAt(0) != sub.charAt(2) &&
                sub.charAt(1) != sub.charAt(2)) {
                count++;
            }
        }

        // Return the total count of "good" substrings of length 3.
        return count;
    }

    /**
     * The main method reads an input string from the user, computes the
     * number of good substrings of length 3, and prints the result.
     */
    public static void main(String[] args) {
        // We use a Scanner to read the input string.
        Scanner sc = new Scanner(System.in);

        // Read the input string from the user.
        String input = sc.nextLine();

        // Compute the number of good substrings of length 3.
        int result = countGoodSubstringsOfSizeThree(input);

        // Print the result.
        System.out.println(result);

        // Close the scanner.
        sc.close();
    }
}

