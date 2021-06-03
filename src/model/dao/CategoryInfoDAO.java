package model.dao;

import Operations.ErrorHandler;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import model.To.CategoryInfoTO;
import model.To.LoginInfoTO;

public class CategoryInfoDAO extends DAO{
    public boolean insertRecord(CategoryInfoTO record){
        try{
            String query=" insert into categoryinfo";
            query += " (categoryid,categoryname)";
            query+= " values(?,?)";
            
            PreparedStatement stmt = DataConnection.getStatement(query);
            stmt.setString(1,record.getCategoryid());
            stmt.setString(2,record.getCategoryname());
            boolean result = stmt.executeUpdate()>0;
            stmt.close();
           
            return result;
            }catch(Exception ex){
                error_message = ex.toString();
                ex.printStackTrace();  
                ErrorHandler.showStacktrace(ex);
                return false;
        }
    }
    
    public boolean updateRecord(CategoryInfoTO record){
        try{
            String query=" update categoryinfo";
            query += " set categoryname=?";
            query+= " where categoryid=?";
            
            PreparedStatement stmt = DataConnection.getStatement(query);
            stmt.setString(1,record.getCategoryname());
            stmt.setString(2,record.getCategoryid());
            boolean result= stmt.executeUpdate()>0;
            stmt.close();
           
            return result;
            }catch(Exception ex){
                error_message = ex.toString();
                ex.printStackTrace();  
                ErrorHandler.showStacktrace(ex);
                return false;
        }
    }
    public boolean deleteRecord(String categoryid){
        try{
            String query=" delete from categoryinfo";
            query += " where categoryid=?";
            
            PreparedStatement stmt = DataConnection.getStatement(query);
            stmt.setString(1,categoryid);
            boolean result = stmt.executeUpdate()>0;
            stmt.close();
           
            return result;
            }catch(Exception ex){
                error_message = ex.toString();
                ex.printStackTrace();  
                ErrorHandler.showStacktrace(ex);
                return false;
        }
    }
    public CategoryInfoTO getRecord(String categoryid){
        try{
            String query="select categoryid,categoryname ";
            query+= " from categoryinfo";
            query+= " where categoryid=?";
            
            PreparedStatement stmt = DataConnection.getStatement(query);
            stmt.setString(1,categoryid);
            CategoryInfoTO result= null;
            ResultSet rs =stmt.executeQuery();
            if(rs.next()){
                result=new CategoryInfoTO();
                result.setCategoryid(rs.getString("categoryid"));
                result.setCategoryname(rs.getString("categoryname"));
            }
            rs.close();
            stmt.close();
           
            return result;
            }catch(Exception ex){
                error_message = ex.toString();
                ex.printStackTrace();  
                ErrorHandler.showStacktrace(ex);
                return null;
        }
    }
    public List<CategoryInfoTO> getAllRecord(){
        try{
            String query=" select categoryid,categoryname ";
            query+= " from categoryinfo";
            PreparedStatement stmt = DataConnection.getStatement(query);
           
            List<CategoryInfoTO> result= null;
            ResultSet rs =stmt.executeQuery();
            if(rs.next()){
                result=new ArrayList<>();
                do{
                   CategoryInfoTO cit = new CategoryInfoTO();
                cit.setCategoryid(rs.getString("categoryid"));
                cit.setCategoryname(rs.getString("categoryname"));
                result.add(cit);
                }while(rs.next());
            }
            rs.close();
            stmt.close();
           
            return result;
            }catch(Exception ex){
                error_message = ex.toString();
                ex.printStackTrace();  
                ErrorHandler.showStacktrace(ex);
                return null;
        }
    }
    
}
