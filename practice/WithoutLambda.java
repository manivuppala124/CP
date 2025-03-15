package practice;
interface Greetings  {
    String greet(String s);
}
public class WithoutLambda implements Greetings {
    public String greet(String s){
            return "Hello world";
        }
        public static void main(String[] args) {
            Greetings g=new WithoutLambda();
            System.out.println(g.greet("hi"));
        }
}
