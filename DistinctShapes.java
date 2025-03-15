/*Viraj Aanand is a wedding planner, He ordered his assistant to decorate a wall.
The decorator plans to decorate the wall with two different colored balloons.
The wall size is M*N, The decorator can decorate the wall using M*N balloons
the balloons are blue or white in color.

Blue colored ballons represented with digit-1 and 
White colored ballons represented with digit-0.

The blue colored balloons forms different shapes, that are connected 4 directonally.
The directons are upwards, downwards, left, and right. Viraj Aanand got an idea to 
count the unique shapes formed by blue colored ballons.

You will be given the decorated wall as a matrix wall[][].
Your task is to help, Viraj Aanand to count the unique shapes.

Input Format:
-------------
Line-1: Two space separated integers M and N, size of the wall.
Next M lines: N space separated integers, either 0 or 1.

Output Format:
--------------
Print an integer, Number of distinct shapes formed by blue balloons.


Sample Input-1:
---------------
4 5
1 1 0 0 0
1 1 0 0 0
0 0 0 1 1
0 0 0 1 1

Sample Output-1:
----------------
1


Sample Input-2:
---------------
5 5
1 1 0 1 1
1 0 0 0 1
0 0 0 0 0
1 0 0 0 1
1 1 0 1 1

Sample Output-2:
----------------
4
 */

 import java.util.*;

 public class DistinctShapes {
     public static int countDistinctShapes(int[][] wall) {
         int rows = wall.length, cols = wall[0].length;
         Set<String> uniqueShapes = new HashSet<>();
         boolean[][] visited = new boolean[rows][cols];
 
         for (int i = 0; i < rows; i++) {
             for (int j = 0; j < cols; j++) {
                 if (wall[i][j] == 1 && !visited[i][j]) {
                     List<String> shape = new ArrayList<>();
                     dfs(wall, visited, i, j, i, j, shape);
                     uniqueShapes.add(String.join(",", shape));
                 }
             }
         }
         return uniqueShapes.size();
     }
 
     private static void dfs(int[][] wall, boolean[][] visited, int x, int y, int baseX, int baseY, List<String> shape) {
         int rows = wall.length, cols = wall[0].length;
         if (x < 0 || y < 0 || x >= rows || y >= cols || wall[x][y] == 0 || visited[x][y]) return;
 
         visited[x][y] = true;
         shape.add((x - baseX) + "_" + (y - baseY));  // Normalize shape coordinates
 
         int[][] directions = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}}; // Up, Down, Left, Right
         for (int[] dir : directions) {
             dfs(wall, visited, x + dir[0], y + dir[1], baseX, baseY, shape);
         }
     }
 
     public static void main(String[] args) {
         Scanner sc = new Scanner(System.in);
         int M = sc.nextInt(), N = sc.nextInt();
         int[][] wall = new int[M][N];
 
         for (int i = 0; i < M; i++)
             for (int j = 0; j < N; j++)
                 wall[i][j] = sc.nextInt();
 
         System.out.println(countDistinctShapes(wall));
     }
 }
 