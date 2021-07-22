package com.vfislk.openemr;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;



public class AddPatientTest {

	public static void main(String[] args) throws InterruptedException {
		WebDriver driver=new ChromeDriver();	
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		
		driver.get("http://demo.openemr.io/b/openemr/interface/login/login.php?site=default");
				
		driver.findElement(By.id("authUser")).sendKeys("admin");
		driver.findElement(By.id("clearPass")).sendKeys("pass");
		
		Select selectLanguage=new Select(driver.findElement(By.name("languageChoice")));
		selectLanguage.selectByVisibleText("English (Indian)");
		
		driver.findElement(By.xpath("//button[@type='submit']")).click();
	
		
//		driver.findElement(By.xpath("//div[text()='Patient/Client']")).click();
		
		Actions action=new Actions(driver);
		action.moveToElement(driver.findElement(By.xpath("//div[text()='Patient/Client']"))).perform();
		
		driver.findElement(By.xpath("//div[text()='Patients']")).click();
		
//		driver.switchTo().frame("fin");
		driver.switchTo().frame(driver.findElement(By.xpath("//iframe[contains(@src,'dynamic_finder')]")));
		
		driver.findElement(By.xpath("//button[normalize-space()='Add New Patient']")).click();
		
		driver.switchTo().defaultContent();
		
		
		driver.switchTo().frame("pat");
		
		driver.findElement(By.id("form_fname")).sendKeys("Balaji");
		driver.findElement(By.id("form_lname")).sendKeys("Dinakaran");	
		driver.findElement(By.id("form_DOB")).sendKeys("2021-07-22");		
		Select selectGender=new Select(driver.findElement(By.id("form_sex")));
		selectGender.selectByVisibleText("Male");
		driver.findElement(By.id("create")).click();
		
		driver.switchTo().defaultContent();
		
	
		driver.switchTo().frame(driver.findElement(By.xpath("//iframe[@id='modalframe']")));
		
		driver.findElement(By.xpath("//input[@value='Confirm Create New Patient']")).click();
		
		driver.switchTo().defaultContent();
		
		WebDriverWait wait =new WebDriverWait(driver,50);
		wait.until(ExpectedConditions.alertIsPresent());
		
		Alert alert= driver.switchTo().alert();
		String actualAlertText=alert.getText();
		System.out.println(actualAlertText);
		
		alert.accept();
	}
}



