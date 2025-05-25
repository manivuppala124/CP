import java.util.ArrayList;

public class Recursion2 {
    public static void printPermutations(String str,String permutation){
        if(str.length()==0){
            System.out.println(permutation);
            return;
        }
        for(int i=0;i<str.length();i++){
            char curr=str.charAt(i);
            String newstr=str.substring(0, i)+str.substring(i+1);
            printPermutations(newstr, permutation+curr);
        }
    }
    public static int placeTiles(int n,int m){
        if(n==m){
            return 2;
        }
        if(n<m){
            return 1;
        }
        int vertPlacements=placeTiles(n-m, m);
        int horPlacements=placeTiles(n-1, m);
        return vertPlacements+horPlacements;
    }
    public static int totalPathsMaze(int i,int j,int n, int m){
        if(i==n||j==m){
            return 0;
        }
        if(i==n-1&&j==m-1){
            return 1;
        }
        //move downwords
        int down=totalPathsMaze(i+1, j, n, m);
        int right=totalPathsMaze(i, j+1, n, m);
        return down+right;
    }
    public static int callGuests(int n){
        if(n<=1){
            return 1;
        }

        int ways1=callGuests(n-1);
        int ways2=(n-1)*callGuests(n-2);
        return ways1+ways2;
    }
    public static void printSubset(ArrayList<Integer> l){
        for(int i=0;i<l.size();i++){
            System.out.print(l.get(i)+" ");
        }
        System.out.println();
    }
    public static void findSubsets(int n,ArrayList<Integer> l){
        if(n==0){
            printSubset(l);
            return;
        }
        l.add(n);
        findSubsets(n-1, l);
        l.remove(l.size()-1);
        findSubsets(n-1, l);
    }
    public static void main(String[] args) {
        printPermutations("abc", "");
        System.out.println(totalPathsMaze(0, 0, 3, 4));
        System.out.println(placeTiles(4, 2));
        System.out.println(callGuests(4));
        int n=3;
        ArrayList<Integer> l=new ArrayList<>();
        findSubsets(3, l);
    }
}
/*
 import java.util.*;
 public class Questions{
 public static int averageOfThree(int a,int b,int c){
 return (a+b+c)/3;
 }
 public static int sumOfOdd(int n){
 int sum=0;
 for(int i=1;i<=n;i++){
 if(i%2!=0){
 sum+=i;
 }
 }
 return sum;
 }
 public static int circumferenceOfCircle(int radius){
 return 2*3.14*radius;
 }
 public static void checkEligibleVote(int age){
 if(age>=18){
 System.out.println("Eligible to vote");
 }
 else{
 System.out.println("Not eligible to vote");
 }
 }
 public static int greaterOfTwo(int a,int b){
 return Math.max(a,b);}
 public static void infiniteWhileLoop(){
 int i=1;
 while(true){
 System.out.println(i);
 i++;
 }
 }
 public static void main(String args[]){
 Scanner sc=new Scanner(System.in);
 int a=sc.nextInt();
 int b=sc.nextInt();
 int c=sc.nextInt();
 System.out.println(averageOfThree(a,b,c));
 System.out.println(sumOfOdd(5));
 System.out.println(greaterOfTwo(a,b));
 System.out.println(circumferenceOfCircle(5));
 System.out.println(checkEligibleVote(20));
 infiniteWhileLoop();

 }
 }

 */