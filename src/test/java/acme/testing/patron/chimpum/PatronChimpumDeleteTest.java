package acme.testing.patron.chimpum;

import org.junit.jupiter.api.Order;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;
import org.openqa.selenium.By;

import acme.framework.testing.BrowserDriver;
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
		super.clickOnListingRecord(recordIndex);
		super.checkFormExists();
		super.checkInputBoxHasValue("code", code);
		super.checkInputBoxHasValue("title", title);
		super.checkInputBoxHasValue("description", description);
		super.checkInputBoxHasValue("creationMoment", creation_moment);
		super.checkInputBoxHasValue("startDate", start_date);
		super.checkInputBoxHasValue("endDate", end_date);
		super.checkInputBoxHasValue("budget", budget);
		super.checkInputBoxHasValue("link", link);
		final BrowserDriver driver = super.getDriver();
		driver.locateOne(By.xpath("//*[@id=\"itemId_proxy\"]/option[" + item_id +"]")).click();
		super.checkInputBoxHasValue("item.tipo", item_tipo);
		super.checkInputBoxHasValue("item.name",item_name);
		super.checkInputBoxHasValue("item.code", item_code);
		super.checkInputBoxHasValue("item.technology", item_technology);
		super.checkInputBoxHasValue("item.description", item_description);
		super.checkInputBoxHasValue("item.retailPrice", item_retailPrice);
		super.checkInputBoxHasValue("item.optionalLink", item_link);
		
		super.clickOnSubmit("Delete");
		super.checkNotErrorsExist();
		
		super.clickOnMenu("Patron", "List My Chimpums");
		super.checkNotErrorsExist();


		super.signOut();
	}
	

	// Ancillary methods ------------------------------------------------------


	
	@ParameterizedTest
	@CsvFileSource(resources = "/patron/patronage/delete-negative.csv", encoding = "utf-8", numLinesToSkip = 1)
	@Order(10)
	public void negativePatronage(final int recordIndex, final String code, final String budget, final String start_date, final String end_date, 
		final String status, final String published, final String legal_stuff, final String link,final String inventor_username, final String inventor_company, final String inventor_link, final String inventor_statement) {
		
		
		super.signIn("patron1", "patron1");
		super.clickOnMenu("Patron", "List patronages");
		super.checkListingExists();
		super.sortListing(0, "asc");
		super.clickOnListingRecord(recordIndex);
		super.checkFormExists();
		super.checkInputBoxHasValue("code", code);
		super.checkInputBoxHasValue("startDate", start_date);
		super.checkInputBoxHasValue("endDate", end_date);
		super.checkInputBoxHasValue("legalStuff", legal_stuff);
		super.checkInputBoxHasValue("budget", budget);
		super.checkInputBoxHasValue("status", status);
		super.checkInputBoxHasValue("published", published);
		super.checkInputBoxHasValue("link", link);
		super.checkNotSubmitExists("Delete patronage");
		
		super.signOut();
	}

}
