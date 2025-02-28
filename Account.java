import java.util.Arrays;

public class Account {
    int id;
    String name;
    double balance;
    Account(int i,String s,double b){
        id=i;
        name=s;
        balance=b;
    }
    @Override
    public boolean equals(Object obj){
        System.out.println("Object equals called");
        if((obj instanceof Account)&&(((Account)obj).name==this.name&&((Account)obj).balance==this.balance)){
            return true;
        }else{
            return false;
        }
    }
    @Override
    public String toString(){
        return "hello";
    }
    public static void main(String[] args) {
        Account b=new Account(1, "abc", 100.0);
        Account b1=new Account(2, "abc", 10.0);
        System.out.println(b.equals(b1));
        System.out.println(b.toString());
        String s1=new String("hello");
        String s2=new String("hello");
        System.out.println(s1==s2);
        System.out.println(s1.equals(s2));
        int[] a=new int[2];
        System.out.println(a[1]);
        int[] arr2,arr3={3,9};
        // System.out.println(arr2[0]);
        System.out.println(arr3[1]);
        String[] str1={"hello","world"};
        String[] str2=str1;
        String[][] s={{"hello"},{"world"}};
        System.out.println(Arrays.deepToString(s));
        System.out.println(str1.toString());
        String[] arr4=new String[2];
        System.out.println(arr4[0]);
        System.out.println(arr4.length);
        String[] sarr={"17","4","21"};
        Arrays.sort(sarr);
        for(String sarrr:sarr){
            System.out.println(sarrr);
        }
    }
}
