class Test{
    int i;
    Test(int x){
        this();
        i=x;
    }
    Test(){
        System.out.println("called through test with one argument");
    }
    int geti(){
        return i;
    }
}
class TestChild extends Test{
    static int i;
    TestChild(int x){
        super(x);
    }
    public static void main(String[] args) {
        TestChild tc=new TestChild(10);
        System.out.println(tc.i);
    }
}