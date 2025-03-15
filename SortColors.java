/*You are given an array nums of size n, where each element represents an object colored red, white, or blue. 
Your task is to sort the array in-place so that all objects of the same color are adjacent, following the order:
-> Red (0)
-> White (1)
-> Blue (2)

Rules:
-> You must not use the built-in sort function.
-> You must modify the array in-place with a time-efficient approach.

Input Format:
-------------
Line 1: An integer n, representing the size of the array.
Line 2: n space-separated integers representing the array nums, where each element is either 0 (red), 1 (white), or 2 (blue).

Output Format:
--------------
Line-1: Print the sorted array as n space-separated integers.

Constraints:
------------
-> 1≤n≤300
-> nums[i]∈{0,1,2} (each element is either 0, 1, or 2)

Sample Input-1:
---------------
6
2 0 2 1 1 0

Sample Output-1:
----------------
0 0 1 1 2 2

Sample Input-2:
---------------
3
2 0 1

Sample Output-2:
----------------
0 1 2 */
import java.util.*;

public class SortColors {
    public static void sortColors(int[] nums) {
        int low = 0, mid = 0, high = nums.length - 1;

        while (mid <= high) {
            if (nums[mid] == 0) { // Swap with low and move both pointers
                swap(nums, low, mid);
                low++;
                mid++;
            } else if (nums[mid] == 1) { // Keep mid as it is
                mid++;
            } else { // Swap with high and move high pointer
                swap(nums, mid, high);
                high--;
            }
        }
    }

    private static void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt(); // Size of the array
        int[] nums = new int[n];

        for (int i = 0; i < n; i++) {
            nums[i] = sc.nextInt();
        }

        sortColors(nums);

        for (int num : nums) {
            System.out.print(num + " ");
        }

        sc.close();
    }
}

