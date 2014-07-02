
public class Test {
	
	public static void main(String... args){
		MyClass c = new MyClass();
		System.out.println(Interface1.VAL_B);
	}
	
}


class MyClass implements Interface1, Interface2 {
	 @Override
	public void h() {
		// TODO Auto-generated method stub
		
	}
	public void f() { }
	 public void g() { }
	}
	 
interface Interface1 {
	 int VAL_A = 1;
	 int VAL_B = 2;
	 
	 void f();
	 void g();
}
 
interface Interface2 {
	 int VAL_B = 3;
	 int VAL_C = 4;
	 
	 void g();
	 void h();
}
