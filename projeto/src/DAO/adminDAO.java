package DAO;

import java.sql.*;
import Modelo.*;

public class adminDAO extends ExecuteSQL {
    
    public adminDAO(Connection con) {
        super(con);
    }
    
    public boolean Logar(String login, String senha){
        
        boolean finalResult = false;
        
        try { 
            
            String consulta = "Select login, senha from admin " +
            "where login = '" + login + "' and senha = '" + senha + "'";
            
            PreparedStatement ps = getcon().prepareStatement(consulta);
            ResultSet rs = ps.executeQuery();
            
            if (rs != null) {
                
                while (rs.next()) {

                    Admin a = new Admin();
                    a.setLogin(rs.getString(1));
                    a.setSenha(rs.getString(2));
                    finalResult = true;
                    
                }
                
            }
            
        } catch (SQLException e) {
            
            e.getMessage();
            
        }
       
        return finalResult;
        
    }
    
}
