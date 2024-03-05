package commonUtils;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.apache.poi.EncryptedDocumentException;


public class PropertyFileUtil {
	
	//public void getDatafromPropertyFil()
	public String getDatafromPropertyFil(String keyname) throws EncryptedDocumentException, IOException {
		
		// FileInputStream fil = new FileInputStream("src\\test\\resources\\data.properties");
		FileInputStream fil = new FileInputStream("src\\test\\resources\\login.properties");
	
		 Properties p = new Properties();
		 
		 p.load(fil);
		 
		 //p.getProperty(keyname);after store in variable
		 String value = p.getProperty(keyname);
		 
		 return value;
		 
	
	}

}
