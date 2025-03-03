/*Given string num representing a non-negative integer num, and an integer k, return the smallest possible integer after removing k digits from num.

Example 1:
input =1432219
3
output =1219

num = "1432219", k = 3
Output: "1219"
Explanation: Remove the three digits 4, 3, and 2 to form the new number 1219 which is the smallest.


Input: num = "10200", k = 1
Output: "200"
Explanation: Remove the leading 1 and the number is 200. Note that the output must not contain leading zeroes.
Example 3:

Input: num = "10", k = 2
Output: "0"
Explanation: Remove all the digits from the number and it is left with nothing which is 0.
 */
import java.util.*;

public class RemoveKdigits {
    public static String removek(String s, int k) {
        if (s.length() == 0 || s.length() == k) return "0"; // If k equals length, return "0"

        Stack<Character> st = new Stack<>();

        for (char digit : s.toCharArray()) {
            while (!st.isEmpty() && k > 0 && st.peek() > digit) {
                st.pop();
                k--;
            }
            st.push(digit);
        }

        // Remove remaining k digits if needed
        while (k > 0 && !st.isEmpty()) {
            st.pop();
            k--;
        }

        // Construct the final result
        StringBuilder sb = new StringBuilder();
        while (!st.isEmpty()) {
            sb.append(st.pop());
        }
        sb.reverse();

        // Remove leading zeros
        while (sb.length() > 1 && sb.charAt(0) == '0') {
            sb.deleteCharAt(0);
        }

        return sb.length() == 0 ? "0" : sb.toString();
    }

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String s = scan.next();
        int k = scan.nextInt();
        scan.close();
        System.out.println(removek(s, k));
    }
}

