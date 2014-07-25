package test3.dao;

import test3.deposit.AbstractDeposit;
import test3.deposit.CapDeposit;
import test3.deposit.SimpleDeposit;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

/**
 * Created by oper4 on 25.07.2014.
 */
public class DepositsDAO {

    public List<AbstractDeposit> getBySum(double sum){
        List<AbstractDeposit> res = new ArrayList<>();

        try {
            Connection con = getConnection();

            String sql = "SELECT * FROM deposits WHERE sum > ?";
            PreparedStatement statement = con.prepareStatement(sql);
            statement.setDouble(1, sum);

            ResultSet rs = statement.executeQuery();

            while (rs.next()){
                AbstractDeposit deposit;
                switch(rs.getInt("type")){
                    case 2:
                        deposit = new CapDeposit();
                        break;
                    default:
                        deposit = new SimpleDeposit();
                        break;
                }


                deposit.setId(rs.getInt("deposits_id"));
                deposit.setBankName(rs.getString("bank"));
                deposit.setDepositId(rs.getString("id"));
                deposit.setType(rs.getInt("type"));
                deposit.setStartDate(rs.getDate("start_date"));
                deposit.setDuration(rs.getInt("duration"));
                deposit.setSum(rs.getDouble("sum"));
                deposit.setRate(rs.getDouble("rate"));
                deposit.setMaturityDate();
                deposit.calculateInterest();

                res.add(deposit);
            }

            con.close();
        } catch (IOException e){
            e.printStackTrace();
        } catch (SQLException e){
            e.printStackTrace();
        }

        return res;

    }

    public List<AbstractDeposit> getAll(){
        List<AbstractDeposit> res = new ArrayList<>();

        try {
            Connection con = getConnection();

            String sql = "SELECT * FROM deposits";
            PreparedStatement statement = con.prepareStatement(sql);

            ResultSet rs = statement.executeQuery();

            while (rs.next()){
                AbstractDeposit deposit;
                switch(rs.getInt("type")){
                    case 2:
                        deposit = new CapDeposit();
                        break;
                    default:
                        deposit = new SimpleDeposit();
                        break;
                }


                deposit.setId(rs.getInt("deposits_id"));
                deposit.setBankName(rs.getString("bank"));
                deposit.setDepositId(rs.getString("id"));
                deposit.setType(rs.getInt("type"));
                deposit.setStartDate(rs.getDate("start_date"));
                deposit.setDuration(rs.getInt("duration"));
                deposit.setSum(rs.getDouble("sum"));
                deposit.setRate(rs.getDouble("rate"));
                deposit.setMaturityDate();
                deposit.calculateInterest();

                res.add(deposit);
            }

            con.close();
        } catch (IOException e){
            e.printStackTrace();
        } catch (SQLException e){
            e.printStackTrace();
        }

        return res;

    }


    protected Connection getConnection() throws IOException, SQLException {
        Connection conn = null;
        Properties props = new Properties();
        InputStreamReader in = new InputStreamReader(new FileInputStream("connection.properties"), "UTF-8");
        props.load(in);
        in.close();

        String connString = props.getProperty("DBConnectionString");
        conn = DriverManager.getConnection(connString);
        return conn;
    }
}
