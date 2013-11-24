package com.tutorials.cm.managedbeans;

import java.io.Serializable;
import java.util.List;

import javax.annotation.ManagedBean;
import javax.ejb.EJB;
import javax.ejb.EJBException;
import javax.enterprise.context.SessionScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;

import com.tutorials.cm.entities.Item;
import com.tutos.cm.business.api.ItemFacade;

@SessionScoped
@ManagedBean
public class ItemManagedBean implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 6903290772625899220L;
	
	private static final String CREATE_ITEM = "createItem";
	private static final String DELETE_ITEM = "deleteItem";
	private static final String UPDATE_ITEM = "updateItem";
	private static final String LIST_ALL_ITEMS = "listAllItems";
	private static final String STAY_IN_THE_SAME_PAGE = null;


	private Item item;
	
	@EJB
	private ItemFacade itemFacade;
	

	public Item getItem() {
		if(item == null)
			item = new Item();
		
		return item;
	}
	
	public List<Item> getListItems(){
	
		return itemFacade.findAll();	
	}
	
	public String updateItemStart() {
		return UPDATE_ITEM;
	}

	public String updateItemEnd() {
		try {
			itemFacade.update(item);
		} catch (EJBException e) {
			sendErrorMessageToUser("Error while updating an item");
			return STAY_IN_THE_SAME_PAGE;
		}

		sendInfoMessageToUser("Operation Complete: Update");
		return LIST_ALL_ITEMS;
	}

	public String deleteItemStart() {
		return DELETE_ITEM;
	}

	public String deleteItemEnd() {
		try {
			itemFacade.delete(item);
		} catch (EJBException e) {
			sendErrorMessageToUser("Error. Call the ADM");
			return STAY_IN_THE_SAME_PAGE;
		}
		sendInfoMessageToUser("Operation Complete: Delete");

		return LIST_ALL_ITEMS;
	}

	public String createItemStart() {
		return CREATE_ITEM;
	}

	public String createItemEnd() {
		try {
			itemFacade.save(item);
		} catch (EJBException e) {
			sendErrorMessageToUser("Error. Check details adm");
			return STAY_IN_THE_SAME_PAGE;
		}
		sendInfoMessageToUser("Operation Complete: Create");

		return LIST_ALL_ITEMS;
	}

	public String listAllItems() {
		return LIST_ALL_ITEMS;
	}

	private void sendInfoMessageToUser(String message) {
		FacesContext context = getContext();
		context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO,
				message, message));
	}

	private void sendErrorMessageToUser(String message) {
		FacesContext context = getContext();
		context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR,
				message, message));
	}

	private FacesContext getContext() {
		FacesContext context = FacesContext.getCurrentInstance();
		return context;
	}
	
	public void setItem(Item item) {
		this.item = item;
	}

	public ItemFacade getItemFacade() {
		return itemFacade;
	}

	public void setItemFacade(ItemFacade itemFacade) {
		this.itemFacade = itemFacade;
	}

	
}
