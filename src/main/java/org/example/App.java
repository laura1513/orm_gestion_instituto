package org.example;

import jakarta.transaction.Transaction;
import org.example.entities.Alumno;
import org.example.entities.Direccion;
import org.example.entities.Modulo;
import org.example.entities.Profesor;
import org.example.repositories.AlumnoRepository;
import org.example.repositories.DireccionRepository;
import org.example.repositories.ModuloRepository;
import org.example.repositories.ProfesorRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class App 
{
    public static void main( String[] args )
    {
        Direccion d1 = new Direccion("Gran Via", 28, "Madrid", "Madrid");
        Direccion d2 = new Direccion("Boqueras", 17, "Almazora", "Castellon");

        Profesor p1 = new Profesor("Juan", "Rodriguez", "Gil", "751359684", d1);
        Profesor p2 = new Profesor("Sara", "Fernandez", "Mera", "153957846", d2);

        Alumno a1 = new Alumno("Juan", "Lopez", "Tormo", "111111111", "123456789");
        Alumno a2 = new Alumno("Roberto", "Sanchez", "Martín", "222222222", "987654321");

        Modulo m1 = new Modulo("Matematicas", "2ESO", 8, p1);
        m1.anyadirAl(a1);
        Modulo m2 = new Modulo("Fisica", "3ESO", 5, p2);
        m2.anyadirAl(a2);

        ModuloRepository modulos = new ModuloRepository();
        modulos.create(m1);
        modulos.create(m2);

        DireccionRepository direcciones = new DireccionRepository();
        direcciones.create(d1);
        direcciones.create(d2);

        System.out.println();

        System.out.println("Creación de los alumnos");
        AlumnoRepository alumnos = new AlumnoRepository();
        alumnos.create(a1);
        alumnos.create(a2);

        System.out.println();

        System.out.println("Creación de los profesores");
        ProfesorRepository profesores = new ProfesorRepository();
        profesores.create(p1);
        profesores.create(p2);

        System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
        System.out.println("Imprimo modulos");
        modulos.readAll().forEach(System.out::println);
        System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");

        System.out.println();

        System.out.println("Buscar al modulo por su id");
        Optional<Modulo> m1copia = modulos.read(m1.getId());
        if(m1copia.isPresent()) {
            System.out.println(m1copia);
        } else {
            System.out.println("El id del modulo no existe");
        }

        System.out.println();

        Optional<Modulo> moduloNoExiste = modulos.read(4);
        if(moduloNoExiste.isPresent()) {
            System.out.println(moduloNoExiste);
        } else {
            System.out.println("El id del modulo no existe");
        }

        System.out.println();

        System.out.println("Actualizo un modulo");
        m2.setNombre("Inglés");
        modulos.update(m2);
        System.out.println(m2);

        System.out.println();
        modulos.delete(m2);

        System.out.println();

        System.out.println("Borrado y lectura");
        modulos.readAll().forEach(System.out::println);

        alumnos.close();
        profesores.close();
        direcciones.close();
        modulos.close();
    }
}
