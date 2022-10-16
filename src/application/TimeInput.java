package application;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.GregorianCalendar;

import org.apache.poi.hssf.usermodel.HSSFFormulaEvaluator;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.util.CellRangeAddress;


public class TimeInput extends Controller {

	private int dateDay;
	private int dateYear;
	private String dateMonth;

	public TimeInput(int dateDay, int dateYear, String dateMonth) {
		super();
		this.dateDay = dateDay;
		this.dateYear = dateYear;
		this.dateMonth = dateMonth;
	}

	public void timeInput(String workType, String getTimeIn, String getTimeOut, float totalHrs, int getRow) throws ParseException {
		
		Object getDayOfWeek = getDayOfWeek(dateDay);
	
		if(workType == "HOLIDAY" || workType == "ACADEMIC BREAK") {
			System.out.println("Weekend: " + getDayOfWeek);
		}else{
			
			System.out.println("Not weekend: " + getDayOfWeek);
			
			if("Class" == workType) {
				try {
					
					FileInputStream fsIP= new FileInputStream(new File("C:\\Users\\ACER\\Desktop\\Online class\\2nd sem\\COE102.2\\Eclipse\\GUI orig\\FDTR-Form.xls")); //Read the spreadsheet that needs to be updated
				    
				    HSSFWorkbook wb = new HSSFWorkbook(fsIP); //Access the workbook
				      
				    HSSFSheet worksheet = wb.getSheetAt(0); //Access the worksheet, so that we can update / modify it. 
		       
				    
				    // Time in	
				    System.out.println("Time in");
				    Cell timeIn = null; // declare a Cell object
				    timeIn = worksheet.getRow(getRow).getCell(1);   
				    timeIn.setCellValue(getTimeIn);
				    // Time out	
				    System.out.println("Time Out");
				    Cell timeOut = null; // declare a Cell object
				    timeOut = worksheet.getRow(getRow).getCell(2);   
				    timeOut.setCellValue(getTimeOut);
				    // Total Hours
				    System.out.println("Time total: " + totalHrs);
				    Cell totalHours = null; // declare a Cell object
				    totalHours = worksheet.getRow(getRow).getCell(3);   
				    totalHours.setCellValue(totalHrs);
				   

				    fsIP.close(); //Close the InputStream
				     
				    FileOutputStream output_file = new FileOutputStream(new File("C:\\Users\\ACER\\Desktop\\Online class\\2nd sem\\COE102.2\\Eclipse\\GUI orig\\FDTR-Form.xls"));  //Open FileOutputStream to write updates
				      
				    wb.write(output_file); //write changes
				      
				    output_file.close();  //close the stream 
				
				} catch (Exception e1) {
					System.out.println(e1);
				}
	
			}else if("Consultation" == workType) {
				try {
					
					FileInputStream fsIP= new FileInputStream(new File("C:\\Users\\ACER\\Desktop\\Online class\\2nd sem\\COE102.2\\Eclipse\\GUI orig\\FDTR-Form.xls")); //Read the spreadsheet that needs to be updated
				    
				    HSSFWorkbook wb = new HSSFWorkbook(fsIP); //Access the workbook
				      
				    HSSFSheet worksheet = wb.getSheetAt(0); //Access the worksheet, so that we can update / modify it. 
		       
				    
				    // Time in	
				    System.out.println("Time in");
				    Cell timeIn = null; // declare a Cell object
				    timeIn = worksheet.getRow(getRow).getCell(4);   
				    timeIn.setCellValue(getTimeIn);
				    // Time out	
				    System.out.println("Time Out");
				    Cell timeOut = null; // declare a Cell object
				    timeOut = worksheet.getRow(getRow).getCell(5);   
				    timeOut.setCellValue(getTimeOut);
				    // Total Hours
				    System.out.println("Time total: " + totalHrs);
				    Cell totalHours = null; // declare a Cell object
				    totalHours = worksheet.getRow(getRow).getCell(6);   
				    totalHours.setCellValue(totalHrs);
				   

				    fsIP.close(); //Close the InputStream
				     
				    FileOutputStream output_file = new FileOutputStream(new File("C:\\Users\\ACER\\Desktop\\Online class\\2nd sem\\COE102.2\\Eclipse\\GUI orig\\FDTR-Form.xls"));  //Open FileOutputStream to write updates
				      
				    wb.write(output_file); //write changes
				      
				    output_file.close();  //close the stream 
				
				} catch (Exception e1) {
					System.out.println(e1);
				}
	
			}else if("Related Activities" == workType) {
				try {
					
					FileInputStream fsIP= new FileInputStream(new File("C:\\Users\\ACER\\Desktop\\Online class\\2nd sem\\COE102.2\\Eclipse\\GUI orig\\FDTR-Form.xls")); //Read the spreadsheet that needs to be updated
				    
				    HSSFWorkbook wb = new HSSFWorkbook(fsIP); //Access the workbook
				      
				    HSSFSheet worksheet = wb.getSheetAt(0); //Access the worksheet, so that we can update / modify it. 
		       
				    
				    // Time in	
				    System.out.println("Time in");
				    Cell timeIn = null; // declare a Cell object
				    timeIn = worksheet.getRow(getRow).getCell(7);   
				    timeIn.setCellValue(getTimeIn);
				    // Time out	
				    System.out.println("Time Out");
				    Cell timeOut = null; // declare a Cell object
				    timeOut = worksheet.getRow(getRow).getCell(8);   
				    timeOut.setCellValue(getTimeOut);
				    // Total Hours
				    System.out.println("Time total: " + totalHrs);
				    Cell totalHours = null; // declare a Cell object
				    totalHours = worksheet.getRow(getRow).getCell(9);   
				    totalHours.setCellValue(totalHrs);

				    fsIP.close(); //Close the InputStream
				     
				    FileOutputStream output_file = new FileOutputStream(new File("C:\\Users\\ACER\\Desktop\\Online class\\2nd sem\\COE102.2\\Eclipse\\GUI orig\\FDTR-Form.xls"));  //Open FileOutputStream to write updates
				      
				    wb.write(output_file); //write changes
				      
				    output_file.close();  //close the stream 
				
				} catch (Exception e1) {
					System.out.println(e1);
				}
			}else if("Others (Admin. or Research)" == workType) {
				try {
					
					FileInputStream fsIP= new FileInputStream(new File("C:\\Users\\ACER\\Desktop\\Online class\\2nd sem\\COE102.2\\Eclipse\\GUI orig\\FDTR-Form.xls")); //Read the spreadsheet that needs to be updated
				    
				    HSSFWorkbook wb = new HSSFWorkbook(fsIP); //Access the workbook
				      
				    HSSFSheet worksheet = wb.getSheetAt(0); //Access the worksheet, so that we can update / modify it. 
		       
				    
				    // Time in	
				    System.out.println("Time in");
				    Cell timeIn = null; // declare a Cell object
				    timeIn = worksheet.getRow(getRow).getCell(10);   
				    timeIn.setCellValue(getTimeIn);
				    // Time out	
				    System.out.println("Time Out");
				    Cell timeOut = null; // declare a Cell object
				    timeOut = worksheet.getRow(getRow).getCell(11);   
				    timeOut.setCellValue(getTimeOut);
				    // Total Hours
				    System.out.println("Time total: " + totalHrs);
				    Cell totalHours = null; // declare a Cell object
				    totalHours = worksheet.getRow(getRow).getCell(12);   
				    totalHours.setCellValue(totalHrs);
				   

				    fsIP.close(); //Close the InputStream
				     
				    FileOutputStream output_file = new FileOutputStream(new File("C:\\Users\\ACER\\Desktop\\Online class\\2nd sem\\COE102.2\\Eclipse\\GUI orig\\FDTR-Form.xls"));  //Open FileOutputStream to write updates
				      
				    wb.write(output_file); //write changes
				      
				    output_file.close();  //close the stream 
				
				} catch (Exception e1) {
					System.out.println(e1);
				}
			}
		}
	}
	
