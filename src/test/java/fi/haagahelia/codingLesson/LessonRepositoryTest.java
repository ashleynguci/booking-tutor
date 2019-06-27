package fi.haagahelia.codingLesson;

import static org.assertj.core.api.Assertions.assertThat;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;

import fi.haagahelia.codingLesson.domain.TutorEntity;
import fi.haagahelia.codingLesson.domain.LessonEntity;
import fi.haagahelia.codingLesson.domain.LanguageEntity;
import fi.haagahelia.codingLesson.repo.LessonRepository;

@RunWith(SpringRunner.class)
@DataJpaTest
public class LessonRepositoryTest {

    @Autowired
    private LessonRepository repository;

    @Test
    public void findByIdShouldReturnLesson() {
        List<LessonEntity> lessons = repository.findById(1);

        assertThat(lessons).hasSize(1);
        assertThat(lessons.get(0).getTutor()).isEqualTo("Vesa Huotarinen");
    }

    @Test
    public void createNewLesson() throws ParseException {
    	SimpleDateFormat format=new SimpleDateFormat("yyyy-MM-dd"); 
    	LessonEntity lesson = new LessonEntity(format.parse("2019-06-16"),"15:00","18:00", "Arentikuja 1D304", 4, new LanguageEntity("C#"), new TutorEntity("Katie Nguyen","Third year IT student at Aalto Univeristy"),true);

    	repository.save(lesson);
    	assertThat(lesson.getId()).isNotNull();
    }    

}
