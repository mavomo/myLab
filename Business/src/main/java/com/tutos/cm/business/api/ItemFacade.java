package com.tutos.cm.business.api;

import java.util.List;

import com.tutorials.cm.entities.Item;

public interface ItemFacade {
	
	public abstract void save(Item item);

	public abstract void update(Item item);

	public abstract Item find(int entityId);
	
	public abstract void delete(Item item);
	
	public abstract List<Item> findAll();
}
