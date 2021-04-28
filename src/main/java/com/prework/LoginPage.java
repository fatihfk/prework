package com.prework;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.By;

public class LoginPage {

	private String loginUrl = "https://www.gittigidiyor.com/uye-girisi";
	private WebDriver driver;
	
	public LoginPage(WebDriver driver){
		
		this.driver = driver;
	}
	
	public int login( String mail, String password) throws InterruptedException {
		
		driver.navigate().to(loginUrl);
		driver.findElement(By.id("L-UserNameField")).sendKeys(mail);
		driver.findElement(By.id("L-PasswordField")).sendKeys(password);
		driver.findElement(By.id("gg-login-enter")).click(); 
		
	
		return driver.findElements(By.xpath("//*[text() ='fatihkazan941087']")).size(); //check user info
	}
	
}
