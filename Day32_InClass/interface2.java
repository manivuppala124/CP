 interface Demo{
  int m1();
  public void m2();
   final int x = 10;
}
public class interface2 implements Demo{   
  public int m1(){
    return 10;
  } 
  public void m2(){
    System.out.println("ehllo");
  }
  public static void main(String[] args)
  {
    interface2 obj = new interface2();
    System.out.println(obj.m1());
    obj.m2();
  }
}
