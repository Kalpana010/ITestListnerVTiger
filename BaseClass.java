package CommonUtils;

import java.io.IOException;

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

public class BaseClass 

{
	WebDriver driver = new ChromeDriver();
	

	PropertyFileUtils putil = new PropertyFileUtils();
	WebDriverUtils wutil = new WebDriverUtils();
          @BeforeSuite
          public  void BS() throws IOException
          {
        	 System.out.println("connect to database");        	  
          }
          @BeforeClass
          public void BC() throws IOException {
          String URL = putil.getDataFromPropertyFile("Url");
  		
    	  wutil.implicitwait(driver);
    	//To launch the application
    		driver.get(URL);
    		
    	 
          }
        	  
        	  
          
         @BeforeMethod()
          public void BM() throws IOException
           {
        	//@before method is used to login to the application
        	 String USERNAME =putil.getDataFromPropertyFile("Username");
        		String PASSWORD = putil.getDataFromPropertyFile("Password");
        		
        		//login to the application
        		driver.findElement(By.name("user_name")).sendKeys(USERNAME);
        		driver.findElement(By.name("user_password")).sendKeys(PASSWORD);
        		driver.findElement(By.id("submitButton")).click();
        		
          }
         @AfterMethod()
         public void AM()
         {
        	 //it is used to signout the application
        	 WebElement signout = driver.findElement(By.cssSelector("img[src='themes/softed/images/user.PNG']"));
        		wutil.mousehover(driver, signout);
        		
        		//Click on Sign out
        		driver.findElement(By.xpath("//a[text()='Sign Out']")).click();
        		
         }
         @AfterClass()
         public void AC()
         
         {
        	//@after class is used to close the browser
        	 driver.quit();
         }
         @AfterSuite()
         public void AS()
         
         {
        	 System.out.println("Disconnect to the data base");
         }
}

