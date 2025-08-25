/*A Kid built a structure using building blocks, 
by placing the building-blocks adjacent to each other.

A building-block is a vertical alignment of blocks.
									___
here one block each represents  as |___|.

The following structure made up of using building blocks

                          ___
                      ___|___|    ___
                     |___|___|_w_|___|___              ___
                  ___|___|___|___|___|___| w   _w_  w |___| 
              ___|___|___|___|___|___|___|_w__|___|_w_|___|____________
    
               0  1   3   4   2   3    2   0   1   0   2

Once the structure is completed, kid pour water(w) on it.

You are given a list of integers, heights of each building-block in a row.
 Now your task How much amount of water can be stored by the structure.

Input Format:
-------------
Space separated integers, heights of the blocks in the structure. 

Output Format:
--------------
Print an integer, 
  
Sample Input:
-------------
0 1 3 4 2 3 2 0 1 0 2
    
Sample Output:
--------------
6
    
Explanation:
-----------
In the above structure,  6 units of water (w represents the water in the 
structure) can be stored. */
public class BuildingBlocks {
    public static void main(String[] args) {
        java.util.Scanner sc = new java.util.Scanner(System.in);
        String[] tokens = sc.nextLine().trim().split(" ");
        int[] heights = new int[tokens.length];
        for (int i = 0; i < tokens.length; i++) {
            heights[i] = Integer.parseInt(tokens[i]);
        }
        System.out.println(trapWater(heights));
        sc.close();
    }

    public static int trapWater(int[] height) {
        if (height == null || height.length == 0) return 0;
        int n = height.length;
        int[] leftMax = new int[n];
        int[] rightMax = new int[n];
        leftMax[0] = height[0];
        for (int i = 1; i < n; i++) {
            leftMax[i] = Math.max(leftMax[i-1], height[i]);
        }
        rightMax[n-1] = height[n-1];
        for (int i = n-2; i >= 0; i--) {
            rightMax[i] = Math.max(rightMax[i+1], height[i]);
        }
        int water = 0;
        for (int i = 0; i < n; i++) {
            water += Math.min(leftMax[i], rightMax[i]) - height[i];
        }
        return water;
    }
}
