package practice;
interface Greetings{
    void greet(String s);
}
public class WithLambda {
    public static void main(String[] args) {
        Greetings g=message->{System.out.println("hi message");};
        Greetings g1=(message)->System.out.println("person2");
        Greetings g2=(String message)->{System.out.println("with");};
        System.out.println(g.getClass().getName());
        System.out.println(g1.getClass().getName());
        g.greet("hi");
        g1.greet("hello");
        g2.greet("h");
    }
}
