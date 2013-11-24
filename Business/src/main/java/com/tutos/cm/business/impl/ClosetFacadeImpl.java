package com.tutos.cm.business.impl;

import java.util.List;

import javax.ejb.EJB;
import javax.ejb.Stateless;

import com.tutorials.cm.dao.ClosetDAO;
import com.tutorials.cm.entities.Closet;
import com.tutos.cm.business.api.ClosetFacade;

@Stateless
public class ClosetFacadeImpl implements ClosetFacade{

	@EJB
	private ClosetDAO closetDao;
	
	public void save(Closet closet) {
		isClosetWithAllData(closet);
		closetDao.save(closet);
	}

	public void update(Closet closet) {
		isClosetWithAllData(closet);
	 closetDao.update(closet);
	}

	public Closet find(int entityId) {
		return closetDao.find(entityId);
	}
	
	public void delete(Closet closet) {
		closetDao.delete(closet);
	}

	public List<Closet> findAll() {
		return closetDao.findAll();
	}

	private void isClosetWithAllData(Closet closet) {

		boolean hasError = false;

		if (closet == null) {
			hasError = true;
		}

		if (closet.getSerialNumber() <= 0) {
			hasError = true;
		}

		if (closet.getNumShelves() <= 0) {
			hasError = true;
		}

		if (hasError) {
			throw new IllegalArgumentException(
					"The closet is missing data. Check the serial number and number of shelves, they should have value");
		}
	}

	
}
