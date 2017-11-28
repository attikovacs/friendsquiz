package com.attikovacs.friendsquiz.services;

import org.springframework.stereotype.Service;

import com.attikovacs.friendsquiz.data.FriendsActorsJSON;
import com.attikovacs.friendsquiz.model.Question;

@Service
public class QuizServiceImpl implements QuizService {

	private FriendsActorsJSON fa;

	public QuizServiceImpl(FriendsActorsJSON fa) {
		this.fa = fa;
	}

	@Override
	public Question getQuestion() {
		return fa.getRandomQuestion();
	}

}