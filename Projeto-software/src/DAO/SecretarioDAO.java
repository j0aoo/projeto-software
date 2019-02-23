package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import Modelo.*;

public class SecretarioDAO extends ExecuteSQL {
    
    public SecretarioDAO(Connection con) {
        super(con);
    }
    
    public boolean Logar(String login, String senha){
        
        boolean finalResult = false;
        
        try { 
            
            String consulta = "Select login, senha from secretaria " +
            "where login = '" + login + "' and senha = '" + senha + "'";
            
            PreparedStatement ps = getcon().prepareStatement(consulta);
            ResultSet rs = ps.executeQuery();
            
            if (rs != null) {
                
                while (rs.next()) {

                    Secretaria a = new Secretaria();
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
    
    public String Inserir_Secretario(Secretaria a) {

        try {
        
            String sql = "insert into secretaria values(0,?,?,?,?,?,?,?)";
            PreparedStatement ps = getcon().prepareStatement(sql);
            ps.setString(1, a.getLogin());
            ps.setString(2, a.getSenha());
            ps.setString(3, a.getNome());
            ps.setString(4, a.getEndereco());
            ps.setString(5, a.getCpf());
            ps.setString(6, a.getRg());
            ps.setString(7, a.getTelefone());
            
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
