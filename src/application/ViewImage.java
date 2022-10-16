package application;

import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.PDPage;
import org.apache.pdfbox.util.ImageIOUtil;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.List;

public class ViewImage{
	
	public static void viewImage() throws IOException {
		
		String pdfFileName = "WholeToPDF.pdf";
		PDDocument document = PDDocument.loadNonSeq(new File(pdfFileName), null);
		
		List<PDPage> pdPages = document.getDocumentCatalog().getAllPages();
		
		int page = 0;
		
		for(PDPage pdPage : pdPages) {
			++page;
			BufferedImage bim = pdPage.convertToImage(BufferedImage.TYPE_INT_RGB, 300);
			ImageIOUtil.writeImage(bim, pdfFileName + ".jpg" , 300);
		}
		
	}
	        
	
}