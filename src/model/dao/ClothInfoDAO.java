package model.dao;

import Operations.ErrorHandler;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import model.To.ClothInfoTO;
import model.To.CustomerInfoTO;

public class ClothInfoDAO extends DAO {

    public boolean insertRecord(ClothInfoTO record) {
        try {
            String query = "insert into ClothInfo";
            query += " (brandid,subcategoryid,price,discount,description)";
            query += " values(?,?,?,?,?)";

            PreparedStatement stmt = DataConnection.getStatement(query);
            stmt.setString(1, record.getBrandid());
            stmt.setInt(2, record.getSubcategoryid());
            stmt.setFloat(3, record.getPrice());
            stmt.setFloat(4, record.getDiscount());
            stmt.setString(5, record.getdescription());

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

    public boolean updateRecord(ClothInfoTO record) {
        try {
            String query = "update ClothInfo";
            query += " set brandid=?,subcategoryid=?,price=?,discount=?,description=?";
            query += " where clothid=? ";

            PreparedStatement stmt = DataConnection.getStatement(query);
            stmt.setString(1, record.getBrandid());
            stmt.setInt(2, record.getSubcategoryid());
            stmt.setFloat(3, record.getPrice());
            stmt.setFloat(4, record.getDiscount());
            stmt.setString(5, record.getdescription());
            stmt.setInt(6, record.getClothid());

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

    public boolean deleteRecord(int clothid) {
        try {
            String query = " delete from ClothInfo";
            query += " where clothid=? ";

            PreparedStatement stmt = DataConnection.getStatement(query);
            stmt.setInt(1, clothid);

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

    public ClothInfoTO getRecord(int clothid) {
        try {
            String query = "select clothid,brandid,subcategoryid,price,discount,description";
            query += " from ClothInfo";
            query += " where clothid=? ";

            PreparedStatement stmt = DataConnection.getStatement(query);
            stmt.setInt(1, clothid);

            ClothInfoTO result = null;
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                result = new ClothInfoTO();
                result.setClothid(rs.getInt("clothid"));
                result.setBrandid(rs.getString("brandid"));
                result.setSubcategoryid(rs.getInt("subcategoryid"));
                result.setPrice(rs.getFloat("price"));
                result.setDiscount(rs.getFloat("discount"));
                result.setdescription(rs.getString("description"));
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

    public List<ClothInfoTO> getAllRecord() {
        try {
            String query = " select clothid,brandid,subcategoryid,price,discount,description";
            query += " from ClothInfo";
            PreparedStatement stmt = DataConnection.getStatement(query);
            List<ClothInfoTO> result = null;
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                result = new ArrayList<>();
                do {
                    ClothInfoTO clit = new ClothInfoTO();
                    clit.setClothid(rs.getInt("clothid"));
                    clit.setBrandid(rs.getString("brandid"));
                    clit.setSubcategoryid(rs.getInt("subcategoryid"));
                    clit.setPrice(rs.getFloat("price"));
                    clit.setDiscount(rs.getFloat("discount"));
                    clit.setdescription(rs.getString("description"));
                    result.add(clit);
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

    public List<ClothInfoTO> getAllRecord(int subcategoryid) {
        try {
            String query = " select clothid,brandid,subcategoryid,price,discount,description";
            query += " from ClothInfo ";
            query += " where subcategoryid = ?";
            PreparedStatement stmt = DataConnection.getStatement(query);
            stmt.setInt(1,subcategoryid);
            List<ClothInfoTO> result = null;
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                result = new ArrayList<>();
                do {
                    ClothInfoTO clit = new ClothInfoTO();
                    clit.setClothid(rs.getInt("clothid"));
                    clit.setBrandid(rs.getString("brandid"));
                    clit.setSubcategoryid(rs.getInt("subcategoryid"));
                    clit.setPrice(rs.getFloat("price"));
                    clit.setDiscount(rs.getFloat("discount"));
                    clit.setdescription(rs.getString("description"));
                    result.add(clit);
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
