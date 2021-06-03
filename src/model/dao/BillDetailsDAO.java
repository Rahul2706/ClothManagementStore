package model.dao;

import Operations.ErrorHandler;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import model.To.BillDetailsTO;
import model.To.BillInfoTO;

public class BillDetailsDAO {
    public boolean insertRecord(BillDetailsTO record){
        try{
            String query=" insert into BillInfo";
            query += " (billid,clothid,qty,price,discount)";
            query+= " values(?,?,?,?,?) ";
            
            PreparedStatement stmt = DataConnection.getStatement(query);
            stmt.setInt(1,record.getBillid());
            stmt.setInt(2,record.getClothid());
            stmt.setInt(3,record.getQty());
            stmt.setFloat(4,record.getPrice());
            stmt.setFloat(5,record.getDiscount());
            boolean result= stmt.executeUpdate()>0;
            stmt.close();
           
            return result;
            }catch(Exception ex){
                
                ex.printStackTrace();  
                ErrorHandler.showStacktrace(ex);
                return false;
           }
    }
    public boolean updateRecord(BillDetailsTO record){
        try{
            String query="update BillInfo";
            query += " set billid=?,clothid=?,qty=?,price=?,discount=?";
            query+= " where detailid=?";
            
            PreparedStatement stmt = DataConnection.getStatement(query);
            stmt.setInt(1,record.getBillid());
            stmt.setInt(2,record.getClothid());
            stmt.setInt(3,record.getQty());
            stmt.setFloat(4,record.getPrice());
            stmt.setFloat(5,record.getDiscount());
            stmt.setInt(6,record.getDetailid());
            
            boolean result= stmt.executeUpdate()>0;
            stmt.close();
           
            return result;
            }catch(Exception ex){
                
                ex.printStackTrace();  
                ErrorHandler.showStacktrace(ex);
                return false;
           }
    }
    public boolean deleteRecord(int detailid){
        try{
            String query=" delete from BillInfo";
            query+= " where detailid=?";
            
            PreparedStatement stmt = DataConnection.getStatement(query);
            stmt.setInt(1,detailid);
            
            boolean result= stmt.executeUpdate()>0;
            stmt.close();
           
            return result;
            }catch(Exception ex){
                
                ex.printStackTrace();  
                ErrorHandler.showStacktrace(ex);
                return false;
           }
    }
    public BillDetailsTO getRecord(int detailid){
        try{
            String query="select detailid,billid,clothid,qty,price,discount";
            query+= " from billdetails";
            query+= " where detailid=?";
            
            PreparedStatement stmt = DataConnection.getStatement(query);
            stmt.setInt(1,detailid);
            BillDetailsTO result=null;
            ResultSet rs= stmt.executeQuery();
            if(rs.next()){
                result = new BillDetailsTO();
                result.setDetailid(rs.getInt("deatilid"));
                result.setBillid(rs.getInt("billid"));
                result.setClothid(rs.getInt("clothid"));
                result.setQty(rs.getInt("qty"));
                result.setPrice(rs.getFloat("price"));
                result.setDiscount(rs.getFloat("discount"));
            }
            rs.close();
            stmt.close();
            
            return result;
            }catch(Exception ex){
                
                ex.printStackTrace();  
                ErrorHandler.showStacktrace(ex);
                return null;
           }
    }
    public List<BillDetailsTO> getAllRecord(){
        try{
            String query=" select detailid,billid,clothid,qty,price,discount";
            query+= " from billdetails ";
            
            PreparedStatement stmt = DataConnection.getStatement(query);

            List<BillDetailsTO> result=null;
            ResultSet rs= stmt.executeQuery();
            if(rs.next()){
                result = new ArrayList<>();
                do{
                    BillDetailsTO bdt = new BillDetailsTO();
                bdt.setDetailid(rs.getInt("deatilid"));
                bdt.setBillid(rs.getInt("billid"));
                bdt.setClothid(rs.getInt("clothid"));
                bdt.setQty(rs.getInt("qty"));
                bdt.setPrice(rs.getFloat("price"));
                bdt.setDiscount(rs.getFloat("discount"));
                result.add(bdt);    
                }while(rs.next());
                
            }
            rs.close();
            stmt.close();
            
            return result;
            }catch(Exception ex){
                
                ex.printStackTrace();  
                ErrorHandler.showStacktrace(ex);
                return null;
           }
    }
}
