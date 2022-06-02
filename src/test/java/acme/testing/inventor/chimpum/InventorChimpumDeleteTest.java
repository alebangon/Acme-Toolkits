
package acme.testing.inventor.chimpum;

import org.junit.jupiter.api.Order;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;

import acme.testing.TestHarness;

public class InventorChimpumDeleteTest extends TestHarness {

	@ParameterizedTest
	@CsvFileSource(resources = "/inventor/chimpum/delete-positive.csv", encoding = "utf-8", numLinesToSkip = 1)
	@Order(10)
	public void positiveChimpum(final int recordIndex, final String code, final String title, final String description, final String creation_moment, final String start_date, final String end_date, final String budget, final String link) {

		super.signIn("inventor5", "inventor5");
		super.clickOnMenu("Inventor", "List My Chimpums");
		super.checkListingExists();
		super.sortListing(0, "asc");
		super.clickOnListingRecord(recordIndex);

		super.clickOnSubmit("Delete");
		super.checkNotErrorsExist();

		super.clickOnMenu("Inventor", "List My Chimpums");
		super.checkNotErrorsExist();

		super.signOut();
	}

	// Ancillary methods ------------------------------------------------------

	@ParameterizedTest
	@CsvFileSource(resources = "/inventor/chimpum/delete-negative.csv", encoding = "utf-8", numLinesToSkip = 1)
	@Order(10)
	public void negativeChimpum(final int recordIndex, final String code, final String title, final String description, final String creation_moment, final String start_date, final String end_date, final String budget, final String link) {

		super.sortListing(0, "asc");
		super.signIn("inventor5", "inventor5");
		super.clickOnMenu("Inventor", "List My Chimpums");
		super.checkListingExists();
		super.clickOnListingRecord(recordIndex);
		super.checkNotSubmitExists("Delete");
		super.checkNotErrorsExist();

		super.signOut();
	}
}
