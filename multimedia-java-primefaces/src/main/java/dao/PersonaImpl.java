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
import modelo.Persona;

/**
 *
 * @author diego
 */
public class PersonaImpl extends Conexion {

    public void registrar(Persona modelo) {
        System.out.println("modelo: " + modelo.toString());
        String sql = "insert into prueba(nombre,apellido,dni,video) values(?,?,?,?)";
        try {
            PreparedStatement ps = this.conectar().prepareStatement(sql);
            ps.setString(1, modelo.getNombre());
            ps.setString(2, modelo.getApellido());
            ps.setInt(3, modelo.getDni());
            ps.setInt(4, modelo.getVideo());
            ps.execute();
            ps.close();
        } catch (Exception e) {
            System.out.println("Error al registrar PersonaImpl: " + e.getMessage());
        }
    }

    public List<Persona> listar() {
        List<Persona> lista = null;
        String sql = "select * from prueba";
        try {
            PreparedStatement ps = this.conectar().prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            lista = new ArrayList<>();
            while (rs.next()) {
                Persona p = new Persona();
                p.setNombre(rs.getString("nombre"));
                p.setApellido(rs.getString("apellido"));
                p.setDni(rs.getInt("dni"));
                p.setVideo(rs.getInt("video"));
                lista.add(p);
            }
        } catch (Exception e) {
            System.out.println("Error al listar personaC: " + e.getMessage());
        }

        return lista;
    }

}
