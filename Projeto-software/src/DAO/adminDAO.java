package DAO;

import java.sql.*;
import Modelo.*;
import java.util.ArrayList;
import java.util.List;

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
    
    public String Excluir_Admin(Admin a){
  
        String sql = "DELETE FROM admin WHERE id = ? AND login = ?";
        
        try {
        
            PreparedStatement ps = getcon().prepareStatement(sql);
            ps.setInt(1, a.getId());
            ps.setString(2, a.getLogin());
            
            if (ps.executeUpdate() > 0) {
            
                return "Excluído com sucesso!";
            
            } else {
            
                return "Erro ao excluir!";
            
            }
        } catch (Exception e) {
        
            return e.getMessage();
        
        }
        
    }
     
     
    public List<Admin> ListarComboAdmin(){
    
        String sql = "SELECT login FROM admin ORDER BY login";
        List<Admin> lista = new ArrayList<>();
        
        try {
        
            PreparedStatement ps = getcon().prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            
            if (rs != null) {
            
                while (rs.next()) {
                
                    Admin a = new Admin();
                    a.setLogin(rs.getString(1));
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
    
    public List<Admin> ConsultaCodigoAdmin(String nome){
    
        String sql = "SELECT id FROM admin WHERE login = '"+ nome +"'";
        List<Admin> lista = new ArrayList<>();
        
        try {
        
            PreparedStatement ps = getcon().prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            
            if (rs != null) {
            
                while (rs.next()) {
                
                    Admin a = new Admin();
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
    
    public List<Admin> ListarAdmin() {
    
        String sql = "select id,login,senha,senhaExtra from admin";
        List<Admin> Lista = new ArrayList<>();
           
        try {

            PreparedStatement ps = getcon().prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            
            if (rs != null) {
                
                while (rs.next()) {
                    
                    Admin a = new Admin();
                    a.setId(rs.getInt(1));
                    a.setLogin(rs.getString(2));
                    a.setSenha(rs.getString(3));
                    a.setSenhaExtra(rs.getString(4));
               
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
    
    public List<Admin> Pesquisar_Nome_Admin(String nome) {
    
        String sql = "select id,login,senha,senhaExtra from admin where login like '%"+ nome +"'%";
        List<Admin> Lista = new ArrayList<>();
           
        try {

            PreparedStatement ps = getcon().prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            
            if (rs != null) {
                
                while (rs.next()) {
                    
                    Admin a = new Admin();
                    a.setId(rs.getInt(1));
                    a.setLogin(rs.getString(2));
                    a.setSenha(rs.getString(3));
                    a.setSenhaExtra(rs.getString(4));
               
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
    
    public List<Admin> Pesquisar_Nome_Cod(int cod) {
    
        String sql = "select id,login,senha,senhaExtra from admin where id = '"+ cod +"'";
        List<Admin> Lista = new ArrayList<>();
           
        try {

            PreparedStatement ps = getcon().prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            
            if (rs != null) {
                
                while (rs.next()) {
                    
                    Admin a = new Admin();
                    a.setId(rs.getInt(1));
                    a.setLogin(rs.getString(2));
                    a.setSenha(rs.getString(3));
                    a.setSenhaExtra(rs.getString(4));
               
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
    
    public boolean Testar_Admin(int cod) {
        
        boolean Resultado = false;
        
        try {
            
            String sql = "select * from admin where id = '"+ cod +"'";
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
    
    public List<Admin> CapturarAdmin(int cod){
        
        String sql = "select * from admin where id = "+ cod +"";
        List<Admin> lista = new ArrayList<>();
        
        try {

            PreparedStatement ps = getcon().prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            
            if (rs != null) {
                
                while (rs.next()) {
                    
                    Admin a = new Admin();
                    
                    a.setId(rs.getInt(1));
                    a.setLogin(rs.getString(2));
                    a.setSenha(rs.getString(3));
                    a.setSenhaExtra(rs.getString(4));
                    
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
    
    public String Alterar_Admim(Admin a) {
        
        String sql = "update admin set login = ? ,senha = ? ,senhaExtra = ?"
                + " where id = ? ";
        
        try {
            
            PreparedStatement ps = getcon().prepareStatement(sql);
            ps.setString(1, a.getLogin());
            ps.setString(2, a.getSenha());
            ps.setString(3, a.getSenhaExtra());
            ps.setDouble(4, a.getId());
            
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
