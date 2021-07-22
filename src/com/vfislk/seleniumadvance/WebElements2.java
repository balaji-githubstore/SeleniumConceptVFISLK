package com.vfislk.seleniumadvance;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class WebElements2 {

	public static void main(String[] args) {
		WebDriver driver=new ChromeDriver();	
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.get("https://www.google.com/");
		
		
		List<WebElement> elements= driver.findElements(By.xpath("//frame"));
		int linkCount=elements.size();
		System.out.println(linkCount);

		for(WebElement ele : elements)
		{
			String text=ele.getText();	
			System.out.println(text);
			
			if(text.equals("Images"))
			{
				ele.click();
				break;
			}
		}
	
		
		
	}
}
