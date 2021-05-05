package GlobalBox;

import java.io.File;
import java.io.FileInputStream;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Properties;
public class CommonMethods 
{

	public static String TestRunnerFolderPath;
	
	/***
	 * This method is used for to read the property File
	 * @param pathFile - Property File Location
	 * @param key - Key mentioned in property file
	 * @return Value - It return the value of the key passed in parameter
	 */
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

/**
 * This method get the current date Object and convert it String Format
 * @return currentDateStringFormat - It return Current Date in the format of -dd-MMM-YYYY-hh-mm-s
 */
	public static String getTimeStamp()
	{
		try 
		{
			SimpleDateFormat dateFormat = new SimpleDateFormat("-dd-MMM-hh-mm-ss");
			Date currentDate = new Date();
			String currentDateStringFormat = dateFormat.format(currentDate);
			return currentDateStringFormat;
		}
		catch(Exception e)
		{
			return e.toString();
		}
	}
	
}