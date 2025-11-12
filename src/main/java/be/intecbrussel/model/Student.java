package be.intecbrussel.model;

import be.intecbrussel.config.JpaConfig;
import jakarta.persistence.*;
import java.util.List;

@Entity
@Table(name = "Student")
public class Student { // The owner
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="student_id")
    private Long id;
    @Column(name = "firstName")
    private String firstName;
    @Column(name = "lastName")
    private String lastName;


    @ManyToOne(cascade = {CascadeType.PERSIST, CascadeType.REMOVE,CascadeType.MERGE})
    @JoinColumn(name = "school_id") // foreign key
    private School school;

    @ManyToMany
    @JoinTable(name = "student_teacher", joinColumns = @JoinColumn(name = "student_id"), inverseJoinColumns = @JoinColumn(name = "teacher_id"))
    private List<Teacher> teachers;


    public Student(String firstName, String lastName, School school, List<Teacher> teachers) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.school = school;
        this.teachers = teachers;
    }

    public Student(String firstName, String lastName, School school) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.school = school;
    }

    public Student() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public School getSchool() {
        return school;
    }

    public void setSchool(School school) {
        this.school = school;
    }

    public List<Teacher> getTeachers() {
        return teachers;
    }

    public void setTeachers(List<Teacher> teachers) {
        this.teachers = teachers;
    }

    public void updateStudent(Student updateStudent) {
        this.firstName = updateStudent.firstName;
    }

    @Override
    public String toString() {
        return "Student{" +
                "id='" + id + '\'' +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", school=" + school +
                ", teachers=" + teachers +
                '}';
    }
}
