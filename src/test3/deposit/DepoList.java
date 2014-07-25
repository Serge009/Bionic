package test3.deposit;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Created by oper4 on 25.07.2014.
 */
public class DepoList {
    private List<AbstractDeposit> list = new ArrayList<>();


    public void sort(){
        Collections.sort(list);
    }


    public List<AbstractDeposit> getList() {
        return list;
    }
}
