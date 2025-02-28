/*Given an integer array nums sorted in non-decreasing order, 
return an array of the squares of each number sorted in non-decreasing order.

Input Format:
-------------
Line-1: An integer N
Line-2: N space seperated integers

Output Format:
--------------
Line-1: A list of integers

Sample Input-1:
---------------
5
-4 -1 0 3 10

Sample Output-1: 
----------------
[0, 1, 9, 16, 100]

 */
import java.util.*;
public class SquaresOfSorted{
    public static int[] sos(int n,int[] a){
        int[] res=new int[n];
        int l=0,r=n-1,k=n-1;
        while(l<=r){
            if(Math.abs(a[l])<Math.abs(a[r])){
                res[k]=a[r]*a[r];
                k--;
                r--;
            }else{
                res[k]=a[l]*a[l];
                k--;
                l++;
            }
        }
        return res;
    }
    public static void main(String[] args){
        Scanner scan=new Scanner(System.in);
        int n=scan.nextInt();
        int[] a=new int[n];
        for(int i=0;i<n;i++){
            a[i]=scan.nextInt();
        }
        System.out.println(Arrays.toString(sos(n,a)));
    }
}
