package acme.features.inventor.patronage;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import acme.entities.Patronage;
import acme.framework.controllers.AbstractController;
import acme.roles.Inventor; 
 
@Controller 
public class InventorPatronageController extends AbstractController<Inventor, Patronage> { 
	//Internal State 
	 
	@Autowired 
	protected InventorPatronageListService listRecentService; 
	@Autowired 
	protected InventorPatronageShowService showService; 
	 
	 
	//Constructors 
	@PostConstruct 
	protected void initialise() { 
		super.addCommand("show", this.showService); 
		super.addCommand("list", this.listRecentService); 
	} 
 
} 
