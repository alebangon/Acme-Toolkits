
package acme.features.inventor.item;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import acme.entities.Item;
import acme.framework.controllers.AbstractController;
import acme.roles.Inventor;

@Controller
public class InventorItemController extends AbstractController<Inventor, Item> {
	// Internal state ---------------------------------------------------------

	@Autowired
	protected InventorToolListService		toolListService;

	@Autowired
	protected InventorComponentListService	componentListService;

	@Autowired
	protected InventorItemShowService	itemShowService;


	@PostConstruct
	protected void initialise() {
		super.addCommand("listTools", "list", this.toolListService);
		super.addCommand("listComponents", "list", this.componentListService);
		super.addCommand("show", this.itemShowService);
	}
}
