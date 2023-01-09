package org.example.entities;

import jakarta.persistence.*;

import java.io.Serializable;

@Entity
@Table(name = "alumnos")
public class Alumno implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(length = 30)
    private String nombre;
    @Column(name = "primer_apellido", length = 50)
    private String apellidoUno;
    @Column(name = "segumdo_apellido", length = 50)
    private String apellidoDos;
    @Column(unique = true, length = 9)
    private String nia;
    @Column(unique = true, length = 9)
    private String telefono;

    public Alumno() {
    }

    public Alumno(int id, String nombre, String apellidoUno, String apellidoDos, String nia, String telefono) {
        this.id = id;
        this.nombre = nombre;
        this.apellidoUno = apellidoUno;
        this.apellidoDos = apellidoDos;
        this.nia = nia;
        this.telefono = telefono;
    }
}
