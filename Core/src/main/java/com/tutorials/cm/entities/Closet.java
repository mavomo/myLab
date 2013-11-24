package com.tutorials.cm.entities;

import java.util.Collection;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="closets")
public class Closet {
	/**
	 * 
	 */
	private static final long serialVersionUID = -3515472572801032398L;
	
	@Id
	private int serialNumber;
	private int height;
	private int width;
	private int depth;
	private boolean isDivided;
	private int numShelves;	
	
	@OneToMany
	private Collection<Item> items;
	
	
	public int getSerialNumber() {
		return serialNumber;
	}
	public void setSerialNumber(int serialNumber) {
		this.serialNumber = serialNumber;
	}
	public int getHeight() {
		return height;
	}
	public void setHeight(int height) {
		this.height = height;
	}
	public int getWidth() {
		return width;
	}
	public void setWidth(int width) {
		this.width = width;
	}
	public int getDepth() {
		return depth;
	}
	public void setDepth(int depth) {
		this.depth = depth;
	}
	
	public boolean isDivided() {
		return isDivided;
	}
	public void setDivided(boolean isDivided) {
		this.isDivided = isDivided;
	
	}
	public int getNumShelves() {
		return numShelves;
	}
	public void setNumShelves(int numShelves) {
		this.numShelves = numShelves;
	}
	
	
	public Collection<Item> getItems() {
		return items;
	}
	public void setItems(Collection<Item> items) {
		this.items = items;
	}

	
}
