package org.example;

import jakarta.transaction.Transaction;
import org.example.entities.Alumno;
import org.example.entities.Direccion;
import org.example.entities.Modulo;
import org.example.entities.Profesor;
import org.example.repositories.AlumnoRepository;

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
        Profesor p1 = new Profesor("Juan", "Rodriguez", "Gil", "123456789", d1);


        AlumnoRepository alumnos = new AlumnoRepository();
        alumnos.create(a1);
        alumnos.create(a2);
        alumnos.readAll().forEach(System.out::println);

        Optional<Alumno> a1copia = alumnos.read(a1.getId());
        if(a1copia.isPresent()) {
            System.out.println(a1copia);
        } else {
            System.out.println("El id del alumno no existe");
        }

        Optional<Alumno> alumnoNoExiste = alumnos.read(4);
        if(alumnoNoExiste.isPresent()) {
            System.out.println(alumnoNoExiste);
        } else {
            System.out.println("El id del alumno no existe");
        }

        a2.setNombre("Pablo");
        alumnos.update(a2);
        System.out.println(a2);

        alumnos.close();
    }
}
