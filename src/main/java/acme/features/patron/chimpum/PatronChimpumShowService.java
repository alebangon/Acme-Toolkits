package acme.features.patron.chimpum;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import acme.entities.Chimpum;
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
		int chimpunId = request.getModel().getInteger("id");
		int patronId= request.getPrincipal().getActiveRoleId();
		int patronBuscaId=this.repository.findChimpumById(chimpunId).getPatron().getId();
		if(patronBuscaId!=patronId || this.repository.findChimpumById(chimpunId).getItem().isPublished()) {
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
		model.setAttribute("items", this.repository.allToolsWithoutChimpun(true));
		model.setAttribute("itemId", entity.getItem().getId());
		model.setAttribute("itemPublished", entity.getItem().isPublished());

		request.unbind(entity, model,"code","title","description","creationMoment", "startDate","endDate","budget","link","item.tipo", "item.name", "item.code","item.technology", "item.description","item.retailPrice","item.optionalLink");
	
	}

}
