package amazon.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AmazonResultsPage {
	
	WebDriver driver;
	@FindBy(css=".s-result-list.s-search-results") WebElement resultsPage;
	
	public AmazonResultsPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver,this);
	}
	
	public long getPrize(String productName) {
		WebElement priceElement = resultsPage.findElement(By.xpath("//span[starts-with(text(),'"+productName+"')]/ancestor::div[@class=\"sg-col-inner\"]"));
		String price = priceElement.findElement(By.xpath("//div[@class=\"sg-row\"][2]/following::span[@class=\"a-price\"]")).getText();
		return Long.parseLong(price.replaceAll("[?₹$,]+",""));
	}
}
