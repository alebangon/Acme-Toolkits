package acme.forms;

import java.io.Serializable;
import java.util.Map;

import org.springframework.data.util.Pair;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class AdministratorDashboard implements Serializable {
	
	// Serialisation identifier -----------------------------------------------

		protected static final long	serialVersionUID	= 1L;

		// Attributes -------------------------------------------------------------

		int totalNumberOfComponents;
		int totalNumberOfTools;
		Map<Pair<String,String>,Double>averageRetailPriceOfComponents;
		Map<Pair<String,String>,Double>deviationRetailPriceOfComponents;
		Map<Pair<String,String>,Double>minRetailPriceOfComponents;
		Map<Pair<String,String>,Double>maxRetailPriceOfComponents;
		Map<String,Double> averageRetailPriceOfTools;
		Map<String,Double> deviationRetailPriceOfTools;
		Map<String,Double> maxRetailPriceOfTools;
		Map<String,Double> minRetailPriceOfTools;
		int totalNumberOfProposedPatronages;
		int totalNumberOfAcceptedPatronages;
		int totalNumberOfDeniedPatronages;
		Map<String,Double> averageBudgetByStatus;
		Map<String,Double> deviationBudgetByStatus;
		Map<String,Double> minBudgetByStatus;
		Map<String,Double> maxBudgetByStatus;
		
		
		Map<String,Double> averageChimpumByCurrency;
		Map<String,Double> deviationChimpumByCurrency;
		Map<String,Double> minChimpumByCurrency;
		Map<String,Double> maxChimpumByCurrency;
		
		double ratioOfItemsWithChimpum;

}

