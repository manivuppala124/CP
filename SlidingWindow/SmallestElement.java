/* You are given an array consisting of N integers, and an integer, K. 
Your task is to determine the minimum element in subarrays of size K.

Sample Input1:
--------------
5
10 12 14 11 15
3

Sample Output1:
---------------
10 11 11

Sample Input2:
--------------
5
5 2 1 1 1
4

Sample Output2:
---------------
1 1

*/
import java.util.*;
public class SmallestElement{
    public static void unique(int n,int p,int[] arr){
        int res[]=new int[n-p+1];
        for(int i=0;i<n-p+1;i++){
            int min=arr[i];
            for(int j=i+1;j<i+p;j++){
                if(arr[j]<min){
                    min=arr[j];
                }
            }
            res[i]=min;
        }
        for(int i=0;i<res.length;i++){
            System.out.println(res[i]+" ");
        }
    }
    public static void main(String[] args){
        Scanner scan=new Scanner(System.in);
        int n=scan.nextInt();
        int arr[]=new int[n];
        for(int i=0;i<n;i++){
            arr[i]=scan.nextInt();
            
        }
        int p=scan.nextInt();
        unique(n,p,arr);
    }
}