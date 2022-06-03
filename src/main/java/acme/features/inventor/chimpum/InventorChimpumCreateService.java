package acme.features.inventor.chimpum;

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
import acme.framework.services.AbstractCreateService;
import acme.roles.Inventor;
@Service
public class InventorChimpumCreateService  implements AbstractCreateService<Inventor, Chimpum>{	
	@Autowired
	protected InventorChimpumRepository repository;

	@Override
	public boolean authorise(final Request<Chimpum> request) {
		assert request != null;
		return true;
	}

	@Override
	public void bind(final Request<Chimpum> request, final Chimpum entity, final Errors errors) {

		assert request != null;
		assert entity != null;
		assert errors != null;
		Collection<Item> items;
		items = this.repository.allToolsByInventorId(false, request.getPrincipal().getActiveRoleId());
//		request.bind(entity, errors, "code","title","description", "startDate","endDate","budget","link","item");
		if(items.isEmpty()) {			
			request.bind(entity, errors, "code","title","description", "startDate","endDate","budget","link");
		}else {
			entity.setItem(this.repository.findItemById(Integer.valueOf(request.getModel().getAttribute("itemId").toString())));
			request.bind(entity, errors, "code","title","description", "startDate","endDate","budget","link","itemId");
		}
	}	

	@Override
	public void unbind(final Request<Chimpum> request, final Chimpum entity, final Model model) {

		assert request != null; 
		assert entity != null; 
		assert model != null; 
		Collection<Item> items;
		items = this.repository.allToolsByInventorId(false, request.getPrincipal().getActiveRoleId());

			
		request.unbind(entity, model, "code","title","description", "startDate","endDate","budget","link");
		model.setAttribute("items", items);

	}


	@Override
	public Chimpum instantiate(final Request<Chimpum> request) {
		assert request != null;
		final Chimpum result = new Chimpum();

		result.setStartDate(DateUtils.addMonths( new Date(System.currentTimeMillis() - 1),1));
		result.setEndDate(DateUtils.addMonths( new Date(System.currentTimeMillis() - 1),2));

		Date moment;

		moment = new Date(System.currentTimeMillis() - 1);
		result.setCreationMoment(moment);
		
		return result;
	}

	@Override
	public void validate(final Request<Chimpum> request, final Chimpum entity, final Errors errors) {
		assert request != null;
		assert entity != null;
		assert errors != null;
		
		if(entity.getItem()==null) {
		        errors.state(request, entity.getItem() != null, "itemId", "inventor.chimpum.form.error.noItem");
		    }
		if (!errors.hasErrors("code")) {
			Chimpum existing;
			
			existing = this.repository.findChimpumByCode(entity.getCode());
			
			errors.state(request, existing == null, "code", "patron.chimpum.form.error.duplicated");
		}
		if(!errors.hasErrors("startDate")) {
			final Date minimumStartDate=DateUtils.addMonths(new Date(System.currentTimeMillis() - 1),1);

			
			errors.state(request,entity.getStartDate().after(minimumStartDate), "startDate", "patron.chimpum.form.error.too-close-start-date");
			
		}
		if(!errors.hasErrors("endDate") && !errors.hasErrors("startDate")) {
			final Date minimumFinishDate=(DateUtils.addDays(entity.getStartDate(), 6));
			

			errors.state(request,entity.getEndDate().after(minimumFinishDate), "endDate", "patron.chimpum.form.error.one-month");
			
		}
		if (!errors.hasErrors("budget")) {
			final String[] currencies=this.repository.findSystemConfiguration().getAcceptedCurrencies().split(",");

            Boolean acceptedCurrency=false;
            for(int i=0;i<currencies.length;i++) {
	                if(entity.getBudget().getCurrency().equals(currencies[i].trim())) {
                    acceptedCurrency=true;
                }
            }
			
			errors.state(request, entity.getBudget().getAmount() > 0, "budget", "patron.chimpum.form.error.negative-budget");
			errors.state(request, acceptedCurrency, "budget", "patron.chimpum.form.error.non-accepted-currency");
		}

	}



	@Override
	public void create(final Request<Chimpum> request, final Chimpum entity) {
		assert request != null;
		assert entity != null;		
		
		Date moment;
		
		moment = new Date(System.currentTimeMillis() - 1);
		entity.setCreationMoment(moment);
		this.repository.save(entity);
	}

}