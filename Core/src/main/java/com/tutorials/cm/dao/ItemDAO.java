package com.tutorials.cm.dao;

import javax.ejb.Stateless;

import com.tutorials.cm.dao.generic.GenericDAO;
import com.tutorials.cm.entities.Item;

@Stateless
public class ItemDAO extends GenericDAO<Item>{

	public ItemDAO() {
		super(Item.class);		
	}

}
