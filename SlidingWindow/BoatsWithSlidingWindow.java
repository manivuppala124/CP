/*You are given an array people, where each element people[i] represents the weight of the i-th person. 
You also have an unlimited number of boats, but each boat has a maximum weight capacity defined by limit.

Each boat can carry at most two people at the same time, as long as their combined weight does not exceed the limit.

Your task is to determine the minimum number of boats required to transport all the given people across safely.

Input Format:
-------------
Line 1: An integer N, representing the number of people.
Line 2: N space-separated integers, representing the weight of each person.
Line 3: An integer limit, representing the maximum weight capacity of a boat.

Output Format:
--------------
Print a single integer, the minimum number of boats needed.

Sample Input-1:
---------------
2
1 2
3

Sample Output-1:
----------------
1

Explanation: Only 1 boat is needed, as both people (weights 1 and 2) fit within the limit of 3.

Sample Input-2:
---------------
4
3 2 2 1
3

Sample Output-2:
----------------
3

Explanation:
------------
Boat 1: (1,2)
Boat 2: (2)
Boat 3: (3)
Total boats required: 3.

Sample Input-3:
---------------
4
3 5 3 4
5

Sample Output-3:
----------------
4

Explanation:
------------
Boat 1: (3)
Boat 2: (3)
Boat 3: (4)
Boat 4: (5)
Total boats required: 4.
 */
/*import java.util.*;
class Boat{
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        int[] arr=new int[n];
        for(int i=0;i<n;i++){
            arr[i]=sc.nextInt();
        }
        int k=sc.nextInt();
        System.out.println(boat(arr,k));
    }
    public static int boat(int[] arr,int k){
       Arrays.sort(arr);
       int low=0;
       int high=arr.length-1;
       int c=0;
       while(low<=high){
           if(arr[low]+arr[high]<=k){
               low+=1;
           }
           high-=1;
           c+=1;
       }
       return c;
    }
    
} */
import java.util.Scanner;
import java.util.Arrays;

public class BoatsWithSlidingWindow {

    /**
     * Returns the minimum number of boats required such that
     * each boat can carry at most two people without exceeding 'limit'.
     *
     * @param people An array where people[i] is the weight of the i-th person.
     * @param limit The maximum weight capacity for each boat.
     * @return The minimum number of boats needed.
     */
    public static int numRescueBoats(int[] people, int limit) {
        // Sort the array so we can pair the lightest and heaviest efficiently.
        Arrays.sort(people);

        // Sliding window boundaries:
        // left = start of window (lightest person not yet placed),
        // right = end of window (heaviest person not yet placed).
        int left = 0;
        int right = people.length - 1;

        // Count of boats needed.
        int boats = 0;

        while (left <= right) {
            // If the lightest and heaviest person can share a boat:
            if (people[left] + people[right] <= limit) {
                left++;  // The lightest person is now placed.
            }
            // In either case, the heaviest person is now placed.
            right--;

            // We've used one boat (whether it holds one or two people).
            boats++;
        }

        return boats;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Read the number of people.
        int n = sc.nextInt();

        // Read their weights.
        int[] people = new int[n];
        for (int i = 0; i < n; i++) {
            people[i] = sc.nextInt();
        }

        // Read the boat weight limit.
        int limit = sc.nextInt();

        // Compute and print the minimum number of boats required.
        int result = numRescueBoats(people, limit);
        System.out.println(result);

        sc.close();
    }
}
