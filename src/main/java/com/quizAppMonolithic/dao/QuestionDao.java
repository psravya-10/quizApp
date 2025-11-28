package com.quizAppMonolithic.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.quizAppMonolithic.model.Question;

@Repository
public interface QuestionDao extends JpaRepository<Question, Integer>  {
   List<Question> findByCategory(String category); // jpa will understnad and will fetch teh data based on category

  //to give a value we use :
   @Query(value="SELECT * FROM question q WHERE q.category=:category ORDER BY RAND() LIMIT :numQ", nativeQuery=true)
   List<Question> findRandomQuestionsByCategory(String category, int numQ);

   
}
