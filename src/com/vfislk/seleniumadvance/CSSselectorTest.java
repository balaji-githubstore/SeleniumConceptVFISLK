package com.vfislk.seleniumadvance;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class CSSselectorTest {

	public static void main(String[] args) {
		
		WebDriver driver=new ChromeDriver();	
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		
		driver.get("http://demo.openemr.io/b/openemr/interface/login/login.php?site=default");
				
		driver.findElement(By.cssSelector("#authUser")).sendKeys("admin");
		
		driver.findElement(By.id("clearPass")).sendKeys("pass");
		
		Select selectLanguage=new Select(driver.findElement(By.cssSelector("[name='languageChoice']")));
		selectLanguage.selectByVisibleText("English (Indian)");
		
		driver.findElement(By.cssSelector(".btn-login")).click();

	}

}
