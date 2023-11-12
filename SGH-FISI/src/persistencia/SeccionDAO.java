package persistencia;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import model.Seccion;

public class SeccionDAO {
    public List<Seccion> obtenerSecciones() {
        List<Seccion> secciones = new ArrayList<>();
        Connection conexion = ConexionDB.obtenerConexion();
        PreparedStatement ps = null;
        ResultSet rs = null;

        try {
            String query = "SELECT id, nombre FROM secciones";
            ps = conexion.prepareStatement(query);
            rs = ps.executeQuery();

            while (rs.next()) {
                Seccion seccion = new Seccion();
                seccion.setId(rs.getInt("id"));
                seccion.setNombre(rs.getString("nombre"));
                secciones.add(seccion);
            }
        } catch (SQLException e) {
            System.out.println("Error al obtener secciones: " + e.getMessage());
        } finally {
            // Cerrar ResultSet, PreparedStatement y la conexión
        }

        return secciones;
    }
}
