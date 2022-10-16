package application;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.text.ParseException;

import org.apache.poi.hssf.usermodel.HSSFFont;
import org.apache.poi.hssf.usermodel.HSSFRichTextString;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.Font;
import org.apache.poi.ss.usermodel.RichTextString;
import org.apache.poi.ss.util.CellRangeAddress;

import javafx.event.ActionEvent;

public class DateInput extends Controller{
	
	public void dateInput(int getDateDay, int getDateYear, String getDateMonth) {
		try {
			
			FileInputStream fsIP= new FileInputStream(new File("C:\\Users\\ACER\\Desktop\\Online class\\2nd sem\\COE102.2\\Eclipse\\GUI orig\\FDTR-Form.xls")); //Read the spreadsheet that needs to be updated
		    
		    HSSFWorkbook wb = new HSSFWorkbook(fsIP); //Access the workbook
		      
		    HSSFSheet worksheet = wb.getSheetAt(0); //Access the worksheet, so that we can update / modify it.
		    
       
		    
		    //	Date Top
		    Cell cellfullDate1 = null; // declare a Cell object
		    cellfullDate1 = worksheet.getRow(6).getCell(0);   // Access the second cell in second row to update the value
		    cellfullDate1.setCellValue("For the month of " + getDateMonth + " " + getDateYear);  // Get current cell value value and overwrite the value
		   
		    //	Date bottom	    
		    Cell cellfullDate2 = null; // declare a Cell object
		    cellfullDate2 = worksheet.getRow(108).getCell(0);   // Access the second cell in second row to update the value
		    cellfullDate2.setCellValue("of Technology during the month of " + getDateMonth + " " + getDateYear);  // Get current cell value value and overwrite the value
		    CellStyle style = wb.createCellStyle();
		   
		    fsIP.close(); //Close the InputStream
		     
		    FileOutputStream output_file = new FileOutputStream(new File("C:\\Users\\ACER\\Desktop\\Online class\\2nd sem\\COE102.2\\Eclipse\\GUI orig\\FDTR-Form.xls"));  //Open FileOutputStream to write updates
		      
		    wb.write(output_file); //write changes
		      
		    output_file.close();  //close the stream 
		
		} catch (Exception e1) {
			System.out.println(e1);
		}
		
	}

