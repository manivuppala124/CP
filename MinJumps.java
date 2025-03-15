/*Given an array of integers arr, you are initially positioned at the first index of the array.

In one step you can jump from index i to index:
i + 1 where: i + 1 < arr.length.
i - 1 where: i - 1 >= 0.
j where: arr[i] == arr[j] and i != j.

Return the minimum number of steps to reach the last index of the array.

Notice that you can not jump outside of the array at any time.

Input Format:
-------------
Line-1: An integer n
Line-2: n space separated integers

Output Format:
--------------
Line-1: An integer

Sample Input-1:
---------------
10
100 -23 -23 404 100 23 23 23 3 404

Sample Output-1:
----------------
3

Explanation: You need three jumps from index 0 --> 4 --> 3 --> 9. Note that index 9 is the last index of the array.

Sample Input-2:
---------------
1
7

Sample Output-2: 
----------------
0

Explanation: Start index is the last index. You do not need to jump.

Sample Input-3:
---------------
8
7 6 9 6 9 6 9 7

Sample Output-3:
----------------
1

Explanation: You can jump directly from index 0 to index 7 which is last index of the array.
 
 Constraints:
 ------------
1 <= arr.length <= 5 * 10^4
-10^8 <= arr[i] <= 10^8 */
import java.util.*;

public class MinJumps {
    public static int minJumps(int[] arr) {
        int n = arr.length;
        if (n == 1) return 0; // Already at the last index

        // Step 1: Build a map of value -> list of indices
        Map<Integer, List<Integer>> graph = new HashMap<>();
        for (int i = 0; i < n; i++) {
            graph.computeIfAbsent(arr[i], k -> new ArrayList<>()).add(i);
        }

        // Step 2: BFS initialization
        Queue<Integer> queue = new LinkedList<>();
        boolean[] visited = new boolean[n];
        queue.add(0);
        visited[0] = true;
        int steps = 0;

        // Step 3: BFS traversal
        while (!queue.isEmpty()) {
            int size = queue.size();
            while (size-- > 0) {
                int curr = queue.poll();

                // If we reached the last index
                if (curr == n - 1) return steps;

                // Explore adjacent indices
                List<Integer> nextMoves = new ArrayList<>();
                if (curr - 1 >= 0) nextMoves.add(curr - 1);
                if (curr + 1 < n) nextMoves.add(curr + 1);
                
                // Jump to all indices with the same value
                if (graph.containsKey(arr[curr])) {
                    nextMoves.addAll(graph.get(arr[curr]));
                    // Avoid revisiting the same value group
                    graph.remove(arr[curr]);
                }

                for (int next : nextMoves) {
                    if (!visited[next]) {
                        queue.add(next);
                        visited[next] = true;
                    }
                }
            }
            steps++; // Increment step count at each BFS level
        }

        return -1; // Should never reach here
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
        System.out.println(minJumps(arr));
    }
}

