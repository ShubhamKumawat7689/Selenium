package commonUtils;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;

public class BaseClass {
	
	//public WebDriver d;
	 public static WebDriver d = new ChromeDriver();
	WebDriverUtil wutil = new WebDriverUtil();
	PropertyFileUtil putil = new PropertyFileUtil();
	
	@BeforeSuite
	public void BS() {
		System.out.println("Connect to data base");
	}
	
	@AfterSuite
	public void AS() {
		System.out.println("Disconnect to data base");
	}
	
	
	@BeforeClass
	public void BC() throws  IOException {
		
		//@BEFORE CLASS IS USED TO LAUNCH THE APPLICATION
		String URL = putil.getDatafromPropertyFil("Url");
		
		//TO LAUNCH EMPTY BROWSER
//		WebDriver d = new ChromeDriver();
		wutil.maximize(d);
		
		//TO APPLY IMPLICIT WAIT FOR FINDELEMENT()
		wutil.implicitwait(d);
		
		//TO LAUNCH THE APPLICATION
		d.get(URL);
	}
	

	@AfterClass
	public void AC() {
		//@AfterClass IS USED TO close the browser
		
		d.quit();
		
		
	}
	
	@BeforeMethod
	public void BM() throws  IOException {
		
	
		
		//@BEFOREMETHOD IS USED TO LOGIN TO THE APPLICATION
		String USERNAME = putil.getDatafromPropertyFil("Username");
		String PASSWORD = putil.getDatafromPropertyFil("Password");
		
		//LOGIN TO APPLICATION
		d.findElement(By.name("user_name")).sendKeys(USERNAME);
		d.findElement(By.name("user_password")).sendKeys(PASSWORD);
		d.findElement(By.id("submitButton")).click();
		
	}
	
	@AfterMethod
	public void AM() throws InterruptedException {
		
		Thread.sleep(2000);
		
		//@AfterMethod IS USED TO Sign Out the application
		
		//MOUSEHOVER
		WebElement image = d.findElement(By.cssSelector("img[src='themes/softed/images/user.PNG']"));
		wutil.mousehover(d, image);
		
		d.findElement(By.xpath("//a[text()='Sign Out']")).click();
		
	}
	

}
