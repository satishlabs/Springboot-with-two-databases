package com.satish.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Setter
@Getter
@ToString
@Entity
@Table(name = "user")
public class User {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int uid;
	private String name;
	private String emaild;
	private String gender;
	
	public User(String name, String emaild, String gender) {
		super();
		this.name = name;
		this.emaild = emaild;
		this.gender = gender;
	}
}
