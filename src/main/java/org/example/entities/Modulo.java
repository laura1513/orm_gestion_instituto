package org.example.entities;

import jakarta.persistence.*;

import java.io.Serializable;
import java.util.List;

@Entity
@Table(name = "modulos")
public class Modulo implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(length = 30)
    private String nombre;
    @Column(length = 30)
    private String curso;
    private int horas;
    @ManyToOne(cascade = {CascadeType.PERSIST,CascadeType.MERGE})
    private Profesor profesor;

    @ManyToMany(cascade = {CascadeType.PERSIST, CascadeType.MERGE}, mappedBy = "modulos")
    private List<Alumno> alumnos;

    public Modulo() {
    }

    public Modulo(String nombre, String curso, int horas) {
        this.nombre = nombre;
        this.curso = curso;
        this.horas = horas;
    }

    public Modulo(String nombre, String curso, int horas, Profesor profesor) {
        this.nombre = nombre;
        this.curso = curso;
        this.horas = horas;
        this.profesor = profesor;
    }

    public Modulo(int id, String nombre, String curso, int horas, Profesor profesor, List<Alumno> alumnos) {
        this.id = id;
        this.nombre = nombre;
        this.curso = curso;
        this.horas = horas;
        this.profesor = profesor;
        this.alumnos = alumnos;
    }

    public List<Alumno> getAlumnos() {
        return alumnos;
    }

    public void setAlumnos(List<Alumno> alumnos) {
        this.alumnos = alumnos;
    }

    public Profesor getProfesor() {
        return profesor;
    }

    public void setProfesor(Profesor profesor) {
        this.profesor = profesor;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getCurso() {
        return curso;
    }

    public void setCurso(String curso) {
        this.curso = curso;
    }

    public int getHoras() {
        return horas;
    }

    public void setHoras(int horas) {
        this.horas = horas;
    }

    @Override
    public String toString() {
        return "Modulo{" +
                "id=" + id +
                ", nombre='" + nombre + '\'' +
                ", curso='" + curso + '\'' +
                ", horas=" + horas +
                ", profesor=" + profesor +
                ", alumnos=" + alumnos +
                '}';
    }
}
