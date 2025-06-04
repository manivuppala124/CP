/*A software engineer is designing a display panel that arranges characters of a given string 
in a decorative wave pattern across multiple lines. 

The panel has k horizontal rows, and characters are written in a downward and then upward zigzag fashion across these rows.
Once all characters are placed in the wave pattern, the engineer wants to read the characters row by row 
to generate the final output that will be printed on the screen.

Input Format:
---------------
Line-1: A string `S` (the message to display)
Line-2: An integer `k` representing the number of rows on the display

Sample Format:
----------------------   
A string — the message as it appears when read row-by-row from the wave pattern

Explanation
------------
We are given a string and a number k, and we want to print the string as if it's written in a zigzag across k rows.

Example 
Input: "THISPROBLEMISAWESOME", k = 4
Row0:   T      	       O       	  A           E
Row1:      H         R   L      S   W       M
Row2:          I   P   	  E   I       E   O
Row3:            S          M           S
Reading row by row:

Output: TOWHLBSMIPEAESM

Sample input: 
----------------
ZIGZAGPATTERN
3
Sample Output:
-----------------
ZATNIZGATRGPE
 */
public class ZigZagKFormRows {
    public static String convertToZigZag(String str, int k) {
        if (k == 1) return str;
        
        // Create array of StringBuilder for each row
        StringBuilder[] rows = new StringBuilder[k];
        for (int i = 0; i < k; i++) {
            rows[i] = new StringBuilder();
        }
        
        int currentRow = 0;
        boolean goingDown = true;
        
        // Place each character in appropriate row
        for (char c : str.toCharArray()) {
            rows[currentRow].append(c);
            
            if (goingDown) {
                currentRow++;
                if (currentRow == k - 1) {
                    goingDown = false;
                }
            } else {
                currentRow--;
                if (currentRow == 0) {
                    goingDown = true;
                }
            }
        }
        
        // Combine all rows to get final result
        StringBuilder result = new StringBuilder();
        for (StringBuilder row : rows) {
            result.append(row);
        }
        
        return result.toString();
    }
    
    public static void main(String[] args) {
        // Test cases
        System.out.println(convertToZigZag("THISPROBLEMISAWESOME", 4)); // Should print: TOWHLBSMIPEAESM
        System.out.println(convertToZigZag("ZIGZAGPATTERN", 3)); // Should print: ZATNIZGATRGPE
    }
}
