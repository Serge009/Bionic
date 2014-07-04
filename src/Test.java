import app10.Dictionary;



public class Test {

	public static void main(String... args) {
		Dictionary d = new Dictionary();
		
		System.out.println(d.getTranslate("Save"));
		System.out.println(d.getTranslate("Remove"));
		System.out.println(d.getTranslate("Cancel"));
		System.out.println(d.getTranslate("Ok"));
		System.out.println(d.getTranslate("No Translation"));
	}
}
