/*In a joint family, every person is assigned with an ID, an integer value.
and the entire family is arranged in the from of tree.

You will be given the family tree and two persons IDs P1 and P2.
Your task is to find the person ID, who is the latest common ascendant of P1 and P2.
and return the Lowest Common Ascendant ID.

Implement the class Solution:
    - Node lowestCommonAscendant(Node root, Node P1, Node P2):
        return the person ID who is the latest common ascendant of P1 and P2.

Input Format:
-------------
Line-1: Single line of space separated integers, person ID's in the family.
Line-2: Two Person IDs, P1 and P2.

Output Format:
--------------
Return the latest common ascendant of P1 and P2.


Sample Input-1:
---------------
3 5 1 6 2 0 8 -1 -1 7 4
6 4

Sample Output-1:
----------------
5

Sample Input-2:
---------------
11 99 88 77 22 33 66 55 10 20 30 40 50 60 44
66 55

Sample Output-2:
----------------
11

 */
import java.util.*;

class Node 
{
    public int data;
    public Node left;
    public Node right;
    public Node(int value) 
	{
        data = value;
        left = null;
        right = null;
    }
}

public class LowestCommonAncestor
{
    public static void main(String[] args) 
	{
        Scanner sc = new Scanner(System.in);
        
        String[] arr= sc.nextLine().split(" ");
        String[] persons = sc.nextLine().split(" ");
        
        List<Integer> v = new ArrayList<>();
        int n=arr.length;
        for (int i = 0; i < n; i++) 
		{
            v.add(Integer.parseInt(arr[i]));
        }
        
        Node P1 = new Node(Integer.parseInt(persons[0]));
        Node P2 = new Node(Integer.parseInt(persons[1]));
        Queue<Node> q = new LinkedList<>();
		Node root = new Node(v.get(0));
      
        //Write necessary code
        Node res=new Solution().lowestCommonAscendant(root, P1, P2);
        System.out.println(res.data);
  }
}

class Solution 
{
    Node lowestCommonAscendant(Node root, Node P1, Node P2)
	{
		//Write your code here
    }
}

