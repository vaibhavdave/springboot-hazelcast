package com.spring.boot.hazelcast.api.model;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;


@Entity
public class Employee implements Serializable{
	
	public Employee() {
		
	}
	/**
	 * 
	 */
	private static final long serialVersionUID = -3117335093664557260L;
	@Id
    @GeneratedValue(strategy = GenerationType.AUTO,generator = "empId")
	private int id;
	private String name;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	private int age;
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}

}
