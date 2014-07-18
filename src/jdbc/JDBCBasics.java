package jdbc;

import jdbc.dao.impl.MerchantDAO;
import jdbc.dao.impl.PaymentDAO;
import jdbc.entity.Customer;
import jdbc.entity.Merchant;
import jdbc.entity.Payment;

import java.io.*;
import java.sql.*;
import java.util.Properties;

/**
 * Created by oper4 on 16.07.2014.
 */
public class JDBCBasics {
    public static void main(String[] args) {
        //System.out.println(new MerchantDAO().getAll());

        Payment payment = new Payment();
        Merchant merchant = new Merchant();
        Customer customer = new Customer();
        customer.setId(1);

        merchant.setId(1);

        payment.setMerchant(merchant);
        payment.setCustomer(customer);
        payment.setDt(1000000000);
        payment.setGoods("Some goods");
        payment.setTotal(200);
        payment.setCharge(20);

        new PaymentDAO().create(payment);
    }


    /*
    public static Connection getConnection() throws IOException, SQLException{
        Connection conn = null;
        Properties props = new Properties();
        InputStreamReader in = new InputStreamReader(new FileInputStream("connection.properties"), "UTF-8");
        props.load(in);
        in.close();

        String connString = props.getProperty("DBConnectionString");
        conn = DriverManager.getConnection(connString);
        return conn;
    }

    public static void addCustomer(String name, String address, String email, String ccNo, String ccType, Date dt) throws SQLException, IOException{
        Connection con = getConnection();
        String sql = "INSERT INTO customer (name, address, ";
        sql += " email, ccNo, ccType, maturity) values(?,?,?,?,?,?) ";
        PreparedStatement stmt = con.prepareStatement(sql);
        stmt.setString(1, name);
        stmt.setString(2, address);
        stmt.setString(3, email);
        stmt.setString(4, ccNo);
        stmt.setString(5, ccType);
        stmt.setDate(6, dt);
        stmt.executeUpdate();
        con.close();
    }

    public static double getMerchantTotal(int id) throws IOException, SQLException {
        Connection con = getConnection();

        String sql = "SELECT total FROM MERCHANT WHERE id = ?";
        PreparedStatement statement = con.prepareStatement(sql);
        statement.setInt(1, id);

        ResultSet rs = statement.executeQuery();
        double res = 0;

        while (rs.next()){
            res = rs.getDouble("total");
        }

        con.close();

        return res;
    }

    */
}