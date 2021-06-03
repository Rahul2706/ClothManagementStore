package model.dao;

import Operations.ErrorHandler;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import model.To.CategoryInfoTO;
import model.To.CustomerInfoTO;

public class CustomerInfoDAO extends DAO {

    public boolean insertRecord(CustomerInfoTO record) {
        try {
            String query = " insert into customerinfo";
            query += " (customername,contactno,address,entrydate,username)";
            query += " values(?,?,?,?,?)";

            PreparedStatement stmt = DataConnection.getStatement(query);
            stmt.setString(1, record.getCustomername());
            stmt.setString(2, record.getContactno());
            stmt.setString(3, record.getAddress());
            stmt.setDate(4, record.getEntrydate());
            stmt.setString(5, record.getUsername());

            boolean result = stmt.executeUpdate() > 0;
            stmt.close();

            return result;
        } catch (Exception ex) {
            error_message = ex.toString();
            ex.printStackTrace();
            ErrorHandler.showStacktrace(ex);
            return false;
        }
    }

    public boolean updateRecord(CustomerInfoTO record) {
        try {
            String query = "update customerinfo";
            query += " set customername= ?,contactno= ?,address= ?,entrydate= ?,username= ?";
            query += " where customerid=? ";

            PreparedStatement stmt = DataConnection.getStatement(query);
            stmt.setString(1, record.getCustomername());
            stmt.setString(2, record.getContactno());
            stmt.setString(3, record.getAddress());
            stmt.setDate(4, record.getEntrydate());
            stmt.setString(5, record.getUsername());
            stmt.setInt(6, record.getCustomerid());
            boolean result = stmt.executeUpdate() > 0;
            stmt.close();

            return result;
        } catch (Exception ex) {
            error_message = ex.toString();
            ex.printStackTrace();
            ErrorHandler.showStacktrace(ex);
            return false;
        }
    }

    public boolean deleteRecord(int customerid) {
        try {
            String query = " delete from customerinfo";
            query += " where customerid=? ";

            PreparedStatement stmt = DataConnection.getStatement(query);
            stmt.setInt(1, customerid);
            boolean result = stmt.executeUpdate() > 0;
            stmt.close();

            return result;
        } catch (Exception ex) {
            error_message = ex.toString();
            ex.printStackTrace();
            ErrorHandler.showStacktrace(ex);
            return false;
        }
    }

    public CustomerInfoTO getRecord(int customerid) {
        try {
            String query = "select customerid,customername,contactno,address,entrydate,username";
            query += " from customerinfo";
            query += " where customerid=? ";

            PreparedStatement stmt = DataConnection.getStatement(query);
            stmt.setInt(1, customerid);
            CustomerInfoTO result = null;
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                result = new CustomerInfoTO();
                result.setCustomerid(rs.getInt("customerid"));
                result.setCustomername(rs.getString("customername"));
                result.setContactno(rs.getString("contactno"));
                result.setAddress(rs.getString("address"));
                result.setEntrydate(rs.getDate("entrydate"));
                result.setUsername(rs.getString("username"));
            }
            rs.close();
            stmt.close();

            return result;
        } catch (Exception ex) {
            error_message = ex.toString();
            ex.printStackTrace();
            ErrorHandler.showStacktrace(ex);
            return null;
        }
    }

    public List<CustomerInfoTO> getAllRecord() {
        try {
            String query = " select customerid,customername,contactno,address,entrydate,username";
            query += " from customerinfo ";
            PreparedStatement stmt = DataConnection.getStatement(query);
            List<CustomerInfoTO> result = null;
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                result = new ArrayList<>();
                do {
                    CustomerInfoTO cuit = new CustomerInfoTO();
                    cuit.setCustomerid(rs.getInt("customerid"));
                    cuit.setCustomername(rs.getString("customername"));
                    cuit.setContactno(rs.getString("contactno"));
                    cuit.setAddress(rs.getString("address"));
                    cuit.setEntrydate(rs.getDate("entrydate"));
                    cuit.setUsername(rs.getString("username"));
                    result.add(cuit);
                } while (rs.next());

            }
            rs.close();
            stmt.close();

            return result;
        } catch (Exception ex) {
            error_message = ex.toString();
            ex.printStackTrace();
            ErrorHandler.showStacktrace(ex);
            return null;
        }
    }

}
