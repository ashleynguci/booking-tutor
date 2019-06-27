package fi.haagahelia.codingLesson;

import static org.assertj.core.api.Assertions.assertThat;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;

import fi.haagahelia.codingLesson.domain.LanguageEntity;
import fi.haagahelia.codingLesson.repo.LanguageRepository;


@RunWith(SpringRunner.class)
@DataJpaTest
public class LanguageRepositoryTests {

    @Autowired
    private LanguageRepository langRepository;

    @Test
    public void findByNameShouldReturnLanguage() {
        
        List<LanguageEntity> language = langRepository.findByName("C#");
        assertThat(language).hasSize(1);
        assertThat(language.get(0).getId()).isNotNull();
    }
    
    @Test
    public void deleteLanguage() {
		List<LanguageEntity> lang = langRepository.findByName("React");
		assertThat(lang).hasSize(1);
    	langRepository.deleteById((long) 7);
    	lang = langRepository.findByName("React");
    	assertThat(lang).hasSize(0);
    }
  
}