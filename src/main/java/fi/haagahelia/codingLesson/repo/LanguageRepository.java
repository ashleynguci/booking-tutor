package fi.haagahelia.codingLesson.repo;

import fi.haagahelia.codingLesson.domain.LanguageEntity;
import org.springframework.data.repository.CrudRepository;

import java.util.List;


public interface LanguageRepository extends CrudRepository<LanguageEntity, Long> {

    List<LanguageEntity> findByName(String name);
}
