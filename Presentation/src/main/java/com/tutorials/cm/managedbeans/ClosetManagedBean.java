package com.tutorials.cm.managedbeans;

import java.io.Serializable;
import java.util.List;

import javax.ejb.EJB;
import javax.ejb.EJBException;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;

import com.tutorials.cm.entities.Closet;
import com.tutos.cm.business.api.ClosetFacade;

@ManagedBean
@RequestScoped
public class ClosetManagedBean implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 9010831338014553362L;

	@EJB
	private ClosetFacade closetFacade;
	
	private static final String CREATE_CLOSET = "createCloset";
	private static final String DELETE_CLOSET = "deleteCloset";
	private static final String UPDATE_CLOSET = "updateCloset";
	private static final String LIST_ALL_CLOSETS = "listAllClosets";
	private static final String STAY_IN_THE_SAME_PAGE = null;

	private Closet closet;

	public Closet getCloset() {

		if (closet == null) 
			closet = new Closet();
		return closet;
	}

	public void setCloset(Closet closet) {
		this.closet = closet;
	}

	public List<Closet> getAllClosets() {
		return closetFacade.findAll();
	}

	public String updateClosetStart() {
		return UPDATE_CLOSET;
	}

	public String updateClosetEnd() {
		try {
			closetFacade.update(closet);
		} catch (EJBException e) {
			sendErrorMessageToUser("Error. Check if the weight is above 0 or call the adm");
			return STAY_IN_THE_SAME_PAGE;
		}

		sendInfoMessageToUser("Operation Complete: Update");
		return LIST_ALL_CLOSETS;
	}

	public String deleteClosetStart() {
		return DELETE_CLOSET;
	}

	public String deleteClosetEnd() {
		try {
			closetFacade.delete(closet);
		} catch (EJBException e) {
			sendErrorMessageToUser("Error. Call the ADM");
			return STAY_IN_THE_SAME_PAGE;
		}
		sendInfoMessageToUser("Operation Complete: Delete");

		return LIST_ALL_CLOSETS;
	}

	public String createClosetStart() {
		return CREATE_CLOSET;
	}

	public String createClosetEnd() {
		try {
			closetFacade.save(closet);
		} catch (EJBException e) {
			sendErrorMessageToUser("Error. Check details adm");
			return STAY_IN_THE_SAME_PAGE;
		}
		sendInfoMessageToUser("Operation Complete: Create");

		return LIST_ALL_CLOSETS;
	}

	public String listAllClosets() {
		return LIST_ALL_CLOSETS;
	}

	private void sendInfoMessageToUser(String message) {
		FacesContext context = getContext();
		context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO,
				message, message));
	}

	private void sendErrorMessageToUser(String message) {
		FacesContext context = getContext();
		context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR,message, message));
	}

	private FacesContext getContext() {
		FacesContext context = FacesContext.getCurrentInstance();
		return context;
	}

}
