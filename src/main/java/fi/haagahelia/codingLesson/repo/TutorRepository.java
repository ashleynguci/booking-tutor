package fi.haagahelia.codingLesson.repo;

import fi.haagahelia.codingLesson.domain.TutorEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;


public interface TutorRepository extends JpaRepository<TutorEntity, Long> {
    List<TutorEntity> findByName(String name);
}
