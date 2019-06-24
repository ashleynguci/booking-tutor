package fi.haagahelia.codingLesson;

import fi.haagahelia.codingLesson.domain.LanguageEntity;
import fi.haagahelia.codingLesson.domain.LessonEntity;
import fi.haagahelia.codingLesson.domain.UserEntity;
import fi.haagahelia.codingLesson.repo.LanguageRepository;
import fi.haagahelia.codingLesson.repo.LessonRepository;
import fi.haagahelia.codingLesson.repo.UserRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.text.SimpleDateFormat;



@SpringBootApplication
public class CodingLessonApplication {

	public static void main(String[] args) {
		SpringApplication.run(CodingLessonApplication.class, args);
	}

	@Bean
	public CommandLineRunner demo(LessonRepository lessonRepository, LanguageRepository langRepository, UserRepository userRepository) {
	return (args) -> {

			SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm");
			langRepository.save( new LanguageEntity("Java"));
		langRepository.save( new LanguageEntity("C#"));
		langRepository.save( new LanguageEntity("Javascript"));
		langRepository.save( new LanguageEntity("Scala"));
		langRepository.save( new LanguageEntity("Python"));
		langRepository.save( new LanguageEntity("HTML"));
		langRepository.save( new LanguageEntity("React"));
		langRepository.save( new LanguageEntity("Spring Boot"));

			userRepository.save( new UserEntity("Katie Nguyen"));
			userRepository.save( new UserEntity("Vesa Huotarinen"));
			userRepository.save( new UserEntity("Felix Bloch"));
			userRepository.save( new UserEntity("Carlos Sunila"));
			userRepository.save( new UserEntity("Markus Leppa"));


			lessonRepository.save( new LessonEntity(dateFormat.parse("2019-06-20 15:00"),dateFormat.parse("2019-06-20 18:00"), "Arentikuja 1D304", 4, langRepository.findByName("Javascript").get(0), userRepository.findByName("Vesa Huoritanen").get(0)));
			lessonRepository.save( new LessonEntity(dateFormat.parse("2019-06-15 09:00"),dateFormat.parse("2019-06-15 13:00"), "Hamenkatu 10A", 5, langRepository.findByName("C#").get(0), userRepository.findByName("Katie Nguyen").get(0)));
			lessonRepository.save( new LessonEntity(dateFormat.parse("2019-06-21 19:00"),dateFormat.parse("2019-06-21 21:30"), "Aurakatu 123", 3, langRepository.findByName("React").get(0), userRepository.findByName("Carlos Sunila").get(0)));




		};
	}
}
