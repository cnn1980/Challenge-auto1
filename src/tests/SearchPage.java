package tests;

import static org.junit.Assert.assertTrue;

import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;


public class SearchPage extends PageBase {

	String baseURL = "https://www.autohero.com/de/search/";
	
	public SearchPage(WebDriver driver) {
		super(driver);
	}
	
	public SearchPage gotoSearchPage() {
		driver.get(baseURL);
		return this;
	}
	
	By regFilterBy = By.xpath(".//div[@data-qa-selector='filter-year']");
	By elementSelectorBy = By.xpath(".//select[@name='yearRange.min']");
	By sortingBy = By.xpath(".//select[@name='sort']");

	
	public SearchPage openFilterByRegYear(String year) {
		click(regFilterBy);
		click(elementSelectorBy);
		By elementSelectedBy = By.xpath(".//option[text()='"+ year +"']");
		click(elementSelectedBy);
		return this;
	}
	
	public SearchPage sortingCars(String method) throws InterruptedException {
		click(sortingBy);
		By sortingSelected = By.xpath(".//option[text()='"+ method + "']");
		click(sortingSelected);
		Thread.sleep(3000);
		return this;
	}
	
	public SearchPage verifyFilter(int year) {
		List<WebElement> allRegDates = driver.findElements(By.xpath(".//ul[@class='specList___2i0rY']/li[@class='specItem___2gMHn'][1]"));
		for (WebElement element: allRegDates) {
			assertTrue(Integer.parseInt(element.getText().substring(5)) >= year);
		}
		return this;
	}

	public SearchPage verifySorting() {
		List<WebElement> allPrices = driver.findElements(By.xpath(".//div[@class='totalPrice___3yfNv']"));
		float previousPrice = Float.parseFloat(allPrices.get(0).getText().substring(0, allPrices.get(0).getText().length()-2));
		for (WebElement element: allPrices) {
			float currentPrice = Float.parseFloat(element.getText().substring(0, element.getText().length()-2));
			assertTrue(currentPrice <= previousPrice);
			previousPrice = currentPrice;  
		}		
		return this;
	}

}
