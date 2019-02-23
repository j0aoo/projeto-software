package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import Modelo.*;


public class AnimalDAO extends ExecuteSQL {
    
    public AnimalDAO(Connection con) {
        super(con);
    }
    
    public String Inserir_Animal(Animal a) {

        try {
        
            String sql = "insert into animais values(0,?,?,?,?,?,?)";
            PreparedStatement ps = getcon().prepareStatement(sql);
            ps.setString(1, a.getNome());
            ps.setString(2, a.getTipo());
            ps.setString(3, a.getRaca());
            ps.setDouble(4, a.getTamanho());
            ps.setDouble(5, a.getPeso());
            ps.setInt(6, a.getIdade());

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
