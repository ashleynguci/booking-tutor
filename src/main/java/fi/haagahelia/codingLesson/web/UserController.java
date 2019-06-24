package fi.haagahelia.codingLesson.web;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import fi.haagahelia.codingLesson.domain.LanguageEntity;
import fi.haagahelia.codingLesson.domain.UserEntity;
import fi.haagahelia.codingLesson.repo.LanguageRepository;
import fi.haagahelia.codingLesson.repo.LessonRepository;
import fi.haagahelia.codingLesson.repo.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;


@Controller
//@RequestMapping("/api")

public class UserController {
    @Autowired
    private LessonRepository lessonRepository;
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private LanguageRepository langRepository;

     //RESTful service to get all book
    @RequestMapping(value ="/tutors", method = RequestMethod.GET)
    public @ResponseBody List<UserEntity> tutorListRest(){
        return (List<UserEntity>) userRepository.findAll();
    }
    @RequestMapping(value="/tutor/{id}", method = RequestMethod.GET)
    public @ResponseBody Optional<UserEntity> findTutorRest(@PathVariable("id") Long Id) {	
   	return userRepository.findById(Id);
    }  
}  