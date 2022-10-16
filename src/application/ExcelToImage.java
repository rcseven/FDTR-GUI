package application;
import com.spire.xls.*;
import java.io.*;
 

public class ExcelToImage {

    public static void xlsToImage() throws IOException {
        //Create a workbook instance
        Workbook workbook = new Workbook();
        //Load the Excel file
        workbook.loadFromFile("C:\\Users\\ACER\\Desktop\\Online class\\2nd sem\\COE102.2\\Eclipse\\GUI orig\\FDTR-Form.xls");
        //Get the first worksheet
        Worksheet sheet = workbook.getWorksheets().get(0);
        //Save the sheet to image
        sheet.saveToImage("FDTRimage.jpg");
    }
}


