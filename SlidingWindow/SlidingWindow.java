/*
 * You are given an array books, where each element represents the time (in minutes) required to read a book. 
You are also given an integer k, which represents the total available reading time in minutes.

Your task is to determine the maximum number of books that can be read within the given time k 
while ensuring that the sum of reading times does not exceed k.

You must find the longest contiguous subarray where the sum of elements is less than or equal to k, 
and return its length.

Input Format:
-------------
Line-1: An integer 'n' representing the number of books.
Line-2: 'n' space-separated integers representing the time (in minutes) required to read each book.
Line-3: An integer 'k', the available reading time in minutes.

Output Format:
--------------
Line-1: An integer representing the maximum number of books that can be read within 'k' minutes.

Sample Input-1:
---------------
8
1 1 2 1 1 1 4 2
8

Sample Output-1:
----------------
6

Explanation:
------------
We must find the longest subarray where the sum is ≤ 8.
Possible valid subarrays: [1, 1, 2, 1, 1, 1], [1, 2, 1, 1, 1], [2, 1, 1, 1], etc.
The longest valid subarray has a length of 6.

Sample Input-2:
---------------
7
2 3 1 2 4 3 1
5

Sample Output-2:
----------------
3

Explanation:
-------------
Possible valid subarrays: [2, 3], [3, 1, 2], [1, 2, 1], [2, 3], etc.
The longest valid subarray has a length of 3.



 */
public class SlidingWindow {

    /**
     * This method calculates the maximum sum of any contiguous subarray of size k.
     *
     * @param books An array of integers (e.g., number of books read each day).
     * @param k The fixed size (length) of the subarray window.
     * @return The maximum sum of any subarray of length k.
     */
    static int maxSubArraySum(int[] books, int k) {
        // Initialize two pointers for the sliding window boundaries.
        // 'left' represents the left boundary (start) of the window,
        // and 'right' will move as we expand the window to the right.
        int left = 0;
        int right = 0;

        // 'sum' keeps track of the sum of the current window.
        // 'maxbooks' will store the maximum sum encountered.
        int sum = 0;
        int maxbooks = 0;

        // We iterate 'right' from 0 to the end of the array, effectively expanding
        // the window one element at a time.
        for (right = 0; right < books.length; right++) {

            // Add the current element (at 'right') to our running sum.
            sum += books[right];

            // Check if the current window size (right - left + 1) has exceeded k.
            // If so, we need to shrink the window from the left side.
            if ((right - left + 1) > k) {
                // Subtract the element going out of the window from 'sum'.
                sum -= books[left];
                // Move the left boundary to the right by one position.
                left++;
            }

            // At this point, if our window size is exactly k (or has just become k),
            // 'sum' represents the sum of that window. We compare and update 'maxbooks'.
            maxbooks = Math.max(maxbooks, sum);
        }

        // After we've processed all possible windows, 'maxbooks' will be the maximum
        // sum of any subarray of size k.
        return maxbooks;
    }

    /**
     * Main method to test the maxSubArraySum function.
     */
    public static void main(String[] args) {
        // Define an example array. For instance, each value might represent the number
        // of books read on a given day. We want to find the maximum sum over a subarray
        // of a fixed length k.
        int[] arr = {2, 1, 5, 1, 3, 2};

        // Define the subarray size k.
        int k = 3;

        // Call our sliding window function to find the maximum subarray sum of size k.
        int result = maxSubArraySum(arr, k);

        // Print out the result to verify correctness.
        System.out.println("Maximum sum of subarray of size " + k + " is: " + result);
    }
}
