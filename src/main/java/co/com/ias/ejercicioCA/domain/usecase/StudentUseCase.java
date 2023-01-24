package co.com.ias.ejercicioCA.domain.usecase;

import co.com.ias.ejercicioCA.domain.model.course.Course;
import co.com.ias.ejercicioCA.domain.model.course.dto.CourseDTO;
import co.com.ias.ejercicioCA.domain.model.gateway.IStudentRepository;
import co.com.ias.ejercicioCA.domain.model.student.Student;
import co.com.ias.ejercicioCA.domain.model.student.dto.StudentDTO;

import java.util.Optional;


public class StudentUseCase {
    private final IStudentRepository iStudentRepository;
    private final CourseUseCase courseUseCase;

    public StudentUseCase(IStudentRepository iStudentRepository, CourseUseCase courseUseCase) {
        this.iStudentRepository = iStudentRepository;
        this.courseUseCase = courseUseCase;
    }

    public StudentDTO saveStudent(StudentDTO studentDTO) {
        Optional<CourseDTO> courseDTO = Optional
                .ofNullable(courseUseCase.findById(studentDTO.getCourseId()));
        if (courseDTO.isPresent()){
            Student student = studentDTO.toDomain(studentDTO);
            Course course = courseDTO.get().toDomain(courseDTO.get());
            return studentDTO.fromDomain(iStudentRepository.saveStudent(student, course));
        }
        return null;



    }
}
