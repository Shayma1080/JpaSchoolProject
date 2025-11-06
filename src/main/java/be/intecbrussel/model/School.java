package be.intecbrussel.model;
import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "School")
public class School {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="school_id")
    private Long schoolId;
    @Column(name = "school_name")
    private String schoolName;
    @Column(name= "school_city")
    private String schoolCity;


    @OneToMany(mappedBy = "school")
    private List<Student> students;
    @OneToMany(mappedBy = "school")
    private List<Teacher> teachers;


    public School(String schoolName, String schoolCity, List<Teacher> teachers, List<Student> students) {
        this.schoolName = schoolName;
        this.schoolCity = schoolCity;
        this.teachers = teachers;
        this.students = students;
    }

    public School(String schoolName, String schoolCity) {
        this.schoolName = schoolName;
        this.schoolCity = schoolCity;
    }

    public School() {}

    public Long getSchoolId() {
        return schoolId;
    }

    public void setSchoolId(Long schoolId) {
        this.schoolId = schoolId;
    }

    public String getSchoolName() {
        return schoolName;
    }

    public void setSchoolName(String schoolName) {
        this.schoolName = schoolName;
    }

    public String getSchoolCity() {
        return schoolCity;
    }

    public void setSchoolCity(String schoolCity) {
        this.schoolCity = schoolCity;
    }

    public List<Teacher> getTeachers() {
        return teachers;
    }

    public void setTeachers(List<Teacher> teachers) {
        this.teachers = teachers;
    }

    public List<Student> getStudents() {
        return students;
    }

    public void setStudents(List<Student> students) {
        this.students = students;
    }

    public void updatSchool(School updateSchool) {
        this.schoolName = updateSchool.schoolName;
    }

    @Override
    public String toString() {
        return "School{" +
                "schoolId=" + schoolId +
                ", schoolName='" + schoolName + '\'' +
                ", schoolCity='" + schoolCity + '\'' +
                ", teachers=" + teachers +
                ", students=" + students +
                '}';
    }
}
