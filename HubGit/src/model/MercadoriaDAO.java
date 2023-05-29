package model;

import model.Conectarbd;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.swing.JOptionPane;
import java.util.ArrayList;

public class MercadoriaDAO {
    
    private Connection con;

    public MercadoriaDAO() {
        con = new Conectarbd().conectar();
    }
    
     public ArrayList<Mercadoria> listar() {
        String sql = "SELECT * FROM mercadoria";
        ArrayList<Mercadoria> mercadorias;
        mercadorias = new ArrayList<Mercadoria>();
        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Mercadoria c = new Mercadoria();
                c.setCodigo(rs.getInt("id"));
                c.setProduto(rs.getString("mercadoria"));
                c.setPreço(rs.getString("preço"));
                mercadorias.add(c);
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return mercadorias;
    }
    
    public void inserir(Mercadoria m) {
        String sql = "INSERT INTO mercadoria(mercadoria,preço) VALUE(?,?)";
        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, m.getProduto());
            ps.setString(2, m.getPreço());
            ps.execute();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
    
     public void atualizar(Mercadoria m) {
        String sql = "UPDATE mercadoria SET mercadoria=?,preço=? WHERE id=?";
        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, m.getProduto());
            ps.setString(2, m.getPreço());
            ps.setInt(3, m.getCodigo());
            ps.executeUpdate();
            JOptionPane.showMessageDialog(null, "Mercadoria atualizada ");
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
     
    public void excluir(int id) {
        String sql = "DELETE FROM mercadoria WHERE id=?";
        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, id);
            ps.executeUpdate();
            JOptionPane.showMessageDialog(null, "Mercadoria excluida");
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
