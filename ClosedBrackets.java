/*Clavius, the person who suggested grouping of data using brackets.
He has suggested that the group of brackets should be Well-Formed.

A string is said to be Well-Formed, if:
    - Any open bracket must have corresponding two consecutive close brackets.
    - Open bracket must appear before the corresponding close brackets.

You will be given a string B, consists of square brackets only '[' , ']'.
In one operation, you can insert one square bracket at any position of B.
i.e., Given B = [[]]], in one operation you can add a open square bracket,
now B can be Well-Formed string, if you add at index 2,3,4 or 5 => [[]]]]

Your task is to return the least number of operations required,
to make B as a Well-Formed string.

Input Format:
-------------
A string, B contains only characters '[', ']'

Output Format:
--------------
Print an integer value.


Sample Input-1:
---------------
[]]][

Sample Output-1:
----------------
4


Sample Input-2:
---------------
[]][[]]

Sample Output-2:
----------------
2
 */
import java.util.*;

public class ClosedBrackets {
    public static int minInsertions(String B) {
        int open = 0, insertions = 0;
        int i = 0;
        
        while (i < B.length()) {
            if (B.charAt(i) == '[') {
                open++;
            } else { // If it's a closing bracket ']'
                if (i + 1 < B.length() && B.charAt(i + 1) == ']') {
                    if (open > 0) {
                        open--; // One pair of '[]' is completed
                    } else {
                        insertions++; // Need one extra open bracket
                    }
                    i++; // Skip the next ']'
                } else {
                    insertions++; // Need one more closing bracket ']'
                    if (open > 0) {
                        open--; // One pair is completed
                    } else {
                        insertions++; // Need one extra open bracket
                    }
                }
            }
            i++;
        }
        
        return insertions + 2 * open; // Remaining open brackets need 2 close brackets each
    }
    
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String B = scanner.next();
        scanner.close();
        
        System.out.println(minInsertions(B));
    }
}
