package tests;

import org.junit.Test;


public class ChromeTest extends TestBase {

	@Test
	public void filterByRegistrationAndSorting() throws Exception {
		SearchPage searchPage = new SearchPage(driver);
		searchPage.gotoSearchPage()
				  .openFilterByRegYear("2015")
				  .sortingCars("Höchster Preis");
	}
	
}