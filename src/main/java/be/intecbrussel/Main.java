package be.intecbrussel;

import be.intecbrussel.model.School;
import be.intecbrussel.model.Student;
import be.intecbrussel.model.Teacher;
import be.intecbrussel.repository.SchoolRepository;
import be.intecbrussel.repository.StudentRepository;
import be.intecbrussel.repository.TeacherRepository;
import be.intecbrussel.service.SchoolService;
import be.intecbrussel.service.StudentService;
import be.intecbrussel.service.TeacherService;

public class Main {
    public static void main(String[] args) {
        // repositories
        SchoolRepository  schoolRepository = new SchoolRepository();
        TeacherRepository teacherRepository = new TeacherRepository();
        StudentRepository studentRepository = new StudentRepository();

        //servies
        StudentService studentService = new StudentService();
        TeacherService teacherService = new TeacherService();
        SchoolService schoolService = new SchoolService();


        // scholen maken
        School imelda = new School("Imelda","Brussel");
        School kak =  new School("Koninkelijk Athenium Koekelberg","Brussel");
        School intec =  new School("Intec","Brussel");


        // studenten maken
        Student chaima = new Student("chaima","hajji",imelda);
        Student lola = new Student("lola","MonoPoly",kak);

        // teachers maken
        Teacher hilal = new Teacher("Hilal","Demir",intec);

        // school opslaan
        schoolService.addSchool(imelda);
        System.out.println("school toegevoegd: " + imelda);
        schoolService.addSchool(kak);
        schoolService.addSchool(intec);


        // student opslaan
        studentService.addStudent(chaima);
        studentService.addStudent(lola);
        System.out.println("student toegevoegd: " + chaima.getFirstName()+" "+chaima.getLastName());
        chaima.setFirstName("Fatima");

        System.out.println(" Student naam veranderd: " + chaima.getFirstName());
        studentService.updateStudent(chaima.getId(), chaima);

        studentService.removeStudent(chaima.getId());
        System.out.println("student delete: " + chaima.getFirstName());

        // teacher opslaan
        teacherService.addTeacher(hilal);
        System.out.println("teacher toegevoegd: " + hilal.getFirstName());






    }
}
