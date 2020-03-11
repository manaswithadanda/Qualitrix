package tripadvisor.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class TripadHomePage {
	
	WebDriver driver;
	String tripadURL = "https://www.tripadvisor.in/";
	@FindBy(css="._3qLQ-U8m") WebElement searchBox;
	@FindBy(css="._2LyoLJ4U._2HBN-k68") WebElement searchBtn;
	
	public TripadHomePage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver,this);
	}
	
	public TripadHomePage open() {
		driver.get(tripadURL);
		new WebDriverWait(driver, 20).until(ExpectedConditions.visibilityOf(searchBox));
		if(driver.getCurrentUrl().contains(tripadURL) && driver.getTitle().contains("Tripadvisor"))
			return new TripadHomePage(driver);
		else
			throw new WebDriverException("Application not Found");
	}
	
	public TripadSearchResult searchPlace(String placeName) {
		searchBox.click();
		searchBox.sendKeys(placeName);
		searchBtn.click();
		return new TripadSearchResult(driver);
	}
}
