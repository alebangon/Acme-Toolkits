package acme.features.patronage.dashboard;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import acme.forms.PatronageDashboard;
import acme.framework.components.models.Model;
import acme.framework.controllers.Request;
import acme.framework.roles.Administrator;
import acme.framework.services.AbstractShowService;

@Service
public class PatronageDashboardShowService implements AbstractShowService<Administrator, PatronageDashboard> {


	@Autowired
	protected PatronageDashboardRepository repository;



	@Override
	public boolean authorise(final Request<PatronageDashboard> request) {
		assert request != null;

		return true;
	}

	@Override
	public void unbind(final Request<PatronageDashboard> request, final PatronageDashboard entity, final Model model) {
		assert request != null;
		assert entity != null;
		assert model != null;

		request.unbind(entity, model, "totalNumberOfProposedPatronages", "totalNumberOfAccepedPatronages", "totalNumberOfDeniedPatronages",
			"deviationPatronageProposedEUR", "deviationPatronageProposedUSD", "deviationPatronageProposedGBP",
			"deviationPatronageAcceptedEUR", "deviationPatronageAcceptedUSD","deviationPatronageAcceptedGBP",
			"deviationPatronageDeniedEUR", "deviationPatronageDeniedUSD", "deviationPatronageDeniedGBP", 
			
			"averagePatronageProposedEUR", "averagePatronageProposedUSD", "averagePatronageProposedGBP", 
			"averagePatronageAcceptedEUR", "averagePatronageAcceptedUSD","averagePatronageAcceptedGBP", 
			"averagePatronageDeniedEUR", "averagePatronageDeniedUSD", "averagePatronageDeniedGBP", 
			"maxPatronageProposedEUR", "maxPatronageProposedUSD", "maxPatronageProposedGBP", 
			"maxPatronageAcceptedEUR","maxPatronageAcceptedUSD","maxPatronageAcceptedGBP",
			"maxPatronageDeniedEUR", "maxPatronageDeniedUSD", "maxPatronageDeniedGBP", 
			"minPatronageProposedEUR", "minPatronageProposedUSD", "minPatronageProposedGBP", 
			"minPatronageAcceptedEUR","minPatronageAcceptedEUR","minPatronageAcceptedEUR", 
			"minPatronageDeniedEUR", "minPatronageDeniedUSD", "minPatronageDeniedGBP");
	}

	@Override
	public PatronageDashboard findOne(final Request<PatronageDashboard> request) {
		assert request != null;

		PatronageDashboard result;
		 Integer totalNumberOfProposedPatronages;
		 Integer totalNumberOfAccepedPatronages;
		 Integer totalNumberOfDeniedPatronages;
		 
		 Double deviationBudgetPatronageProposedEUR;
		 Double deviationBudgetPatronageProposedUSD;
		 Double deviationBudgetPatronageProposedGBP;
		 
		 Double deviationBudgetPatronageAcceptedEUR;
		 Double deviationBudgetPatronageAcceptedUSD;
		 Double deviationBudgetPatronageAcceptedGBP;
		 
		 Double deviationBudgetPatronageDeniedEUR;
		 Double deviationBudgetPatronageDeniedUSD;
		 Double deviationBudgetPatronageDeniedGBP;
		 
		 Double averageBudgetPatronageProposedEUR;
		 Double averageBudgetPatronageProposedUSD;
		 Double averageBudgetPatronageProposedGBP;
		 
		 Double averageBudgetPatronageAcceptedEUR;
		 Double averageBudgetPatronageAcceptedUSD;
		 Double averageBudgetPatronageAcceptedGBP;
		 
		 Double averageBudgetPatronageDeniedEUR;
		 Double averageBudgetPatronageDeniedUSD;
		 Double averageBudgetPatronageDeniedGBP;
		 
		 Double maxBudgetPatronageProposedEUR;
		 Double maxBudgetPatronageProposedUSD;
		 Double maxBudgetPatronageProposedGBP;
		 
		 Double maxBudgetPatronageAcceptedEUR;
		 Double maxBudgetPatronageAcceptedUSD;
		 Double maxBudgetPatronageAcceptedGBP;
		 
		 Double maxBudgetPatronageDeniedEUR;
		 Double maxBudgetPatronageDeniedUSD;
		 Double maxBudgetPatronageDeniedGBP;
		 
		 Double minBudgetPatronageProposedEUR;
		 Double minBudgetPatronageProposedUSD;
		 Double minBudgetPatronageProposedGBP;
		 
		 Double minBudgetPatronageAcceptedEUR;
		 Double minBudgetPatronageAcceptedUSD;
		 Double minBudgetPatronageAcceptedGBP;
		 
		 Double minBudgetPatronageDeniedEUR;
		 Double minBudgetPatronageDeniedUSD;
		 Double minBudgetPatronageDeniedGBP;

		result = new PatronageDashboard();

		return result;
	}



}