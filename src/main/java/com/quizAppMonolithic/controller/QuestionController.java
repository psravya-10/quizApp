package com.quizAppMonolithic.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.quizAppMonolithic.model.Question;
import com.quizAppMonolithic.service.QuestionService;


@RestController //to accept req
@RequestMapping("question") //path
public class QuestionController {
	
	@Autowired //for dep injection 
	QuestionService questionService; //creating the refernce
	
	@GetMapping("allQuestions") //to map
	public List<Question> getAllQuestions() {
//		return "these are your questions";
		return questionService.getAllQuestions();
		
	}
	
	@GetMapping("category/{cat}")  //to catch teh path we use path var , and it stores in categort
	public List<Question> getQuestionByCategory(@PathVariable("cat") String  category){
		return questionService.getQuestionsByCategory(category); //fetching from service	
		
	}
	
	
	@PostMapping("add")
	public String addQuestion(@RequestBody Question question) {
		
		return questionService.addQuestion(question);
		
	}

}
