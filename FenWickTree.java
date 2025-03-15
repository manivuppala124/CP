/*Malika taught a new fun time program practice for Engineering Students.
As a part of this she has given set of N numbers, and asked the students 
to perform the operations listed below:
1. sumRange(start, end) - return the sum of numbers between the indices start and end, both are inclusive.
2. update(ind, val) - update the value at the index 'ind' to 'val'.

Your task is to solve this problem using Fenwick Tree concept.

Input Format:
-------------
Line-1: Two integers N and Q, size of the array(set of numbers) and query count.
Line-2: N space separated integers.
next Q lines: Three integers option, start/ind and end/val.

Output Format:
--------------
An integer result, for every sumRange query.


Sample Input-1:
---------------
8 5
1 2 13 4 25 16 17 8
1 2 6		//sumRange
1 0 7		//sumRange
2 2 18	//update
2 4 17	//update
1 2 7		//sumRange

Sample Output-1:
----------------
75
86
80



Sample Input-2:
---------------
8 5
1 2 13 4 25 16 17 8
1 2 6		
1 0 7		
2 2 18	
2 4 17	
1 0 7

Sample Output-2:
----------------
75
86
83
 */
import java.util.*;
public class FenWickTree{
    int[] nums;
    int[] bit;
    int n;
    FenWickTree(int[] nums,int n){
        this.nums=nums;
        this.n=n;
        bit=new int[n+1];
        for(int i=0;i<n;i++){
            init(i,nums[i]);
        }
    }
    public void init(int i,int val){
        i++;
        while(i<=n){
            bit[i]+=val;
            i+=(i&-i);
        }
    }
    public int sumRange(int i,int j){
        return getSum(j)-getSum(i-1);
    }
    public int getSum(int i){
        i++;
        int sum=0;
        while(i>0){
            sum+=bit[i];
            i-=(i&-i);
        }
        return sum;
    }
    public void update(int i,int val){
        int diff=val-nums[i];
        nums[i]=val;
        init(i,diff);
    }
    public static void main(String[] args){
        Scanner scan=new Scanner(System.in);
        int n=scan.nextInt();
        int operations=scan.nextInt();
        int[] a=new int[n];
        for(int i=0;i<n;i++){
            a[i]=scan.nextInt();
        }
        int[] count=new int[operations];
        int k=0,m=0;
        FenWickTree ft=new FenWickTree(a,n);
        while(operations-->0){
            int opt=scan.nextInt();
            if(opt==1){
                int i1=scan.nextInt();
                int i2=scan.nextInt();
                count[k++]=ft.sumRange(i1,i2);
            }else if(opt==2){
                int i=scan.nextInt();
                int val=scan.nextInt();
                ft.update(i,val);
                m++;
            }
        }
        for(int i=0;i<count.length-m;i++){
            System.out.println(count[i]);
        }
    }
}
