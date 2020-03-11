package tests;

import org.testng.annotations.Test;
import testBase.TestBase;
import tripadvisor.pages.HotelPage;
import tripadvisor.pages.ReviewPage;
import tripadvisor.pages.TripadHomePage;
import tripadvisor.pages.TripadSearchResult;

public class AssignmentTwo extends TestBase {
	
	@Test
	public void assignmentTwo() {
		
		TripadHomePage tpHomePage = new TripadHomePage(driver);
		tpHomePage.open();
		
		TripadSearchResult searchResult = tpHomePage.searchPlace("Club Mahindra");
		HotelPage hotelPG = searchResult.selectHotel();
		
		ReviewPage reviewPG = hotelPG.getReviewPage();
		reviewPG.setRating(5);
		reviewPG.fillReviewForm("ReviewTitle","The property is well maintained with garden colorfully flowers and the room is also maintained well daily room cleaning is done The property is well maintained with garden colorfully flowers and the room");
		reviewPG.submitReview();
	}
}
