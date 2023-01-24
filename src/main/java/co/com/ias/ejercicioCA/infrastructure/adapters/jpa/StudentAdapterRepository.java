package co.com.ias.ejercicioCA.infrastructure.adapters.jpa;

import co.com.ias.ejercicioCA.domain.model.gateway.IStudentRepository;
import co.com.ias.ejercicioCA.domain.model.student.Student;
import co.com.ias.ejercicioCA.infrastructure.adapters.jpa.entity.StudentDBO;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Repository;

@Repository
@AllArgsConstructor
public class StudentAdapterRepository implements IStudentRepository {
    private final IStudentAdapterRepository iStudentAdapterRepository;
    @Override
    public Student saveStudent(Student student) {
        StudentDBO studentDBO = StudentDBO.studentDBOfromDomain(student);
        StudentDBO savedStudent = iStudentAdapterRepository.save(studentDBO);
        Student studentConverted = savedStudent.studentDBOtoDomain(savedStudent);
        return studentConverted;
    }
}
