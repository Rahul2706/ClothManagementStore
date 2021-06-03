package model.dao;

import Operations.ErrorHandler;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import model.To.BillDetailsTO;
import model.To.BrandInfoTO;

public class BrandInfoDAO extends DAO {

    public boolean insertRecord(BrandInfoTO record) {
        try {
            String query = "insert into BrandInfo";
            query += " (brandid,brandname)";
            query += " values(?,?)";

            PreparedStatement stmt = DataConnection.getStatement(query);
            stmt.setString(1, record.getBrandid());
            stmt.setString(2, record.getBrandname());

            boolean result = stmt.executeUpdate() > 0;
            stmt.close();
            return result;
        } catch (Exception ex) {
            ex.printStackTrace();
            ErrorHandler.showStacktrace(ex);
            return false;
        }
    }

    public boolean updateRecord(BrandInfoTO record) {
        try {
            String query = "update BrandInfo";
            query += " set brandname=?";
            query += " where brandid=?";

            PreparedStatement stmt = DataConnection.getStatement(query);
            stmt.setString(1, record.getBrandname());
            stmt.setString(2, record.getBrandid());

            boolean result = stmt.executeUpdate() > 0;
            stmt.close();

            return result;
        } catch (Exception ex) {
            ex.printStackTrace();
            ErrorHandler.showStacktrace(ex);
            return false;
        }
    }

    public boolean deleteRecord(String brandid) {
        try {
            String query = " delete from BrandInfo";
            query += " where brandid=?";

            PreparedStatement stmt = DataConnection.getStatement(query);
            stmt.setString(1, brandid);

            boolean result = stmt.executeUpdate() > 0;
            stmt.close();

            return result;
        } catch (Exception ex) {
            ex.printStackTrace();
            ErrorHandler.showStacktrace(ex);
            return false;
        }
    }

    public BrandInfoTO getRecord(String brandid) {
        try {
            String query = " select brandid,brandname ";
            query += " from BrandInfo";
            query += " where brandid=?";

            PreparedStatement stmt = DataConnection.getStatement(query);
            stmt.setString(1, brandid);
            ResultSet rs = stmt.executeQuery();
            BrandInfoTO result = null;
            if (rs.next()) {
                result = new BrandInfoTO();
                result.setBrandid(rs.getString("brandid"));
                result.setBrandname(rs.getString("brandname"));
            }
            rs.close();
            stmt.close();

            return result;
        } catch (Exception ex) {
            ex.printStackTrace();
            ErrorHandler.showStacktrace(ex);
            return null;
        }
    }

    public List<BrandInfoTO> getAllRecord() {
        try {
            String query = " select brandid,brandname ";
            query += " from BrandInfo";
            PreparedStatement stmt = DataConnection.getStatement(query);

            ResultSet rs = stmt.executeQuery();
            List<BrandInfoTO> result = null;
            if (rs.next()) {
                result = new ArrayList<>();
                do {
                    BrandInfoTO brit = new BrandInfoTO();
                    brit.setBrandid(rs.getString("brandid"));
                    brit.setBrandname(rs.getString("brandname"));
                    result.add(brit);
                } while (rs.next());
            }
            rs.close();
            stmt.close();

            return result;
        } catch (Exception ex) {
            ex.printStackTrace();
            ErrorHandler.showStacktrace(ex);
            return null;
        }
    }

}
