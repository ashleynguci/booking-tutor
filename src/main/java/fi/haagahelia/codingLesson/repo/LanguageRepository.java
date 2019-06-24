package fi.haagahelia.codingLesson.repo;

import fi.haagahelia.codingLesson.domain.LanguageEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;


public interface LanguageRepository extends JpaRepository<LanguageEntity, Long> {

    List<LanguageEntity> findByName(String name);
}
