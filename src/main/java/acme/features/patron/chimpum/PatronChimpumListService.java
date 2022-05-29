package acme.features.patron.chimpum;
import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import acme.entities.Chimpum;
import acme.framework.components.models.Model;
import acme.framework.controllers.Request;
import acme.framework.services.AbstractListService;
import acme.roles.Patron; 
 
@Service 
public class PatronChimpumListService implements AbstractListService<Patron, Chimpum> { 
	 
	@Autowired 
	protected PatronChimpumRepository repository; 
 
	@Override 
	public boolean authorise(final Request<Chimpum> request) { 
		assert request != null; 
		return true; 
	} 
 
	@Override 
	public Collection<Chimpum> findMany(final Request<Chimpum> request) { 
		assert request != null; 
		 
		final Collection<Chimpum> result; 
		final int UAId = request.getPrincipal().getAccountId();
		final int PatronId = this.repository.findPatronByUserAccountId(UAId).getId();
		result=this.repository.findChimpumsByPatronId(PatronId); 
		
		return result;
	} 
 
	@Override 
	public void unbind(final Request<Chimpum> request, final Chimpum entity, final Model model) { 
		assert request != null; 
		assert entity != null; 
		assert model != null; 
		request.unbind(entity, model, "code","creationMoment","title","description", "startDate","endDate","budget","link","item");		 
	} 
 
} 
