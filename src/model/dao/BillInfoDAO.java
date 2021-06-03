package model.dao;

import Operations.ErrorHandler;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import model.To.BillInfoTO;
import model.To.ClothStockTO;

public class BillInfoDAO extends DAO{
     public boolean insertRecord(BillInfoTO record){
        try{
            String query=" insert into BillInfo";
            query += " (customerid,billdate,username)";
            query+= " values(?,?,?)";
            
            PreparedStatement stmt = DataConnection.getStatement(query);
            stmt.setInt(1,record.getCustomerid());
            stmt.setTimestamp(2,record.getBilldate());
            stmt.setString(3,record.getUsername());
            
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
     public boolean updateRecord(BillInfoTO record){
        try{
            String query=" update BillInfo";
            query += " set customerid=?,billdate=?,username=?";
            query+= " where billid=?";
            
            PreparedStatement stmt = DataConnection.getStatement(query);
            stmt.setInt(1,record.getCustomerid());
            stmt.setTimestamp(2,record.getBilldate());
            stmt.setString(3,record.getUsername());
            stmt.setInt(4,record.getBillid());
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
     public boolean deleteRecord(int billid){
        try{
            String query=" delete from BillInfo";
            query+= " where billid=?";
            
            PreparedStatement stmt = DataConnection.getStatement(query);
            stmt.setInt(1,billid);
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
          public BillInfoTO getRecord(int billid){
        try{
            String query="select billid ,customerid,billdate,username";
            query+= " from BillInfo";
            query+= " where billid=?";
            
            PreparedStatement stmt = DataConnection.getStatement(query);
            stmt.setInt(1,billid);
            BillInfoTO result= null;
            ResultSet rs = stmt.executeQuery();
            if(rs.next()){
                result=new BillInfoTO();
                result.setBillid(rs.getInt("billid"));
                result.setCustomerid(rs.getInt("customerid"));
                result.setBilldate(rs.getTimestamp("billdate"));
                result.setUsername(rs.getString("username"));
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
          public List<BillInfoTO> getAllRecord(){
        try{
            String query=" select billid ,customerid,billdate,username";
            query+= " from BillInfo";
            
            
            PreparedStatement stmt = DataConnection.getStatement(query);
            
            List<BillInfoTO> result= null;
            ResultSet rs = stmt.executeQuery();
            if(rs.next()){
                result=new ArrayList<>();
                do{
                    BillInfoTO bit = new BillInfoTO();
                bit.setBillid(rs.getInt("billid"));
                bit.setCustomerid(rs.getInt("customerid"));
                bit.setBilldate(rs.getTimestamp("billdate"));
                bit.setUsername(rs.getString("username"));
                result.add(bit);
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
