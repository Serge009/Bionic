package deposit.app5;

/*
Give performance coefficients from Exercise 3.1.4 for n = 10, n = 100, n = 1000, n = 10000, and n = 100000
*/

public class Main {

    public static void main(String[] args) {
        test(10);
        test(100);
        test(1000);
        test(10000);
        test(100000);
    }


    /**
     * test performance of generateString and generateStringBuilder methods
     * @param
     * @description n
     *
     */
    public static void test(int n){
        long start;
        long middle;
        long end;
        double res;

        start = System.nanoTime();
        generateString(n);
        middle = System.nanoTime();
        generateStringBuilder(n);
        end = System.nanoTime();

        res = (double)(middle - start) / (end - middle);
        System.out.println("n = " + n + "; res = " + res);
    }

    /**
     * @param n
     * @return generated String
     */
    public static String generateString(int n){
        String res = null;
        for(int i = 1; i <= n; i++){
            res += i + " ";
        }
        return res;
    }

    /**
     * @param n
     * @return generated StringBuilder object
     */
    public static StringBuilder generateStringBuilder(int n){
        StringBuilder res = new StringBuilder();
        for(int i = 1; i <= n; i++){
            res.append(i + " ");
        }
        return res;
    }

}
