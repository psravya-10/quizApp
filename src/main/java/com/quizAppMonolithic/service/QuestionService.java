package com.quizAppMonolithic.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.quizAppMonolithic.dao.QuestionDao;
import com.quizAppMonolithic.model.Question;

@Service
public class QuestionService {
	@Autowired
	QuestionDao questionDao;

//	public List<Question> getAllQuestions() {
//		
//		return questionDao.findAll();
//	}
	public ResponseEntity<List<Question>> getAllQuestions() { // to handle the exceptions also
			try {
			return new  ResponseEntity<>(questionDao.findAll(),HttpStatus.OK); // changed to response entity to return more than one parameter, like teh status also
		}catch(Exception e) {
			e.printStackTrace();
			
		}
			return new  ResponseEntity<>(new ArrayList<>(),HttpStatus.BAD_REQUEST); // this will exeicute is teh above condition not done , return empty array and bad req
	}
	
	
	
	

	public ResponseEntity<List<Question>> getQuestionsByCategory(String category) {
		try {
		 return new ResponseEntity<>(questionDao.findByCategory(category),HttpStatus.OK);
	}catch(Exception e) {
		e.printStackTrace();
	}
		return new  ResponseEntity<>(new ArrayList<>(),HttpStatus.BAD_REQUEST);
	}

	
	
	public ResponseEntity<String> addQuestion(Question question) {
		questionDao.save(question);
		return new ResponseEntity<>("success",HttpStatus.CREATED);
	}

}
