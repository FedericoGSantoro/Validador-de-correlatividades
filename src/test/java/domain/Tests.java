package domain;

import domain.alumno.Alumno;
import domain.facultad.Inscripcion;
import domain.facultad.Materia;
import org.junit.Assert;
import org.junit.Test;

public class Tests {

    @Test
    public void soloUnaAsignaturaYAprueba() {
        Alumno fede = new Alumno("Fede", 21);

        Materia diseñoSistemas = new Materia("Diseño de Sistemas");
        Materia analisisSistemas = new Materia("Analisis de Sistemas");
        Materia algoritmos = new Materia("Algoritmos y Estructura de datos");

        Inscripcion unaInscripcion = new Inscripcion(fede);

        fede.agregarMateriasCursadas(analisisSistemas, algoritmos);

        diseñoSistemas.agregarCorrelativas(analisisSistemas, algoritmos);

        unaInscripcion.agregarAsignaturas(diseñoSistemas);

        Assert.assertTrue(unaInscripcion.aprobada());
    }

    @Test
    public void soloUnaAsignaturaYDesaprueba() {
        Alumno fede = new Alumno("Fede", 21);

        Materia diseñoSistemas = new Materia("Diseño de Sistemas");
        Materia analisisSistemas = new Materia("Analisis de Sistemas");
        Materia algoritmos = new Materia("Algoritmos y Estructura de datos");

        Inscripcion unaInscripcion = new Inscripcion(fede);

        fede.agregarMateriasCursadas(algoritmos);

        diseñoSistemas.agregarCorrelativas(analisisSistemas, algoritmos);

        unaInscripcion.agregarAsignaturas(diseñoSistemas);

        Assert.assertFalse(unaInscripcion.aprobada());
    }

    @Test
    public void masDeUnaAsignaturaConCorrelativasSimplesYAprueba() {
        Alumno fede = new Alumno("Fede", 21);

        Materia diseñoSistemas = new Materia("Diseño de Sistemas");
        Materia analisisSistemas = new Materia("Analisis de Sistemas");
        Materia algoritmos = new Materia("Algoritmos y Estructura de datos");
        Materia paradigmas = new Materia("Paradigmas de Programacion");
        Materia discreta = new Materia("Matematica Discreta");

        Inscripcion unaInscripcion = new Inscripcion(fede);

        fede.agregarMateriasCursadas(algoritmos, analisisSistemas, discreta);

        paradigmas.agregarCorrelativas(algoritmos, discreta);
        diseñoSistemas.agregarCorrelativas(analisisSistemas, algoritmos);

        unaInscripcion.agregarAsignaturas(diseñoSistemas, paradigmas);

        Assert.assertTrue(unaInscripcion.aprobada());
    }

    @Test
    public void masDeUnaAsignaturaConCorrelativasSimplesYDesaprueba() {
        Alumno fede = new Alumno("Fede", 21);

        Materia diseñoSistemas = new Materia("Diseño de Sistemas");
        Materia analisisSistemas = new Materia("Analisis de Sistemas");
        Materia algoritmos = new Materia("Algoritmos y Estructura de datos");
        Materia paradigmas = new Materia("Paradigmas de Programacion");
        Materia discreta = new Materia("Matematica Discreta");

        Inscripcion unaInscripcion = new Inscripcion(fede);

        fede.agregarMateriasCursadas(algoritmos, discreta);

        paradigmas.agregarCorrelativas(algoritmos, discreta);
        diseñoSistemas.agregarCorrelativas(analisisSistemas, algoritmos);

        unaInscripcion.agregarAsignaturas(diseñoSistemas, paradigmas);

        Assert.assertFalse(unaInscripcion.aprobada());
    }

