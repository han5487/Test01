package com.ubot.lis.function.api3;

import java.util.Map.Entry;

import com.itextpdf.kernel.pdf.PdfDocument;
import com.itextpdf.kernel.pdf.PdfWriter;
import com.itextpdf.layout.Document;
import com.itextpdf.layout.element.Paragraph;

public class Test02 {

	public static void main(String[] args) {
		createPdf("F:\\司資料\\Test\\目錄.pdf");
	}

	public static void createPdf(String dest) {

		PDFUtil pdfUtil2 = new PDFUtil(dest);
		Document doc2 = pdfUtil2.createPdfDoc();

		for (Entry<String, Integer> entry : catalogMap.entrySet()) {

			String title = entry.getKey();
			String page = entry.getValue() + "";

			if (countInString(title, ".") == 0) {

				pdfUtil2.addParagraph(doc2, title + "......." + page);

			} else if (countInString(title, ".") == 1) {

				pdfUtil2.addParagraph(doc2, title + "......." + page);

			}
		}
	}

	public static int countInString(String str1, String str2) {
		int total = 0;
		for (String tmp = str1; tmp != null && tmp.length() >= str2.length();) {
			if (tmp.indexOf(str2) == 0) {
				total++;
				tmp = tmp.substring(str2.length());
			} else {
				tmp = tmp.substring(1);
			}
		}
		return total;
	}
}
