package com.ubot.lis.function.api3;

import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

import com.itextpdf.kernel.events.PdfDocumentEvent;
import com.itextpdf.kernel.pdf.PdfDocument;
import com.itextpdf.layout.Document;

public class Test03 {
	public static String url = "F:\\司資料\\Test\\test04.pdf";// 这里两个路径应改成你自己的路径
	public static String urlOrig = "F:\\司資料\\Test\\test01.pdf";

	static Map<String, Integer> catalogMap = new HashMap<String, Integer>();

	public static void main(String[] args) throws Exception {

		long old = System.currentTimeMillis();

		// 生成内容pdf
		PDFUtil pdfUtil = new PDFUtil(url);
		Document doc = pdfUtil.createPdfDoc();
		PdfDocument pdfDoc = doc.getPdfDocument();

		// 这里生成页码，引用TextFooterEventHandler的方法
		TextFooterEventHandler eh = new TextFooterEventHandler(doc);
		pdfDoc.addEventHandler(PdfDocumentEvent.END_PAGE, eh);

		pdfUtil.addTitle(doc, "预案");
		for (int i = 0; i < 15; i++) {
			pdfUtil.addHeading1(doc, i + " 标题");
			if (i % 2 == 0) {
				pdfUtil.addHeading2(doc, i + ".1 小标题标题");
			}
			pdfUtil.addParagraph(doc,
					"内容QAQAQZAAAWQSXFDSFSD内容QAQAQZAAAWQSXFDSFSD内容QAQAQZAAAWQSXFDSFSD内容QAQAQZAAAWQSXFDSFSD内容QAQAQZAAAWQSXFDSFSD");
		}

		pdfDoc.close();
		doc.close();

		// ------------------分割线--------------

		// 生成目录方法，暂时只能生产目录的pdf，还需努力合并
		PDFUtil pdfUtil2 = new PDFUtil(urlOrig);
		Document doc2 = pdfUtil2.createPdfDoc();
		System.out.println(doc2.getPdfDocument().getCatalog().getPdfObject());
		for (Entry<String, Integer> entry : pdfUtil.getCatalogMap().entrySet()) {

			String title = entry.getKey();
			String page = entry.getValue() + "";
			if (countInString(title, ".") == 0) {
				pdfUtil2.addParagraph(doc2, title + "......." + page);
			} else if (countInString(title, ".") == 1) {
				pdfUtil2.addParagraph(doc2, title + "......." + page);
			} else {

			}
		}
		doc2.close();

		long now = System.currentTimeMillis();
		System.out.println("共耗时：" + ((now - old) / 1000.0) + "秒\n\n" + "文件保存在:" + url + "," + urlOrig);

	}

	// 用来控制生成目录
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
