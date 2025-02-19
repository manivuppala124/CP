import java.util.*;
public class bwXor{
    public static String lowercase(char[] a){
        for (int i=0; i<a.length; i++)
{
//Bitwise XOR with 32
a[i]^=32;
}
return new String(a);
    }
    public static void main(String[] args) {
        Scanner scan=new Scanner(System.in);
        String s=scan.nextLine();
        System.out.println(lowercase(s.toCharArray()));
    }
}