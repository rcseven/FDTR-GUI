package application;


import com.spire.xls.*;
 
public class ConvertToPDF {
	
    public static void xlsToPDF() {
        //Create a Workbook and load an Excel file
        Workbook workbook = new Workbook();
        workbook.loadFromFile("C:\\Users\\ACER\\Desktop\\Online class\\2nd sem\\COE102.2\\Eclipse\\GUI orig\\FDTR-Form.xls");
 
        //Fit to page
        workbook.getConverterSetting().setSheetFitToPage(true);
 
        //Save to PDF file
        workbook.saveToFile("FDTR-Form.pdf",FileFormat.PDF);
        }
    
}