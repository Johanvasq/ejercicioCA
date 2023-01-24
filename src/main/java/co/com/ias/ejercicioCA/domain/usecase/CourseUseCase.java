package co.com.ias.ejercicioCA.domain.usecase;

import co.com.ias.ejercicioCA.domain.model.course.dto.CourseDTO;
import co.com.ias.ejercicioCA.domain.model.gateway.ICourseRepository;

public class CourseUseCase {

    private final ICourseRepository iCourserepository;

    public CourseUseCase(ICourseRepository iCourserepository) {
        this.iCourserepository = iCourserepository;
    }

    public CourseDTO saveCourse(CourseDTO courseDTO){
        return courseDTO.fromDomain(iCourserepository.saveCourse(courseDTO.toDomain(courseDTO)));
    }

    public CourseDTO findById(Long id){
        CourseDTO courseDTO = new CourseDTO().fromDomain(iCourserepository.findById(id));
        return courseDTO;
    }
}
