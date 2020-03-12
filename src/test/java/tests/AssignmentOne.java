package tests;

import org.testng.annotations.Test;
import amazon.pages.AmazonHomePage;
import amazon.pages.AmazonResultsPage;
import flipkart.pages.FlipkartHomePage;
import flipkart.pages.FlipkartResultsPage;
import testBase.TestBase;

public class AssignmentOne extends TestBase {
	
	@Test
	public void assignmentOne() {
		
		String productName="Apple iPhone XR (64GB) - Yellow";
//		String productName="NIVEA Soap, Creme Soft, 125g";
		
		//To get price of product from Amazon website 
		AmazonHomePage azHomePage = new AmazonHomePage(driver);
		azHomePage.open();
		AmazonResultsPage azResultsPage = azHomePage.searchProduct(productName);
		long azPrice = azResultsPage.getPrize(productName);
		
		//To get price of product from Flipkart website 
		FlipkartHomePage fpHomePage = new FlipkartHomePage(driver);
		fpHomePage.open();
		FlipkartResultsPage fpResultsPage = fpHomePage.searchProduct(productName);
		long fkPrice = fpResultsPage.getPrize(productName);
		
		System.out.println("AssignmentOne Output:\nPrice of the product: "+productName+" \nAmazon: "+azPrice+"\nFlipkart: "+fkPrice);
		if(azPrice<fkPrice)
			System.out.println("Amazon has lower price compared to Flipkart");
		else
			System.out.println("Flipkart has lower price compared to Amazon");
	}
}
