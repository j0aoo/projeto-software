package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import Modelo.*;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;


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
    
    public String Excluir_Amimal(Animal a){
  
        String sql = "DELETE FROM animais WHERE id_animal = ? AND nome = ?";
        
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
     
     
    public List<Animal> ListarComboAnimal(){
    
        String sql = "SELECT nome FROM animais ORDER BY nome";
        List<Animal> lista = new ArrayList<>();
        
        try {
        
            PreparedStatement ps = getcon().prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            
            if (rs != null) {
            
                while (rs.next()) {
                
                    Animal a = new Animal();
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
    
    public List<Animal> ConsultaCodigoAnimal(String nome){
    
        String sql = "SELECT id_animal FROM animais WHERE nome = '"+ nome +"'";
        List<Animal> lista = new ArrayList<>();
        
        try {
        
            PreparedStatement ps = getcon().prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            
            if (rs != null) {
            
                while (rs.next()) {
                
                    Animal a = new Animal();
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
    
    public List<Animal> ListarAnimal() {
    
        String sql = "select id_animal,nome,tipo,raca,tamanho,peso,idade from animais";
        List<Animal> Lista = new ArrayList<>();
           
        try {

            PreparedStatement ps = getcon().prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            
            if (rs != null) {
                
                while (rs.next()) {
                    
                    Animal a = new Animal();
                    a.setId(rs.getInt(1));
                    a.setNome(rs.getString(2));
                    a.setTipo(rs.getString(3));
                    a.setRaca(rs.getString(4));
                    a.setTamanho(rs.getDouble(5));
                    a.setPeso(rs.getDouble(6));
                    a.setIdade(rs.getInt(7));
               
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
    
    public List<Animal> Pesquisar_Nome_Animal(String nome) {
    
        String sql = "select id_animal,nome,tipo,raca,tamanho,peso,idade from animais where nome like '%"+ nome +"%'";
        List<Animal> Lista = new ArrayList<>();
           
        try {

            PreparedStatement ps = getcon().prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            
            if (rs != null) {
                
                while (rs.next()) {
                    
                    Animal a = new Animal();
                    a.setId(rs.getInt(1));
                    a.setNome(rs.getString(2));
                    a.setTipo(rs.getString(3));
                    a.setRaca(rs.getString(4));
                    a.setTamanho(rs.getDouble(5));
                    a.setPeso(rs.getDouble(6));
                    a.setIdade(rs.getInt(7));
               
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
    
    public List<Animal> Pesquisar_Cod_Animal(int cod) {
    
        String sql = "select id_animal,nome,tipo,raca,tamanho,peso,idade from animais where id_animal = '"+ cod +"'";
        List<Animal> Lista = new ArrayList<>();
           
        try {

            PreparedStatement ps = getcon().prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            
            if (rs != null) {
                
                while (rs.next()) {
                    
                    Animal a = new Animal();
                    a.setId(rs.getInt(1));
                    a.setNome(rs.getString(2));
                    a.setTipo(rs.getString(3));
                    a.setRaca(rs.getString(4));
                    a.setTamanho(rs.getDouble(5));
                    a.setPeso(rs.getDouble(6));
                    a.setIdade(rs.getInt(7));
               
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
