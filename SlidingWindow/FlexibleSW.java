/*You are given an array books, where each element represents the time (in minutes) required to read a book. 
You are also given an integer k, which represents the total available reading time in minutes.

Your task is to determine the maximum number of books that can be read within the given time k 
while ensuring that the sum of reading times does not exceed k.

You must find the longest contiguous subarray where the sum of elements is less than or equal to k, 
and return its length.

Input Format:
-------------
Line-1: An integer 'n' representing the number of books.
Line-2: 'n' space-separated integers representing the time (in minutes) required to read each book.
Line-3: An integer 'k', the available reading time in minutes.

Output Format:
--------------
Line-1: An integer representing the maximum number of books that can be read within 'k' minutes.

Sample Input-1:
---------------
8
1 1 2 1 1 1 4 2
8

Sample Output-1:
----------------
6

Explanation:
------------
We must find the longest subarray where the sum is ≤ 8.
Possible valid subarrays: [1, 1, 2, 1, 1, 1], [1, 2, 1, 1, 1], [2, 1, 1, 1], etc.
The longest valid subarray has a length of 6.

Sample Input-2:
---------------
7
2 3 1 2 4 3 1
5

Sample Output-2:
----------------
3

Explanation:
-------------
Possible valid subarrays: [2, 3], [3, 1, 2], [1, 2, 1], [2, 3], etc.
The longest valid subarray has a length of 3.


 */
/*import java.util.*;
class FlexibleSW{
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        int[] arr=new int[n];
        for(int i=0;i<n;i++){
            arr[i]=sc.nextInt();
        }
        int k=sc.nextInt();
        System.out.println(slidingwindow(arr,k));
    }
    public static int slidingwindow(int[] arr,int k){
        int right,left=0,sum=0,max=0;
        for(right=0;right<arr.length;right++){
            sum+=arr[right];
            while(sum>k){
                sum-=arr[left];
                left+=1;
            }
            max=Math.max(max,right-left+1);
        }
        return max;
        
        
    }
} */
import java.util.*;
public class FlexibleSW{
    static int maxSubArraySum(int[] books,int k){
        int l=0;
        int r=0;
        int sum=0;
        int maxbooks=0;
        for(r=0;r<books.length;r++){
            sum+=books[r];
            while(sum>k){
                sum-=books[l];
                l++;
            }
            maxbooks=Math.max(maxbooks,r-l+1);
        }
        return maxbooks;
    }
    public static void main(String[] args){
        Scanner scan=new Scanner(System.in);
        int n=scan.nextInt();
        int[] arr=new int[n];
        for(int i=0;i<n;i++){
            arr[i]=scan.nextInt();
        }
        int k=scan.nextInt();
        System.out.println(maxSubArraySum(arr,k));
    }
}