	public void clearInput1(int getDateDay, int getDateYear, String getDateMonth, int rowindex, int i) throws ParseException {	
		TimeInput time = new TimeInput(getDateDay, getDateYear, getDateMonth);
		Object getDayOfWeek = time.getDayOfWeek(i);
		System.out.println(getDayOfWeek + " " + i);
		
		unmergeCell();
		
		if(getDayOfWeek.equals("Saturday")) {
			
			try {
				
				FileInputStream fsIP= new FileInputStream(new File("C:\\Users\\ACER\\Desktop\\Online class\\2nd sem\\COE102.2\\Eclipse\\GUI orig\\FDTR-Form.xls")); //Read the spreadsheet that needs to be updated
			    
			    HSSFWorkbook wb = new HSSFWorkbook(fsIP); //Access the workbook
			      
			    HSSFSheet worksheet = wb.getSheetAt(0); //Access the worksheet, so that we can update / modify it. 
	       
			    
			    //	Day
			    Cell cellfullDate1 = null; // declare a Cell object
			   
			    //	Time In cell value
			    for(int j = 0; j < 12; j++) {
			    	Cell rmvcontent = null; // declare a Cell object
			    	rmvcontent = worksheet.getRow(13 + rowindex).getCell(2+j);   
			    	rmvcontent.setCellValue(" ");  // Get current cell value value and overwrite the value
			    }
			    for(int j = 0; j < 13; j++) {
			    	Cell rmvcontent = null; // declare a Cell object
			    	rmvcontent = worksheet.getRow(14 + rowindex).getCell(1+j);   
			    	rmvcontent.setCellValue(" ");  // Get current cell value value and overwrite the value
			    }
			    for(int j = 0; j < 13; j++) {
			    	Cell rmvcontent = null; // declare a Cell object
			    	rmvcontent = worksheet.getRow(15 + rowindex).getCell(1+j);   
			    	rmvcontent.setCellValue(" ");  // Get current cell value value and overwrite the value
			    }
			    
//			    cellfullDate1 = worksheet.getRow(13 + rowindex).getCell(1);   // Access the second cell in second row to update the value
//			    cellfullDate1.setCellValue("SATURDAY");  // Get current cell value value and overwrite the value
//			    
//			    worksheet.addMergedRegion(new CellRangeAddress(
//			    		13 + rowindex, //first row (0-based)
//			    		13 + rowindex, //last row  (0-based)
//			            1, //first column (0-based)
//			            2  //last column  (0-based)
//			    ));
			    
			    fsIP.close(); //Close the InputStream
			     
			    FileOutputStream output_file = new FileOutputStream(new File("C:\\Users\\ACER\\Desktop\\Online class\\2nd sem\\COE102.2\\Eclipse\\GUI orig\\FDTR-Form.xls"));  //Open FileOutputStream to write updates
			      
			    wb.write(output_file); //write changes
			      
			    output_file.close();  //close the stream 
			
			} catch (Exception e1) {
				System.out.println(e1);
			}
			
		}
		else if(getDayOfWeek.equals("Sunday")) {
			
			try {
				
				FileInputStream fsIP= new FileInputStream(new File("C:\\Users\\ACER\\Desktop\\Online class\\2nd sem\\COE102.2\\Eclipse\\GUI orig\\FDTR-Form.xls")); //Read the spreadsheet that needs to be updated
			    
			    HSSFWorkbook wb = new HSSFWorkbook(fsIP); //Access the workbook
			      
			    HSSFSheet worksheet = wb.getSheetAt(0); //Access the worksheet, so that we can update / modify it. 
	       
			    
			    //	Day
			    Cell cellfullDate1 = null; // declare a Cell object
			    cellfullDate1 = worksheet.getRow(13 + rowindex).getCell(1);   // Access the second cell in second row to update the value
			    cellfullDate1.setCellValue("SUNDAY");  // Get current cell value value and overwrite the value
			    
			    //	Time In cell value
			    for(int j = 0; j < 12; j++) {
			    	Cell rmvcontent = null; // declare a Cell object
			    	rmvcontent = worksheet.getRow(13 + rowindex).getCell(2+j);   
			    	rmvcontent.setCellValue(" ");  // Get current cell value value and overwrite the value
			    }
			    for(int j = 0; j < 13; j++) {
			    	Cell rmvcontent = null; // declare a Cell object
			    	rmvcontent = worksheet.getRow(14 + rowindex).getCell(1+j);   
			    	rmvcontent.setCellValue(" ");  // Get current cell value value and overwrite the value
			    }
			    for(int j = 0; j < 13; j++) {
			    	Cell rmvcontent = null; // declare a Cell object
			    	rmvcontent = worksheet.getRow(15 + rowindex).getCell(1+j);   
			    	rmvcontent.setCellValue(" ");  // Get current cell value value and overwrite the value
			    }
			  
			   
			    fsIP.close(); //Close the InputStream
			     
			    FileOutputStream output_file = new FileOutputStream(new File("C:\\Users\\ACER\\Desktop\\Online class\\2nd sem\\COE102.2\\Eclipse\\GUI orig\\FDTR-Form.xls"));  //Open FileOutputStream to write updates
			      
			    wb.write(output_file); //write changes
			      
			    output_file.close();  //close the stream 
			
			} catch (Exception e1) {
				System.out.println(e1);
			}
			
		
		}else{
			
			try {
				
				FileInputStream fsIP= new FileInputStream(new File("C:\\Users\\ACER\\Desktop\\Online class\\2nd sem\\COE102.2\\Eclipse\\GUI orig\\FDTR-Form.xls")); //Read the spreadsheet that needs to be updated
			    
			    HSSFWorkbook wb = new HSSFWorkbook(fsIP); //Access the workbook
			      
			    HSSFSheet worksheet = wb.getSheetAt(0); //Access the worksheet, so that we can update / modify it. 
	       
			    
			    //	Day
			    for(int k = 0; k < 3; k++) {
				    for(int j = 0; j < 13; j++) {
					    Cell cellfullDate1 = null; // declare a Cell object
					    cellfullDate1 = worksheet.getRow(k + 13 + rowindex).getCell(1+j);   // Access the second cell in second row to update the value
					    cellfullDate1.setCellValue(" ");  // Get current cell value value and overwrite the value
				    }
			    }
			   
			    fsIP.close(); //Close the InputStream
			     
			    FileOutputStream output_file = new FileOutputStream(new File("C:\\Users\\ACER\\Desktop\\Online class\\2nd sem\\COE102.2\\Eclipse\\GUI orig\\FDTR-Form.xls"));  //Open FileOutputStream to write updates
			      
			    wb.write(output_file); //write changes
			      
			    output_file.close();  //close the stream 
			
			} catch (Exception e1) {
				System.out.println(e1);
			}


		}
		
	}
	
