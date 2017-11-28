package com.attikovacs.friendsquiz.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.attikovacs.friendsquiz.services.QuizService;

@Controller
public class QuizController {

	private QuizService quizService;

	public QuizController(QuizService quizService) {
		this.quizService = quizService;
	}
	
	@RequestMapping(value = {"", "/"})
	public String getJokes(Model model) {
		model.addAttribute("question", quizService.getQuestion());
		System.out.println(System.currentTimeMillis() + " new question");
		return "friendsquiz";
	}
	
}
