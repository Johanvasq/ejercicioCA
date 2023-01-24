package co.com.ias.ejercicioCA.infrastructure.entrypoint;


import co.com.ias.ejercicioCA.domain.model.course.dto.CourseDTO;
import co.com.ias.ejercicioCA.domain.usecase.CourseUseCase;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/course")
@AllArgsConstructor
public class CourseEntryRepository {

    private final CourseUseCase courseUseCase;

    @PostMapping
    public ResponseEntity<?> saveCourse(@RequestBody CourseDTO courseDTO){
        return ResponseEntity.ok().body(courseUseCase.saveCourse(courseDTO));
    }
}
