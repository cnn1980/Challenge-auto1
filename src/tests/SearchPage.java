package tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

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
	
	public SearchPage sortingCars(String method) {
		click(sortingBy);
		By sortingSelected = By.xpath(".//option[text()='"+ method + "']");
		click(sortingSelected);
		return this;
	}


}
