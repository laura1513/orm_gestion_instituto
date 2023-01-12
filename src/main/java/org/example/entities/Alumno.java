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
    @Column(name = "segundo_apellido", length = 50)
    private String apellidoDos;
    @Column(unique = true, length = 9)
    private String nia;
    @Column(unique = true, length = 9)
    private String telefono;

    public Alumno() {
    }

    public Alumno(String nombre, String apellidoUno, String apellidoDos, String nia, String telefono) {
        this.nombre = nombre;
        this.apellidoUno = apellidoUno;
        this.apellidoDos = apellidoDos;
        this.nia = nia;
        this.telefono = telefono;
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

    public String getApellidoUno() {
        return apellidoUno;
    }

    public void setApellidoUno(String apellidoUno) {
        this.apellidoUno = apellidoUno;
    }

    public String getApellidoDos() {
        return apellidoDos;
    }

    public void setApellidoDos(String apellidoDos) {
        this.apellidoDos = apellidoDos;
    }

    public String getNia() {
        return nia;
    }

    public void setNia(String nia) {
        this.nia = nia;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    @Override
    public String toString() {
        return "Alumno{" +
                "id=" + id +
                ", nombre='" + nombre + '\'' +
                ", apellidoUno='" + apellidoUno + '\'' +
                ", apellidoDos='" + apellidoDos + '\'' +
                ", nia='" + nia + '\'' +
                ", telefono='" + telefono + '\'' +
                '}';
    }
}
