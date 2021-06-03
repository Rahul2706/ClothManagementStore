package model.dao;

import Operations.ErrorHandler;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import model.To.CategoryInfoTO;
import model.To.SubCategoryTO;

public class SubCategoryDAO extends DAO {

    public boolean insertRecord(SubCategoryTO record) {
        try {
            String query = "insert into subcategoryinfo";
            query += " (subcategoryname,categoryid)";
            query += " values(?,?)";

            PreparedStatement stmt = DataConnection.getStatement(query);
            stmt.setString(1, record.getSubcategoryname());
            stmt.setString(2, record.getCategoryid());
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

    public boolean updateRecord(SubCategoryTO record) {
        try {
            String query = " update subcategoryinfo";
            query += " set subcategoryname=?,categoryid=?";
            query += " where subcategoryid=?";

            PreparedStatement stmt = DataConnection.getStatement(query);
            stmt.setString(1, record.getSubcategoryname());
            stmt.setString(2, record.getCategoryid());
            stmt.setInt(3, record.getSubcategoryid());
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

    public boolean deleteRecord(int subcategoryid) {
        try {
            String query = " delete from subcategoryinfo";
            query += " where subcategoryid=?";

            PreparedStatement stmt = DataConnection.getStatement(query);
            stmt.setInt(1, subcategoryid);
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

    public SubCategoryTO getRecord(int subcategoryid) {
        try {
            String query = "select subcategoryid,subcategoryname,categoryid";
            query += " from subcategoryinfo";
            query += " where subcategoryid=?";

            PreparedStatement stmt = DataConnection.getStatement(query);
            stmt.setInt(1, subcategoryid);
            SubCategoryTO result = null;
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                result = new SubCategoryTO();
                result.setSubcategoryid(rs.getInt("subcategoryid"));
                result.setSubcategoryname(rs.getString("subcategoryname"));
                result.setCategoryid(rs.getString("categoryid"));
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

    public List<SubCategoryTO> getAllRecord() {
        try {
            String query = " select subcategoryid,subcategoryname,categoryid";
            query += " from subcategoryinfo";
            PreparedStatement stmt = DataConnection.getStatement(query);
            List<SubCategoryTO> result = null;
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                result = new ArrayList<>();
                do {
                    SubCategoryTO sct = new SubCategoryTO();
                    sct.setSubcategoryid(rs.getInt("subcategoryid"));
                    sct.setSubcategoryname(rs.getString("subcategoryname"));
                    sct.setCategoryid(rs.getString("categoryid"));
                    result.add(sct);
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

    public List<SubCategoryTO> getAllRecord(String categoryid) {
        try {
            String query = " select subcategoryid,subcategoryname,categoryid";
            query += " from subcategoryinfo";
            query += " where categoryid = ?";
            PreparedStatement stmt = DataConnection.getStatement(query);
            stmt.setString(1, categoryid);
            List<SubCategoryTO> result = null;
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                result = new ArrayList<>();
                do {
                    SubCategoryTO sct = new SubCategoryTO();
                    sct.setSubcategoryid(rs.getInt("subcategoryid"));
                    sct.setSubcategoryname(rs.getString("subcategoryname"));
                    sct.setCategoryid(rs.getString("categoryid"));
                    result.add(sct);
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
