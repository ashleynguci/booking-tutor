package fi.haagahelia.codingLesson.web;

import java.util.List;
import java.util.Optional;


import fi.haagahelia.codingLesson.domain.LessonEntity;

import fi.haagahelia.codingLesson.repo.LessonRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
//import org.springframework.web.bind.annotation.RestController;



@Controller
public class LessonController {
    @Autowired
    private LessonRepository lessonRepository;


    @RequestMapping(value = "/login")
	public String login() {
		return "login";
	}
	
     //RESTful service to get all book
    @RequestMapping(value ="/lessons", method = RequestMethod.GET)
    public @ResponseBody List<LessonEntity> lessonListRest(){
        return (List<LessonEntity>) lessonRepository.findAll();
    }
    @RequestMapping(value="/lesson/{id}", method = RequestMethod.GET)
    public @ResponseBody Optional<LessonEntity> findLessonRest(@PathVariable("id") Long Id) {	
   	return lessonRepository.findById(Id);
    }  

}
