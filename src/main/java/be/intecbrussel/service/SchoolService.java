package be.intecbrussel.service;

import be.intecbrussel.config.JpaConfig;
import be.intecbrussel.model.School;
import be.intecbrussel.model.Teacher;
import be.intecbrussel.repository.SchoolRepository;
import be.intecbrussel.repository.TeacherRepository;
import jakarta.persistence.EntityManager;

import java.util.Optional;

public class SchoolService {

    SchoolRepository schoolRepository = new SchoolRepository();


    public void addSchool(School school) {
        EntityManager em = JpaConfig.getEntityManager();
        schoolRepository.createSchool(em,school);
        em.close();
    }

    public void getAllSchool() {
        EntityManager em = JpaConfig.getEntityManager();
        schoolRepository.findSchoolAll();
        em.close();
    }

    public void updateSchool(Long id, School school) {
        EntityManager em = JpaConfig.getEntityManager();
        school = em.find(School.class,id);
        Optional<School> optionalSchool = schoolRepository.findSchoolById(id);

        if(optionalSchool.isEmpty()) {
            em.close();
        }
        School updateStudent = optionalSchool.get();
        updateStudent.updatSchool(school);
        schoolRepository.UpdateSchool(em);
        em.close();
    }

    public void removeSchool(Long id) {
        EntityManager em = JpaConfig.getEntityManager();
        Optional<School> optionalSchool = schoolRepository.findSchoolById(id);

        if(optionalSchool.isPresent()) {
            schoolRepository.DeleteSchool(optionalSchool.get().getSchoolId());
        }
        em.close();
    }
}
