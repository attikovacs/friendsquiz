package com.attikovacs.friendsquiz.model;

public class Actor {

	private String name;
	
	private String role;
	
	private Gender gender;

//	public Actor(String name, String role, Gender gender) {
//		this.name = name;
//		this.role = role;
//		this.gender = gender;
//	}
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	public Gender getGender() {
		return gender;
	}

	public void setGender(Gender gender) {
		this.gender = gender;
	}
	
	@Override
	public String toString() {
		return this.name + " " + this.role + " " + this.gender;
	}
}