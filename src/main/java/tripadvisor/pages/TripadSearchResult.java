package tripadvisor.pages;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class TripadSearchResult {
	
	WebDriver driver;
	@FindBy(css=".result-card-default") List<WebElement> searchResult;
	
	public TripadSearchResult(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver,this);
	}
	
	public HotelPage selectHotel() {
		searchResult.get(0).click();
		List<String> tabs = new ArrayList<String>(driver.getWindowHandles());
		driver.switchTo().window(tabs.get(1));
		return new HotelPage(driver);
	}
}
