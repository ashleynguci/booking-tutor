package fi.haagahelia.codingLesson.web;

import java.util.List;
import java.util.Optional;



import fi.haagahelia.codingLesson.domain.LanguageEntity;
import fi.haagahelia.codingLesson.repo.LanguageRepository;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Controller;

import org.springframework.web.bind.annotation.PathVariable;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;



@Controller

public class LanguageController {
   
    @Autowired
    private LanguageRepository langRepository;

     //RESTful service to get all book
    @RequestMapping(value ="/languages", method = RequestMethod.GET)
    public @ResponseBody List<LanguageEntity> langListRest(){
        return (List<LanguageEntity>) langRepository.findAll();
    }
    @RequestMapping(value="/language/{id}", method = RequestMethod.GET)
    public @ResponseBody Optional<LanguageEntity> findLangRest(@PathVariable("id") Long Id) {	
   	return langRepository.findById(Id);
    }   
    

}
