package co.com.ias.ejercicioCA.domain.model.gateway;

import co.com.ias.ejercicioCA.domain.model.course.Course;
import co.com.ias.ejercicioCA.domain.model.student.Student;

public interface IStudentRepository {
    Student saveStudent(Student student, Course course);
}
