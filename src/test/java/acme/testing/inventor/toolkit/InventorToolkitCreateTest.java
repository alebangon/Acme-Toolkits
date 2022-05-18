package acme.testing.inventor.toolkit;

import org.junit.jupiter.api.Order;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;

import acme.testing.TestHarness;

public class InventorToolkitCreateTest extends TestHarness{
	
	@ParameterizedTest
	@CsvFileSource(resources = "/inventor/toolkit/create-positive.csv", encoding = "utf-8", numLinesToSkip = 1)
	@Order(10)
	public void positiveItem(final int recordIndex, final String code, final String description,
		final String assemblynotes, final String link) {
		
		
		super.signIn("inventor1", "inventor1");
		//list
		super.clickOnMenu("Inventor", "List my toolkits");
		super.checkListingExists();
		
		super.clickOnButton("Create");
		super.fillInputBoxIn("code", code);
		super.fillInputBoxIn("description", description);
		super.fillInputBoxIn("assemblyNotes", assemblynotes);
		super.fillInputBoxIn("optionalLink", link);
		super.clickOnSubmit("Create");
		
		super.clickOnMenu("Inventor", "List my toolkits");
		super.checkListingExists();
		super.sortListing(0, "asc");
		super.sortListing(0, "asc");
		super.checkColumnHasValue(recordIndex, 0, code);
		super.checkColumnHasValue(recordIndex, 1, description);
		super.checkColumnHasValue(recordIndex, 2, assemblynotes);
		
		super.clickOnListingRecord(recordIndex);
		super.checkFormExists();
		super.checkInputBoxHasValue("code", code);
		super.checkInputBoxHasValue("description", description);
		super.checkInputBoxHasValue("assemblyNotes", assemblynotes);
		super.checkInputBoxHasValue("optionalLink", link);
		super.clickOnButton("Items");
		super.checkListingExists();
		super.checkListingEmpty();

		super.signOut();
	}
//	@ParameterizedTest
//	@CsvFileSource(resources = "/inventor/toolkit/create-negative.csv", encoding = "utf-8", numLinesToSkip = 1)
//	@Order(10)
//	public void negativeTest() {
//		// Es una lista, asi que no hay datos para un caso negativo
//	}
	
//	@Test
//	@Order(30)
//	public void hackingTest() {
//		super.checkNotLinkExists("Account");
//		super.navigate("/inventor/toolkit/list");
//		super.checkPanicExists();
//		
//		super.signIn("administrator", "administrator");
//		super.navigate("/inventor/toolkit/list");
//		super.checkPanicExists();
//		super.signOut();
//		
//		super.signIn("patron1", "patron1");
//		super.navigate("/inventor/toolkit/list");
//		super.checkPanicExists();
//		super.signOut();
//		
//		
//	}


	// Ancillary methods ------------------------------------------------------

}