    @Test
    public void unaAsignaturaConCorrelativasConsecutivasYAprueba() {
        Alumno fede = new Alumno("Fede", 21);

        Materia diseñoSistemas = new Materia("Diseño de Sistemas");
        Materia analisisSistemas = new Materia("Analisis de Sistemas");
        Materia algoritmos = new Materia("Algoritmos y Estructura de datos");
        Materia paradigmas = new Materia("Paradigmas de Programacion");

        Inscripcion unaInscripcion = new Inscripcion(fede);

        fede.agregarMateriasCursadas(algoritmos, paradigmas, analisisSistemas);

        paradigmas.agregarCorrelativas(algoritmos);
        diseñoSistemas.agregarCorrelativas(analisisSistemas, paradigmas);

        unaInscripcion.agregarAsignaturas(diseñoSistemas);

        Assert.assertTrue(unaInscripcion.aprobada());
    }

    @Test
    public void unaAsignaturaConCorrelativasConsecutivasYDesaprueba() {
        Alumno fede = new Alumno("Fede", 21);

        Materia diseñoSistemas = new Materia("Diseño de Sistemas");
        Materia analisisSistemas = new Materia("Analisis de Sistemas");
        Materia algoritmos = new Materia("Algoritmos y Estructura de datos");
        Materia paradigmas = new Materia("Paradigmas de Programacion");

        Inscripcion unaInscripcion = new Inscripcion(fede);

        fede.agregarMateriasCursadas(paradigmas, analisisSistemas);

        paradigmas.agregarCorrelativas(algoritmos);
        diseñoSistemas.agregarCorrelativas(analisisSistemas, paradigmas);

        unaInscripcion.agregarAsignaturas(diseñoSistemas);

        Assert.assertFalse(unaInscripcion.aprobada());
    }

    @Test
    public void masDeUnaAsignaturaConCorrelativasConsecutivasYAprueba() {
        Alumno fede = new Alumno("Fede", 21);

        Materia diseñoSistemas = new Materia("Diseño de Sistemas");
        Materia analisisSistemas = new Materia("Analisis de Sistemas");
        Materia algoritmos = new Materia("Algoritmos y Estructura de datos");
        Materia paradigmas = new Materia("Paradigmas de Programacion");
        Materia discreta = new Materia("Matematica Discreta");
        Materia sintaxis = new Materia("Sintaxis y Semantica de los Lenguajes");
        Materia otraMateria = new Materia("Materia Correlativa");

        Inscripcion unaInscripcion = new Inscripcion(fede);

        fede.agregarMateriasCursadas(paradigmas, analisisSistemas, algoritmos, discreta, otraMateria);

        sintaxis.agregarCorrelativas(algoritmos, discreta, otraMateria);
        paradigmas.agregarCorrelativas(algoritmos, discreta);
        diseñoSistemas.agregarCorrelativas(analisisSistemas, paradigmas);

        unaInscripcion.agregarAsignaturas(diseñoSistemas, sintaxis);

        Assert.assertTrue(unaInscripcion.aprobada());
    }

    @Test
    public void masDeUnaAsignaturaConCorrelativasConsecutivasYDesaprueba() {
        Alumno fede = new Alumno("Fede", 21);

        Materia diseñoSistemas = new Materia("Diseño de Sistemas");
        Materia analisisSistemas = new Materia("Analisis de Sistemas");
        Materia algoritmos = new Materia("Algoritmos y Estructura de datos");
        Materia paradigmas = new Materia("Paradigmas de Programacion");
        Materia discreta = new Materia("Matematica Discreta");
        Materia sintaxis = new Materia("Sintaxis y Semantica de los Lenguajes");
        Materia otraMateria = new Materia("Materia Correlativa");

        Inscripcion unaInscripcion = new Inscripcion(fede);

        fede.agregarMateriasCursadas(paradigmas, analisisSistemas, algoritmos, discreta);

        sintaxis.agregarCorrelativas(algoritmos, discreta, otraMateria);
        paradigmas.agregarCorrelativas(algoritmos, discreta);
        diseñoSistemas.agregarCorrelativas(analisisSistemas, paradigmas);

        unaInscripcion.agregarAsignaturas(diseñoSistemas, sintaxis);

        Assert.assertFalse(unaInscripcion.aprobada());
    }
}
