package application;

import java.io.*;
import java.text.ParseException;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class Controller {

	//Left Boarder
	@FXML
	private ImageView msulogo;
	@FXML
	private Button confirmDate;
	@FXML
	private Label dateLabel;
	@FXML
	private ComboBox<Integer> dateDay;
	@FXML
	private ComboBox dateMonth;
	@FXML
	private ComboBox<Integer> dateYear;
	private int numberOfDays;
	
	//	Getters
	public int getDateDay() {
		return (Integer) dateDay.getSelectionModel().getSelectedItem();
	}
	
	public String getDateMonth() {
		return dateMonth.getSelectionModel().getSelectedItem().toString();
	}

	public int getDateYear() {
		return (Integer) dateYear.getSelectionModel().getSelectedItem();
	}
	

	//	Methods
	public void setNumberOfDays(int numberOfDays) {
		this.numberOfDays = numberOfDays;
	}

	public int getNumberOfDays() {
		return numberOfDays;
	}

	public void month_numberOfDays() {
		
		if(	
			getDateMonth() == "January" || getDateMonth() == "March" ||
			getDateMonth() == "May" || getDateMonth() == "July" || 
			getDateMonth() == "August" || getDateMonth() == "October" || 
			getDateMonth() == "December" ) {
			
			setNumberOfDays(31);  	
		
		}
		else if(getDateMonth() == "April" || getDateMonth() == "June" || 
				getDateMonth() == "September" || getDateMonth() == "November") {
			
			setNumberOfDays(30);  	
		
		}
		else if(getDateMonth() == "February") {
			if(getDateYear() % 4 == 0) {
				if(getDateYear() % 100 == 0) {
					if(getDateYear() % 400 == 0) {
						setNumberOfDays(29);
					}else {
						setNumberOfDays(28);
					}
				}else{
					setNumberOfDays(29);
				}
			}else{
				setNumberOfDays(28);
			}
		}
		
		Integer[] days = new Integer[getNumberOfDays()];
		for(int i = 1; i <= getNumberOfDays(); i++) {
			days[i-1] = i;
			}
		
		ObservableList<Integer> day_option = FXCollections.observableArrayList();
		day_option.addAll(days);
		dateDay.setItems(day_option);
		
		System.out.println(getNumberOfDays());
		dateLabel.setText(getDateMonth() + " " + getDateDay() + ", "+ getDateYear());
	}
	
	@FXML
	private ComboBox workType;
	public String getWorkType() {
		return workType.getSelectionModel().getSelectedItem().toString();
	}
	@FXML
	private ComboBox hourIn;
	@FXML
	private ComboBox minuteIn;
	@FXML
	private ComboBox hourOut;
	@FXML
	private ComboBox minuteOut;
	@FXML
	private ComboBox ampmIn;
	@FXML
	private ComboBox ampmOut;
	public String getTimeIn() {
		return hourIn.getSelectionModel().getSelectedItem().toString() +
				":" +  minuteIn.getSelectionModel().getSelectedItem().toString() + 
				" " + ampmIn.getSelectionModel().getSelectedItem().toString();
	}
	
	public String getTimeOut() {
		return hourOut.getSelectionModel().getSelectedItem().toString() + 
				":" + minuteOut.getSelectionModel().getSelectedItem().toString() + 
				" " + ampmOut.getSelectionModel().getSelectedItem().toString();
	}
	
	public int getHourIn() {
		return (Integer) hourIn.getSelectionModel().getSelectedItem();
	}
	public int getHourOut() {
		return (Integer) hourOut.getSelectionModel().getSelectedItem();
	}
	public int getMinuteIn() {
		int minute = Integer.parseInt((String) minuteIn.getSelectionModel().getSelectedItem());
		return minute;
	}
	public int getMinuteOut() {
		int minute = Integer.parseInt((String) minuteOut.getSelectionModel().getSelectedItem());
		return minute;
	}
	
	
	public float getTotalHrs() {
		String In = ampmIn.getSelectionModel().getSelectedItem().toString();
		String Out = ampmOut.getSelectionModel().getSelectedItem().toString();
		float minuteIn = getMinuteIn();
		float minuteOut = getMinuteOut();
		float timeIn = (getHourIn() + (minuteIn/60));
		float timeOut = (getHourOut() + (minuteOut/60));
		float totalHours = 0;
		
		System.out.println(timeIn);
		System.out.println(timeOut);
		
		if((In == "AM" && Out == "AM") || (In == "PM" && Out == "PM")) 
			totalHours = timeIn - timeOut;
		if(In == "AM" && Out == "PM") 
			totalHours =(12-timeIn) + timeOut;
		if(In == "AM" && Out == "NN") 
			totalHours = 12-timeIn;
		if(In == "NN" && Out == "PM") 
			totalHours = timeOut;
		else
			System.out.println("hrs not found");
		
		
		return Float.valueOf(String.format("%.1f", Math.abs(totalHours))).floatValue();
	}
	
	

	
	
	public void initialize() {
		
		msulogo.setVisible(true);
		Image image = new Image("file:///C:/Users/ACER/Desktop/Online%20class/2nd%20sem/COE102.2/Eclipse/GUI%20orig/FDTRimage.jpg", 688, 0, false, false);
		
		xlsimage.setImage(image);
		xlsimage.setVisible(true);
		
		Integer[] days = new Integer[31];
		for(int i = 1; i <= 31; i++) {
			days[i-1] = i;
			}

		Integer[] years = new Integer[10];
		int currentYear = 2021;
		for(int i = 0; i < years.length; i++) 
			years[i] = currentYear+i;
		
		Integer[] hours = new Integer[13];
		for(int i = 1; i < hours.length; i++)
			hours[i] = i;

		
		String[] minutes = new String[60];
		for(int i = 0; i < minutes.length; i++) {
			if(i < 10)	{
				minutes[i] = "0" + i;
			}else {
				minutes[i] = Integer.toString(i);
			}
		}
		
		// ComboBox Options
		ObservableList<Integer> day_option = FXCollections.observableArrayList();
		day_option.addAll(days);
		dateDay.setItems(day_option);
		
		ObservableList<String> month_option = FXCollections.
				observableArrayList(
						"January", "February", "March","April", 
						"May", "June", "July", "August", 
						"September", "Octobber", "November", "December"
						);
		dateMonth.setItems(month_option);
		
		ObservableList<Integer> year_option = FXCollections.observableArrayList();
		year_option.addAll(years);
		dateYear.setItems(year_option);
		
		ObservableList<Integer> hour_option = FXCollections.observableArrayList();
		hour_option.addAll(hours);
		
		ObservableList<String> minute_option = FXCollections.observableArrayList();
		minute_option.addAll(minutes);
		
		ObservableList<String> ampm_option = FXCollections.
				observableArrayList("AM", "PM", "NN");
		
		ObservableList<String> work_option = FXCollections.
				observableArrayList("Class", 
						"Consultation", 
						"Related Activities",
			            "Others (Admin. or Research)",
			            "HOLIDAY",
			            "ACADEMIC BREAK"
						);
		
		ObservableList<String> dept_option = FXCollections.
				observableArrayList( 
						"MMT", 
	        			"DCHET", 
	        			"DCHET",
	                    "EECE", 
	                    "DMT"
	                    );
		
		workType.setItems(work_option);
		ampmIn.setItems(ampm_option);
		ampmOut.setItems(ampm_option);
		hourIn.setItems(hour_option);
		hourOut.setItems(hour_option);
		minuteIn.setItems(minute_option);
		minuteOut.setItems(minute_option);
		deptName.setItems(dept_option);
	}
	
	@FXML
	private Button holidayButton;
	public void addholidayButton(ActionEvent e) {
		System.out.println("Holiday");
	}
	@FXML
	private Button removeButton;
	public void removeSched() {
		
	}
	
	
	
	// Top Boarder
	@FXML
	private TextField fullName;
	@FXML
	private TextField headName;
	@FXML
	private ComboBox deptName;
	@FXML
	private Button confirmButton;
	private int day;
	
	
	
	public String getFullName() {
		return fullName.getText();
	}

	public void setFullName(TextField fullName) {
		this.fullName = fullName;
	}

	public String getHeadName() {
		return headName.getText();
	}

	public void setHeadName(TextField headName) {
		this.headName = headName;
	}

	public String getDeptName() {
		return (String) deptName.getSelectionModel().getSelectedItem();
	}

	public void setDeptName(ComboBox deptName) {
		this.deptName = deptName;
	}
	


	public void confirmButton(ActionEvent e) {

		try {
			
			FileInputStream fsIP= new FileInputStream(new File("C:\\Users\\ACER\\Desktop\\Online class\\2nd sem\\COE102.2\\Eclipse\\GUI orig\\FDTR-Form.xls")); //Read the spreadsheet that needs to be updated
		    
		    HSSFWorkbook wb = new HSSFWorkbook(fsIP); //Access the workbook
		      
		    HSSFSheet worksheet = wb.getSheetAt(0); //Access the worksheet, so that we can update / modify it.
		    
		    //	Full Name Top
		    Cell cellfullName1 = null; // declare a Cell object
		    cellfullName1 = worksheet.getRow(8).getCell(0);   // Access the second cell in second row to update the value
		    cellfullName1.setCellValue("NAME: " + getFullName());  // Get current cell value value and overwrite the value
		    //	Full Name bottom	    
		    Cell cellfullName2 = null; // declare a Cell object
		    cellfullName2 = worksheet.getRow(110).getCell(1);   // Access the second cell in second row to update the value
		    cellfullName2.setCellValue(getFullName());  // Get current cell value value and overwrite the value
		    
		    //	Department Head Name
		    Cell cellheadName = null; // declare a Cell object
		    cellheadName = worksheet.getRow(111).getCell(9);   // Access the second cell in second row to update the value
		    cellheadName.setCellValue(getHeadName());
		      
		    //	Deapartment Name
		    Cell cellDeptName = null; // declare a Cell object
		    cellDeptName = worksheet.getRow(8).getCell(8);   // Access the second cell in second row to update the value
		    cellDeptName.setCellValue("DEPARTMENT: " + getDeptName());
		    
		    fsIP.close(); //Close the InputStream
		     
		    FileOutputStream output_file = new FileOutputStream(new File("C:\\Users\\ACER\\Desktop\\Online class\\2nd sem\\COE102.2\\Eclipse\\GUI orig\\FDTR-Form.xls"));  //Open FileOutputStream to write updates
		      
		    wb.write(output_file); //write changes
		      
		    output_file.close();  //close the stream 
		
		} catch (Exception e1) {
			System.out.println(e1);
		}
		
	}
	
	public void confirmDate(ActionEvent e) throws ParseException {
		
		DateInput input = new DateInput();
		input.dateInput(getDateDay(), getDateYear(), getDateMonth());
		
		int rowindex1 = 0;
		int rowindex2 = 0;
		TimeInput time = new TimeInput(getDateDay(), getDateDay(), getDateMonth());
		
		for(int i = 1; i <= getNumberOfDays(); i++) {
			if(i < 16) {
				input.clearInput1(getDateDay(), getDateYear(), getDateMonth(), rowindex1, i);
				rowindex1 += 3;
			}
			else if(i > 15 && i < 29){
				input.clearInput2(getDateDay(), getDateYear(), getDateMonth(), rowindex2, i);
				rowindex2 += 3;
			}else{
					System.out.println("Last cleared index: " + rowindex2);
					input.clearInput2(getDateDay(), getDateYear(), getDateMonth(), rowindex2, i);
					rowindex2 += 2;
			}	
		}
	}

	
	
	public void addSched1(ActionEvent e) throws ParseException {
		
		TimeInput time = new TimeInput(getDateDay(), getDateYear(), getDateMonth());
		int getRowNum1 = 10 + (getDateDay()*3);
		int getRowNum2 = 4 + (10 + (getDateDay()*3));
		int getRowNum3 = (4 + (10 + (getDateDay()*3))) - 1;
		
		
		if(getDateDay() < 16) {
			if(getWorkType() == "HOLIDAY" || getWorkType() == "ACADEMIC BREAK")
				time.specialInput(getWorkType(), getRowNum1);
			else {
				time.timeInput(getWorkType(), getTimeIn(), getTimeOut(), getTotalHrs(), getRowNum1);
				time.grandTotalHrs(getRowNum1);
			}
		}
		else if(getDateDay() > 15 && getDateDay() < 30) {
			if(getWorkType() == "HOLIDAY" || getWorkType() == "ACADEMIC BREAK")
				time.specialInput(getWorkType(), getRowNum2);
			else {
				time.timeInput(getWorkType(), getTimeIn(), getTimeOut(), getTotalHrs(), getRowNum2);
				time.grandTotalHrs(getRowNum2);
			}
		}
		else if(getDateDay() == 30) {
			if(getWorkType() == "HOLIDAY" || getWorkType() == "ACADEMIC BREAK")
				time.specialInput(getWorkType(), getRowNum3);
			else {
				time.timeInput(getWorkType(), getTimeIn(), getTimeOut(), getTotalHrs(), getRowNum3);
				time.grandTotalHrs(getRowNum3);
			}
		}
		else if(getDateDay() == 31) {
			if(getWorkType() == "HOLIDAY" || getWorkType() == "ACADEMIC BREAK")
				time.specialInput(getWorkType(), getRowNum3-1);
			else {
				time.timeInput(getWorkType(), getTimeIn(), getTimeOut(), getTotalHrs(), getRowNum3-1);
				time.grandTotalHrs(getRowNum3-1);
			}
		}
	}
	
	public void addSched2(ActionEvent e) throws ParseException {
		
		TimeInput time = new TimeInput(getDateDay(), getDateYear(), getDateMonth());
		int getRowNum1 = 10 + (getDateDay()*3)+1;
		int getRowNum2 = 4 + (10 + (getDateDay()*3))+1;
		int getRowNum3 = (4 + (10 + (getDateDay()*3)));
		
		
		if(getDateDay() < 16) {
			if(getWorkType() == "HOLIDAY" || getWorkType() == "ACADEMIC BREAK")
				time.specialInput(getWorkType(), getRowNum1);
			else {
				time.timeInput(getWorkType(), getTimeIn(), getTimeOut(), getTotalHrs(), getRowNum1);
				time.grandTotalHrs(getRowNum1-1);
			}
		}
		else if(getDateDay() > 15 && getDateDay() < 30) {
			if(getWorkType() == "HOLIDAY" || getWorkType() == "ACADEMIC BREAK")
				time.specialInput(getWorkType(), getRowNum2);
			else {
				time.timeInput(getWorkType(), getTimeIn(), getTimeOut(), getTotalHrs(), getRowNum2);
				time.grandTotalHrs(getRowNum2-1);
			}
		}
		else if(getDateDay() == 30) {
			if(getWorkType() == "HOLIDAY" || getWorkType() == "ACADEMIC BREAK")
				time.specialInput(getWorkType(), getRowNum3);
			else {
				time.timeInput(getWorkType(), getTimeIn(), getTimeOut(), getTotalHrs(), getRowNum3);
				time.grandTotalHrs(getRowNum3-1);
			}
		}
		else if(getDateDay() == 31) {
			if(getWorkType() == "HOLIDAY" || getWorkType() == "ACADEMIC BREAK")
				time.specialInput(getWorkType(), getRowNum3-1);
			else {
				time.timeInput(getWorkType(), getTimeIn(), getTimeOut(), getTotalHrs(), getRowNum3-1);
				time.grandTotalHrs(getRowNum3-2);
			}
		}
	}

	public void addSched3(ActionEvent e) throws ParseException {
	
		TimeInput time = new TimeInput(getDateDay(), getDateYear(), getDateMonth());
		int getRowNum1 = 10 + (getDateDay()*3)+2;
		int getRowNum2 = 4 + (10 + (getDateDay()*3))+2;
		int getRowNum3 = (4 + (10 + (getDateDay()*3))) + 1;
		
		
		if(getDateDay() < 16) {
			if(getWorkType() == "HOLIDAY" || getWorkType() == "ACADEMIC BREAK")
				time.specialInput(getWorkType(), getRowNum1);
			else {
				time.timeInput(getWorkType(), getTimeIn(), getTimeOut(), getTotalHrs(), getRowNum1);
				time.grandTotalHrs(getRowNum1-2);
			}
		}
		else if(getDateDay() > 15 && getDateDay() < 30) {
			if(getWorkType() == "HOLIDAY" || getWorkType() == "ACADEMIC BREAK")
				time.specialInput(getWorkType(), getRowNum2);
			else {
				time.timeInput(getWorkType(), getTimeIn(), getTimeOut(), getTotalHrs(), getRowNum2);
				time.grandTotalHrs(getRowNum2-2);
			}
		}
		else if(getDateDay() == 30) {
			if(getWorkType() == "HOLIDAY" || getWorkType() == "ACADEMIC BREAK")
				time.specialInput(getWorkType(), getRowNum3);
			else {
				time.timeInput(getWorkType(), getTimeIn(), getTimeOut(), getTotalHrs(), getRowNum3);
				time.grandTotalHrs(getRowNum3-2);
			}
		}
		
	}
	
	public void dateAuto(ActionEvent e) {
		dateLabel.setText(getDateMonth() + " " + getDateDay() + ", "+ getDateYear());
	}
	
	@FXML
	private ImageView xlsimage;
	public void previewButton(ActionEvent e) throws IOException {
		
		ExcelToImage.xlsToImage();		
		Image image = new Image("file:///C:/Users/ACER/Desktop/Online%20class/2nd%20sem/COE102.2/Eclipse/GUI%20orig/FDTRimage.jpg", 688, 0, false, false);
		
		xlsimage.setImage(image);
		xlsimage.setVisible(true);
		
		System.out.println("Converted to image");
	
	}
	
	public void printToPDF(ActionEvent e) {
		ConvertToPDF.xlsToPDF();
		System.out.println("Print to PDF");
	}
	
	
    
	
	
}
 
