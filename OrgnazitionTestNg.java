package Vtiger;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import commonUtils.BaseClass;
import commonUtils.ExcelUtil;
import commonUtils.PropertyFileUtil;
import commonUtils.WebDriverUtil;
import commonUtils.javautil;

public class OrgnazitionTestNg extends BaseClass {
	
//  public WebDriver d;
	
    PropertyFileUtil putil = new PropertyFileUtil();
	
	WebDriverUtil wutil = new WebDriverUtil();
	
	ExcelUtil eutil = new ExcelUtil();
	
	javautil jutil = new javautil();

	@Test
	public void OrganizationTest() throws EncryptedDocumentException, IOException, InterruptedException {
		
		/*WebDriver d = new ChromeDriver();
		wutil.maximize(d);
		wutil.implicitwait(d);*/
		
//	   d.manage().window().maximize();
//		
//		d.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		//TO READ DATA FROM PROPERTY FILE 
		/*String URL = putil.getDatafromPropertyFil("Url");
		String USERNAME = putil.getDatafromPropertyFil("Username");
		String PASSWORD = putil.getDatafromPropertyFil("Password");*/
		
		
		//TO READ FROM EXCEL FILE
		String ORGANAME = eutil.getDataFromExcel("Organization", 0, 1);
		
		String GROUP = eutil.getDataFromExcel("Organization", 1, 1);
		
		
		
		
		//TO LAUNCH THE APPLICATION
		//d.get(URL);
		
		//LOGIN TO APPLICATION
		/*d.findElement(By.name("user_name")).sendKeys(USERNAME);
		d.findElement(By.name("user_password")).sendKeys(PASSWORD);
		d.findElement(By.id("submitButton")).click();*/
		
		//CLICK ON ORGANIZATION
		d.findElement(By.xpath("//a[text()='Organizations']")).click();
		
		//CLICK ON THE +ICON
		d.findElement(By.cssSelector("img[alt='Create Organization...']")).click();
		
		//ENTER ORGANIZATION NAME
//		d.findElement(By.name("accountname")).sendKeys(ORGANAME);
		d.findElement(By.name("accountname")).sendKeys(ORGANAME+jutil.getRandomNumber());
		//d.findElement(By.name("website")).sendKeys("");
		
		//IN ASSIGNED TO CLICK ON GROUP
		d.findElement(By.xpath("(//input[@name='assigntype'])[2]")).click();
		
		//IN THE DROP DOWN SELECT SUPPORT GROUP
		WebElement dropdown = d.findElement(By.name("assigned_group_id"));
//		Select s = new Select(dropdown);
//		s.selectByVisibleText(GROUP);
		
		wutil.handledropdown(dropdown, GROUP);
		
		// TO CLICK ON SAVE BUTTON
		d.findElement(By.xpath("(//input[@name='button'])[3]")).click();
		
		Thread.sleep(2000);
		//MOUSEHOVER ON IMG
	/*	WebElement image = d.findElement(By.cssSelector("img[src='themes/softed/images/user.PNG']"));
		wutil.mousehover(d, image);*/
		
		
//		Actions a = new Actions(d);
//		a.moveToElement(image);
//		a.perform();
		
		
		// CLICK ON SIGNOUT
	/*	d.findElement(By.xpath("//a[text()='Sign Out']")).click();*/
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		

//		d.findElement(By.name("assigned_group_id")).click();
		
		//d.findElement(By.xpath("//option[text()='Support Group']"));
		
		
		
	}
}



