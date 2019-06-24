package fi.haagahelia.codingLesson.repo;

import fi.haagahelia.codingLesson.domain.LessonEntity;
import org.springframework.data.repository.CrudRepository;



    public interface LessonRepository extends CrudRepository<LessonEntity, Long> {

    }
