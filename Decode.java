/*Mr Bond is a spy and he is working on a mission to solve that mission he needs 
list of numbers which are password to a secret locker, he got a secret code from his informer 
which consists of a circular array code of length of n and a key k.

To decrypt the code, he must replace every number. All the numbers are replaced simultaneously.
with your programming skills help bond to decrypt the code.
The following are the rules to be followed to decrypt the code.

If k > 0, replace the ith number with the sum of the next k numbers.
If k < 0, replace the ith number with the sum of the previous k numbers.
If k == 0, replace the ith number with 0.

As code is circular, the next element of code[n-1] is code[0], and the previous element of code[0] is code[n-1].

Input Format: 
-------------
Line-1: An integer (n)
Line-2: n space separated integers
Line-3: An integer (k)

Output Format:
---------------
Line-1: list of integers

Sample Input-1:
---------------
4
5 7 1 4
3

Sample Output-1: 
----------------
[12,10,16,13]

Explanation: Each number is replaced by the sum of the next 3 numbers. 
The decrypted code is [7+1+4, 1+4+5, 4+5+7, 5+7+1]. Notice that the numbers wrap around.

Sample Input-2:
---------------
4
1 2 3 4
0

Sample Output-2:
----------------
[0,0,0,0]

Explanation: When k is zero, the numbers are replaced by 0. 

Sample Input-3:
---------------
4
2 4 9 3
-2

Sample Output-3:
----------------
[12,5,6,13]

Explanation: The decrypted code is [3+9, 2+3, 4+2, 9+4]. 
Notice that the numbers wrap around again. If k is negative, the sum is of the previous numbers.
 

Constraints:

n == code.length
1 <= n <= 100
1 <= code[i] <= 100
-(n - 1) <= k <= n - 1 */
import java.util.*;

public class Decode {
    
    public static int[] decrypt(int[] code, int k) {
        int n = code.length;
        int[] decrypted = new int[n]; // Stores the decrypted values
        
        if (k == 0) {
            Arrays.fill(decrypted, 0); // If k is 0, all elements become 0
            return decrypted;
        }
        
        for (int i = 0; i < n; i++) { // Iterate through each element in the array
            int sum = 0;
            
            if (k > 0) { // Sum of next k numbers
                for (int j = 1; j <= k; j++) {
                    sum += code[(i + j) % n]; // Circular index calculation
                }
            } else { // Sum of previous k numbers
                for (int j = 1; j <= -k; j++) {
                    sum += code[(i - j + n) % n]; // Circular index for negative k
                }
            }
            
            decrypted[i] = sum; // Store the sum in decrypted array
        }
        
        return decrypted;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        int n = sc.nextInt(); // Read number of elements
        int[] code = new int[n];
        
        for (int i = 0; i < n; i++) {
            code[i] = sc.nextInt(); // Read the elements of the array
        }
        
        int k = sc.nextInt(); // Read the key k
        
        int[] result = decrypt(code, k); // Call the decrypt function
        
        System.out.println(Arrays.toString(result)); // Print the result as a list
    }
}
