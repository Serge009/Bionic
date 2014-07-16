package jdbc;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.*;
import java.util.Properties;

/**
 * Created by oper4 on 16.07.2014.
 */
public class MerchantDAO {
    public static MerchantList getMerchants(){
        MerchantList res = new MerchantList();

        try {
            Connection con = getConnection();

            String sql = "SELECT * FROM MERCHANT";
            PreparedStatement statement = con.prepareStatement(sql);

            ResultSet rs = statement.executeQuery();

            while (rs.next()){
                Merchant m = new Merchant();

                m.setAccount(rs.getString("account"));
                m.setBankName(rs.getString("bankname"));
                m.setCharge(rs.getDouble("charge"));
                m.setId(rs.getInt("id"));
                m.setMinSum(rs.getDouble("minsum"));
                m.setName(rs.getString("name"));
                m.setPeriod(rs.getInt("period"));
                m.setSwift(rs.getString("swift"));
                m.setTotal(rs.getDouble("total"));

                res.add(m);
            }

            con.close();
        } catch (IOException e){

        } catch (SQLException e){

        }

        return res;

    }

    public static Connection getConnection() throws IOException, SQLException {
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
