import app11.PrintList;
import app9.DepoList;



public class Test {

	public static void main(String... args) {
        PrintList<Integer> list = new PrintList<>();

        for(int i = 0; i < 10; i++){
            list.add(i);
        }

        list.printList(false);
        list.printList(true);
	}
}
