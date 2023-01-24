package co.com.ias.ejercicioCA.infrastructure.adapters.jpa.student;

import co.com.ias.ejercicioCA.infrastructure.adapters.jpa.student.entity.StudentDBO;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IStudentAdapterRepository extends JpaRepository<StudentDBO, Long> {

}
