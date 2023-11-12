package persistencia;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import model.Curso;

public class CursoDAO {

    public List<Curso> obtenerCursos() {
        List<Curso> cursos = new ArrayList<>();
        Connection conexion = ConexionDB.obtenerConexion();
        PreparedStatement ps = null;
        ResultSet rs = null;

        try {
            String query = "SELECT id_curso, nombre FROM cursos";
            ps = conexion.prepareStatement(query);
            rs = ps.executeQuery();

            while (rs.next()) {
                Curso curso = new Curso();
                curso.setId(rs.getInt("id_curso"));
                curso.setNombre(rs.getString("nombre"));
                cursos.add(curso);
            }
        } catch (SQLException e) {
            System.out.println("Error al obtener cursos: " + e.getMessage());
        } finally {
            // Cerrar ResultSet, PreparedStatement y la conexión
        }

        return cursos;
    }

    public List<Curso> obtenerCursosPorCiclo(int idCiclo) {
        List<Curso> cursos = new ArrayList<>();
        Connection conexion = ConexionDB.obtenerConexion();
        PreparedStatement ps = null;
        ResultSet rs = null;

        try {
            String query = "SELECT c.Codigo, c.nombre, c.cantidad_alumnos, "
                    + "IFNULL(pe.nombre, '') as plan_estudios_nombre, "
                    + "IFNULL(s.nombre, '') as seccion "
                    + "FROM cursos c "
                    + "LEFT JOIN plan_estudios pe ON c.id_plan_estudios = pe.id_plan_estudios "
                    + "LEFT JOIN seccion s ON c.id_seccion = s.id_seccion "
                    + "WHERE c.id_ciclo = ?";
            ps = conexion.prepareStatement(query);
            ps.setInt(1, idCiclo);
            rs = ps.executeQuery();

            while (rs.next()) {
                Curso curso = new Curso();
                curso.setCodigo(rs.getString("Codigo"));
                curso.setNombre(rs.getString("nombre"));
                curso.setCantidadAlumnos(rs.getInt("cantidad_alumnos"));
                curso.setPlanEstudios(rs.getString("plan_estudios_nombre"));
                curso.setSeccion(rs.getString("seccion"));
                cursos.add(curso);
            }
        } catch (SQLException e) {
            System.out.println("Error al obtener cursos por ciclo: " + e.getMessage());
        } finally {
            // Cerrar ResultSet, PreparedStatement y la conexión
        }

        return cursos;
    }

}
