package fi.haagahelia.codingLesson.web;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import fi.haagahelia.codingLesson.domain.LessonEntity;
import fi.haagahelia.codingLesson.repo.LanguageRepository;
import fi.haagahelia.codingLesson.repo.LessonRepository;
import fi.haagahelia.codingLesson.repo.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
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


@RestController
@RequestMapping("/api")

public class LessonController {
    @Autowired
    private LessonRepository lessonRepository;
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private LanguageRepository langRepository;

     //RESTful service to get all book
//    @RequestMapping(value ="/lessons", method = RequestMethod.GET)
//    public @ResponseBody List<LessonEntity> lessonListRest(){
//        return (List<LessonEntity>) lessonRepository.findAll();
//    }
    
    @GetMapping("/lessons")
    public List<LessonEntity> getAllLessons() {
    	return (List<LessonEntity>) lessonRepository.findAll();
    }
    
    @PostMapping("/lessons")
    public LessonEntity createLesson(@Valid @RequestBody LessonEntity lesson) {
        return lessonRepository.save(lesson);
    }
}
