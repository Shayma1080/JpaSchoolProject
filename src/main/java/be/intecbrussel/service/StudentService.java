package be.intecbrussel.service;

import be.intecbrussel.config.JpaConfig;
import be.intecbrussel.model.Student;
import be.intecbrussel.repository.StudentRepository;
import jakarta.persistence.EntityManager;
import be.intecbrussel.repository.SchoolRepository;

import java.util.Optional;

public class StudentService {

    private StudentRepository studentRepository = new StudentRepository();

    public void addStudent(Student student) {
        EntityManager em = JpaConfig.getEntityManager();
        studentRepository.createStudent(em,student);
        em.close();
    }

    public void getAllStudents() {
        EntityManager em = JpaConfig.getEntityManager();
        studentRepository.findStudentAll();
        em.close();
    }

    public void updateStudent(Long id,Student student) {
        EntityManager em = JpaConfig.getEntityManager();

        Optional<Student> optionalStudent = studentRepository.findStudentById(id);

        if(optionalStudent.isEmpty()) {
            em.close();
            return;
        }
        Student updateStudent = optionalStudent.get();
        updateStudent.updateStudent(student);
        studentRepository.Update(em);
        em.close();
    }

    public void removeStudent(Long id) {
        EntityManager em = JpaConfig.getEntityManager();
        Optional<Student> optionalStudent = studentRepository.findStudentById(id);

        if(optionalStudent.isPresent()) {
            studentRepository.Delete(optionalStudent.get().getId());
        }
        em.close();
    }
}
