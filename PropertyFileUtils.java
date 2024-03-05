package CommonUtils;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class PropertyFileUtils
{
	
	public String getDataFromPropertyFile(String keyname) throws IOException 
	{
	
		FileInputStream file = new FileInputStream("src\\test\\resources\\login.properties");
	 
	//step 2 : create object of Properties class
	
	Properties p = new Properties();
	
	//step 3 : load() to the fetch the location of external file
	p.load(file);
	String value = p.getProperty(keyname);
	return value;
	
	

}
}

