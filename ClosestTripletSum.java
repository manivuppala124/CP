/*You are given three sorted integer arrays A[], B[], and C[], and an integer target.

Your task is to find one element from each array (A[i], B[j], and C[k]) such that the sum of these three elements is equal to target.

If there is no exact match, return the triplet with the minimum absolute difference to the target.

Input Format:
-------------
Line 1: An integer N, the size of the first array.
Line 2: N space-separated integers representing elements of array A.
Line 3: An integer M, the size of the second array.
Line 4: M space-separated integers representing elements of array B.
Line 5: An integer P, the size of the third array.
Line 6: P space-separated integers representing elements of array C.
Line 7: An integer target, the required sum.

Output Format:
--------------
Line-1: Print the triplet (A[i], B[j], C[k]) that either matches the target or has the closest sum to the target.

Constraints:
------------
Time Complexity: O(N + M + P)
Space Complexity: O(1)

Sample Input-1:
---------------
4
5 10 20 30
4
1 3 7 10
4
2 5 8 12
25

Sample Output-1:
----------------
10 7 8

Explanation:
-------------
The sum 10 + 7 + 8 = 25, which exactly matches target.


Sample Input-2:
---------------
3
1 5 10
3
3 6 9
3
4 7 8
30

Sample Output-2:
----------------
10 9 8

Explanation:
------------
The sum 10 + 9 + 8 = 27, which is the closest sum to 30 (minimum absolute difference |30 - 27| = 3). */
import java.util.*;

public class ClosestTripletSum {
    public static int[] findClosestTriplet(int[] A, int[] B, int[] C, int target) {
        int n = A.length, m = B.length, p = C.length;
        int i = 0, j = 0, k = 0;
        int closestSum = Integer.MAX_VALUE;
        int[] result = new int[3];
        
        while (i < n && j < m && k < p) {
            int sum = A[i] + B[j] + C[k];
            
            if (Math.abs(target - sum) < Math.abs(target - closestSum)) {
                closestSum = sum;
                result[0] = A[i];
                result[1] = B[j];
                result[2] = C[k];
            }
            
            if (sum == target) {
                return new int[]{A[i], B[j], C[k]};
            } else if (sum < target) {
                if (i < n - 1 && (j == m - 1 || A[i + 1] <= B[j + 1]) && (k == p - 1 || A[i + 1] <= C[k + 1])) {
                    i++;
                } else if (j < m - 1 && (k == p - 1 || B[j + 1] <= C[k + 1])) {
                    j++;
                } else {
                    k++;
                }
            } else {
                if (k > 0 && (j == 0 || C[k - 1] >= B[j - 1]) && (i == 0 || C[k - 1] >= A[i - 1])) {
                    k--;
                } else if (j > 0 && (i == 0 || B[j - 1] >= A[i - 1])) {
                    j--;
                } else {
                    i--;
                }
            }
        }
        
        return result;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int N = scanner.nextInt();
        int[] A = new int[N];
        for (int i = 0; i < N; i++) A[i] = scanner.nextInt();
        
        int M = scanner.nextInt();
        int[] B = new int[M];
        for (int i = 0; i < M; i++) B[i] = scanner.nextInt();
        
        int P = scanner.nextInt();
        int[] C = new int[P];
        for (int i = 0; i < P; i++) C[i] = scanner.nextInt();
        
        int target = scanner.nextInt();
        scanner.close();
        
        int[] result = findClosestTriplet(A, B, C, target);
        System.out.println(result[0] + " " + result[1] + " " + result[2]);
    }
}
