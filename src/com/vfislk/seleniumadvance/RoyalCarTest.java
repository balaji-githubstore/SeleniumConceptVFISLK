package com.vfislk.seleniumadvance;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class RoyalCarTest {

	public static void main(String[] args) {
		
		WebDriver driver=new ChromeDriver();	
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		
		driver.get("https://www.royalcaribbean.com/");
		
		if(driver.findElements(By.xpath("//*[@class='email-capture__close']")).size()>0)
		{
			if(driver.findElement(By.xpath("//*[@class='email-capture__close']")).isDisplayed())
			{
				driver.findElement(By.xpath("//*[@class='email-capture__close']")).click();
			}
		}
		
		//click on sign in
		driver.findElement(By.id("rciHeaderSignIn")).click();
		//click on create an account 
		driver.findElement(By.linkText("Create an account")).click();
		//enter firstname as Dennis
		driver.findElement(By.xpath("//input[@data-placeholder='First name/Given name']")).sendKeys("Dennis");
		//lastname as riche
		driver.findElement(By.xpath("//input[@data-placeholder='Last name/Surname']")).sendKeys("Richie");
		
		//month - april 
		driver.findElement(By.xpath("//span[text()='Month']")).click();
		//span[text()=' December ']
		driver.findElement(By.xpath("//span[normalize-space()='December']")).click();
		
		//day - 30 
		driver.findElement(By.xpath("//span[text()='Day']")).click();
		driver.findElement(By.xpath("//span[normalize-space()='30']")).click();
		
		// year -1992
		driver.findElement(By.xpath("//input[@data-placeholder='Year']")).sendKeys("Richie");
		//country as India
		driver.findElement(By.xpath("//span[text()='Country/Region of residence']")).click();
		
		driver.findElement(By.xpath("//span[normalize-space()='India']")).click();
		
//		driver.findElement(By.xpath("(//span[contains(text(),'India')])[2]")).click();
		//check terms and condition
		driver.findElement(By.xpath("//input[@aria-labelledby='agreements']/..")).click();

	}

}
