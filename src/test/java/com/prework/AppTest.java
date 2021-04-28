package com.prework;

import org.junit.Test;
import org.junit.Assert;
import java.util.concurrent.TimeUnit;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;


public class AppTest {

	
	private static Logger logger = LogManager.getLogger();
	
	
	BasePage homePage = new BasePage();
	LoginPage loginPage = new LoginPage(homePage.driver);
	SearchPage searchPage = new SearchPage(homePage.driver);
	BasketPage basketPage = new BasketPage(homePage.driver);
	
	@Test
	public void openSite()  throws InterruptedException{
		
		
		Assert.assertEquals(true, homePage.openChrome());
		logger.info("Home page opened-successfully");
		
		Assert.assertEquals(1, loginPage.login("huseyinfatihkazan@gmail.com", "huseyinfatih97"));
		logger.info("Login-successfully");
		
		
		String searchText = "bilgisayar";		
		Assert.assertEquals(true, searchPage.searchWithText(searchText));
		logger.info("Results listed '"+searchText+"'-successfully");
		
		TimeUnit.SECONDS.sleep(1);
		Assert.assertEquals(true, searchPage.selectListPage(2));
		logger.info("Second page selected for results-successfully");
		
		TimeUnit.SECONDS.sleep(1);
		Assert.assertEquals(true, searchPage.selectProduct() );
		logger.info("Random product select-successfully");
		
		TimeUnit.SECONDS.sleep(1);
		Assert.assertEquals(true, basketPage.addToBasket() );
		logger.info("Add to basket-successfully");
		
		TimeUnit.SECONDS.sleep(3);
		Assert.assertEquals(true, basketPage.goToBasketPage() );
		logger.info("Go to basket page-successfully");
		
		TimeUnit.SECONDS.sleep(1);
		Assert.assertEquals(true, basketPage.checkPrice() ); 
		logger.info("Check price-successfully");
		
		TimeUnit.SECONDS.sleep(1);
		Assert.assertEquals(true, basketPage.increaseAmount() ); 
		logger.info("Increase to amount-successfully");
		
		
		TimeUnit.SECONDS.sleep(2);
		Assert.assertEquals(true, basketPage.checkAmount("2") ); 
		logger.info("Check amount-successfully");
		
		TimeUnit.SECONDS.sleep(1);
		Assert.assertEquals(true, basketPage.deleteProduct() ); 
		logger.info("Delete product from basket-successfully");
		
		TimeUnit.SECONDS.sleep(2);
		Assert.assertEquals(true, basketPage.checkBasket() ); 
		logger.info("Check basket-successfully");
		
		
		logger.info("Test completed");
	}

}
