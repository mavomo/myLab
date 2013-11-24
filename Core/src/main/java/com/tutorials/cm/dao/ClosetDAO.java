package com.tutorials.cm.dao;

import javax.ejb.Stateless;

import com.tutorials.cm.dao.generic.GenericDAO;
import com.tutorials.cm.entities.Closet;

@Stateless
public class ClosetDAO extends GenericDAO<Closet> {
	
	public ClosetDAO() {
		super(Closet.class);
	}
	
}
