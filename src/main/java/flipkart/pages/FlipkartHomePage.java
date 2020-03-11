package flipkart.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class FlipkartHomePage {
	
	WebDriver driver;
	private @FindBy(css=".LM6RPg") WebElement searchBox;
	private @FindBy(css=".vh79eN") WebElement searchBtn;
	private @FindBy(css="._3Njdz7") WebElement loginPopup; 
	private @FindBy(css="._2AkmmA._29YdH8") WebElement lgPopupcloseBtn; 
	
	String flipkartURL = "https://www.flipkart.com/";
		
	public FlipkartHomePage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver,this);
	}
	
	public FlipkartHomePage open() {
		driver.get(flipkartURL);
		new WebDriverWait(driver, 20).until(ExpectedConditions.visibilityOf(searchBtn));
		
		if(driver.getCurrentUrl().contains(flipkartURL))
			return this;
		else
			throw new WebDriverException("Application not Found");
	}
	
	public FlipkartResultsPage searchProduct(String productName) {
		if(loginPopup.getSize().height>0)
			lgPopupcloseBtn.click();
		searchBox.sendKeys(productName);
		searchBtn.click();
		return new FlipkartResultsPage(driver);
	}
}
