/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.dao;

import Operations.ErrorHandler;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Rahul khurana
 */
public class CommonDAO extends DAO {

    public int getLastInsertId() {
        try {
            String query = "select last_insert_id()";
            PreparedStatement stmt = DataConnection.getStatement(query);
            int id = 0;
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                id = rs.getInt(1);
            }
            rs.close();
            stmt.close();
            return id;
        } catch (Exception ex) {
            error_message = ex.toString();
            ErrorHandler.showStacktrace(ex);
            return 0;
        }
    }

}
