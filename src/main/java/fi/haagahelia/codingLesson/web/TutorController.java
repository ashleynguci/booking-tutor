package fi.haagahelia.codingLesson.web;

import java.util.List;
import java.util.Optional;

import fi.haagahelia.codingLesson.domain.TutorEntity;

import fi.haagahelia.codingLesson.repo.TutorRepository;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Controller;

import org.springframework.web.bind.annotation.PathVariable;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;



@Controller


public class TutorController {
    
    @Autowired
    private TutorRepository tutorRepository;
    

     //RESTful service to get all book
    @RequestMapping(value ="/tutors", method = RequestMethod.GET)
    public @ResponseBody List<TutorEntity> tutorListRest(){
        return (List<TutorEntity>) tutorRepository.findAll();
    }
    @RequestMapping(value="/tutor/{id}", method = RequestMethod.GET)
    public @ResponseBody Optional<TutorEntity> findTutorRest(@PathVariable("id") Long Id) {	
   	return tutorRepository.findById(Id);
    }  
}  