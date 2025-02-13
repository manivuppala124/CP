/*Given an integer array of nums and an integer window size X, 
return true if there are duplicate values (nums[i]== nums[j])in that Window(X)
X size is always <= abs(i - j) where i and j are two distinct indices of array.

Input Format:
-------------
Line-1: An integer N, Array Size
Line-2: Space separated integers, array elements
Line-3: An integer X, window size

Output Format:
--------------
Line-1: Booelan value, true/false


Sample Input-1:
---------------
4
1 2 3 1  
3 

Sample Output-1: 
----------------
false

Sample Input-2:
---------------
6
1 2 3 3 2 3
2

Sample Output-2: 
----------------
true */
import java.util.*;
public class DuplicateWindow{
    public static boolean hasDuplicate(int[] nums,int k){
        int n = nums.length;
        int i = 0, j = 0;
        Set<Integer> set = new HashSet<>();
        while (j < n){
        if (set.contains(nums[j]))
            return true;
        set.add(nums[j]);
        while (j - i + 1 >= k){
                set.remove(nums[i]);
                i++;
            }
            j++;
        }
        return false;
    }
    public static void main(String[] args){
        Scanner scan=new Scanner(System.in);
        int n=scan.nextInt();
        int[] arr=new int[n];
        for(int i=0;i<n;i++){
            arr[i]=scan.nextInt();
            
        }
        int x=scan.nextInt();
        System.out.println(hasDuplicate(arr,x));
    }
}