	public void clearInput2(int getDateDay, int getDateYear, String getDateMonth, int rowindex, int i) throws ParseException {	
		TimeInput time = new TimeInput(getDateDay, getDateYear, getDateMonth);
		Object getDayOfWeek = time.getDayOfWeek(i);
		System.out.println(getDayOfWeek + " " + (i));
		
		if(getDayOfWeek.equals("Saturday")) {
			
			try {
				
				FileInputStream fsIP= new FileInputStream(new File("C:\\Users\\ACER\\Desktop\\Online class\\2nd sem\\COE102.2\\Eclipse\\GUI orig\\FDTR-Form.xls")); //Read the spreadsheet that needs to be updated
			    
			    HSSFWorkbook wb = new HSSFWorkbook(fsIP); //Access the workbook
			      
			    HSSFSheet worksheet = wb.getSheetAt(0); //Access the worksheet, so that we can update / modify it. 
	       
			    
			    //	Day
			    Cell cellfullDate1 = null; // declare a Cell object
			    cellfullDate1 = worksheet.getRow(62 + rowindex).getCell(1);   // Access the second cell in second row to update the value
			    cellfullDate1.setCellValue("SATURDAY");  // Get current cell value value and overwrite the value
			    
//			    worksheet.addMergedRegion(new CellRangeAddress(
//			    		62 + rowindex, //first row (0-based)
//			    		62 + rowindex, //last row  (0-based)
//			            1, //first column (0-based)
//			            2  //last column  (0-based)
//			    ));
			   
			    //	Time In cell value
			    for(int j = 0; j < 12; j++) {
			    	Cell rmvcontent = null; // declare a Cell object
			    	rmvcontent = worksheet.getRow(62 + rowindex).getCell(2+j);   
			    	rmvcontent.setCellValue(" ");  // Get current cell value value and overwrite the value
			    }
			    for(int j = 0; j < 13; j++) {
			    	Cell rmvcontent = null; // declare a Cell object
			    	rmvcontent = worksheet.getRow(63 + rowindex).getCell(1+j);   
			    	rmvcontent.setCellValue(" ");  // Get current cell value value and overwrite the value
			    }
			    if(rowindex < 43) {
				    for(int j = 0; j < 13; j++) {
				    	Cell rmvcontent = null; // declare a Cell object
				    	rmvcontent = worksheet.getRow(64 + rowindex).getCell(1+j);   
				    	rmvcontent.setCellValue(" ");  // Get current cell value value and overwrite the value
				    }
			    }
			    
			    fsIP.close(); //Close the InputStream
			     
			    FileOutputStream output_file = new FileOutputStream(new File("C:\\Users\\ACER\\Desktop\\Online class\\2nd sem\\COE102.2\\Eclipse\\GUI orig\\FDTR-Form.xls"));  //Open FileOutputStream to write updates
			      
			    wb.write(output_file); //write changes
			      
			    output_file.close();  //close the stream 
			
			} catch (Exception e1) {
				System.out.println(e1);
			}
			
		}
		else if(getDayOfWeek.equals("Sunday")) {
			
			try {
				
				FileInputStream fsIP= new FileInputStream(new File("C:\\Users\\ACER\\Desktop\\Online class\\2nd sem\\COE102.2\\Eclipse\\GUI orig\\FDTR-Form.xls")); //Read the spreadsheet that needs to be updated
			    
			    HSSFWorkbook wb = new HSSFWorkbook(fsIP); //Access the workbook
			      
			    HSSFSheet worksheet = wb.getSheetAt(0); //Access the worksheet, so that we can update / modify it. 
	       
			    
			    //	Day
			    Cell cellfullDate1 = null; // declare a Cell object
			    cellfullDate1 = worksheet.getRow(62 + rowindex).getCell(1);   // Access the second cell in second row to update the value
			    cellfullDate1.setCellValue("SUNDAY");  // Get current cell value value and overwrite the value
			   
			    //	Time In cell value
			    for(int j = 0; j < 12; j++) {
			    	Cell rmvcontent = null; // declare a Cell object
			    	rmvcontent = worksheet.getRow(62 + rowindex).getCell(2+j);   
			    	rmvcontent.setCellValue(" ");  // Get current cell value value and overwrite the value
			    }
			    for(int j = 0; j < 13; j++) {
			    	Cell rmvcontent = null; // declare a Cell object
			    	rmvcontent = worksheet.getRow(63 + rowindex).getCell(1+j);   
			    	rmvcontent.setCellValue(" ");  // Get current cell value value and overwrite the value
			    }
			    if(rowindex < 43) {
				    for(int j = 0; j < 13; j++) {
				    	Cell rmvcontent = null; // declare a Cell object
				    	rmvcontent = worksheet.getRow(64 + rowindex).getCell(1+j);   
				    	rmvcontent.setCellValue(" ");  // Get current cell value value and overwrite the value
				    	}
			    }
			  
			   
			    fsIP.close(); //Close the InputStream
			     
			    FileOutputStream output_file = new FileOutputStream(new File("C:\\Users\\ACER\\Desktop\\Online class\\2nd sem\\COE102.2\\Eclipse\\GUI orig\\FDTR-Form.xls"));  //Open FileOutputStream to write updates
			      
			    wb.write(output_file); //write changes
			      
			    output_file.close();  //close the stream 
			
			} catch (Exception e1) {
				System.out.println(e1);
			}
			
		}else{
			
			try {
				
				FileInputStream fsIP= new FileInputStream(new File("C:\\Users\\ACER\\Desktop\\Online class\\2nd sem\\COE102.2\\Eclipse\\GUI orig\\FDTR-Form.xls")); //Read the spreadsheet that needs to be updated
			    
			    HSSFWorkbook wb = new HSSFWorkbook(fsIP); //Access the workbook
			      
			    HSSFSheet worksheet = wb.getSheetAt(0); //Access the worksheet, so that we can update / modify it. 
	       
			    
			    //	Day
			    if(rowindex < 43) {
				    for(int k = 0; k < 3; k++) {
				    	for(int j = 0; j < 13; j++) {
				    		Cell cellfullDate1 = null; // declare a Cell object
							cellfullDate1 = worksheet.getRow(k + 62 + rowindex).getCell(1+j);   // Access the second cell in second row to update the value
							cellfullDate1.setCellValue(" ");  // Get current cell value value and overwrite the value
				    	}
				    }
			    }else{
			    	for(int k = 0; k < 2; k++) {
				    	for(int j = 0; j < 13; j++) {
				    		Cell cellfullDate1 = null; // declare a Cell object
							cellfullDate1 = worksheet.getRow(k + 62 + rowindex).getCell(1+j);   // Access the second cell in second row to update the value
							cellfullDate1.setCellValue(" ");  // Get current cell value value and overwrite the value
				    	}
			    	}
			    }
			   
			    fsIP.close(); //Close the InputStream
			     
			    FileOutputStream output_file = new FileOutputStream(new File("C:\\Users\\ACER\\Desktop\\Online class\\2nd sem\\COE102.2\\Eclipse\\GUI orig\\FDTR-Form.xls"));  //Open FileOutputStream to write updates
			      
			    wb.write(output_file); //write changes
			      
			    output_file.close();  //close the stream 
			
			} catch (Exception e1) {
				System.out.println(e1);
			}
		}

	}
	
