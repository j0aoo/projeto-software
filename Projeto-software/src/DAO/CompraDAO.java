package DAO;

import Modelo.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class CompraDAO extends ExecuteSQL {
    
    public CompraDAO(Connection con) {
        super(con);
    }
    
    public String Inserir_Compra(Compra a) {

        try {
        
            String sql = "insert into compra values(0,?,?,?,?,?,?,?,?)";
            PreparedStatement ps = getcon().prepareStatement(sql);
            ps.setString(1, a.getCpf_cliente());
            ps.setInt(2, a.getId_animal());
            ps.setString(3, a.getLista_serv());
            ps.setDouble(4, a.getDesconto());
            ps.setDouble(5, a.getTotal());
            ps.setString(6, a.getFormaPag());
            ps.setString(7, a.getDataAtual());
            ps.setString(8, a.getDataAgend());

            if (ps.executeUpdate()> 0) {
                
                return "Inserido com sucesso!";
                
            } else {
                
                return "Erro ao inserir!";
                
            }
            
        } catch (SQLException e) {
            
            return e.getMessage();
            
        }
        
    }
    
    public List<Compra> ListarCompra() {
    
        String sql = "select id_compra,cpf_cliente,id_animal,listaServ,total,formaPagamento,dataAtual,dataAgend from compra";
        List<Compra> Lista = new ArrayList<>();
           
        try {

            PreparedStatement ps = getcon().prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            
            if (rs != null) {
                
                while (rs.next()) {
                    
                    Compra a = new Compra();
                    
                    a.setId_compra(rs.getInt(1));
                    a.setCpf_cliente(rs.getString(2));
                    a.setId_animal(rs.getInt(3));
                    a.setLista_serv(rs.getString(4));
                    a.setTotal(rs.getDouble(5));
                    a.setFormaPag(rs.getString(6));
                    a.setDataAtual(rs.getString(7));
                    a.setDataAgend(rs.getString(8));
                    
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
    
    public List<Compra> ListaDelete() {
    
        String sql = "select id_compra,cpf_cliente,id_animal,listaServ,dataAgend from compra";
        List<Compra> Lista = new ArrayList<>();
           
        try {

            PreparedStatement ps = getcon().prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            
            if (rs != null) {
                
                while (rs.next()) {
                    
                    Compra a = new Compra();
                    
                    a.setId_compra(rs.getInt(1));
                    a.setCpf_cliente(rs.getString(2));
                    a.setId_animal(rs.getInt(3));
                    a.setLista_serv(rs.getString(4));
                    a.setDataAgend(rs.getString(5));
                    
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
    
    public List<Compra> ListarCompraHoje() {
 
        Date date = new Date();
        SimpleDateFormat data = new SimpleDateFormat("dd/MM/yyyy");
        SimpleDateFormat hora = new SimpleDateFormat("hh:mm");
        
        String sql = "select id_compra,cpf_cliente,id_animal,listaServ,total,formaPagamento,dataAtual,dataAgend from compra where dataAgend = "+ data.format(date) +"";
        List<Compra> Lista = new ArrayList<>();
           
        try {

            PreparedStatement ps = getcon().prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            
            if (rs != null) {
                
                while (rs.next()) {
                    
                    Compra a = new Compra();
                    
                    a.setId_compra(rs.getInt(1));
                    a.setCpf_cliente(rs.getString(2));
                    a.setId_animal(rs.getInt(3));
                    a.setLista_serv(rs.getString(4));
                    a.setTotal(rs.getDouble(5));
                    a.setFormaPag(rs.getString(6));
                    a.setDataAtual(rs.getString(7));
                    a.setDataAgend(rs.getString(8));
                    
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
    
    public List<Compra> ListarCompraExp() {
 
        Date date = new Date();
        SimpleDateFormat data = new SimpleDateFormat("dd/MM/yyyy");
        SimpleDateFormat hora = new SimpleDateFormat("hh:mm");
        
        String[] textoSeparado = data.format(date).split(";");
        
        String sql = "select id_compra,cpf_cliente,id_animal,listaServ,total,formaPagamento,dataAtual,dataAgend from compra where dataAgend = "+ data.format(date) +"";
        List<Compra> Lista = new ArrayList<>();
           
        try {

            PreparedStatement ps = getcon().prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            
            if (rs != null) {
                
                while (rs.next()) {
                    
                    Compra a = new Compra();
                    
                    a.setId_compra(rs.getInt(1));
                    a.setCpf_cliente(rs.getString(2));
                    a.setId_animal(rs.getInt(3));
                    a.setLista_serv(rs.getString(4));
                    a.setTotal(rs.getDouble(5));
                    a.setFormaPag(rs.getString(6));
                    a.setDataAtual(rs.getString(7));
                    a.setDataAgend(rs.getString(8));
                    
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
    
    public List<Compra> Pesquisar_Nome_Cod(int cod) {
    
        String sql = "select id_compra,cpf_cliente,id_animal,listaServ,total,formaPagamento,dataAtual,dataAgend from compra where id_compra = "+ cod +"";
        List<Compra> Lista = new ArrayList<>();
           
        try {

            PreparedStatement ps = getcon().prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            
            if (rs != null) {
                
                while (rs.next()) {
                    
                    Compra a = new Compra();
                    a.setId_compra(rs.getInt(1));
                    a.setCpf_cliente(rs.getString(2));
                    a.setId_animal(rs.getInt(3));
                    a.setLista_serv(rs.getString(4));
                    a.setTotal(rs.getDouble(5));
                    a.setFormaPag(rs.getString(6));
                    a.setDataAtual(rs.getString(7));
                    a.setDataAgend(rs.getString(8));
               
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
    
    public String Excluir_Compra(Compra a){
  
        String sql = "DELETE FROM compra WHERE id_compra = ? AND listaServ = ?";
        
        try {
        
            PreparedStatement ps = getcon().prepareStatement(sql);
            ps.setInt(1, a.getId_compra());
            ps.setString(2, a.getLista_serv());
            
            if (ps.executeUpdate() > 0) {
            
                return "Excluído com sucesso!";
            
            } else {
            
                return "Erro ao excluir!";
            
            }
        } catch (Exception e) {
        
            return e.getMessage();
        
        }
        
    }
    
    public List<Compra> ListarComboCompra(){
    
        String sql = "SELECT listaServ FROM compra ORDER BY listaServ";
        List<Compra> lista = new ArrayList<>();
        
        try {
        
            PreparedStatement ps = getcon().prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            
            if (rs != null) {
            
                while (rs.next()) {
                
                    Compra a = new Compra();
                    a.setLista_serv(rs.getString(1));
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
    
    public List<Compra> ConsultaCodigoCompra(String serv){
    
        String sql = "SELECT id_compra FROM compra WHERE listaServ = '"+ serv +"'";
        List<Compra> lista = new ArrayList<>();
        
        try {
        
            PreparedStatement ps = getcon().prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            
            if (rs != null) {
            
                while (rs.next()) {
                
                    Compra a = new Compra();
                    a.setId_compra(rs.getInt(1));
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
    
}
