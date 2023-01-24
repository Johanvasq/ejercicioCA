package co.com.ias.ejercicioCA.infrastructure.adapters.jpa.student;

import co.com.ias.ejercicioCA.domain.model.gateway.IStudentRepository;
import co.com.ias.ejercicioCA.domain.model.student.Student;
import co.com.ias.ejercicioCA.infrastructure.adapters.jpa.student.entity.StudentDBO;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Repository;

@Repository
@AllArgsConstructor
public class StudentAdapterRepository implements IStudentRepository {
    private final IStudentAdapterRepository iStudentAdapterRepository;
    @Override
    public Student saveStudent(Student student) {
        StudentDBO studentDBO = new StudentDBO().fromDomain(student);
        return studentDBO.toDomain(iStudentAdapterRepository.save(studentDBO));
    }
}
