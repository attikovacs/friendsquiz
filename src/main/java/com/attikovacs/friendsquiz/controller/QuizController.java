package com.attikovacs.friendsquiz.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.attikovacs.friendsquiz.model.Question;
import com.attikovacs.friendsquiz.services.QuizService;

@Controller
public class QuizController {

	private final Logger logger = LoggerFactory.getLogger(this.getClass());
	
	private QuizService quizService;

	public QuizController(QuizService quizService) {
		this.quizService = quizService;
	}
	
	@RequestMapping(value = {"", "/"})
	public String getQuestion(Model model) {
		Question question = quizService.getQuestion();
		model.addAttribute("question", question);
		logger.info(question.getQuestion() + " - " + question.getAnswers().toString() + " - correct answer: " + question.getCorrectIndex());
		return "friendsquiz";
	}
	
}
