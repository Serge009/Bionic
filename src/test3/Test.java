package test3;

import test3.dao.DepositsDAO;
import test3.deposit.AbstractDeposit;

import java.io.*;
import java.util.Collections;
import java.util.List;

/**
 * Created by oper4 on 25.07.2014.
 */
public class Test {
    public static void main(String[] args) {
        List<AbstractDeposit> deposits = new DepositsDAO().getBySum(1000);
        Collections.sort(deposits);


        try(FileWriter out = new FileWriter(new File("deposits.txt"), true)){
            for(AbstractDeposit d : deposits){
                StringBuilder builder = new StringBuilder();
                builder
                        .append(d.getBankName())
                        .append(" ")
                        .append(d.getDepositId())
                        .append(" ")
                        .append(d.getMaturityDate())
                        .append(" ")
                        .append(d.getSum())
                        .append(" ")
                        .append(d.getInterest())
                        .append("\n");

                out.write(builder.toString());
            }

        } catch (IOException e){
            e.printStackTrace();
        }
    }
}
