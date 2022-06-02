package acme.testing.patron.chimpum;

import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;

import acme.testing.TestHarness;

public class PatronChimpumDeleteTest extends TestHarness{
	
	@ParameterizedTest
	@CsvFileSource(resources = "/patron/chimpum/delete-positive.csv", encoding = "utf-8", numLinesToSkip = 1)
	@Order(10)
	public void positiveChimpum(final int recordIndex, final String code, final String title, final String description, final String creation_moment, final String start_date, final String end_date, final String budget,
		final String link, final String item_id, final String item_tipo, final String item_name,  final String item_code, final String item_technology, final String item_description, final String item_retailPrice, final String item_link) {
		
		
		
		super.signIn("patron1", "patron1");
		super.clickOnMenu("Patron", "List My Chimpums");
		super.checkListingExists();
		super.sortListing(0, "asc");
		super.clickOnListingRecord(1);
				
		super.clickOnSubmit("Delete");
		super.checkNotErrorsExist();
		
		super.clickOnMenu("Patron", "List My Chimpums");
		super.checkNotErrorsExist();


		super.signOut();
	}
	

	// Ancillary methods ------------------------------------------------------
	@Test
	@Order(30)
	public void hackingTest() {
		super.signIn("inventor1", "inventor1");
		super.navigate("/patron/chimpum/show");
		super.checkPanicExists();
		super.signOut();
		super.navigate("/patron/chimpum/show");
		super.checkPanicExists();


	}
	// Ancillary methods ------------------------------------------------------


	
	
	}
	