	public void unmergeCell() {
		try {

			FileInputStream fsIP= new FileInputStream(new File("C:\\Users\\ACER\\Desktop\\Online class\\2nd sem\\COE102.2\\Eclipse\\GUI orig\\FDTR-Form.xls")); //Read the spreadsheet that needs to be updated

			HSSFWorkbook wb = new HSSFWorkbook(fsIP); //Access the workbook

			HSSFSheet sheet = wb.getSheetAt(0); //Access the worksheet, so that we can update / modify it. 

			while (sheet.getNumMergedRegions() > 0) {
				System.out.println("Number of merged regions = " + sheet.getNumMergedRegions());
				for (int i = 0; i < sheet.getNumMergedRegions(); i++) {
					System.out.println("Removing merged region " + (i + 1));
					sheet.removeMergedRegion(i);
				}
			}


			fsIP.close(); //Close the InputStream

			FileOutputStream output_file = new FileOutputStream(new File("C:\\Users\\ACER\\Desktop\\Online class\\2nd sem\\COE102.2\\Eclipse\\GUI orig\\FDTR-Form.xls"));  //Open FileOutputStream to write updates

			wb.write(output_file); //write changes

			output_file.close();  //close the stream 

		} catch (Exception e1) {
			System.out.println(e1);
		}
	}
}
