package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import Modelo.*;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class ServicoDAO extends ExecuteSQL {
    
    public ServicoDAO(Connection con) {
        super(con);
    }
    
    public String Inserir_Servico(Servico a) {

        try {
        
            String sql = "insert into servicos values(0,?,?,?,?,?)";
            PreparedStatement ps = getcon().prepareStatement(sql);
           
            ps.setString(1, a.getNome());
            ps.setString(2, a.getIndicacao());
            ps.setDouble(3, a.getPreco());
            ps.setString(4, a.getDisponibilidade());
            ps.setDouble(5, a.getDesconto());

            if (ps.executeUpdate()> 0) {
                
                return "Inserido com sucesso!";
                
            } else {
                
                return "Erro ao inserir!";
                
            }
            
        } catch (SQLException e) {
            
            return e.getMessage();
            
        }
        
    }
    
    public String Excluir_Servico(Servico a){
  
        String sql = "DELETE FROM servicos WHERE id_serv = ? AND nome = ?";
        
        try {
        
            PreparedStatement ps = getcon().prepareStatement(sql);
            ps.setInt(1, a.getId_serv());
            ps.setString(2, a.getNome());
            
            if (ps.executeUpdate() > 0) {
            
                return "Excluído com sucesso!";
            
            } else {
            
                return "Erro ao excluir!";
            
            }
        } catch (Exception e) {
        
            return e.getMessage();
        
        }
        
    }
     
     
    public List<Servico> ListarComboServico(){
    
        String sql = "SELECT nome FROM servicos ORDER BY nome";
        List<Servico> lista = new ArrayList<>();
        
        try {
        
            PreparedStatement ps = getcon().prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            
            if (rs != null) {
            
                while (rs.next()) {
                
                    Servico a = new Servico();
                    a.setNome(rs.getString(1));
                    lista.add(a);
                    
                }
                
                return lista;
            
            } else {
            
                return null;
            
            }
        } catch (Exception e) {
        
            return null;
        
        }
        
    }
    
    public List<Servico> ConsultaCodigoServico(String nome){
    
        String sql = "SELECT id_serv FROM servicos WHERE nome = '"+ nome +"'";
        List<Servico> lista = new ArrayList<>();
        
        try {
        
            PreparedStatement ps = getcon().prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            
            if (rs != null) {
            
                while (rs.next()) {
                
                    Servico a = new Servico();
                    a.setId_serv(rs.getInt(1));
                    lista.add(a);
                
                }
                
                return lista;
            
            } else {
            
                return null;
            
            }
        } catch (Exception e) {
                
            return null;
        
        }
        
    }
    
    public List<Servico> ListarSevico() {
    
        String sql = "select id_serv,nome,indicacao,preco,disponibilidade,desconto from servicos";
        List<Servico> Lista = new ArrayList<>();
           
        try {

            PreparedStatement ps = getcon().prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            
            if (rs != null) {
                
                while (rs.next()) {
                    
                    Servico a = new Servico();
                    a.setId_serv(rs.getInt(1));
                    a.setNome(rs.getString(2));
                    a.setIndicacao(rs.getString(3));
                    a.setPreco(rs.getDouble(4));
                    a.setDisponibilidade(rs.getString(5));
                    a.setDesconto(rs.getDouble(6));
               
                    Lista.add(a);
                    
                }
                
                return Lista;
                
            } else {
                
                return null;
                
            }
            
        } catch (SQLException e) {
            
            return null;
            
        }
        
    }
    
    public List<Servico> Pesquisar_Nome_Servico(String nome) {
    
        String sql = "select id_serv,nome,indicacao,preco,disponibilidade,desconto from servicos where nome like '%"+ nome +"%'";
        List<Servico> Lista = new ArrayList<>();
           
        try {

            PreparedStatement ps = getcon().prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            
            if (rs != null) {
                
                while (rs.next()) {
                    
                    Servico a = new Servico();
                    a.setId_serv(rs.getInt(1));
                    a.setNome(rs.getString(2));
                    a.setIndicacao(rs.getString(3));
                    a.setPreco(rs.getDouble(4));
                    a.setDisponibilidade(rs.getString(5));
                    a.setDesconto(rs.getDouble(6));
               
                    Lista.add(a);
                    
                }
                
                return Lista;
                
            } else {
                
                return null;
                
            }
            
        } catch (SQLException e) {
            
            return null;
            
        }
        
    }
    
    public List<Servico> Pesquisar_Cod_Servico(int cod) {
    
        String sql = "select id_serv,nome,indicacao,preco,disponibilidade,desconto from servicos where id_serv = '"+ cod +"'";
        List<Servico> Lista = new ArrayList<>();
           
        try {

            PreparedStatement ps = getcon().prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            
            if (rs != null) {
                
                while (rs.next()) {
                    
                    Servico a = new Servico();
                    a.setId_serv(rs.getInt(1));
                    a.setNome(rs.getString(2));
                    a.setIndicacao(rs.getString(3));
                    a.setPreco(rs.getDouble(4));
                    a.setDisponibilidade(rs.getString(5));
                    a.setDesconto(rs.getDouble(6));
               
                    Lista.add(a);
                    
                }
                
                return Lista;
                
            } else {
                
                return null;
                
            }
            
        } catch (SQLException e) {
            
            return null;
            
        }
        
    }
    
}
