package be.intecbrussel.repository;

import be.intecbrussel.config.JpaConfig;
import be.intecbrussel.model.Student;
import be.intecbrussel.model.Teacher;
import jakarta.persistence.EntityManager;

import java.util.Optional;

public class TeacherRepository {

    public void createTeacher(EntityManager em, Teacher teacher) {
        em.getTransaction().begin();
        em.merge(teacher);
        em.getTransaction().commit();
    }

    public Optional<Teacher> findTeacherById(Long id) {
        EntityManager entityManager = JpaConfig.getEntityManager();
        Teacher teacher = entityManager.find(Teacher.class, id);
        return Optional.ofNullable(teacher);
    }

    public Optional<Teacher> findTeacherAll() {
        EntityManager entityManager = JpaConfig.getEntityManager();
        Teacher teacherobj = new Teacher();
        Teacher newTeacher = entityManager.find(Teacher.class, teacherobj.getFirstName());
        return Optional.ofNullable(newTeacher);
    }

    public Optional <Teacher> UpdateTeacher(EntityManager em) {
        Teacher  teacher = new Teacher();
        em.getTransaction().begin();
        em.merge(teacher);
        em.getTransaction().commit();
        return Optional.of(teacher);
    }

    public Optional <Teacher> DeleteTeacher(Long id) {
        EntityManager em = JpaConfig.getEntityManager();
        em.getTransaction().begin();
        Teacher teacher = em.find(Teacher.class, id);
        em.remove(teacher);
        em.getTransaction().commit();
        return Optional.of(teacher);
    }
}
