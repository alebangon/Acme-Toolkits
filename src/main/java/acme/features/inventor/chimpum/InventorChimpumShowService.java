package acme.features.inventor.chimpum;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import acme.entities.Chimpum;
import acme.entities.Item;
import acme.framework.components.models.Model;
import acme.framework.controllers.Request;
import acme.framework.services.AbstractShowService;
import acme.roles.Inventor;
@Service
public class InventorChimpumShowService implements AbstractShowService<Inventor, Chimpum> {

	@Autowired
	protected InventorChimpumRepository repository;


	@Override
	public boolean authorise(final Request<Chimpum> request) {
		assert request != null;
		boolean result;
		int chimpumID;
		Inventor inv;
		Chimpum chimpum;
		
		chimpumID = request.getModel().getInteger("id");
		chimpum = this.repository.findChimpumById(chimpumID);
		inv =this.repository.findInventorByUserAccountId(request.getPrincipal().getAccountId());
		result = chimpum.getItem().getInventor().equals(inv);

		return result; 
	}

	@Override
	public Chimpum findOne(final Request<Chimpum> request) {

		assert request != null;
		final int id=request.getModel().getInteger("id"); 

		return this.repository.findChimpumById(id);
	}

	@Override
	public void unbind(final Request<Chimpum> request, final Chimpum entity, final Model model) {
		assert request != null;
		assert entity != null;
		assert model != null;
		final Collection<Item> items;
		items = this.repository.allComponentsByInventorId(false, entity.getItem().getInventor().getId());

		items.add(entity.getItem());
		request.unbind(entity, model,"code","title","description","creationMoment", "startDate","endDate","budget","link","item.tipo", "item.name", "item.code","item.technology", "item.description","item.retailPrice","item.optionalLink","item.published");
		model.setAttribute("items",items);
		model.setAttribute("itemId", entity.getItem().getId());
		if(entity.getItem().isPublished()) {
			model.setAttribute("readonly", true);
		}
		model.setAttribute("itemPublished", entity.getItem().isPublished());

	}

}
