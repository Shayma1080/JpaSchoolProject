package be.intecbrussel.service;

import be.intecbrussel.config.JpaConfig;
import be.intecbrussel.model.Student;
import be.intecbrussel.model.Teacher;
import be.intecbrussel.repository.TeacherRepository;
import jakarta.persistence.EntityManager;

import java.util.Optional;

public class TeacherService {

    private TeacherRepository teacherRepository= new TeacherRepository();

    public void addTeacher(Teacher teacher) {
        EntityManager em = JpaConfig.getEntityManager();
        teacherRepository.createTeacher(em,teacher);
        em.close();
    }

    public void getAllStudents() {
        EntityManager em = JpaConfig.getEntityManager();
        teacherRepository.findTeacherAll();
        em.close();
    }

    public void updateStudent(Long id,Teacher teacher) {
        EntityManager em = JpaConfig.getEntityManager();
        teacher = em.find(Teacher.class,id);
        Optional<Teacher> optionalStudent = teacherRepository.findTeacherById(id);

        if(optionalStudent.isEmpty()) {
            em.close();
        }
        Teacher updateStudent = optionalStudent.get();
        updateStudent.updateTeacher(teacher);
        teacherRepository.UpdateTeacher(em);
        em.close();
    }

    public void removeStudent(Long id) {
        EntityManager em = JpaConfig.getEntityManager();
        Optional<Teacher> optionalTeacher = teacherRepository.findTeacherById(id);

        if(optionalTeacher.isPresent()) {
            teacherRepository.DeleteTeacher(optionalTeacher.get().getId());
        }
        em.close();
    }
}
