package flipkart.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class FlipkartResultsPage {
	
	WebDriver driver;
	@FindBy(css="._1HmYoV._35HD7C:nth-of-type(2)") WebElement resultsPage;
	
	public FlipkartResultsPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver,this);
	}
	
	public long getPrize(String productName) {
		WebElement priceElement = resultsPage.findElement(By.cssSelector("._1vC4OE._2rQ-NK"));
		String price = priceElement.getText();
		return Long.parseLong(price.replaceAll("[?₹$,]+", ""));
	}
}
