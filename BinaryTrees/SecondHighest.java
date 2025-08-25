/*In an Intelligence Agency, each senior officer supervises either two junior officers 
or none. The senior officer is assigned a clearance level equal to the higher clearance 
level of the two junior officers they supervise.

The clearance levels are represented as integer values in the range [1, 50], and multiple 
officers may have the same clearance level.

At the end, all officers (senior and junior) are collectively referred to as agents in the system.

You are provided with a hierarchical clearance level tree where each node represents 
an officer's clearance level. The tree structure follows these rules:
	- If a node has two children, its clearance level is the maximum of the two children's
	  clearance levels.
	- If a node has no children, it's clearance level is same as exists.
	- The value -1 indicates an empty (null) position.
Your task is to find the second highest clearance level among all agents in the agency. 
If no such level exists, return -2.

Input Format:
-------------
A single line of space separated integers, clearance levels of each individual.

Output Format:
--------------
Print an integer, second top agent based on rank.


Sample Input-1:
---------------
5 5 4 -1 -1 2 4

Sample Output-1:
----------------
4


Sample Input-2:
---------------
3 3 3 3 3

Sample Output-2:
----------------
-2 */
import java.util.*;

class TreeNode {
    Integer val;
    TreeNode left, right;

    TreeNode(Integer val) {
        this.val = val;
        this.left = this.right = null;
    }
}

class Solution {
    public int secondHighest(TreeNode root) {
        // We need to find the second highest value among all nodes in the tree.
        // If all values are the same or only one unique value, return -2.

        // Use a set to collect all unique values (excluding -1/nulls)
        Set<Integer> unique = new HashSet<>();
        collectValues(root, unique);

        // Remove -1 if present (since -1 means null)
        unique.remove(-1);

        if (unique.size() < 2) {
            return -2;
        }

        // Find the highest and second highest
        int max = Integer.MIN_VALUE;
        int second = Integer.MIN_VALUE;
        for (int v : unique) {
            if (v > max) {
                second = max;
                max = v;
            } else if (v > second && v < max) {
                second = v;
            }
        }
        return second;

    }

    private void collectValues(TreeNode node, Set<Integer> set) {
        if (node == null) return;
        set.add(node.val);
        collectValues(node.left, set);
        collectValues(node.right, set);
    }
}

class Main {
    public static TreeNode buildTree(List<Integer> data) {
        if (data.isEmpty() || data.get(0) == -1) {
            return null;
        }
        
        TreeNode root = new TreeNode(data.get(0));
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        
        int i = 1;
        while (!queue.isEmpty() && i < data.size()) {
            TreeNode current = queue.poll();
            
            // Left child
            if (i < data.size() && data.get(i) != -1) {
                current.left = new TreeNode(data.get(i));
                queue.offer(current.left);
            }
            i++;
            
            // Right child
            if (i < data.size() && data.get(i) != -1) {
                current.right = new TreeNode(data.get(i));
                queue.offer(current.right);
            }
            i++;
        }
        
        return root;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] input = scanner.nextLine().split(" ");
        List<Integer> data = new ArrayList<>();
        for (String s : input) {
            data.add(Integer.parseInt(s));
        }
        scanner.close();

        TreeNode root = buildTree(data);
        int secondTop = new Solution().secondHighest(root);
        System.out.println(secondTop);
    }
}