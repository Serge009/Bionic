package jdbc.dao.impl;

import jdbc.dao.AbstractPaymentDAO;
import jdbc.entity.Merchant;
import jdbc.entity.Payment;

import java.io.IOException;
import java.sql.*;

/**
 * Created by Matrix on 18.07.2014.
 */
public class PaymentDAO extends AbstractPaymentDAO {

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

    @Override
    public void create(Payment payment) {
        try {
            Connection con = getConnection();
            double charge = payment.getMerchant().getCharge();
            payment.setCharge(charge);


            String sql = "INSERT INTO payment(dt, merchantid, customerid, goods, total, charge) VALUES(?, ?, ?, ?, ?, ?)";
            PreparedStatement statement = con.prepareStatement(sql);
            statement.setDate(1, new Date(payment.getDt()));
            statement.setInt(2, payment.getMerchant().getId());
            statement.setInt(3, payment.getCustomer().getId());
            statement.setString(4, payment.getGoods());
            statement.setDouble(5, payment.getTotal());
            statement.setDouble(6, payment.getCharge());

            boolean rs = statement.execute();

            new MerchantDAO().updateTotal(payment.getMerchant(), payment.getTotal());

            con.close();
        } catch (IOException e){
            e.printStackTrace();
        } catch (SQLException e){
            e.printStackTrace();
        }


    }
}
