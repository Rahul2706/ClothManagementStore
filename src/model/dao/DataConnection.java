package model.dao;

import Config.Configuration;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

public class DataConnection {
    
    private static Connection con = null;
    
    private DataConnection(){
        
        
    }
        public static Connection getConnection()throws Exception{
            if(con==null){
            
                Class.forName(Configuration.DRIVER_NAME);
                con= DriverManager.getConnection(Configuration.CONNECTION_URL,Configuration.DB_USER,Configuration.DB_PASS);
            }        
           
           return con;
        }
        public static void closeConnection() throws Exception{
            if(con!=null){
             con.close();
            }    
             con=null;
        }
           public static PreparedStatement getStatement(String query)throws Exception{
           return getConnection().prepareStatement(query);
        }
}
