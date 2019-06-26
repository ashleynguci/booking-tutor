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

	 
     //RESTful service to get all languages
    @RequestMapping(value ="/languages", method = RequestMethod.GET)
    public @ResponseBody List<LanguageEntity> langListRest(){
        return (List<LanguageEntity>) langRepository.findAll();
    }
    
 // RESTful service to get language by id
    @RequestMapping(value="/language/{id}", method = RequestMethod.GET)
    public @ResponseBody Optional<LanguageEntity> findLangRest(@PathVariable("id") Long Id) {	
   	return langRepository.findById(Id);
    }   
    
    

    @RequestMapping(value = "/login")
	public String login() {
		return "login";
	}
	
     //RESTful service to get all lesson
    @RequestMapping(value ="/lessons", method = RequestMethod.GET)
    public @ResponseBody List<LessonEntity> lessonListRest(){
        return (List<LessonEntity>) lessonRepository.findAll();
    }
    
 // RESTful service to get lesson by id
    @RequestMapping(value="/lesson/{id}", method = RequestMethod.GET)
    public @ResponseBody Optional<LessonEntity> findLessonRest(@PathVariable("id") Long Id) {	
   	return lessonRepository.findById(Id);
    }  
   

     //RESTful service to get all tutors
    @RequestMapping(value ="/tutors", method = RequestMethod.GET)
    public @ResponseBody List<TutorEntity> tutorListRest(){
        return (List<TutorEntity>) tutorRepository.findAll();
    }
    
 // RESTful service to get tutor by id
    @RequestMapping(value="/tutor/{id}", method = RequestMethod.GET)
    public @ResponseBody Optional<TutorEntity> findTutorRest(@PathVariable("id") Long Id) {	
   	return tutorRepository.findById(Id);
    }  
    
    
    @RequestMapping(value = "/tutorlist")
    public String tutorList(Model model) {
		  model.addAttribute("tutors",tutorRepository.findAll());
		  return "tutorlist";
		//return name of template
	}
    
    @RequestMapping(value = "/schedule/{id}")
	public String schedule(@PathVariable("id") Long tutorId, Model model){
	model.addAttribute("tutors", tutorRepository.findById(tutorId).get());
//	model.addAttribute("lessons", lessonRepository.findAll());
	return "schedule";
	
	}

}
