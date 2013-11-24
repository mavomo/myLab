package com.tutos.cm.business.impl;

import java.util.List;

import javax.ejb.EJB;
import javax.ejb.Stateless;

import com.tutorials.cm.dao.ItemDAO;
import com.tutorials.cm.entities.Item;
import com.tutos.cm.business.api.ItemFacade;

@Stateless
public class ItemFacadeImpl implements ItemFacade {

	@EJB
	private ItemDAO dao;
	
	public void save(Item item) {
		dao.save(item);
	}

	public void update(Item item) {
		dao.update(item);
		
	}

	public Item find(int entityId) {
		return dao.find(entityId);
	}

	public List<Item> findAll() {
		return dao.findAll();
	}

	public void delete(Item item) {
		dao.delete(item);
	}

}
