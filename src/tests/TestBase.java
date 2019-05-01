package tests;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class TestBase {
	
	public static WebDriver driver;
	
	@BeforeClass
	public static void setup() {

        System.setProperty(
                "webdriver.chrome.driver",
                "C:/Eclipse/Selenium/chromedriver.exe");

        driver = new ChromeDriver();
        driver.manage().window().maximize();
	}
	
//	@AfterClass
//	public static void tearDown() {
//
//	    driver.quit();
//	}
//		
}
