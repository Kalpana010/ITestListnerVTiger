package CommonUtils;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.Set;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;




public class WebDriverUtils
{
	
	public WebDriver driver;
	
	public void maximize(WebDriver driver) {
		driver.manage().window().maximize();
	}
	
	public void implicitwait(WebDriver driver) 
	{
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	}
	
	public void handledropdown(WebElement element,String targetedelement) {
		
		Select s = new Select(element);
		s.selectByVisibleText(targetedelement);
	}
	
	public void mousehover(WebDriver driver,WebElement element) {
		
		Actions a = new Actions(driver);
		a.moveToElement(element);
		a.perform();
	}
	public void switchWindow(WebDriver driver,String expectedurl) {
		 Set<String> ids = driver.getWindowHandles();
		 for(String a:ids) 
		 {
			String actualurl = driver.switchTo().window(a).getCurrentUrl();
			if(actualurl.contains(expectedurl))
			{
				break;
				
			}
		 }
	}
		 public File screenShot(WebDriver driver,String ScreenShotName) throws IOException
		 {
			 TakesScreenshot ts=(TakesScreenshot)driver;
			File tempfile = ts.getScreenshotAs(OutputType.FILE);
			File destfile = new File("./Screenshot/"+ScreenShotName+".png");
			FileUtils.copyFile(tempfile, destfile);
			return destfile;
		 }
	}
	
	
