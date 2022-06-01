package acme.testing.patron.chimpum;

import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;

import acme.testing.TestHarness;

public class PatronChimpumListTest extends TestHarness{
	
	@ParameterizedTest
	@CsvFileSource(resources = "/patron/chimpum/list-positive.csv", encoding = "utf-8", numLinesToSkip = 1)
	@Order(10)
	public void positiveChimpum(final int recordIndex, final String code,final String title, final String budget, final String start_date, final String end_date, 
		final String creation_moment) {
		
		
		super.signIn("patron1", "patron1");
		super.clickOnMenu("Patron", "List My Chimpums");
		super.checkListingExists();
		super.sortListing(0, "asc");
		super.checkColumnHasValue(recordIndex, 0, code);
		super.checkColumnHasValue(recordIndex, 1, title);
		super.checkColumnHasValue(recordIndex, 2, budget);
		super.checkColumnHasValue(recordIndex, 3, start_date);
		super.checkColumnHasValue(recordIndex, 4, end_date);
		super.checkColumnHasValue(recordIndex, 5, creation_moment);

		super.signOut();
	}
	
	
	@Test
	@Order(30)
	public void hackingTest() {
		super.checkNotLinkExists("Patron");
		super.navigate("/patron/chimpum/list");
		super.checkPanicExists();
	}
	// Ancillary methods ------------------------------------------------------

}
