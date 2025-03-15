/*Mr.Sathya is playing with numbers he converts the decimal to binary 
and try to find number of positions at which the corresponding
bits are different. Help sathya by giving solution to the problem 
to find sum of bits differences between all the pairs of the 
integers in given numbers.

Input Format:
-------------
Line-1: An integer, N, Number of integers
Lint-2: N space separted, List of integers

Output Format:
--------------
Line-1: An integer, Return the sum of bit differences between all the pairs of the integers.
 
Sample Input-1:
---------------
3
4 14 2

Sample Output-1:
----------------
6

Explanation: In binary representation, the 4 is 0100, 14 is 1110, and 2 is 0010 (just
showing the four bits relevant in this case).
The answer will be:
HammingDistance(4, 14) + HammingDistance(4, 2) + HammingDistance(14, 2) = 2 + 2 + 2 = 6.

Sample Input-2:
--------------- 
3
4 14 4

Sample Output-2:
----------------
4 */
import java.util.*;

public class TotalHammingDistance {
    public static int totalHammingDistance(int[] nums) {
        int totalDistance = 0;
        int n = nums.length;

        // Iterate over 32 bits (since int has 32 bits in Java)
        for (int bit = 0; bit < 32; bit++) {
            int countOnes = 0;
            
            // Count numbers with a 1 at this bit position
            for (int num : nums) {
                countOnes += (num >> bit) & 1;
            }

            int countZeros = n - countOnes; // Remaining numbers have 0 at this bit position
            totalDistance += countOnes * countZeros; // Contribution of this bit
        }
        
        return totalDistance;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();  // Number of elements
        int[] nums = new int[n];

        for (int i = 0; i < n; i++) {
            nums[i] = sc.nextInt();
        }

        System.out.println(totalHammingDistance(nums)); // Output the total Hamming distance

        sc.close();
    }
}

