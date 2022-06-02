package acme.features.patron.chimpum;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import acme.entities.Chimpum;
import acme.framework.components.models.Model;
import acme.framework.controllers.Errors;
import acme.framework.controllers.Request;
import acme.framework.services.AbstractDeleteService;
import acme.roles.Patron;
@Service
public class PatronChimpumDeleteService  implements AbstractDeleteService<Patron, Chimpum> {

	// Internal state ---------------------------------------------------------

	@Autowired
	protected PatronChimpumRepository repository;

	// AbstractDeleteService<Patron, Patronage> -------------------------------------


	@Override
	public boolean authorise(final Request<Chimpum> request) {
		
		
		boolean result=true;
		int chimpunId = request.getModel().getInteger("id");
		int patronId= request.getPrincipal().getActiveRoleId();
		int patronBuscaId=this.repository.findChimpumById(chimpunId).getPatron().getId();
		if(patronBuscaId!=patronId || !this.repository.findChimpumById(chimpunId).getItem().isPublished()) {
			result= false;
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
		model.setAttribute("itemPublished", entity.getItem().isPublished());

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


		this.repository.delete(entity);
	}
	

}
