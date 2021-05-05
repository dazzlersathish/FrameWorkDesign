package GlobalBox;


import java.io.File;
import java.io.FileOutputStream;

import org.apache.commons.io.FileUtils;
import org.apache.poi.xwpf.usermodel.XWPFDocument;
import org.apache.poi.xwpf.usermodel.XWPFParagraph;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import com.itextpdf.text.Document;
import com.itextpdf.text.Image;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfWriter;
public class ScreenshotMethod {

	private static XWPFDocument doc;
	
	private static Document document;
	
	public static String screenshotFileName;
	
	public static void initializeScreenshot(String nameDocument) throws Exception
	{
		doc = new XWPFDocument();
		XWPFParagraph p = doc.createParagraph();
		p.createRun();
		document = new Document();
		try
		{
			screenshotFileName = nameDocument;
			PdfWriter.getInstance(document, new FileOutputStream(CommonMethods.TestRunnerFolderPath+"/"+nameDocument+".pdf"));
			document.open();
		}
		catch(Exception e)
		{
			System.out.println(e.toString());
		}
	}
	
	public static void takeScreenshot(WebDriver localdriver,String nameScreenshot, String stepDefinition)
	{
		try
		{
			File testFile1 = ((TakesScreenshot)localdriver).getScreenshotAs(OutputType.FILE);
			FileUtils.copyFile(testFile1, new File(CommonMethods.TestRunnerFolderPath+"/"+ nameScreenshot+".png"));
			
			document.add(new Paragraph(stepDefinition));
			
			Image image1 = Image.getInstance(CommonMethods.TestRunnerFolderPath+"/"+ nameScreenshot+".png");
			image1.scalePercent(100f,70f);
			image1.scaleToFit(500, 600);
			
			document.add(image1);
			document.newPage();
		}
		catch (Exception e)
		{
			System.out.println(e.toString());
		}
	}
	
	public static void finalizeScreenshotDocument() throws Exception
	{
		try 
		{
			document.close();
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
	}
	
}
