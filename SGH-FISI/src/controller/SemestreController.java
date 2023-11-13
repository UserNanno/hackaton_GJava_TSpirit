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

    public boolean actualizarSemestre(Semestre semestre) {
        return semestreDAO.actualizarSemestre(semestre);
    }

    public boolean eliminarSemestre(int idSemestre) {
        return semestreDAO.eliminarSemestre(idSemestre);
    }
}
