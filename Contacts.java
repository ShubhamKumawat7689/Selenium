package Vtiger;

import java.io.IOException;
import java.util.Set;

import org.apache.poi.EncryptedDocumentException;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import commonUtils.ExcelUtil;
import commonUtils.ListenerImpementation;
import commonUtils.PropertyFileUtil;
import commonUtils.WebDriverUtil;

@Listeners(ListenerImpementation.class)
public class Contacts {
	
	WebDriverUtil wutil = new WebDriverUtil();
	PropertyFileUtil putil = new PropertyFileUtil();
	ExcelUtil eutil = new ExcelUtil();
	
	
	@Test
	public void ContactsTest() throws EncryptedDocumentException, IOException, InterruptedException {
		
		//TO LAUNCH EMPTY BROWSER
		WebDriver d = new ChromeDriver();
		wutil.maximize(d);
		
		//TO APPLY IMPLICIT WAIT FOR FINDELEMENT()
		wutil.implicitwait(d);
		
		//TO READ DATA FROM PROPERTY FILE 
				String URL = putil.getDatafromPropertyFil("Url");
				String USERNAME = putil.getDatafromPropertyFil("Username");
				String PASSWORD = putil.getDatafromPropertyFil("Password");
				
				
				
				//TO READ FROM EXCEL FILE
				String FIRSTNAME = eutil.getDataFromExcel("Contacts", 0, 1);
				String LASTNAME = eutil.getDataFromExcel("Contacts", 1, 1);
				String GROUP = eutil.getDataFromExcel("Contacts", 2, 1);
				String ORGNAME = eutil.getDataFromExcel("contacts", 3, 1);
				
				
				//TO LAUNCH THE APPLICATION
				d.get(URL);
				
				//LOGIN TO APPLICATION
				d.findElement(By.name("user_name")).sendKeys(USERNAME);
				d.findElement(By.name("user_password")).sendKeys(PASSWORD);
				d.findElement(By.id("submitButton")).click();
				
				
				//CLICK ON CONTACTS
				d.findElement(By.xpath("//a[text()='Contacts']")).click();
				
				//CLICK ON +ICON
				d.findElement(By.cssSelector("img[alt='Create Contact...']")).click();
				
				//ENTER ORGANIZATION NAME
				//ENETR THE FIRST NAME
				d.findElement(By.name("firstname")).sendKeys(FIRSTNAME);
				
				//ENTER THE LAST NAME
				d.findElement(By.name("lastname")).sendKeys(LASTNAME);
				
				
				
				
				//TO FAIL THE TESTSCRIPT
//				String actual = d.getTitle();
//				String expected=" Administrator - Contacts - vtiger CRM 5 - Commercial Open Source CRM";
//				Assert.assertEquals(actual, expected);
				
				
				
				String actualurl = d.getCurrentUrl();
				String expectedurl = "http://localhost:8888/pune/index.php?module=Contacts&action=EditView&return_action=DetailView&parenttab=Marketing";
				Assert.assertEquals(actualurl, expectedurl);
				
				
				
				
				
				
				
				
				
				
				// CLICK ON GROUP
				d.findElement(By.xpath("(//input[@name='assigntype'])[2]")).click();
				
				//IN DROPDOWN SELECT TEAM SELLING
				WebElement dropdown = d.findElement(By.name("assigned_group_id"));
				
				wutil.handledropdown(dropdown, GROUP);
				
				
				//CLICK ON ORAGANIZATION + ICON
				d.findElement(By.xpath("(//img[@alt='Select'])[1]")).click();
				
//.---------------------.-----------------.------------------.----------------------				
				//TANSFER THE DRIVER CONTROL FROM PARENT WINDOW TO CHILD WINDOW
//				Set<String> ids = d.getWindowHandles();
//				System.out.println(ids);
//				
//				for(String e:ids) {
//					String actualurl = d.switchTo().window(e).getCurrentUrl();
//					System.out.println(actualurl);
//					
//					String childurl = "http://localhost:8888/index.php?module=Accounts&action=Popup&popuptype=specific_contact_account_address&form=TasksEditView&form_submit=false&fromlink=&recordid=";
//					
//					if(actualurl.contains(childurl)) {
//						
//					}
//				}
//..--------------------------------.-------------------.-------------------------				
				
				//TO ENTER CHILD URL
				wutil.switchwindow(d, "http://localhost:8888/index.php?module=Accounts&action=Popup&popuptype=specific_contact_account_address&form=TasksEditView&form_submit=false&fromlink=&recordid=");
				
				//TO ENTER ORGANIZATION NAME IN SEARCH TEXT FIELD
				d.findElement(By.id("search_txt")).sendKeys(ORGNAME);
				
				//TO CLICK ON SEARCH NOW BUTTON
				d.findElement(By.cssSelector("input[name='search']")).click();
				
				//CLICK ON ORGANIZATION NAME
				d.findElement(By.xpath("//a[text()='Wipro']")).click();
				
				
				//TANSFER CONTROL FROM CHILD TO PARENT WINDOW
				wutil.switchwindow(d, "http://localhost:8888/index.php?module=Contacts&action=EditView&return_action=DetailView&parenttab=Marketing");
				
				
				
				//TO CLICK ON SAVE
				d.findElement(By.xpath("(//input[@name='button'])[3]")).click();
				
				
				
				
				
				//TAKESCREEN SHOT ON CONTACTS
				//wutil.screenshot(d, "Contacts");
				
				
				
				
				Thread.sleep(2000);
				
				//MOUSEHOVER
				WebElement mousehover = d.findElement(By.cssSelector("img[src='themes/softed/images/user.PNG']"));
				wutil.mousehover(d, mousehover);
				
				d.findElement(By.xpath("//a[text()='Sign Out']")).click();
				
	}

}
