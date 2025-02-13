import java.util.*;
public class ClosestPair{
    public static void printClosest(int[] arr1,int[] arr2,int m,int n,int x){
        int l=0,r=n-1;
        int r1=0,r2=0;
        int diff=Integer.MAX_VALUE;
        while(l<m&&r>0){
            if(Math.abs(arr1[l]+arr2[r]-x)<diff){
                r1=arr1[l];
                r2=arr2[r];
                diff=Math.abs(arr1[l]+arr2[r]-x);
            }
            if((arr1[l]+arr2[r])>x){
                r--;
            }else{
                l++;
            }
        }
        System.out.println(r1+","+r2);
    }
    public static void main(String[] args){
        Scanner scan=new Scanner(System.in);
        int m=scan.nextInt();
        int[] arr1=new int[m];
        for(int i=0;i<m;i++){
            arr1[i]=scan.nextInt();
        }
        int n=scan.nextInt();
        int[] arr2=new int[n];
        for(int i=0;i<n;i++){
            arr2[i]=scan.nextInt();
        }
        int x=scan.nextInt();
        printClosest(arr1,arr2,m,n,x);
    }
}