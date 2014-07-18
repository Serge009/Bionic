package jdbc.entity;

import java.time.LocalDate;

/**
 * Created by Matrix on 17.07.2014.
 */
public class Customer {
    private int id;
    private String name;
    private String address;
    private String email;
    private String ccno;
    private String cctype;
    private LocalDate maturity;

    public Customer() {
    }

    public Customer(int id, String name, String address, String email, String ccno, String cctype, LocalDate maturity) {
        this.id = id;
        this.name = name;
        this.address = address;
        this.email = email;
        this.ccno = ccno;
        this.cctype = cctype;
        this.maturity = maturity;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getCcno() {
        return ccno;
    }

    public void setCcno(String ccno) {
        this.ccno = ccno;
    }

    public String getCctype() {
        return cctype;
    }

    public void setCctype(String cctype) {
        this.cctype = cctype;
    }

    public LocalDate getMaturity() {
        return maturity;
    }

    public void setMaturity(LocalDate maturity) {
        this.maturity = maturity;
    }
}
