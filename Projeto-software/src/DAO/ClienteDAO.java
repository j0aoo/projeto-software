package DAO;

import Modelo.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class ClienteDAO extends ExecuteSQL {
    
    public ClienteDAO(Connection con) {
        super(con);
    }
    
    public String Inserir_Cliente(Cliente a) {

        try {
        
            String sql = "insert into clientes values(0,?,?,?,?,?)";
            PreparedStatement ps = getcon().prepareStatement(sql);
            
            ps.setString(1, a.getNome());
            ps.setString(2, a.getEmail());
            ps.setString(3, a.getCpf());
            ps.setString(4, a.getTelefone());
            ps.setString(5, a.getEndereco());

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
