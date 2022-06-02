package acme.features.patron.chimpum;

import java.util.Collection;
import java.util.Date;

import org.apache.commons.lang3.time.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import acme.entities.Chimpum;
import acme.entities.Item;
import acme.framework.components.models.Model;
import acme.framework.controllers.Errors;
import acme.framework.controllers.Request;
import acme.framework.services.AbstractUpdateService;
import acme.roles.Patron;
@Service
public class PatronChimpumUpdateService implements AbstractUpdateService<Patron, Chimpum>{
	@Autowired
	protected PatronChimpumRepository repository;

	// AbstractUpdateService<Patron, Patronage> -------------------------------------


	@Override
	public boolean authorise(final Request<Chimpum> request) {
		assert request != null;
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
		entity.setItem(this.repository.findItemById(request.getModel().getInteger("itemId")));		
		request.bind(entity, errors, "code","title","description","creationMoment", "startDate","endDate","budget","link");

	}

	@Override
	public void validate(final Request<Chimpum> request, final Chimpum entity, final Errors errors) {
		assert request != null;
		assert entity != null;
		assert errors != null;
		
		
		if (!errors.hasErrors("code")) {
            Chimpum existing;

            existing = this.repository.findChimpumByCode(entity.getCode());
            if(existing!=null) {
                errors.state(request, existing.getId()==entity.getId() , "code", "patron.chimpum.form.error.duplicated");
                }
            }
		if(!errors.hasErrors("startDate")) {
			final Date minimumStartDate=DateUtils.addMonths(new Date(System.currentTimeMillis() - 1),1);

			
			errors.state(request,entity.getStartDate().after(minimumStartDate), "startDate", "patron.patronage.form.error.too-close-start-date");
			
		}
		if(!errors.hasErrors("endDate") && !errors.hasErrors("startDate")) {
			final Date minimumFinishDate=(DateUtils.addDays(entity.getStartDate(), 6));
			

			errors.state(request,entity.getEndDate().after(minimumFinishDate), "endDate", "patron.patronage.form.error.one-month");
			
		}
		if (!errors.hasErrors("budget")) {
			final String[] currencies=this.repository.findSystemConfiguration().getAcceptedCurrencies().split(",");

            Boolean acceptedCurrency=false;
            for(int i=0;i<currencies.length;i++) {
	                if(entity.getBudget().getCurrency().equals(currencies[i].trim())) {
                    acceptedCurrency=true;
                }
            }
			
			errors.state(request, entity.getBudget().getAmount() > 0, "budget", "patron.patronage.form.error.negative-budget");
			errors.state(request, acceptedCurrency, "budget", "patron.patronage.form.error.non-accepted-currency");
		}


	}


	@Override
	public void unbind(final Request<Chimpum> request, final Chimpum entity, final Model model) {
		assert request != null; 
		assert entity != null; 
		assert model != null; 

		request.unbind(entity, model, "code","title","description","creationMoment", "startDate","endDate","budget","link","item.tipo", "item.name", "item.code","item.technology", "item.description","item.retailPrice","item.optionalLink");
		final Collection<Item> items = this.repository.allComponentsWithoutChimpum(true);
        items.add(entity.getItem());
		model.setAttribute("items", items);
		model.setAttribute("itemId",  entity.getItem().getId());
	}

	@Override
	public void update(final Request<Chimpum> request, final Chimpum entity) {
		assert request != null;
		assert entity != null;
		entity.setItem(this.repository.findItemById(request.getModel().getInteger("itemId")));
		this.repository.save(entity);

	}
}