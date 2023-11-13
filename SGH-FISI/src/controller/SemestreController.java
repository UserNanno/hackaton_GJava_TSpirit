package controller;

import java.util.List;
import model.Semestre;
import persistencia.SemestreDAO;

public class SemestreController {

    private SemestreDAO semestreDAO;

    public SemestreController() {
        this.semestreDAO = new SemestreDAO();
    }

    public List<Semestre> obtenerSemestres() {
        return semestreDAO.obtenerSemestres();
    }

    public boolean agregarSemestre(Semestre semestre) {
        return semestreDAO.agregarSemestre(semestre);
    }

    public boolean actualizarSemestre(int idSemestre, String nombre) {
        Semestre semestre = new Semestre();
        semestre.setId(idSemestre);
        semestre.setNombre(nombre);
        return semestreDAO.actualizarSemestre(semestre);
    }

    public boolean eliminarSemestre(int idSemestre) {
        return semestreDAO.eliminarSemestre(idSemestre);
    }

    public boolean existeSemestre(String nombre) {
        List<Semestre> semestres = obtenerSemestres(); // Obtener todos los semestres
        for (Semestre semestre : semestres) {
            if (semestre.getNombre().equalsIgnoreCase(nombre)) {
                return true; // El nombre ya existe
            }
        }
        return false; // El nombre no existe
    }
}
