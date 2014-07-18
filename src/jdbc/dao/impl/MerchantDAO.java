package jdbc.dao.impl;

import jdbc.dao.AbstractMerchantDAO;
import jdbc.entity.Merchant;
import jdbc.lib.MerchantList;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.*;
import java.util.Properties;

/**
 * Created by oper4 on 16.07.2014.
 */
public class MerchantDAO extends AbstractMerchantDAO {
    public MerchantList getAll(){
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

    public void updateTotal(Merchant merchant, double total){
        MerchantList res = new MerchantList();

        try {
            Connection con = getConnection();

            String sql = "UPDATE MERCHANT SET total = total + ?";
            PreparedStatement statement = con.prepareStatement(sql);
            statement.setDouble(1, total);
            int rs = statement.executeUpdate();



            con.close();
        } catch (IOException e){
            e.printStackTrace();
        } catch (SQLException e){
            e.printStackTrace();
        }
    }


}
