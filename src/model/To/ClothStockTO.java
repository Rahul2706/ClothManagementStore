package model.To;

import java.sql.Date;
import java.sql.Timestamp;

public class ClothStockTO {

    private int stockid;
    private int clothid;
    private float price;
    private Date stockdate;
    private int Qty;
    
    public Date getStockdate() {
        return stockdate;
    }

    public void setStockdate(Date stockdate) {
        this.stockdate = stockdate;
    }
    private int qty;

    public int getStockid() {
        return stockid;
    }

    public void setStockid(int stockid) {
        this.stockid = stockid;
    }

    public int getClothid() {
        return clothid;
    }

    public void setClothid(int clothid) {
        this.clothid = clothid;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public int getQty() {
        return qty;
    }

    public void setQty(int qty) {
        this.qty = qty;
    }

    
}
