/*You are given a 0-indexed integer array nums.

We say that an integer x is expressible from nums if there exist some integers 0 <= index1 < index2 < ... < indexk < nums.length for which nums[index1] | nums[index2] | ... | nums[indexk] = x. In other words, an integer is expressible if it can be written as the bitwise OR of some subsequence of nums.

Return the minimum positive non-zero integer that is not expressible from nums.

Sample Input-1:
---------------
2
2 1

Sample Output-1:
----------------
4

Explanation: 
------------
1 and 2 are already present in the array. We know that 3 is expressible, since nums[0] | nums[1] = 2 | 1 = 3. 
Since 4 is not expressible, we return 4.

Sample Input-2:
---------------
3
5 3 2

Sample Output-2: 
----------------
1

Explanation: We can show that 1 is the smallest number that is not expressible.
 

Constraints:
------------
1 <= nums.length <= 10^5
1 <= nums[i] <= 10^9
 */
import java.util.*;
public class ImpossibleOrBitManipulation{
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        int[] arr=new int[n];
        for(int i=0;i<n;i++){
            arr[i]=sc.nextInt();
        }
        System.out.println(helper(arr,n));
    }
    public static int helper(int[] arr,int n){
        Set<Integer> set=new HashSet();
        for(int i=0;i<arr.length;i++){
            for(int j=i;j<arr.length;j++){
                set.add(arr[i]|arr[j]);
            }
            set.add(arr[i]);
        }
        int c=1;
        while(true){
            if(!set.contains(c)){
                return c;
            }
            c+=1;
        }
    
    }
}