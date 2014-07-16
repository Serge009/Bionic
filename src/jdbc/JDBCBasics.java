package jdbc;

import java.io.*;
import java.sql.*;
import java.time.Instant;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Properties;

/**
 * Created by oper4 on 16.07.2014.
 */
public class JDBCBasics {
    public static void main(String[] args) {
        try{
            /*
            String name = "Mike";
            String address = "Some Address";
            String email = "email@hh.com";
            String ccNo = "58119881458";
            String ccType = "979879878";
            LocalDate date = LocalDate.of(2012, 2, 1);

            Instant instant = date.atStartOfDay(ZoneId.systemDefault()).toInstant();
            Date dt = new java.sql.Date(java.util.Date.from(instant).getTime());
            addCustomer(name, address, email, ccNo, ccType, dt);
            */

            int id = 1;
            System.out.println(getMerchantTotal(id));

        } catch (SQLException e){
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

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


}