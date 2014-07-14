package deposit;

import java.io.*;
import java.net.URL;

/**
 * Created by SERGE on 30.06.2014.
 */
public class Main {
    public static void main(String[] args) throws IOException {
        URL stat = new URL("http://www.ukrstat.gov.ua/express/expr2012/09_12/234.zip");

        try (InputStream in = stat.openStream();
             OutputStream out = new FileOutputStream("C:/234.zip")){

            while (in.available() > 0) {
                int data = in.read();
                out.write(data);
            }
        }



        /*
        List<DepoBase> list = new DepoList().getList();
        int count = list.size();
        List<DepoBase> res = new ArrayList<>();

        try(ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream("C:\\serialized.txt"));
            ObjectInputStream in = new ObjectInputStream(new FileInputStream("C:\\serialized.txt"))) {

            for(DepoBase d : list){
                out.writeObject(d);
            }

            for(int i = 0; i < count; i++) {
                res.add((DepoBase) in.readObject());
            }

        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }


        for(DepoBase d : res){
            System.out.println(d.getInterest());
        }

        */

    }
}
