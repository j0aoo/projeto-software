package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import Modelo.*;
import java.util.ArrayList;
import java.util.List;

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
    
    public String Excluir_Secretario(Secretaria a){
  
        String sql = "DELETE FROM secretaria WHERE id = ? AND nome = ?";
        
        try {
        
            PreparedStatement ps = getcon().prepareStatement(sql);
            ps.setInt(1, a.getId());
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
     
     
    public List<Secretaria> ListarComboSecretaria(){
    
        String sql = "SELECT nome FROM secretaria ORDER BY nome";
        List<Secretaria> lista = new ArrayList<>();
        
        try {
        
            PreparedStatement ps = getcon().prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            
            if (rs != null) {
            
                while (rs.next()) {
                
                    Secretaria a = new Secretaria();
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
    
    public List<Secretaria> ConsultaCodigoSecretaria(String nome){
    
        String sql = "SELECT id FROM secretaria WHERE nome = '"+ nome +"'";
        List<Secretaria> lista = new ArrayList<>();
        
        try {
        
            PreparedStatement ps = getcon().prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            
            if (rs != null) {
            
                while (rs.next()) {
                
                    Secretaria a = new Secretaria();
                    a.setId(rs.getInt(1));
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
    
    public List<Secretaria> ListarSecretaria() {
    
        String sql = "select id,login,nome,endereco,cpf,rg,telefone from secretaria";
        List<Secretaria> Lista = new ArrayList<>();
           
        try {

            PreparedStatement ps = getcon().prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            
            if (rs != null) {
                
                while (rs.next()) {
                    
                    Secretaria a = new Secretaria();
                    a.setId(rs.getInt(1));
                    a.setLogin(rs.getString(2));
                    a.setNome(rs.getString(3));
                    a.setEndereco(rs.getString(4));
                    a.setCpf(rs.getString(5));
                    a.setRg(rs.getString(6));
                    a.setTelefone(rs.getString(7));
               
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
    
    public List<Secretaria> Pesquisar_Nome_Secretaria(String nome) {
    
        String sql = "select id,login,nome,endereco,cpf,rg,telefone from secretaria where nome like '%"+ nome +"%'";
        List<Secretaria> Lista = new ArrayList<>();
           
        try {

            PreparedStatement ps = getcon().prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            
            if (rs != null) {
                
                while (rs.next()) {
                    
                    Secretaria a = new Secretaria();
                    a.setId(rs.getInt(1));
                    a.setLogin(rs.getString(2));
                    a.setNome(rs.getString(3));
                    a.setEndereco(rs.getString(4));
                    a.setCpf(rs.getString(5));
                    a.setRg(rs.getString(6));
                    a.setTelefone(rs.getString(7));
               
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
    
    public List<Secretaria> Pesquisar_Cod_Secretaria(int cod) {
    
        String sql = "select id,login,nome,endereco,cpf,rg,telefone from secretaria where id = '"+ cod +"'";
        List<Secretaria> Lista = new ArrayList<>();
           
        try {

            PreparedStatement ps = getcon().prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            
            if (rs != null) {
                
                while (rs.next()) {
                    
                    Secretaria a = new Secretaria();
                    a.setId(rs.getInt(1));
                    a.setLogin(rs.getString(2));
                    a.setNome(rs.getString(3));
                    a.setEndereco(rs.getString(4));
                    a.setCpf(rs.getString(5));
                    a.setRg(rs.getString(6));
                    a.setTelefone(rs.getString(7));
               
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
    
    public boolean Testar_Secretario(int cod) {
        
        boolean Resultado = false;
        
        try {
            
            String sql = "select * from secretaria where id = "+ cod +"";
            PreparedStatement ps = getcon().prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            
            if (rs != null) {
                
                while (rs.next()) {
                    
                    Resultado = true;
                    
                }
                
            }
            
        } catch (SQLException ex) {
        
            ex.getMessage();
        
        }
        
        return Resultado;
        
    }
    
    public List<Secretaria> CapturarSecretaria(int cod){
        
        String sql = "select * from secretaria where id = "+ cod +"";
        List<Secretaria> lista = new ArrayList<>();
        
        try {

            PreparedStatement ps = getcon().prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            
            if (rs != null) {
                
                while (rs.next()) {
                    
                    Secretaria a = new Secretaria();
                    
                    a.setId(rs.getInt(1));
                    a.setLogin(rs.getString(2));
                    a.setNome(rs.getString(4));
                    a.setEndereco(rs.getString(5));
                    a.setCpf(rs.getString(6));
                    a.setRg(rs.getString(7));
                    a.setTelefone(rs.getString(8));
                    
                    lista.add(a);
                    
                }
                
                return lista;
                
            } else {
                
                return null;
                
            }
            
        } catch (SQLException e) {
            
            return null;
            
        }
            
    }
    
    public String Alterar_Secretaria(Secretaria a) {
        
        String sql = "update secretaria set login = ? ,nome = ? ,endereco = ?"
                + " ,cpf = ? ,rg = ? ,telefone = ?  where id = ? ";
        
        try {
            
            PreparedStatement ps = getcon().prepareStatement(sql);
            ps.setString(1, a.getLogin());
            ps.setString(2, a.getNome());
            ps.setString(3, a.getEndereco());
            ps.setString(4, a.getCpf());
            ps.setString(5, a.getRg());
            ps.setString(6, a.getTelefone());
            ps.setInt(7, a.getId());
            
            if (ps.executeUpdate() > 0) {
                
                return "Atualizado com sucesso!";
                
            } else {
                
                return "Erro ao Atualizar!";
                
            }
            
        } catch (SQLException e) {
            
            return e.getMessage();
            
        }
        
    }
    
}
