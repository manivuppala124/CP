import java.util.*;
class TwoSum{
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        int[] arr=new int[n];
        for(int i=0;i<n;i++){
            arr[i]=sc.nextInt();
        }
        int k=sc.nextInt();
        List<Integer> res=twosum(arr,k);
        System.out.println(res);
    }
    public static List<Integer> twosum(int[] arr,int k){
        List<Integer> res=new ArrayList<>();
        int st=0;
        int end=arr.length-1;
        for(int i=0;i<arr.length;i++){
            if(arr[st]+arr[end]==k){
                res.add(st+1);
                res.add(end+1);
                break;
            }
            else if(arr[st]+arr[end]>k){
                end-=1;
            }
            else{
                st+=1;
            }
        }
        return res;
    }
}