package fi.haagahelia.codingLesson.repo;

import fi.haagahelia.codingLesson.domain.LessonEntity;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;


    public interface LessonRepository extends JpaRepository<LessonEntity, Long> {

		List<LessonEntity> findById(int id);
    	
    	

    }

    
    