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
public class Js1Test {

	public static void main(String[] args) {
		
		WebDriver driver=new ChromeDriver();	
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		
		driver.get("http://demo.openemr.io/b/openemr/interface/login/login.php?site=default");
		
		JavascriptExecutor js =(JavascriptExecutor) driver;
		
		js.executeScript("document.querySelector('#authUser').value='admin'");	
				
		js.executeScript("arguments[0].value='hello'", driver.findElement(By.id("clearPass")));
		
		Select selectLanguage=new Select(driver.findElement(By.name("languageChoice")));
		selectLanguage.selectByVisibleText("English (Indian)");
		
		js.executeScript("document.querySelector(\"[type='submit']\").click()");
	
//		driver.findElement(By.xpath("//div[text()='Patient/Client']")).click();
		
//		Actions action=new Actions(driver);
//		action.moveToElement(driver.findElement(By.xpath("//div[text()='Patient/Client']"))).perform();
		
		
		WebElement ele1=driver.findElement(By.xpath("//div[text()='Patients']"));
//		WebElement ele2=driver.findElement(By.xpath("//div[text()='Billing Manager']"));
		
		js.executeScript("arguments[0].click();", ele1);
		
		
//		driver.findElement(By.xpath("//div[text()='Patients']")).click();
//		WebElement ele1=driver.findElement(By.xpath("//div[text()='Patients']"));
//		WebElement ele2=driver.findElement(By.xpath("//div[text()='Billing Manager']"));
//		
//		js.executeScript("arguments[0].click();arguments[1].click();", ele1,ele2);
//		js.executeScript("arguments[0].click()", ele2);
		

	}

}
