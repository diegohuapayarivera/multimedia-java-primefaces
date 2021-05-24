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
import modelo.Categoria;
import modelo.Producto;

/**
 *
 * @author diego
 */
public class ProductoImpl extends Conexion {

    public List<Producto> listar() {
        List<Producto> lista = null;
        String sql = "select \n"
                + "p.idcat,\n"
                + "p.idpro,\n"
                + "p.nombre,\n"
                + "p.descripcion,\n"
                + "p.imagen,\n"
                + "c.nombre as nombrecategoria \n"
                + "from producto p \n"
                + "inner join categoria c on \n"
                + "p.idcat = c.idcat";
        try {
            PreparedStatement ps = this.conectar().prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            lista = new ArrayList<>();
            while (rs.next()) {
                Producto p = new Producto();
                Categoria c = new Categoria();
                p.setNombre(rs.getString("nombre"));
                p.setDescripcion(rs.getString("descripcion"));
                p.setIdcat(rs.getInt("idcat"));
                p.setIdpro(rs.getInt("idpro"));
                p.setImagen(rs.getInt("imagen"));
                c.setNombre(rs.getString("nombrecategoria"));
                p.setCategoria(c);
                lista.add(p);
            }
        } catch (Exception e) {
            System.out.println("Error al listar productoImpl: " + e.getMessage());
        }
        return lista;
    }
}
