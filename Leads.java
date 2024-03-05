package Vtiger;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import commonUtils.ExcelUtil;
import commonUtils.PropertyFileUtil;
import commonUtils.WebDriverUtil;

public class Leads {
	
	PropertyFileUtil putil = new PropertyFileUtil();
	WebDriverUtil wutil = new WebDriverUtil();
	ExcelUtil eutil = new ExcelUtil();
	
	
	@Test
	public void LeadsTest() throws EncryptedDocumentException, IOException {
		
		//TO LAUNCH THE WEB BROWSER
		WebDriver d = new ChromeDriver();
		
		//MAXIMIZE THE WEBPAGE
		wutil.maximize(d);
		
		//TO APPLY IMPLICIT WAIT FOR FINDELEMENT()
		wutil.implicitwait(d);
		

		
		//READ DATA FROM PROPERTIES FILE
		String URL = putil.getDatafromPropertyFil("Url");
		String USERNAME = putil.getDatafromPropertyFil("Username");
		String PASSWORD = putil.getDatafromPropertyFil("Password");
		
		
		
		//TO READ DATA FROM EXCEL
		String FIRSTNAME = eutil.getDataFromExcel("Leads", 0, 1);
		String LASTNAME = eutil.getDataFromExcel("Leads", 1, 1);
		String COMPANY = eutil.getDataFromExcel("Leads", 2, 1);
		String GROUP = eutil.getDataFromExcel("Leads", 3, 1);
		
		//TO LAUNCH THE APPLICATION
		d.get(URL);
		
		
		
		//LOGIN TO APPLICATION
		d.findElement(By.name("user_name")).sendKeys(USERNAME);
		d.findElement(By.name("user_password")).sendKeys(PASSWORD);
		d.findElement(By.id("submitButton")).click();
		
		//TO CLICK ON LEADS
		d.findElement(By.xpath("(//a[text()='Leads'])[1]")).click();
		
		//CLICK ON (+) ICON
		d.findElement(By.cssSelector("img[alt='Create Lead...']")).click();
		
		//ENTER THE FIRSTNAME 
		d.findElement(By.name("firstname")).sendKeys(FIRSTNAME);
		
		//ENTER THE LASTNAME
		d.findElement(By.name("lastname")).sendKeys(LASTNAME);
		
		//ENTER THE COMPANY NAME
		d.findElement(By.name("company")).sendKeys(COMPANY);
		
		//CLICK ON GROUP OF CHECK BOX
		d.findElement(By.xpath("(//input[@name='assigntype'])[2]")).click();
		
		//IN DROPDOWN SELECT TEAM SELLING
		WebElement dropdown = d.findElement(By.name("assigned_group_id"));
		
		wutil.handledropdown(dropdown, GROUP);
		
	}

}
