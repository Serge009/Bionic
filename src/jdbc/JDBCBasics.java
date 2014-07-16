package jdbc;

import java.io.*;
import java.sql.*;
import java.util.Properties;

/**
 * Created by oper4 on 16.07.2014.
 */
public class JDBCBasics {
    public static void main(String[] args) {
        try{

            Connection con = getConnection();
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery(
                    "SELECT name, charge FROM merchant");
            while (rs.next()){
                String nm = rs.getString("name");
                double p = rs.getDouble(2);
                System.out.println(nm + "   " + p);
            }
            con.close();

        } catch (SQLException e){

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

}