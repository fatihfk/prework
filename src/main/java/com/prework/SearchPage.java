package com.prework;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import java.util.concurrent.ThreadLocalRandom;

public class SearchPage {

	private WebDriver driver;
	
	public SearchPage(WebDriver driver) {
		
		this.driver = driver;
	}
	
	public boolean searchWithText(String searchText) {
		
		
		driver.findElement(By.xpath("//*[@id=\"main-header\"]/div[3]/div/div/div/div[2]/form/div/div[1]/div[2]/input")).sendKeys(searchText);
		
		driver.findElement(By.className("hKfdXF")).click();		
		
		return true; 
	}
	
	public boolean selectListPage(int pageNumber) {
		
		
		String url = driver.findElement(By.xpath("//*[@id=\"best-match-right\"]/div[5]/ul/li[2]/a")).getAttribute("href");
		driver.navigate().to(url);

		return driver.findElement(By.xpath("//*[@id=\"best-match-right\"]/div[4]/ul/li[@class='selected']/a")).getText().equals("2") ? true:false;
		//check selected page
	} 
	
	
	
	public boolean selectProduct() {
		
		int maxCount = driver.findElements(By.xpath("//*[@id=\"best-match-right\"]/div[3]/div[2]/ul/li")).size(); 
		
		int randomNumber = ThreadLocalRandom.current().nextInt( 1, maxCount + 1);
		
		String randomProductXpath = "/html/body/div[5]/div[1]/div/div[2]/div[3]/div[2]/ul/li[" + randomNumber + "]/a";

		String productUrl = driver.findElement(By.xpath(randomProductXpath)).getAttribute("href");
		//get random product url
		driver.navigate().to(productUrl);
		return true;
	}
}