	public void specialInput(String workType, int getRow) throws ParseException {
		Object getDayOfWeek = getDayOfWeek(dateDay);
		if(getDayOfWeek.equals("Saturday") || getDayOfWeek.equals("Sunday")) {
			
		}else {
			if(workType == "ACADEMIC BREAK") {
				try {
					
					FileInputStream fsIP= new FileInputStream(new File("C:\\Users\\ACER\\Desktop\\Online class\\2nd sem\\COE102.2\\Eclipse\\GUI orig\\FDTR-Form.xls")); //Read the spreadsheet that needs to be updated
				    
				    HSSFWorkbook wb = new HSSFWorkbook(fsIP); //Access the workbook
				      
				    HSSFSheet worksheet = wb.getSheetAt(0); //Access the worksheet, so that we can update / modify it. 
		       
				    
				    //	Day
				    Cell cellfullDate1 = null; // declare a Cell object
				    cellfullDate1 = worksheet.getRow(getRow).getCell(1);   // Access the second cell in second row to update the value
				    cellfullDate1.setCellValue("ACADEMIC BREAK");  // Get current cell value value and overwrite the value
				    
				    worksheet.addMergedRegion(new CellRangeAddress(
				            getRow, //first row (0-based)
				            getRow, //last row  (0-based)
				            1, //first column (0-based)
				            2  //last column  (0-based)
				    ));
				    
				    fsIP.close(); //Close the InputStream
				     
				    FileOutputStream output_file = new FileOutputStream(new File("C:\\Users\\ACER\\Desktop\\Online class\\2nd sem\\COE102.2\\Eclipse\\GUI orig\\FDTR-Form.xls"));  //Open FileOutputStream to write updates
				      
				    wb.write(output_file); //write changes
				      
				    output_file.close();  //close the stream 
		
				} catch (Exception e1) {
					System.out.println(e1);
				} 
			}else if(workType == "HOLIDAY") {
				try {
					
					FileInputStream fsIP= new FileInputStream(new File("C:\\Users\\ACER\\Desktop\\Online class\\2nd sem\\COE102.2\\Eclipse\\GUI orig\\FDTR-Form.xls")); //Read the spreadsheet that needs to be updated
				    
				    HSSFWorkbook wb = new HSSFWorkbook(fsIP); //Access the workbook
				      
				    HSSFSheet worksheet = wb.getSheetAt(0); //Access the worksheet, so that we can update / modify it. 
		       
				    
				    //	Day
				    Cell cellfullDate1 = null; // declare a Cell object
				    cellfullDate1 = worksheet.getRow(getRow).getCell(1);   // Access the second cell in second row to update the value
				    cellfullDate1.setCellValue("HOLIDAY");  // Get current cell value value and overwrite the value
				    
				    worksheet.addMergedRegion(new CellRangeAddress(
				            getRow, //first row (0-based)
				            getRow, //last row  (0-based)
				            1, //first column (0-based)
				            2  //last column  (0-based)
				    ));
				    
				    fsIP.close(); //Close the InputStream
				     
				    FileOutputStream output_file = new FileOutputStream(new File("C:\\Users\\ACER\\Desktop\\Online class\\2nd sem\\COE102.2\\Eclipse\\GUI orig\\FDTR-Form.xls"));  //Open FileOutputStream to write updates
				      
				    wb.write(output_file); //write changes
				      
				    output_file.close();  //close the stream 
		
				} catch (Exception e1) {
					System.out.println(e1);
				}
			}
		}
	}
	
	
	public void grandTotalHrs(int getRow) throws ParseException {
		
		Object getDayOfWeek = getDayOfWeek(dateDay);
		try {

			FileInputStream fsIP= new FileInputStream(new File("C:\\Users\\ACER\\Desktop\\Online class\\2nd sem\\COE102.2\\Eclipse\\GUI orig\\FDTR-Form.xls")); //Read the spreadsheet that needs to be updated

			HSSFWorkbook wb = new HSSFWorkbook(fsIP); //Access the workbook

			HSSFSheet worksheet = wb.getSheetAt(0); //Access the worksheet, so that we can update / modify it. 

			// Grand Total Hours
			Cell grandTotalHours = null; // declare a Cell object
			grandTotalHours = worksheet.getRow(getRow).getCell(13);

			int rowTotal1 = getRow+1;
			int rowTotal2 = getRow+2;
			int rowTotal3 = getRow+3;

			String total = "SUM(D" + rowTotal1 + ", " + "G" + rowTotal1 + ", "+"J" + rowTotal1 + ", " + "M" + rowTotal1 + 
					", D" + rowTotal2 + ", " + "G" + rowTotal2 + ", "+"J" + rowTotal2 + ", " + "M" + rowTotal2 +
					", D" + rowTotal3 + ", " + "G" + rowTotal3 + ", "+"J" + rowTotal3 + ", " + "M" + rowTotal3 +
					")";

			grandTotalHours.setCellFormula(total);

			HSSFFormulaEvaluator formulaEvaluator = wb.getCreationHelper().createFormulaEvaluator();
			formulaEvaluator.evaluate(grandTotalHours);
			HSSFFormulaEvaluator.evaluateAllFormulaCells(wb);

			fsIP.close(); //Close the InputStream

			FileOutputStream output_file = new FileOutputStream(new File("C:\\Users\\ACER\\Desktop\\Online class\\2nd sem\\COE102.2\\Eclipse\\GUI orig\\FDTR-Form.xls"));  //Open FileOutputStream to write updates

			wb.write(output_file); //write changes

			output_file.close();

		} catch (Exception e1) {
			System.out.println(e1);
		}
	}
	
	
	public String getDayOfWeek(int day) throws ParseException{
		
		int year = dateYear;
		int month = 1;
		
		switch(dateMonth){
		case "January":
		    month = 1;
		    break;
		case "February":
			month = 2;
		    break;
		case "March":
			month = 3;
		    break;
		case "April":
			month = 4;
		    break;
		case "May":
			month = 5;
		    break;
		case "June":
			month = 6;
		    break;
		case "July":
			month = 7;
		    break;
		case "August":
			month = 8;
		    break;
		case "September":
			month = 9;
		    break;
		case "October":
			month = 10;
		    break;
		case "November":
			month = 11;
		    break;
		case "Deceber":
			month = 12;
		    break;
		}
		
		Date date= (new GregorianCalendar(year, month-1, day)).getTime();
		SimpleDateFormat f = new SimpleDateFormat("EEEE");
		String dayCurrent=f.format(date);
		
		return dayCurrent;
	}    
}

