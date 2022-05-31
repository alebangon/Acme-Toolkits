
package acme.features.patron.chimpum;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import acme.entities.Chimpum;
import acme.framework.controllers.AbstractController;
import acme.roles.Patron;

@Controller
public class PatronChimpumController extends AbstractController<Patron, Chimpum> {

	@Autowired
	protected PatronChimpumShowService showService;

	@Autowired
	protected PatronChimpumListService listService;
	
	@Autowired
	protected PatronChimpumCreateService createService;
	
	@Autowired
	protected PatronChimpumUpdateService updateService;
	@Autowired
	protected PatronChimpumDeleteService deleteService;
	
	@PostConstruct
	protected void initialise() {
		super.addCommand("show", this.showService);
		super.addCommand("list", this.listService);
		super.addCommand("create", this.createService); 
		super.addCommand("update", this.updateService);
		super.addCommand("delete", this.deleteService); 
	}
	
	

}
