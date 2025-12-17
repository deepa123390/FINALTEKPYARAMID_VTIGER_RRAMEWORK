package com.generic.fileutilty;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class ExcelUtility {
	public String getDtataFromExcelFile(String sheet,int rowNum,int cellnum) throws EncryptedDocumentException, IOException {
		FileInputStream fis=new FileInputStream("./Testdata/Vtiger_org.xlsx");
		Workbook wb=WorkbookFactory.create(fis);
		 String data=wb.getSheet(sheet).getRow(rowNum).getCell(cellnum).getStringCellValue();
		 wb.close();
		 
	return data;	 
	}
	public int getRowCount(String sheet) throws EncryptedDocumentException, IOException {
		FileInputStream fis=new FileInputStream("./Testdata/Vtiger_org.xlsx");
		Workbook wb=WorkbookFactory.create(fis);
		 int data=wb.getSheet(sheet).getLastRowNum();
		 wb.close();
		 
	return data;
	}
	public void setDataIntoExcel(String sheet,int rowNum,int cellnum,String value) throws EncryptedDocumentException, IOException {
		FileInputStream fis=new FileInputStream("./Testdata/Vtiger_org.xlsx");
		Workbook wb=WorkbookFactory.create(fis);
		Row row=wb.getSheet(sheet).getRow(rowNum);
		Cell cel=row.createCell(cellnum);
		cel.setCellValue(value);
		FileOutputStream fos=new FileOutputStream("./Testdata/Vtiger_org.xlsx");
		wb.write(fos);
		
		wb.close();
		
	}

}
