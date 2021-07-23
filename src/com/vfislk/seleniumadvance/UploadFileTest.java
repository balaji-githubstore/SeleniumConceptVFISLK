package com.vfislk.seleniumadvance;

import java.io.File;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class UploadFileTest {

	public static void main(String[] args) {
		
		
		File file=new File("file/Profile.docx");
		System.out.println(file.exists());
		String path = file.getAbsolutePath();
		System.out.println(path);
		
		WebDriver driver=new ChromeDriver();	
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.get("https://www.naukri.com/");
		
		//input[@type='file' and @id='file_upload']
		
//		driver.findElement(By.id("file_upload")).sendKeys("D:\\Profile.docx");
		driver.findElement(By.id("file_upload")).sendKeys(path);
	}
}
