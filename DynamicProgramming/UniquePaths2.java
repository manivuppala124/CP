/*You are navigating a spaceship through a galaxy represented as an m x n space 
map.The spaceship starts from the top-left sector (sector[0][0]) and its 
mission is to safely reach the bottom-right sector (sector[m-1][n-1]).

Each sector on the map can either be clear (0) or blocked by an 
asteroid field (1).  
The spaceship can only move right or downward at any moment.  
It cannot pass through sectors with asteroid fields.

Return the total number of distinct safe routes the spaceship can take to 
reach its destination at the bottom-right corner.


Input format:
-------------
2 space seperated integers, m & n
next m lines of representing the sector 

Output format:
--------------
An integer, the total number of distinct safe routes



Example 1:
----------
Input:
3 3
0 0 0
0 1 0
0 0 0

Output:
2

Explanation:  
There's one asteroid field blocking the center of the 3×3 map.  
Two possible safe navigation paths:
- Move → Move → Down → Down
- Down → Down → Move → Move

Example 2:
---------
Input:
2 2
0 1
0 0

Output:
1


Constraints:
- m == sectorMap.length
- n == sectorMap[i].length
- 1 <= m, n <= 100
- sectorMap[i][j] is either 0 (clear) or 1 (asteroid field)
 */
import java.util.*;

public class UniquePaths2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int m = sc.nextInt(), n = sc.nextInt();
        int[][] grid = new int[m][n];
        for (int i = 0; i < m; i++)
            for (int j = 0; j < n; j++)
                grid[i][j] = sc.nextInt();
        System.out.println(uniquePathsWithObstacles(grid));
        sc.close();
    }

    public static int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int m = obstacleGrid.length, n = obstacleGrid[0].length;
        int[][] dp = new int[m][n];
        for (int i = 0; i < m && obstacleGrid[i][0] == 0; i++) dp[i][0] = 1;
        for (int j = 0; j < n && obstacleGrid[0][j] == 0; j++) dp[0][j] = 1;
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                if (obstacleGrid[i][j] == 0)
                    dp[i][j] = dp[i - 1][j] + dp[i][j - 1];
            }
        }
        return obstacleGrid[m - 1][n - 1] == 1 ? 0 : dp[m - 1][n - 1];
    }
}
