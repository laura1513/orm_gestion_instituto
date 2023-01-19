package org.example.repositories;

import jakarta.persistence.OptimisticLockException;
import jakarta.persistence.PersistenceException;
import org.example.entities.Alumno;
import org.example.utils.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import java.util.List;
import java.util.Optional;

public class AlumnoRepository implements Repository<Alumno> {
    private SessionFactory sf = HibernateUtil.getSessionFactory();
    private Session s = sf.openSession();
    @Override
    public Alumno create(Alumno alumno) {
        s.getTransaction().begin();
        try {
            s.persist(alumno);
        } catch (PersistenceException ex) {
            System.out.println("~~~~Error al crear el alumno~~~~");
        }
        s.getTransaction().commit();
        return alumno;
    }

    @Override
    public Optional<Alumno> read(int id) {
        s.getTransaction().begin();
        Alumno alumno = s.get(Alumno.class, id);
        s.getTransaction().commit();
        return Optional.ofNullable(alumno);
    }

    @Override
    public List<Alumno> readAll() {
        s.getTransaction().begin();
        List<Alumno> alumnos = s.createSelectionQuery("from Alumno ", Alumno.class).list();
        s.getTransaction().commit();
        return alumnos;
    }

    @Override
    public Alumno update(Alumno alumno) {
        s.getTransaction().begin();
        s.merge(alumno);
        s.getTransaction().commit();
        return alumno;
    }

    @Override
    public void delete(Alumno alumno) {
        s.getTransaction().begin();
        try {
            s.remove(alumno);
        } catch (OptimisticLockException ex) {
            System.out.println("~~~~Error al borrar el alumno~~~~");
        }
        s.getTransaction().commit();
    }
    public void close() {
        s.close();
        sf.close();
    }
}
