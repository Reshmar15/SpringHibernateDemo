package com.reshma.bean;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "Circle")
public class Circle 
{
	@Id
	@Column(name = "id", unique = true, nullable = false)
	private int id;
	private String name;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	
	@Override
	public String toString() {
		return "Circle [id=" + id + ", name=" + name + "]";
	}
	public Circle(int circleId,String name) {
		setId(circleId);
		setName(name);
		
	}
public Circle() {
		
	}
	
}
