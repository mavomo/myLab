package com.tutos.cm.business.api;

import java.util.List;

import com.tutorials.cm.entities.Closet;

public interface ClosetFacade {

	public abstract void save(Closet closet);

	public abstract void update(Closet closet);
	
	public abstract void delete(Closet closet);

	public abstract Closet find(int entityId);

	public abstract List<Closet> findAll();
}
