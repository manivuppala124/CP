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
    public static void main(String[] args) {
        Account b=new Account(1, "abc", 100.0);
        Account b1=new Account(2, "abc", 10.0);
        System.out.println(b.equals(b1));
    }
}
