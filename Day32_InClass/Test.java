interface I1{
	void m1();
}
interface I2{
	void m1(int x);
}
class Test implements I1,I2{
	public void m1(){
		System.out.println("m1");
	}
	public void m1(int x){
		System.out.println("m1 with one argument");
	}
	public static void main(String[] args){
		Test obj = new Test();
		obj.m1();
		obj.m1(10);
	}
}