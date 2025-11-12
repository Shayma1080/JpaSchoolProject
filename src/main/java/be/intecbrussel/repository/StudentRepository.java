package be.intecbrussel.repository;
import be.intecbrussel.config.JpaConfig;
import be.intecbrussel.model.Student;
import jakarta.persistence.EntityManager;
import jakarta.persistence.Persistence;

import java.util.Optional;

public class StudentRepository {

    public void createStudent(EntityManager em, Student student) {
        em.getTransaction().begin();
        em.merge(student);
        em.getTransaction().commit();
    }

    public Optional<Student> findStudentById(Long id) {
        if (id == null) {
            //System.out.println("⚠️ ID mag niet null zijn bij het zoeken van een student.");
            return Optional.empty();
        }
        EntityManager em = JpaConfig.getEntityManager();
        Student student = em.find(Student.class, id);
        return Optional.ofNullable(student);
    }

    public Optional<Student> findStudentAll() {
        EntityManager em = JpaConfig.getEntityManager();
        Student studentobj = new Student();
        em.getTransaction().begin();
        Student student = em.find(Student.class, studentobj.getId());
        em.getTransaction().commit();
        return Optional.ofNullable(student);
    }

    public void Update(EntityManager em) {
        Student student = new Student();
        em.getTransaction().begin();
        em.merge(student);
        em.getTransaction().commit();
    }

    public void Delete(Long id) {
        EntityManager em = JpaConfig.getEntityManager();
        em.getTransaction().begin();
        Student student = em.find(Student.class, id);
        if(student != null) {
            em.remove(student);
        }
        em.getTransaction().commit();

    }


}
