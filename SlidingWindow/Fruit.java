/*You are visiting a farm that has a single row of fruit trees arranged from left to right.

The trees are represented by an integer array fruits where fruits[i] is the type of fruit the ith tree produces.
You want to collect as much fruit as possible. 

However, the owner has some strict rules that you must follow:
You only have two baskets, and each basket can only hold a single type of fruit. 
There is no limit on the amount of fruit each basket can hold.

Starting from any tree of your choice, you must pick exactly one fruit from every tree (including the start tree)
while moving to the right. The picked fruits must fit in one of your baskets.

Once you reach a tree with fruit that cannot fit in your baskets, you must stop.
Given the integer array fruits, return the maximum number of fruits you can pick.

Sample Input-1:
---------------
3
1 2 1

Sample Output-1: 
----------------
3

Explanation: We can pick from all 3 trees.

Sample Input-2:
--------------- 
4
0 1 2 2 

Sample Output-2: 
----------------
3

Explanation: We can pick from trees [1,2,2].
If we had started at the first tree, we would only pick from trees [0,1].

Sample Input-3: 
---------------- 
5
1 2 3 2 2

Sample Output-4: 
----------------
4

Explanation: We can pick from trees [2,3,2,2].
If we had started at the first tree, we would only pick from trees [1,2]. */
/*import java.util.*;
class Fruit{
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        int[] arr=new int[n];
        for(int i=0;i<n;i++){
            arr[i]=sc.nextInt();
        }
        System.out.println(fruit(arr));
    }
    public static int fruit(int[] arr){
        Map<Integer,Integer> map=new HashMap<>();
        int max=Integer.MIN_VALUE;
        int left=0;
        for(int i=0;i<arr.length;i++){
            map.put(arr[i],map.getOrDefault(arr[i],0)+1);
            while(map.size()>2){
                map.put(arr[left],map.getOrDefault(arr[left],0)-1);
                if(map.get(arr[left])==0){
                    map.remove(arr[left]);
                }
                left+=1;
            }
            max=Math.max(max,i-left+1);
            
        }
        return max;
    }
    
} */
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Fruit {

    /**
     * This method returns the maximum number of fruits you can pick
     * from a row of trees such that you only have two baskets (each
     * basket can only hold a single type of fruit, but unlimited quantity).
     *
     * @param fruits An integer array where fruits[i] represents the type of fruit on the i-th tree.
     * @return The maximum number of fruits you can pick in a contiguous manner with at most two distinct fruit types.
     */
    public static int totalFruit(int[] fruits) {
        // A map to store the frequency of each fruit type within the current window.
        Map<Integer, Integer> fruitCountMap = new HashMap<>();

        // Initialize the left pointer of our sliding window to 0.
        int left = 0;

        // Variable to track the maximum number of fruits we can collect in a valid window.
        int maxFruits = 0;

        // We expand the window by moving 'right' from 0 to the end of the fruits array.
        for (int right = 0; right < fruits.length; right++) {
            int currentFruit = fruits[right];

            // Add the current fruit to the map (or update its count if it already exists).
            fruitCountMap.put(currentFruit, fruitCountMap.getOrDefault(currentFruit, 0) + 1);

            // If we have more than two distinct fruit types in our map, shrink from the left.
            while (fruitCountMap.size() > 2) {
                int leftFruit = fruits[left];
                // Decrease the count of the fruit at 'left' since we're removing it from the window.
                fruitCountMap.put(leftFruit, fruitCountMap.get(leftFruit) - 1);
                // If the count drops to zero, remove that fruit type from the map.
                if (fruitCountMap.get(leftFruit) == 0) {
                    fruitCountMap.remove(leftFruit);
                }
                // Move the left pointer to narrow the window.
                left++;
            }

            // Now we have at most 2 distinct fruits in the window [left...right].
            // Update the maxFruits if the current window is larger than any we've seen before.
            maxFruits = Math.max(maxFruits, right - left + 1);
        }

        return maxFruits;
    }

    /**
     * Main method to handle input and output for testing.
     * It reads:
     *   1) The number of trees (n)
     *   2) The list of fruit types in those n trees
     * Then prints the result from totalFruit().
     */
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Read the number of trees.
        int n = sc.nextInt();

        // Create the fruits array and read each fruit type.
        int[] fruits = new int[n];
        for (int i = 0; i < n; i++) {
            fruits[i] = sc.nextInt();
        }

        // Compute the maximum number of fruits you can pick.
        int result = totalFruit(fruits);

        // Print the result.
        System.out.println(result);

        sc.close();
    }
}