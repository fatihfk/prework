package com.prework;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;


public class BasketPage {

	private WebDriver driver;
	public String priceOnPage;
	public String priceOnBasket;
	
	public BasketPage(WebDriver driver) {
		
		this.driver = driver;
	}
	
	public boolean addToBasket() {
		
		priceOnPage = driver.findElement(By.xpath("//*[@id=\"sp-price-discountPrice\"]")).getText();
		
		
		WebElement element = driver.findElement(By.xpath("//*[@id=\"add-to-basket\"]"));

        JavascriptExecutor js =(JavascriptExecutor)driver;
        js.executeScript("window.scrollTo(0,"+element.getLocation().y+")");
        element.click();
        
		return true;
	} 
	
	public boolean goToBasketPage() {
		
		String basketPageUrl = driver.findElement(By.xpath("//*[@id=\"header_wrapper\"]/div[4]/div[3]/a")).getAttribute("href");
        
        driver.navigate().to(basketPageUrl);
		return true;
	}
	
	
	public boolean checkPrice() {
		
		
		if(driver.findElements(By.xpath("//div[@class='product-group-box'][1]//strong[@class='real-discounted-price']")).size() == 0) {
			
			priceOnBasket = driver.findElement(By.xpath("//div[@class='product-group-box'][1]//div[@class='total-price']/strong")).getText();
			
		}else {
			
			priceOnBasket = driver.findElement(By.xpath("//div[@class='product-group-box'][1]//strong[@class='real-discounted-price']")).getText();
		}
		 
		
		return priceOnBasket.equals(priceOnPage);
	}
	
	
	public boolean increaseAmount() {
	
		Select amount = new Select(driver.findElement(By.xpath("//div[@class='product-group-box'][1]//select[@class='amount']")));
		amount.selectByVisibleText("2");
		
		return true;
	}
	
	
	public boolean checkAmount(String count) {
		
		
		String amount = driver.findElement(By.xpath("//div[@class='product-group-box'][1]//select[@class='amount']")).getAttribute("value");
		
		return amount.equals(count);
	}
	
	public boolean deleteProduct() {
		
		
		driver.findElement(By.xpath("//div[@class='product-group-box'][1]//a[@title='Sil'][1]")).click();
		
		
		return true;
	}
	
	public boolean checkBasket() {
		
		int count = driver.findElements(By.xpath("//div[@class='product-group-box']")).size();
		
		return count == 0 ? true : false ;
	}
	
	
	
	
	
	
}
