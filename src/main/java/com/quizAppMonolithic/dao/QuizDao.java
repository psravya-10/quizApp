package com.quizAppMonolithic.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.quizAppMonolithic.model.Quiz;

public interface QuizDao extends JpaRepository<Quiz, Integer> {

}
