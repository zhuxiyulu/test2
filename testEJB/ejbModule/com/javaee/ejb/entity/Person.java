package com.javaee.ejb.entity;

import java.io.Serializable;

import javax.persistence.*;

@Entity
@Table(name ="person")
@NamedQuery(name= "findAllPerson", query = "select s from Person s")
public class Person implements Serializable{
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int personId;
	private String name;
	
	public Person(String name) {
		this.name = name;
	}

	public Person() {
		// super();
		// TODO Auto-generated constructor stub
	}

	public int getSno() {
		return personId;
	}

	public void setSno(int personId) {
		this.personId = personId;
	}

	public String getSname() {
		return this.name;
	}

	public void setSname(String sname) {
		this.name = sname;
	}
	
}
