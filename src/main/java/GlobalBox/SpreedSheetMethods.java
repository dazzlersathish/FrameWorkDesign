package GlobalBox;

import java.io.File;
import java.io.FileInputStream;
import java.util.ArrayList;
import java.util.List;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class SpreedSheetMethods 
{
	
	public static List<Integer> getRowNumbers(String scenarioName, String workBookPath, String workBookName
			, String workBookSheetName)
	{
		int rowTestcase = 0;
		
		List<Integer> listofRowNumbers = new ArrayList<Integer>();
		try 
		{
			File fileName = new File(workBookPath+"/"+workBookName);
			FileInputStream fis = new FileInputStream(fileName);
			Workbook inputWorkBook = null;
			String fileExtendion = workBookName.substring(workBookName.indexOf("."));
			if(fileExtendion.equalsIgnoreCase(".xls"))
			{
				inputWorkBook = new HSSFWorkbook(fis);
			}
			else if(fileExtendion.equalsIgnoreCase(".xlsx"))
			{
				inputWorkBook = new XSSFWorkbook(fis);
			} 
			Sheet sheet = inputWorkBook.getSheet(workBookSheetName);
			
			int rowNum = sheet.getLastRowNum()+1;
			
			for (int i=1; i < rowNum; i++)
			{
				if(sheet.getRow(i)!= null)
				{
					Row row = sheet.getRow(i);
					int j=0;
					Cell cell;
					if(row.getCell(j)!= null)
					{
						cell = row.getCell(j);
						
						String value = cell.toString();
						
						if(!value.isEmpty() && value.trim().equalsIgnoreCase(scenarioName.trim()))
							{
								rowTestcase = row.getRowNum();
								listofRowNumbers.add(rowTestcase);
							}
					}
				}
			}
			inputWorkBook.close();
			fis.close();
			return listofRowNumbers;
		}
		catch (Exception e) {
			e.printStackTrace();
			return listofRowNumbers;
		}
		
		
		
		
	}

}
