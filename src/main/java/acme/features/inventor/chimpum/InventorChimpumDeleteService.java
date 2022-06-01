package acme.features.inventor.chimpum;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import acme.entities.Chimpum;
import acme.framework.components.models.Model;
import acme.framework.controllers.Errors;
import acme.framework.controllers.Request;
import acme.framework.services.AbstractDeleteService;
import acme.roles.Inventor;
@Service
public class InventorChimpumDeleteService  implements AbstractDeleteService<Inventor, Chimpum> {

	// Internal state ---------------------------------------------------------

	@Autowired
	protected InventorChimpumRepository repository;

	// AbstractDeleteService<Patron, Patronage> -------------------------------------


	@Override
	public boolean authorise(final Request<Chimpum> request) {
		assert request != null;
		boolean result=true;
		int chimpumID;
		Inventor inv;
		Chimpum chimpum;
		
		chimpumID = request.getModel().getInteger("id");
		chimpum = this.repository.findChimpumById(chimpumID);
		inv =this.repository.findInventorByUserAccountId(request.getPrincipal().getAccountId());
		if(!chimpum.getItem().getInventor().equals(inv)||this.repository.findChimpumById(chimpumID).getItem().isPublished()) {
		result = false;
	}

		return result;
	}


	@Override
	public Chimpum findOne(final Request<Chimpum> request) {
		assert request != null;

		Chimpum result;
		int id;

		id = request.getModel().getInteger("id");
		result = this.repository.findChimpumById(id);

		return result;
	}

	@Override
	public void bind(final Request<Chimpum> request, final Chimpum entity, final Errors errors) {
		assert request != null;
		assert entity != null;
		assert errors != null;

		request.bind(entity, errors, "code","title","description","creationMoment", "startDate","endDate","budget","link","item.tipo", "item.name", "item.code","item.technology", "item.description","item.retailPrice","item.optionalLink");
	}

	@Override
	public void unbind(final Request<Chimpum> request, final Chimpum entity, final Model model) {
		assert request != null;
		assert entity != null;
		assert model != null;

		request.unbind(entity, model, "code","title","description","creationMoment", "startDate","endDate","budget","link","item.tipo", "item.name", "item.code","item.technology", "item.description","item.retailPrice","item.optionalLink");
	}

	@Override
	public void validate(final Request<Chimpum> request, final Chimpum entity, final Errors errors) {
		assert request != null;
		assert entity != null;
		assert errors != null;
	}

	@Override
	public void delete(final Request<Chimpum> request, final Chimpum entity) {
		assert request != null;
		assert entity != null;

		if(!entity.getItem().isPublished())
			this.repository.delete(entity);
	}
	

}
