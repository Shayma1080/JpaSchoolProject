package be.intecbrussel.repository;

import be.intecbrussel.config.JpaConfig;
import be.intecbrussel.model.School;
import be.intecbrussel.model.Teacher;
import jakarta.persistence.EntityManager;

import java.util.Optional;

public class SchoolRepository {

    public void createSchool(EntityManager em,School school) {
        em.getTransaction().begin();
        em.merge(school);
        em.getTransaction().commit();
    }

    public Optional<School> findSchoolById(Long id) {
        EntityManager entityManager = JpaConfig.getEntityManager();
        School school = entityManager.find(School.class, id);
        return Optional.ofNullable(school);
    }

    public Optional<School> findSchoolAll() {
        EntityManager entityManager = JpaConfig.getEntityManager();
        School schoolobj = new School();
        School newSchool = entityManager.find(School.class, schoolobj.getSchoolId());
        return Optional.ofNullable(newSchool);
    }

    public Optional <School> UpdateSchool(EntityManager em) {
        School  school = new School();
        em.getTransaction().begin();
        em.merge(school);
        em.getTransaction().commit();
        return Optional.of(school);
    }

    public Optional <School> DeleteSchool(Long id) {
        EntityManager em = JpaConfig.getEntityManager();
        em.getTransaction().begin();
        School school = em.find(School.class, id);
        em.remove(school);
        em.getTransaction().commit();
        return Optional.of(school);
    }
}
