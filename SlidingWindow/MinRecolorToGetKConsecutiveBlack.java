/*You are given a 0-indexed string blocks of length n, 
where each character in blocks[i] represents the color of the i-th block:
-> 'W' represents a white block.
-> 'B' represents a black block.
You are also given an integer k, which represents the desired number of consecutive black blocks.

Operation Allowed is You can recolor a white block (W) to black (B) in a single operation.

Your goal is to determine the minimum number of operations required 
to ensure that at least one sequence of k consecutive black blocks exists.

You are given a 0-indexed string blocks of length n, 
where blocks[i] is either 'W' or 'B', representing the color of the ith block. 
The characters 'W' and 'B' denote the colors white and black, respectively.


Input Format: 
-------------
Line-1: A string 'blocks' representing the sequence of blocks.
Line-2: An integer 'k' (desired consecutive black blocks).

Output Format:
--------------
Line-1: A single integer representing the minimum number of operations required.
 
Sample Input-1:
---------------
WBBWWBBWBW
7

Sample Output-1:
----------------
3

Explanation:
-------------
One way to achieve 7 consecutive black blocks is to recolor the 0th, 3rd, and 4th blocks
so that blocks = "BBBBBBBWBW". 
It can be shown that there is no way to achieve 7 consecutive black blocks in less than 3 operations.
Therefore, we return 3.


Sample Input-2:
---------------
WBWBBBW
2

Sample Output-2:
----------------
0

Explanation:
-------------
No changes need to be made, since 2 consecutive black blocks already exist.
Therefore, we return 0.
 

Constraints:
------------
-> n == blocks.length
-> 1 <= n <= 100
-> blocks[i] is either 'W' or 'B'.
-> 1 <= k <= n */
/*import java.util.*;

class ReColor {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.next();
        int k = sc.nextInt();
        System.out.println(minRepaints(str, k));
    }
    public static int minRepaints(String str, int k) {
        int minRepaints = Integer.MAX_VALUE;
        int currentWCount = 0;
        for (int i = 0; i < k; i++) {
            if (str.charAt(i) == 'W') {
                currentWCount++;
            }
        }
        
        minRepaints = currentWCount;
        for (int i = k; i < str.length(); i++) {
            if (str.charAt(i - k) == 'W') {
                currentWCount--; 
            }
            if (str.charAt(i) == 'W') {
                currentWCount++; 
            }
            minRepaints = Math.min(minRepaints, currentWCount);
        }
        return minRepaints;
    }
}
 */
import java.util.Scanner;

public class MinRecolorToGetKConsecutiveBlack {

    /**
     * This method returns the minimum number of recolors required so that
     * there is at least one substring of length k with all 'B' characters.
     *
     * @param blocks The string representing the color of each block ('W' or 'B').
     * @param k The target number of consecutive black blocks.
     * @return The minimum number of white-to-black recolors needed.
     */
    public static int minimumRecolors(String blocks, int k) {
        int n = blocks.length();

        // Count how many black blocks in the first window [0..k-1].
        int blackCount = 0;
        for (int i = 0; i < k; i++) {
            if (blocks.charAt(i) == 'B') {
                blackCount++;
            }
        }

        // Keep track of the maximum blackCount seen in any window of size k.
        int maxBlack = blackCount;

        // Slide the window from index 1..k, 2..k+1, etc.
        for (int right = k; right < n; right++) {
            // The leftmost block of the old window is at position right - k.
            // If that leftmost block was black, decrement blackCount.
            if (blocks.charAt(right - k) == 'B') {
                blackCount--;
            }

            // The new block entering the window is at position 'right'.
            if (blocks.charAt(right) == 'B') {
                blackCount++;
            }

            // Update maxBlack if this window has more black blocks than before.
            maxBlack = Math.max(maxBlack, blackCount);
        }

        // If a window has maxBlack black blocks, we need (k - maxBlack) recolors to make it fully black.
        return k - maxBlack;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Read the string 'blocks' from input.
        String blocks = sc.nextLine();

        // Read the integer 'k' from input.
        int k = sc.nextInt();

        // Compute the minimum recolors required.
        int result = minimumRecolors(blocks, k);

        // Print the result.
        System.out.println(result);

        sc.close();
    }
}
