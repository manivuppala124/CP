/*Tata motors released a new ELECTRIC CAR, 
which recharges its battery based on the vehicle movement at specific points 
along the road when vehicle passes those points at a specified speed. 
As you are the owner of that CAR, you want to get maximum benefit of that, 
and you are travelling on a road of length "N" kilometres. 

There are specific recharge points at every kilometre, 
it specifies how much percentage of battery improves when you pass those points with a specified speed. 
But you can travel with this specified speed for a continuous distance of "K" kilometres. 

With your programming skills can you determine how to maximize the benefit from this.


Input Format:
--------------
Line-1: two space-separated integers N and K, 
the length of the track and the maximum distance car can run at specified speed.
Line-2: N space-separated integers, the number of charging points within each kilometre of the road.

Output Format:
-------------
Output an integer.


Sample Input-1:
---------------
7 2
2 4 8 1 2 1 8

Sample Output-1:
----------------
12

Explanation:
Car can get maximum recharge 4+8=12 if it runs at specified speed between the 2nd and the 3rd kilometre, inclusive.

Constraints 
1≤T≤10
1≤K≤N≤100
1≤ai≤100
 */
import java.util.*;

public class CarRecharge { 
    public static int carCharge(int n, int[] arr, int k) {
        int maxsum = 0, currsum = 0;

        // Compute the initial window sum (first K elements)
        for (int i = 0; i < k; i++) {
            currsum += arr[i];
        }
        maxsum = currsum;

        // Slide the window across the array
        for (int i = k; i < n; i++) {
            currsum = currsum + arr[i] - arr[i - k];  // Corrected update step
            maxsum = Math.max(maxsum, currsum);
        }

        return maxsum;
    }

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();
        int k = scan.nextInt();
        int[] arr = new int[n];

        for (int i = 0; i < n; i++) {
            arr[i] = scan.nextInt();
        }

        System.out.println(carCharge(n, arr, k));

        scan.close();
    }
}

