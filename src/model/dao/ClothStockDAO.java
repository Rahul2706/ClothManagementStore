package model.dao;

import Operations.ErrorHandler;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import model.To.ClothInfoTO;
import model.To.ClothStockTO;

public class ClothStockDAO extends DAO{
       public boolean insertRecord(ClothStockTO record){
        try{
            String query=" insert into ClothStock";
            query += " (clothid,price,stockdate,qty)";
            query+= " values(?,?,?,?)";
            
            PreparedStatement stmt = DataConnection.getStatement(query);
            stmt.setInt(1,record.getClothid());
            stmt.setFloat(2,record.getPrice());
            stmt.setDate(3,record.getStockdate());
            stmt.setInt(4,record.getQty());
            
            
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

public boolean updateRecord(ClothStockTO record){
        try{
            String query="update ClothStock";
            query += "set clothid=?,price=?,stockdate=?,qty=?";
            query+= "where stockid=?";
            
            PreparedStatement stmt = DataConnection.getStatement(query);
            stmt.setInt(1,record.getClothid());
            stmt.setFloat(2,record.getPrice());
            stmt.setDate(3,record.getStockdate());
            stmt.setInt(4,record.getQty());
            stmt.setInt(5,record.getStockid());
            
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
    public boolean deleteRecord(int stockid){
        try{
            String query=" delete from ClothStock";
            query+= " where stockid=?";
            
            PreparedStatement stmt = DataConnection.getStatement(query);
            stmt.setInt(1,stockid);
            
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
    public ClothStockTO getRecord(int stockid){
        try{
            String query="select stockid,clothid,price,stockdate,qty";
            query+= " from ClothStock";
            query+= " where stockid=?";
            
            PreparedStatement stmt = DataConnection.getStatement(query);
            stmt.setInt(1,stockid);
            ClothStockTO result= null;
            ResultSet rs= stmt.executeQuery();
            if(rs.next()){
                result= new  ClothStockTO();
                result.setStockid(rs.getInt("stockid"));
                result.setClothid(rs.getInt("clothid"));
                result.setPrice(rs.getFloat("price"));
                result.setStockdate(rs.getDate("stockdate"));
                result.setQty(rs.getInt("qty"));
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
       public List<ClothStockTO> getAllRecord(){
        try{
            String query="select stockid,clothid,price,stockdate,qty";
            query+= " from ClothStock";
            PreparedStatement stmt = DataConnection.getStatement(query);
            List<ClothStockTO> result= null;
            ResultSet rs= stmt.executeQuery();
            if(rs.next()){
                result= new ArrayList<>();
                do{
                   ClothStockTO cst = new ClothStockTO();
                cst.setStockid(rs.getInt("stockid"));
                cst.setClothid(rs.getInt("clothid"));
                cst.setPrice(rs.getFloat("price"));
                cst.setStockdate(rs.getDate("stockdate"));
                cst.setQty(rs.getInt("qty"));
                result.add(cst);
            }while(rs.next());
            rs.close();
            stmt.close();
            }
            return result;
            }catch(Exception ex){
                error_message = ex.toString();
                ex.printStackTrace();  
                ErrorHandler.showStacktrace(ex);
                return null;
           }
    }
    
  } 
 


