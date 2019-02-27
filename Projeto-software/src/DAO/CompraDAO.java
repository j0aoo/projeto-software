package DAO;

import Modelo.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
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
    
}
