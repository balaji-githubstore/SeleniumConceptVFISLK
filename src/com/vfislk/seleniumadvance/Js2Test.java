package com.vfislk.seleniumadvance;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

//click and type using javascript
public class Js2Test {

	public static void main(String[] args) {
		
		WebDriver driver=new ChromeDriver();	
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		
		driver.get("https://atozgrocery.in/my-account/#content");
		
		driver.findElement(By.id("reg_email")).sendKeys("king");
		
		JavascriptExecutor js=(JavascriptExecutor) driver;
		
		String tooltip= js.executeScript("return document.querySelectorAll('#reg_email')[0].validationMessage").toString();
		System.out.println(tooltip);

	}

}
