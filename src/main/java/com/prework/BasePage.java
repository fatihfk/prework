package com.prework;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;


public class BasePage {
	
	public WebDriver driver;
	private String url = "https://www.gittigidiyor.com/";
	
	public BasePage() {
		
		System.setProperty("webdriver.chrome.driver", "C:\\chromeDriver\\chromedriver.exe");
		driver = new ChromeDriver(); 
		
	}
	
	
	public boolean openChrome() {	//open base page and check this page exist
		
		driver.navigate().to(url);
		driver.manage().window().maximize();
		return (driver.findElements(By.className("sc-1fjiks5-0") ).size() ) == 0 ? false : true; //check gittiGidiyor logo
		
	}
	
	public void closeChrome() {
		
		driver.close();
	}
	
}
