package tripadvisor.pages;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HotelPage {
	
	WebDriver driver;
	@FindBy(linkText="Write a review") WebElement writeReviewBtn;
	@FindBy(css=".sbx_close") List<WebElement> closeTakeSurvey;
	JavascriptExecutor js;
	
	public HotelPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver,this);
	}
	
	public ReviewPage getReviewPage() {
		js = (JavascriptExecutor)driver;
		js.executeScript("arguments[0].scrollIntoView(false);window.scrollBy(0,200);", writeReviewBtn);
		
		writeReviewBtn.click();
		List<String> tabs = new ArrayList<String>(driver.getWindowHandles());
		driver.switchTo().window(tabs.get(2));
		return new ReviewPage(driver);
	}
	
	//To Cose the Take Servey Footer if available on screen
	public void closeServeyFooter() {
		if(closeTakeSurvey!=null && closeTakeSurvey.size()>0 && closeTakeSurvey.get(0).getSize().height>0)
			closeTakeSurvey.get(0).click();
	}
}
