package com.offbd.qa.util;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.commons.compress.archivers.dump.InvalidFormatException;
import org.apache.commons.io.FileUtils;
import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import com.offbd.qa.base.TestBase;

public class TestUtil extends TestBase {
    public static long PAGE_LOAD_TIMEOUT= 20;
    public static long IMPLICT_TIOMOUT =10;
    public static String TEST_DATA_PATH= "C:/Users/RootNext/eclipse-workspace/FreeCRMTest/src/main/java/com/offbd/qa/testdata/offer.xlsx";
   // public static String TEST_DATA_PATH= "user.dir" + "/src/main/java/com/offbd/qa/testdata/offer.xlsx";
    
    
    static Workbook book;
    static Sheet sheet;
    
    
    public static Object[][] getTestData(String sheetname) throws EncryptedDocumentException, IOException{
    	FileInputStream file = null;
    	try {
    		file = new FileInputStream(TEST_DATA_PATH);
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
    	try {
    		book = WorkbookFactory.create(file);
			
		} catch (InvalidFormatException e) {
			e.printStackTrace();
		}
    	sheet =book.getSheet(sheetname);
    	
    	Object [][] data = new Object[sheet.getLastRowNum()][sheet.getRow(0).getLastCellNum()];
    	for(int i=0; i<sheet.getLastRowNum(); i++) {
    		for(int k=0; k<sheet.getRow(0).getLastCellNum(); k++) {
    			data [i][k]=sheet.getRow(i +1).getCell(k).toString();
    		}
    		
    	}
		return data;
    }
    
    public static void takeScreenshotAtEndOfTest() throws IOException {
		File scrFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		String currentDir = System.getProperty("user.dir");
		FileUtils.copyFile(scrFile, new File(currentDir + "/screenshots/" + System.currentTimeMillis() + ".png"));
	}
}

