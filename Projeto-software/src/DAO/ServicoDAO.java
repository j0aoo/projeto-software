package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import Modelo.*;

public class ServicoDAO extends ExecuteSQL {
    
    public ServicoDAO(Connection con) {
        super(con);
    }
    
    public String Inserir_Servico(Servico a) {

        try {
        
            String sql = "insert into servicos values(0,?,?,?,?)";
            PreparedStatement ps = getcon().prepareStatement(sql);
            
            ps.setString(1, a.getIndicacao());
            ps.setDouble(2, a.getPreco());
            ps.setString(3, a.getDisponibilidade());
            ps.setDouble(4, a.getDesconto());

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
