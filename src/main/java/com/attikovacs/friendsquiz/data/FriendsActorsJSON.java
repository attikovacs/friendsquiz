package com.attikovacs.friendsquiz.data;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.stereotype.Component;

import com.attikovacs.friendsquiz.model.Actor;
import com.attikovacs.friendsquiz.model.Question;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

@Component
public class FriendsActorsJSON {

	private final int ANSWERS = 4;
	
	private final int MAXTRIES = 100;
	
	private List<Actor> actors;
	
    public FriendsActorsJSON() {
    	actors = new ArrayList<>();
		try {
			ObjectMapper jsonMapper = new ObjectMapper();
			Resource resource = new ClassPathResource("actors.json");
			InputStream resourceInputStream = resource.getInputStream();
			actors = jsonMapper.readValue(resourceInputStream, new TypeReference<List<Actor>>() {});
		} catch (IOException e) {
			e.printStackTrace();
		}
    }

    public Question getRandomQuestion(){
        
        //Random generator = new Random();
        //Object[] values = actors.values().toArray();
        //String randomValue = (String) values[generator.nextInt(values.length)];
    	//String randomValue = (String) values[ThreadLocalRandom.current().nextInt(0, actors.size() - 1)];

    	Question question = new Question();
    	int questionId = ThreadLocalRandom.current().nextInt(0, actors.size());
    	Actor actor = actors.get(questionId);
    	String questionKey = actor.getName();
    	List<String> answers = new ArrayList<>();
    	int wrongAnswerId;
    	String wrongAnswer = "";
    	int counter = 0;
    	for (int i = 0; i < ANSWERS - 1; i++) {
    		while (counter++ < MAXTRIES 
    				&& (questionId == (wrongAnswerId = ThreadLocalRandom.current().nextInt(0, actors.size())) 
    				|| !actor.getGender().equals(actors.get(wrongAnswerId).getGender())
    				|| answers.contains((wrongAnswer = actors.get(wrongAnswerId).getName())))) {}
    		answers.add(wrongAnswer);
    	}
    	int correctIndex = ThreadLocalRandom.current().nextInt(0, ANSWERS);
        answers.add(correctIndex, questionKey);
        question.setQuestion(actor.getRole());
        question.setAnswers(answers);
        question.setCorrectIndex(correctIndex);

        return question;
    }
	
}