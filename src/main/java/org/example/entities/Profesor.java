package org.example.entities;

import jakarta.persistence.*;

import java.util.Set;

@Entity
@Table(name = "profesores")
public class Profesor {
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
    private String telefono;
    @OneToOne
    private Direccion direccion;
    @OneToMany(mappedBy = "profesor")
    private Set<Modulo> modulos;
    public Profesor() {
    }

    public Profesor(String nombre, String apellidoUno, String apellidoDos, String telefono, Direccion direccion) {
        this.nombre = nombre;
        this.apellidoUno = apellidoUno;
        this.apellidoDos = apellidoDos;
        this.telefono = telefono;
        this.direccion = direccion;
    }

    public Profesor(String nombre, String apellidoUno, String apellidoDos, String telefono, Direccion direccion, Set<Modulo> modulos) {
        this.nombre = nombre;
        this.apellidoUno = apellidoUno;
        this.apellidoDos = apellidoDos;
        this.telefono = telefono;
        this.direccion = direccion;
        this.modulos = modulos;
    }

    public Set<Modulo> getModulos() {
        return modulos;
    }

    public void setModulos(Set<Modulo> modulos) {
        this.modulos = modulos;
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

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public Direccion getDireccion() {
        return direccion;
    }

    public void setDireccion(Direccion direccion) {
        this.direccion = direccion;
    }

    @Override
    public String toString() {
        return "Profesor{" +
                "id=" + id +
                ", nombre='" + nombre + '\'' +
                ", apellidoUno='" + apellidoUno + '\'' +
                ", apellidoDos='" + apellidoDos + '\'' +
                ", telefono='" + telefono + '\'' +
                ", direccion=" + direccion +
                '}';
    }
}
