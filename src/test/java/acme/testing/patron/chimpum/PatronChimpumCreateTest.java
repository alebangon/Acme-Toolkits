package acme.testing.patron.chimpum;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import org.junit.jupiter.api.Order;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;
import org.openqa.selenium.By;

import acme.framework.testing.BrowserDriver;
import acme.testing.TestHarness;

public class PatronChimpumCreateTest extends TestHarness{
    LocalDateTime currentLocalDateTimeStart = LocalDateTime.now().plusMonths(1).plusDays(1);
    LocalDateTime currentLocalDateTimeEnd = LocalDateTime.now().plusMonths(1).plusWeeks(1).plusDays(1);

    DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm");
    String formattedDateTimeStart = this.currentLocalDateTimeStart.format(this.dateTimeFormatter);
    String formattedDateTimeEND = this.currentLocalDateTimeEnd.format(this.dateTimeFormatter);
    
	
	@ParameterizedTest
	@CsvFileSource(resources = "/patron/chimpum/create-positive.csv", encoding = "utf-8", numLinesToSkip = 1)
	@Order(1)
	public void positiveChimpum(final int recordIndex, final String code, final String title, final String description, 
		final String budget,final String link, final String itemId) {
		
		
		super.signIn("patron1", "patron1");
		//list
		super.clickOnMenu("Patron", "List My Chimpums");
		super.checkListingExists();
		super.clickOnButton("Create A Chimpum");
		super.sortListing(0, "asc");

		super.fillInputBoxIn("code", code);
		super.fillInputBoxIn("title", title);
		super.fillInputBoxIn("description", description);
		super.fillInputBoxIn("startDate",this.formattedDateTimeStart);
		super.fillInputBoxIn("endDate", this.formattedDateTimeEND);
		super.fillInputBoxIn("budget", budget);
		super.fillInputBoxIn("link", link);
		final BrowserDriver driver = super.getDriver();
		driver.locateOne(By.xpath("//*[@id=\"itemId_proxy\"]/option[" + itemId +"]")).click();
		super.clickOnSubmit("Create");
		super.clickOnMenu("Patron", "List My Chimpums");

		super.sortListing(0, "asc");
		super.clickOnListingRecord(recordIndex);
		super.checkInputBoxHasValue("code", code);
		super.checkInputBoxHasValue("title", title);
		super.checkInputBoxHasValue("description", description);
		super.checkInputBoxHasValue("startDate", this.formattedDateTimeStart);
		super.checkInputBoxHasValue("endDate", this.formattedDateTimeEND);
		super.checkInputBoxHasValue("budget", budget);
		super.checkInputBoxHasValue("link", link);

		
		super.signOut();
	}
	@ParameterizedTest
	@CsvFileSource(resources = "/patron/chimpum/create-negative.csv", encoding = "utf-8", numLinesToSkip = 1)
	@Order(1)
	public void negativeChimpum(final int recordIndex, final String code, final String title, final String description, 
		final String budget,final String link, final String itemId) {
		
		
		super.signIn("patron1", "patron1");
		//list
		super.clickOnMenu("Patron", "List My Chimpums");
		super.checkListingExists();
		super.clickOnButton("Create A Chimpum");
		super.sortListing(0, "asc");

		super.fillInputBoxIn("code", code);
		super.fillInputBoxIn("title", title);
		super.fillInputBoxIn("description", description);
		super.fillInputBoxIn("startDate",this.formattedDateTimeStart);
		super.fillInputBoxIn("endDate", this.formattedDateTimeEND);
		super.fillInputBoxIn("budget", budget);
		super.fillInputBoxIn("link", link);
		final BrowserDriver driver = super.getDriver();
		driver.locateOne(By.xpath("//*[@id=\"itemId_proxy\"]/option[" + itemId +"]")).click();
		super.clickOnSubmit("Create");
		super.checkErrorsExist();
		
		super.signOut();
	}
	

}
