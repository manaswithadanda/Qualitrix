package amazon.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class AmazonHomePage {
	
	WebDriver driver;
	private @FindBy(css="#twotabsearchtextbox") WebElement searchBox;
	private @FindBy(css="input[type=submit]") WebElement searchBtn;
	String amazonURL = "https://www.amazon.in./";
		
	public AmazonHomePage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver,this);
	}
	
	public AmazonHomePage open() {
		driver.get(amazonURL);
		new WebDriverWait(driver, 20).until(ExpectedConditions.visibilityOf(searchBtn));
		if(driver.getCurrentUrl().contains(amazonURL) && driver.getTitle().contains("Amazon"))
			return this;
		else
			throw new WebDriverException("Application not Found");
	}
	
	public AmazonResultsPage searchProduct(String productName) {
		searchBox.sendKeys(productName);
		searchBtn.click();
		return new AmazonResultsPage(driver);
	}
}
