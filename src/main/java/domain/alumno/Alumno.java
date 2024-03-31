package domain.alumno;

import domain.facultad.Materia;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Alumno {
    private String nombre;
    private Integer edad;
    public List<Materia> materiasCursadas;

    public Alumno (String nombre, Integer edad) {
        this.nombre = nombre;
        this. edad = edad;
        this.materiasCursadas = new ArrayList<>();
    }

    public void agregarMateriasCursadas(Materia ... materias) {
        Collections.addAll(this.materiasCursadas, materias);
    }

}
