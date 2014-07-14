package deposit;

import deposit.app10.Dictionary;



public class Test {

	public static void main(String... args) {
        Dictionary dictionary = new Dictionary();
        dictionary.read("C:\\in.txt");
        System.out.println(dictionary.getTranslate("Close Something"));
	}
}
