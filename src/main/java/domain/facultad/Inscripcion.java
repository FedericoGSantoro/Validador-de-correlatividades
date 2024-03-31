package domain.facultad;

import domain.alumno.Alumno;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Inscripcion {
    private List<Materia> asignaturas;
    private Alumno alumno;

    public Inscripcion(Alumno alumno) {
        this.alumno = alumno;
        this.asignaturas = new ArrayList<>();
    }

    public void agregarAsignaturas(Materia ... materias) {
        Collections.addAll(this.asignaturas, materias);
    }
    public Boolean aprobada() {
        for(Materia materia: asignaturas) {
            if(!materia.comprobarCorrelativas(this.alumno)) {
                return false;
            }
        }
        return true;
    }

}
