package co.com.ias.ejercicioCA.domain.usecase;

import co.com.ias.ejercicioCA.domain.model.gateway.IStudentRepository;
import co.com.ias.ejercicioCA.domain.model.student.Student;
import co.com.ias.ejercicioCA.domain.model.student.dto.StudentDTO;


public class StudentUseCase {
    private final IStudentRepository iStudentRepository;

    public StudentUseCase(IStudentRepository iStudentRepository) {
        this.iStudentRepository = iStudentRepository;
    }

    public StudentDTO saveStudent(StudentDTO studentDTO) {
        Student student = studentDTO.studentDTOToDomain(studentDTO);

        return studentDTO.valueObjectToDTO(iStudentRepository.saveStudent(student));
    }
}
