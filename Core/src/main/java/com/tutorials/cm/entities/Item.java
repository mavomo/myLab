package com.tutorials.cm.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="items")
public class Item {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int Id;

	private String color;
	private int importance;
	private boolean isClean;
	private boolean isProfessional;
	
	public int getId() {
		return Id;
	}
	public void setId(int id) {
		Id = id;
	}
	public String getColor() {
		return color;
	}
	public void setColor(String color) {
		this.color = color;
	}
	public int getImportance() {
		return importance;
	}
	public void setImportance(int importance) {
		this.importance = importance;
	}
	public boolean isClean() {
		return isClean;
	}
	public void setClean(boolean isClean) {
		this.isClean = isClean;
	}
	public boolean isProfessional() {
		return isProfessional;
	}
	public void setProfessional(boolean isProfessional) {
		this.isProfessional = isProfessional;
	}
		
}
