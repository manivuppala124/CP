// You have a collection of accessories, each having a price and belonging to a specific category. 
// Your task is to create unique disguises by selecting at most one accessory from each category. 
// (It is acceptable to not choose an accessory from a category, 
// but a valid disguise must include at least one accessory overall.)

// Input Format:
// -------------
// Line 1: An integer n indicating the number of accessories.
// Lines 2 to n+1: Each line contains two space-separated values: an integer price and a string category.

// Output Format:
// --------------
// Print a single integer representing the total number of distinct disguises possible.

// Sample Input-1:
// ---------------
// 5
// 100 leather
// 150 leather
// 200 denim
// 250 denim
// 300 cotton


// Sample Output-1:
// ----------------
// 17

// Explanation:
// -------------
// leather: 2, denim: 2, cotton: 1
// Product = (2+1)×(2+1)×(1+1)=3×3×2=18; minus 1 → Expected Output: 17

// Sample Input-2:
// ---------------
// 3
// 150 cotton
// 250 wool
// 350 polyester

// Sample Output-2:
// ----------------
// 7

// Explanation:
// ------------
// Each category appears once → product =2×2×2=8; minus 1 → Expected Output: 7

// Note: 
// The price is provided as additional information and does not affect the number of disguises.
// Remember to exclude the scenario where no accessory is chosen.

import java.util.*;

public class DisguiseCounter {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = Integer.parseInt(sc.nextLine()); // number of accessories
        Map<String, Integer> categoryCount = new HashMap<>();

        for (int i = 0; i < n; i++) {
            String[] input = sc.nextLine().split(" ");
            // price is irrelevant, so skip it
            String category = input[1];
            categoryCount.put(category, categoryCount.getOrDefault(category, 0) + 1);
        }

        long result = 1;
        for (int count : categoryCount.values()) {
            result *= (count + 1);  // +1 means option to not pick from this category
        }

        result -= 1; // remove the "pick nothing" case

        System.out.println(result);
    }
}
