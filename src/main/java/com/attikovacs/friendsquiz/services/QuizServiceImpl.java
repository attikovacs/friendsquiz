package com.attikovacs.friendsquiz.services;

import org.springframework.stereotype.Service;

import com.attikovacs.friendsquiz.data.FriendsActors;
import com.attikovacs.friendsquiz.model.Question;

@Service
public class QuizServiceImpl implements QuizService {

	private FriendsActors fa;

	public QuizServiceImpl(FriendsActors fa) {
		this.fa = fa;
	}

	@Override
	public Question getQuestion() {
		return fa.getRandomQuestion();
	}

}