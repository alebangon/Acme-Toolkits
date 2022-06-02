package acme.features.patron.chimpum;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import acme.entities.Chimpum;
import acme.entities.Item;
import acme.framework.components.models.Model;
import acme.framework.controllers.Request;
import acme.framework.services.AbstractShowService;
import acme.roles.Patron;
@Service
public class PatronChimpumShowService implements AbstractShowService<Patron, Chimpum> {

	@Autowired
	protected PatronChimpumRepository repository;


	@Override
	public boolean authorise(final Request<Chimpum> request) {
		assert request != null;
		boolean result=true;
		final int chimpunId = request.getModel().getInteger("id");
		final int patronId= request.getPrincipal().getActiveRoleId();
		final int patronBuscaId=this.repository.findChimpumById(chimpunId).getPatron().getId();
		if(patronBuscaId!=patronId ) {
			result= false;
		}

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
		final Collection<Item> items = this.repository.allToolsWithoutChimpum(false);
		items.add(entity.getItem());
		model.setAttribute("items",items);
		model.setAttribute("itemId", entity.getItem().getId());
		model.setAttribute("itemPublished", entity.getItem().isPublished());

		request.unbind(entity, model,"code","title","description","creationMoment", "startDate","endDate","budget","link","item","item.tipo", "item.name", "item.code","item.technology", "item.description","item.retailPrice","item.optionalLink");
	
	}

}
