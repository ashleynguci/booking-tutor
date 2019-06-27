package fi.haagahelia.codingLesson.web;

import java.util.List;
import java.util.Optional;

import fi.haagahelia.codingLesson.domain.LanguageEntity;
import fi.haagahelia.codingLesson.domain.LessonEntity;
import fi.haagahelia.codingLesson.domain.TutorEntity;
import fi.haagahelia.codingLesson.repo.LanguageRepository;
import fi.haagahelia.codingLesson.repo.LessonRepository;
import fi.haagahelia.codingLesson.repo.TutorRepository;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller

public class WebController {
	@Autowired
	private TutorRepository tutorRepository;
	@Autowired
	private LanguageRepository langRepository;
	@Autowired
	private LessonRepository lessonRepository;

	/**
	 * This endpoint: /languguages
	 * 
	 * @return a Rest API Json file with all the languages in database
	 */
	@RequestMapping(value = "/languages", method = RequestMethod.GET)
	public @ResponseBody List<LanguageEntity> langListRest() {
		return (List<LanguageEntity>) langRepository.findAll();
	}

	/**
	 * This endpoint
	 * 
	 * @param Id
	 * @return a Rest API Json file of language with a specific Id
	 */
	@RequestMapping(value = "/language/{id}", method = RequestMethod.GET)
	public @ResponseBody Optional<LanguageEntity> findLangRest(@PathVariable("id") Long Id) {
		return langRepository.findById(Id);
	}

	/**
	 * A customer Login page
	 * 
	 * @return
	 */
	@RequestMapping(value = "/login")
	public String login() {
		return "login";
	}

	/**
	 * This endpoint
	 * 
	 * @return a Rest API Json file of all the lessons in database
	 */
	@RequestMapping(value = "/lessons", method = RequestMethod.GET)
	public @ResponseBody List<LessonEntity> lessonListRest() {
		return (List<LessonEntity>) lessonRepository.findAll();
	}

	/**
	 * This endpoint with
	 * @param Id
	 * @return a Rest API Json file of lesson with a specific Id
	 */
	@RequestMapping(value = "/lesson/{id}", method = RequestMethod.GET)
	public @ResponseBody Optional<LessonEntity> findLessonRest(@PathVariable("id") Long Id) {
		return lessonRepository.findById(Id);
	}

	/**
	 * This endpoint
	 * 
	 * @return a Rest API Json file with all the tutors
	 */
	@RequestMapping(value = "/tutors", method = RequestMethod.GET)
	public @ResponseBody List<TutorEntity> tutorListRest() {
		return (List<TutorEntity>) tutorRepository.findAll();
	}

	/**
	 * This endpoint with
	 * @param Id
	 * @return a Rest API Json file of the tutor with a specific Id
	 */
	@RequestMapping(value = "/tutor/{id}", method = RequestMethod.GET)
	public @ResponseBody Optional<TutorEntity> findTutorRest(@PathVariable("id") Long Id) {
		return tutorRepository.findById(Id);
	}

	/**
	 * This is a homepage after succesfully log in
	 * @param model
	 * @return the html page list of all tutors
	 */
	@RequestMapping(value = "/tutorlist")
	public String tutorList(Model model) {
		model.addAttribute("tutors", tutorRepository.findAll());
		return "tutorlist";

	}

	@RequestMapping(value = "/schedule/{id}")
	public String schedule(@PathVariable("id") Long tutorId, Model model) {
		model.addAttribute("tutors", tutorRepository.findById(tutorId).get());

		return "schedule";

	}

	/**
	 * A form to book tutor
	 * 
	 * @param model
	 * @return
	 */
	@RequestMapping(value = "/booktutor")
	public String bookTutor(Model model) {
		model.addAttribute("lesson", new LessonEntity());
		model.addAttribute("language", langRepository.findAll());
		model.addAttribute("tutors", tutorRepository.findAll());

		return "booktutor";
	}

	/**
	 * Only admin has authorized to access
	 * 
	 * @param model
	 * @return Admin page
	 */
	@RequestMapping(value = "/lessonlist")
	public String lessonList(Model model) {
		model.addAttribute("lessons", lessonRepository.findAll());
		return "lessonlist";

	}

	/**
	 * edit html page for a specific lesson Id
	 * 
	 * @param lessonId
	 * @param model
	 * @return a form to edit
	 */
	@RequestMapping(value = "/edit/{id}")
	public String edit(@PathVariable("id") Long lessonId, Model model) {
		model.addAttribute("lesson", lessonRepository.findById(lessonId).get());
		model.addAttribute("languages", langRepository.findAll());
		model.addAttribute("tutors", tutorRepository.findAll());

		return "editlesson";

	}

	@RequestMapping(value = "/save", method = RequestMethod.POST)
	public String save(LessonEntity lesson) {
		lessonRepository.save(lesson);

		return "redirect:tutorlist";
	}

}
