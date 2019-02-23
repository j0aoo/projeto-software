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
    
    public String Inserir_Admin(Admin a) {

        try {
        
            String sql = "insert into admin values(0,?,?,?)";
            PreparedStatement ps = getcon().prepareStatement(sql);
            ps.setString(1, a.getLogin());
            ps.setString(2, a.getSenha());
            ps.setString(3, a.getSenhaExtra());
            
            if (ps.executeUpdate()> 0) {
                
                return "Inserido com sucesso!";
                
            } else {
                
                return "Erro ao inserir!";
                
            }
            
        } catch (SQLException e) {
            
            return e.getMessage();
            
        }
        
    }
    
}
