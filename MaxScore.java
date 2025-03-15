/*You are given an array of positive integers. 
Your task is to find a contiguous subarray where all elements are unique 
and return the maximum possible sum that can be obtained by erasing exactly one such subarray.

A subarray is defined as a contiguous sequence of elements within the given array.

Input Format:
-------------
Line-1: An integer N, representing the number of elements in the array.
Line-2: Space-separated integers, representing the elements of the array.

Output Format:
--------------
Line-1: A single integer, representing the maximum sum of a contiguous subarray with all unique elements.

Sample Input-1:
---------------
5  
4 2 4 5 6  

Sample Output-1:
----------------
17

Explanation:
-------------
The longest unique subarray is [2, 4, 5, 6] with a sum of 2 + 4 + 5 + 6 = 17.
This is the maximum possible sum that can be obtained.


Sample Input-2:
---------------
6  
1 2 3 1 2 3  

Sample Output-2:
----------------
6


Explanation:
------------
The longest unique subarray is [1, 2, 3] with a sum of 1 + 2 + 3 = 6.
This sum cannot be improved by choosing another unique subarray.
 */
import java.util.*;
public class MaxScore{
    public static int check(int n,int[] a){
        int l=0,r=0,sum=0,maxsum=0;
        Set<Integer> s=new HashSet<>();
        while(r<n){
            if(!s.contains(a[r])){
                s.add(a[r]);
                sum+=a[r];
                maxsum=Math.max(maxsum,sum);
                r++;
            }else{
                s.remove(a[l]);
                sum-=a[l];
                l++;
            }
        }
        return maxsum;
    }
    public static void main(String[] args){
        Scanner scan=new Scanner(System.in);
        int n=scan.nextInt();
        int[] a=new int[n];
        for(int i=0;i<n;i++){
            a[i]=scan.nextInt();
        }
        System.out.println(check(n,a));
    }
}
