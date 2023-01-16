package org.example;

import jakarta.transaction.Transaction;
import org.example.entities.Alumno;
import org.example.entities.Direccion;
import org.example.entities.Modulo;
import org.example.entities.Profesor;
import org.example.repositories.AlumnoRepository;
import org.example.repositories.DireccionRepository;
import org.example.repositories.ProfesorRepository;

import java.util.Optional;

public class App 
{
    public static void main( String[] args )
    {
        Alumno a1 = new Alumno("Juan", "Lopez", "Tormo", "111111111", "123456789");
        Alumno a2 = new Alumno("Roberto", "Sanchez", "Martín", "222222222", "987654321");
        Direccion d1 = new Direccion("Gran Via", 28, "Madrid", "Madrid");
        Direccion d2 = new Direccion("Boqueras", 17, "Almazora", "Castellon");
        Modulo m1 = new Modulo("Matematicas", "2ESO", 16);
        Profesor p1 = new Profesor("Juan", "Rodriguez", "Gil", "751359684", d1);
        Profesor p2 = new Profesor("Sara", "Fernandez", "Mera", "153957846", d2);

        DireccionRepository direcciones = new DireccionRepository();
        direcciones.create(d1);
        direcciones.create(d2);

        System.out.println();

        System.out.println("Creación de los alumnos");
        AlumnoRepository alumnos = new AlumnoRepository();
        alumnos.create(a1);
        alumnos.create(a2);
        alumnos.readAll().forEach(System.out::println);

        System.out.println();

        System.out.println("Creación de los profesores");
        ProfesorRepository profesores = new ProfesorRepository();
        profesores.create(p1);
        profesores.create(p2);
        profesores.readAll().forEach(System.out::println);

        System.out.println();

        System.out.println("Buscar al alumno por su id");
        Optional<Alumno> a1copia = alumnos.read(a1.getId());
        if(a1copia.isPresent()) {
            System.out.println(a1copia);
        } else {
            System.out.println("El id del alumno no existe");
        }

        System.out.println();

        Optional<Alumno> alumnoNoExiste = alumnos.read(4);
        if(alumnoNoExiste.isPresent()) {
            System.out.println(alumnoNoExiste);
        } else {
            System.out.println("El id del alumno no existe");
        }

        System.out.println();

        System.out.println("Buscar al profesor por su id");
        Optional<Profesor> p1copia = profesores.read(p1.getId());
        if(p1copia.isPresent()) {
            System.out.println(p1copia);
        } else {
            System.out.println("El id del profesor no existe");
        }

        System.out.println();

        Optional<Profesor> profesorNoExiste = profesores.read(4);
        if (profesorNoExiste.isPresent()) {
            System.out.println(profesorNoExiste);
        } else {
            System.out.println("El id del profesor no existe");
        }

        System.out.println();

        System.out.println("Actualizo un alumno");
        a2.setNombre("Pablo");
        alumnos.update(a2);
        System.out.println(a2);

        System.out.println();

        System.out.println("Actualizo un profesor");
        p1.setNombre("Laura");
        profesores.update(p1);
        System.out.println(p1);

        System.out.println();
        alumnos.delete(a2);
        profesores.delete(p2);

        System.out.println();

        System.out.println("Borrado y lectura");
        alumnos.readAll().forEach(System.out::println);
        profesores.readAll().forEach(System.out::println);

        alumnos.close();
        profesores.close();
        direcciones.close();
    }
}
