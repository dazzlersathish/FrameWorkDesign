package GlobalBox;

import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;

public class CommonMethods 
{
	public static String readPropertiesFile(String pathFile,String key)
	{
		String value = "";
		try 
		{
		File file = new File(pathFile);
		FileInputStream fis = new FileInputStream(file);
		Properties properties = new Properties();
		properties.load(fis);		
		fis.close();
		value = properties.getProperty(key);
		return value;
		}
		catch (Exception e) 
		{
			return e.toString();	
		}
	}

}
