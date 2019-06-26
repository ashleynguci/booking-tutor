package fi.haagahelia.codingLesson;

import fi.haagahelia.codingLesson.domain.LanguageEntity;
import fi.haagahelia.codingLesson.domain.LessonEntity;
import fi.haagahelia.codingLesson.domain.TutorEntity;
import fi.haagahelia.codingLesson.domain.User;
import fi.haagahelia.codingLesson.repo.LanguageRepository;
import fi.haagahelia.codingLesson.repo.LessonRepository;
import fi.haagahelia.codingLesson.repo.TutorRepository;
import fi.haagahelia.codingLesson.repo.UserRepository;

import java.text.SimpleDateFormat;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;





@SpringBootApplication
public class CodingLessonApplication {

	public static void main(String[] args) {
		SpringApplication.run(CodingLessonApplication.class, args);
	}

	@Bean
	public CommandLineRunner demo(LessonRepository lessonRepository, LanguageRepository langRepository , TutorRepository tutorRepository, UserRepository userRepository) {
	return (args) -> {

		SimpleDateFormat format=new SimpleDateFormat("dd/MM/yyyy");  
		langRepository.save( new LanguageEntity("Java"));
		langRepository.save( new LanguageEntity("C#"));
		langRepository.save( new LanguageEntity("Javascript"));
		langRepository.save( new LanguageEntity("Scala"));
		langRepository.save( new LanguageEntity("Python"));
		langRepository.save( new LanguageEntity("HTML"));
		langRepository.save( new LanguageEntity("React"));
		langRepository.save( new LanguageEntity("Spring Boot"));

			tutorRepository.save( new TutorEntity("Katie Nguyen","Third year IT student at Aalto Univeristy"));
			tutorRepository.save( new TutorEntity("Vesa Huotarinen","Frontend Trainee at Reaktor"));
			tutorRepository.save( new TutorEntity("Felix Bloch","Second year BIT student at Haaga-Helia UAS"));
			tutorRepository.save( new TutorEntity("Carlos Sunila","Backend Junior at Futurice"));
			tutorRepository.save( new TutorEntity("Markus Leppa","Software engineer tutor at University of Helsinki"));

		lessonRepository.save( new LessonEntity(format.parse("12/06/2019"),"15:00","18:00", "Arentikuja 1D304", 4, langRepository.findByName("Javascript").get(0), tutorRepository.findByName("Vesa Huotarinen").get(0),true));
		lessonRepository.save( new LessonEntity(format.parse("16/06/2019"),"09:00","13:00", "Hamenkatu 10A", 5, langRepository.findByName("C#").get(0), tutorRepository.findByName("Katie Nguyen").get(0),true));
		lessonRepository.save( new LessonEntity(format.parse("15/06/2019"),"19:00","21:30", "Aurakatu 123", 3, langRepository.findByName("React").get(0), tutorRepository.findByName("Carlos Sunila").get(0),true));
		lessonRepository.save( new LessonEntity(format.parse("22/06/2019"),"14:00","16:00", "Yo kyla  5D7", 4, langRepository.findByName("Javascript").get(0), tutorRepository.findByName("Carlos Sunila").get(0),true));

		userRepository.save(new User("user", "$2a$10$iaA5jcbqZbs5Qfz4eC1GR.djm6ug32hghD0oRxY5EasJgqQkgCk4O", "USER"));
		userRepository.save(new User("admin", "$2a$10$OPO.1kKxqwU7m8aCkBlm5OYWGbRx2ol9k6N382WJP6UsjFsGlJZq2", "ADMIN"));
		

	};
	}
}
