import java.util.HashSet;
import java.util.Set;

public class Recursion {
    public static void printReverse(String str,int idx){
        if(idx==0){
            System.out.print(str.charAt(idx));
            return;
        }
        System.out.print(str.charAt(idx));
        printReverse(str, idx-1);
    }
    public static int first=-1;
    public static int last=-1;
    public static void getFirstLastOccurance(String str,int idx,char element){
        if(idx==str.length()){
            System.out.println(first);
            System.out.println(last);
            return;
        }
        char curr=str.charAt(idx);
        if(curr==element){
            if(first==-1){
                first=idx;
            }else{
                last=idx;
            }
        }
        getFirstLastOccurance(str, idx+1, element);
        
    }
    public static boolean isSorted(int arr[],int idx){
        if(idx==arr.length-1){
            return true;
        }
        if(arr[idx]<arr[idx+1]){
            return isSorted(arr, idx+1);
        }else{
            return false;
        }
    }
    public static void MoveAllX(String str,int idx,int count,String newstr){
        if(idx==str.length()){
            for(int i=0;i<count;i++){
                newstr+="x";
            }
            System.out.println(newstr);
            return;
        }
        char curr=str.charAt(idx);
        if(curr=='x'){
            count++;
            MoveAllX(str, idx+1, count, newstr);
        }else{
            newstr+=curr;
            MoveAllX(str, idx+1, count, newstr);
        }
    }
    public static boolean[] map=new boolean[26];
    public static void removeDuplicates(String str,int idx,String newstr){
        if(idx==str.length()){
            System.out.println(newstr);
            return;
        }
        char curr=str.charAt(idx);
        if(map[curr-'a']==true){
            removeDuplicates(str, idx+1, newstr);
        }else{
            newstr+=curr;
            map[curr-'a']=true;
            removeDuplicates(str, idx+1, newstr);
        }
    }
    public static void subsequences(String str,int idx,String newstr,Set<String> set){
        if(idx==str.length()){
            if(set.contains(newstr)){
                return;
            }else{
                System.out.println(newstr);
                set.add(newstr);
                return;
            }
        }

        char curr=str.charAt(idx);

        subsequences(str, idx+1, newstr+curr,set);

        subsequences(str, idx+1, newstr,set);
    }
    public static String[] keypad={".","abc","def","ghi","jkl","mno","pqrs","tuv","wxyz"};
    public static void printCominations(String str,int idx,String combination){
        if(idx==str.length()){
            System.out.println(combination);
            return;
        }
        char curr=str.charAt(idx);
        String map=keypad[curr-'0'];
        for(int i=0;i<map.length();i++){
            printCominations(str, idx+1, combination+map.charAt(i));
        }
    }
    public static void main(String[] args) {
        String str="abcdeadklaaleka";
        printReverse(str, str.length()-1);
        System.out.println();
        getFirstLastOccurance(str, 0, 'a');
        int arr[]={1,2,4,4,5};
        System.out.println(isSorted(arr, 0));
        String st="axbcxxd";
        MoveAllX(st, 0, 0, "");
        removeDuplicates(st, 0, "");
        Set<String> set=new HashSet<>();
        subsequences("aaa", 0, "",set);
        printCominations("4", 0, "");        
    }
}
