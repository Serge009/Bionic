import app12.Profitable;
import app12.TBill;
import app9.*;

import java.io.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by SERGE on 30.06.2014.
 */
public class Main {
    public static void main(String[] args) {
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

    }
}
