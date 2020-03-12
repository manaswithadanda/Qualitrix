package tripadvisor.pages;

import java.util.List;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class ReviewPage {
	
	WebDriver driver;
	@FindBy(id="bubble_rating") WebElement overallRating;
	@FindBy(id="ReviewTitle") WebElement reviewTitle;
	@FindBy(id="ReviewText") WebElement reviewText;
	@FindBy(css="#trip_type_table .jfy_cloud") List<WebElement> tripType;
	@FindBy(css=".dq_allTravelers:not(.suppress) span[id$=bubbles]") List<WebElement> hotelRating;
	@FindBy(id="noFraud") WebElement noFraudCheckBox;
	@FindBy(id="SUBMIT") WebElement submitBtn;
	@FindBy(id="trip_date_month_year") WebElement travelDate;
	JavascriptExecutor js;
	Actions actions;
	
	public ReviewPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver,this);
	}
	
	public void setOverallRating(int ratingNum) {
		setRating(overallRating, ratingNum);
	}
	
	public void fillReviewForm(String rvTitle, String rvText) {
		
		reviewTitle.sendKeys(rvTitle);
		reviewText.sendKeys(rvText);
		tripType.get(0).click();
		
		Select select = new Select(travelDate);
		select.selectByIndex(1);
		
		setHotelRating(5);
	}
	
	public void submitReview() {
		noFraudCheckBox.click();
		submitBtn.click();
	}
	
	public void setHotelRating(int rating) {
		if(hotelRating.size()>0) 
			for(WebElement element : hotelRating) 
				setRating(element, rating);
	}
	
	private void setRating(WebElement element, int rating) {
		actions = new Actions(driver);
		actions.moveToElement(element,-40,0).pause(50);
		for(int i=1; i<rating; i++) 
			actions.moveByOffset(i*10, 0).pause(50);
		actions.click().perform();
	}
}
