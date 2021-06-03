package model.To;

import java.sql.Timestamp;

public class BillInfoTO {
    private int billid;
    private int customerid;
    private Timestamp billdate;
    private String username;

    public int getBillid() {
        return billid;
    }

    public void setBillid(int billid) {
        this.billid = billid;
    }

    public int getCustomerid() {
        return customerid;
    }

    public void setCustomerid(int customerid) {
        this.customerid = customerid;
    }

    public Timestamp getBilldate() {
        return billdate;
    }

    public void setBilldate(Timestamp billdate) {
        this.billdate = billdate;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }
            
}
