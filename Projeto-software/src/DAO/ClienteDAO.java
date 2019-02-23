package DAO;

import Modelo.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

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
    
    public String Excluir_Cliente(Cliente a){
  
        String sql = "DELETE FROM clientes WHERE id_cliente = ? AND nome = ?";
        
        try {
        
            PreparedStatement ps = getcon().prepareStatement(sql);
            ps.setInt(1, a.getId_cliente());
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
     
     
    public List<Cliente> ListarComboCliente(){
    
        String sql = "SELECT nome FROM clientes ORDER BY nome";
        List<Cliente> lista = new ArrayList<>();
        
        try {
        
            PreparedStatement ps = getcon().prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            
            if (rs != null) {
            
                while (rs.next()) {
                
                    Cliente a = new Cliente();
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
    
    public List<Cliente> ConsultaCodigoCliente(String nome){
    
        String sql = "SELECT id_cliente FROM clientes WHERE nome = '"+ nome +"'";
        List<Cliente> lista = new ArrayList<>();
        
        try {
        
            PreparedStatement ps = getcon().prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            
            if (rs != null) {
            
                while (rs.next()) {
                
                    Cliente a = new Cliente();
                    a.setId_cliente(rs.getInt(1));
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
    
    public List<Cliente> ConsultaCpfCliente(String nome){
    
        String sql = "SELECT cpf FROM clientes WHERE nome = '"+ nome +"'";
        List<Cliente> lista = new ArrayList<>();
        
        try {
        
            PreparedStatement ps = getcon().prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            
            if (rs != null) {
            
                while (rs.next()) {
                
                    Cliente a = new Cliente();
                    a.setCpf(rs.getString(1));
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
    
    public List<Cliente> ListarCliente() {
    
        String sql = "select id_cliente,nome,email,cpf,telefone,endereco from clientes";
        List<Cliente> Lista = new ArrayList<>();
           
        try {

            PreparedStatement ps = getcon().prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            
            if (rs != null) {
                
                while (rs.next()) {
                    
                    Cliente a = new Cliente();
                    a.setId_cliente(rs.getInt(1));
                    a.setNome(rs.getString(2));
                    a.setEmail(rs.getString(3));
                    a.setCpf(rs.getString(4));
                    a.setTelefone(rs.getString(5));
                    a.setEndereco(rs.getString(6));
               
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
    
    public List<Cliente> Pesquisar_Nome_Cliente(String nome) {
    
        String sql = "select id_cliente,nome,email,cpf,telefone,endereco from clientes where nome like '%"+ nome +"%'";
        List<Cliente> Lista = new ArrayList<>();
           
        try {

            PreparedStatement ps = getcon().prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            
            if (rs != null) {
                
                while (rs.next()) {
                    
                    Cliente a = new Cliente();
                    a.setId_cliente(rs.getInt(1));
                    a.setNome(rs.getString(2));
                    a.setEmail(rs.getString(3));
                    a.setCpf(rs.getString(4));
                    a.setTelefone(rs.getString(5));
                    a.setEndereco(rs.getString(6));
               
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
    
    public List<Cliente> Pesquisar_Cod_Cliente(int cod) {
    
        String sql = "select id_cliente,nome,email,cpf,telefone,endereco from clientes where id_cliente = '"+ cod +"'";
        List<Cliente> Lista = new ArrayList<>();
           
        try {

            PreparedStatement ps = getcon().prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            
            if (rs != null) {
                
                while (rs.next()) {
                    
                    Cliente a = new Cliente();
                    a.setId_cliente(rs.getInt(1));
                    a.setNome(rs.getString(2));
                    a.setEmail(rs.getString(3));
                    a.setCpf(rs.getString(4));
                    a.setTelefone(rs.getString(5));
                    a.setEndereco(rs.getString(6));
                    
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
    
    public boolean Testar_Cliente(int cod) {
        
        boolean Resultado = false;
        
        try {
            
            String sql = "select * from clientes where id_cliente = '"+ cod +"'";
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
    
    public List<Cliente> CapturarCliente(int cod){
        
        String sql = "select * from clientes where id_cliente = '"+ cod +"'";
        List<Cliente> lista = new ArrayList<>();
        
        try {

            PreparedStatement ps = getcon().prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            
            if (rs != null) {
                
                while (rs.next()) {
                    
                    Cliente a = new Cliente();
                    
                    a.setId_cliente(rs.getInt(1));
                    a.setNome(rs.getString(2));
                    a.setEmail(rs.getString(3));
                    a.setCpf(rs.getString(4));
                    a.setTelefone(rs.getString(5));
                    a.setEndereco(rs.getString(6));
                    
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
    
    public String Alterar_Cliente(Cliente a) {
        
        String sql = "update clientes set nome = ? ,email = ? ,cpf = ?"
                + " ,telefone = ? ,endereco = ? where id_cliente = ? ";
        
        try {
            
            PreparedStatement ps = getcon().prepareStatement(sql);
            ps.setString(1, a.getNome());
            ps.setString(2, a.getEmail());
            ps.setString(3, a.getCpf());
            ps.setString(4, a.getTelefone());
            ps.setString(5, a.getEndereco());
            ps.setInt(6, a.getId_cliente());
            
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
