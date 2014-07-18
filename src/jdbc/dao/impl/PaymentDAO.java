package jdbc.dao.impl;

import jdbc.dao.AbstractPaymentDAO;
import jdbc.entity.Merchant;
import jdbc.entity.Payment;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Created by Matrix on 18.07.2014.
 */
public class PaymentDAO extends AbstractPaymentDAO {
    @Override
    public void save(Payment payment) {
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


            }

            con.close();
        } catch (IOException e){

        } catch (SQLException e){

        }


    }
}
