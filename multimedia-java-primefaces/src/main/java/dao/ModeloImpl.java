/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import modelo.Modelo;

/**
 *
 * @author diego
 */
public class ModeloImpl extends Conexion {

    public List<Modelo> listarModelo() {
        List<Modelo> lista = null;
        String sql = "select * from modelo";
        try {
            PreparedStatement ps = this.conectar().prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            lista = new ArrayList<>();
            while (rs.next()) {
                Modelo m = new Modelo();
                m.setId(rs.getInt("id"));
                m.setIdentificador(rs.getInt("identificador"));
                lista.add(m);
            }
            System.out.println("se listo");
        } catch (Exception e) {
            System.out.println("Error al listar modelo: " + e.getMessage());
        }
        return lista;
    }
    
    public static void main(String[] args) {
        ModeloImpl m = new ModeloImpl();
        List<Modelo> lista = new ArrayList<>();
        lista = m.listarModelo();
        System.out.println("lista: " + lista);
    }
}
