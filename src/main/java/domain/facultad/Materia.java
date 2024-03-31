package domain.facultad;

import domain.alumno.Alumno;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Materia {
    private String nombre;
    public List<Materia> correlativas;

    public Materia(String nombre) {
        this.nombre = nombre;
        this.correlativas = new ArrayList<>();
    }

    public void agregarCorrelativas(Materia ... materias) {
        Collections.addAll(this.correlativas, materias);
    }
    public Boolean comprobarCorrelativas(Alumno alumno) {
        for(Materia materia: correlativas) {
            if(!alumno.materiasCursadas.contains(materia) || !materia.comprobarCorrelativas(alumno)) {
                        return false;
            }
        }
        return true;
    }
}
