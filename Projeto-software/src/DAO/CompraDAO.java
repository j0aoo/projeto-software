package DAO;

import Modelo.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class CompraDAO extends ExecuteSQL {
    
    public CompraDAO(Connection con) {
        super(con);
    }
    
    public String Inserir_Compra(Compra a) {

        try {
        
            String sql = "insert into compra values(0,?,?,?,?,?,?)";
            PreparedStatement ps = getcon().prepareStatement(sql);
            ps.setString(1, a.getCpf_cliente());
            ps.setInt(2, a.getId_animal());
            ps.setString(3, a.getLista_serv());
            ps.setDouble(4, a.getDesconto());
            ps.setDouble(5, a.getTotal());
            ps.setString(6, a.getFormaPag());

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
