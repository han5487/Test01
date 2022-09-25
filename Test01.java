package com.ubot.lis.function.api3;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Map.Entry;

import com.itextpdf.io.font.PdfEncodings;
import com.itextpdf.kernel.events.PdfDocumentEvent;
import com.itextpdf.kernel.font.PdfFont;
import com.itextpdf.kernel.font.PdfFontFactory;
import com.itextpdf.kernel.pdf.PdfDocument;
import com.itextpdf.kernel.pdf.PdfWriter;
import com.itextpdf.layout.Document;
import com.itextpdf.layout.Style;

import com.itextpdf.layout.element.List;
import com.itextpdf.layout.element.ListItem;
import com.itextpdf.layout.element.Paragraph;
import com.itextpdf.layout.element.Text;
import com.itextpdf.layout.property.TextAlignment;

/*
 * 綜 合 授 信 契 約 書PDF
 */
public class Test01 {

	public static void main(String[] args) {
		createPdf("F:\\司資料\\Test\\綜合授信契約書.pdf");
	}

	public static void createPdf(String dest) {

		try {
			PdfDocument pdfDoc = new PdfDocument(new PdfWriter(dest));
			Document document = new Document(pdfDoc);
			// 設定頁碼
			TextFooterEventHandler eh = new TextFooterEventHandler(document);
			pdfDoc.addEventHandler(PdfDocumentEvent.END_PAGE, eh);

			// 設定中文字體 (若無此設定值會無法顯示中文)
			PdfFont baseFont = PdfFontFactory.createFont("C:/Windows/Fonts/simsun.ttc,1", PdfEncodings.IDENTITY_H);

			// 設定字形.字體大小20.粗體.本文置中
			Style title = new Style().setFont(baseFont).setFontSize(20).setBold()
					.setTextAlignment(TextAlignment.CENTER);
			// 設定字形.字體大小16.粗體.本文置中
			Style title16 = new Style().setFont(baseFont).setFontSize(16).setBold()
					.setTextAlignment(TextAlignment.CENTER);
			// 設定字形.字體大小12.粗體.本文置中
			Style title12 = new Style().setFont(baseFont).setFontSize(12).setBold()
					.setTextAlignment(TextAlignment.CENTER);

			// 設定字形.字體大小10
			Style normal = new Style().setFont(baseFont).setFontSize(10);

			// 新增段落文字&設定樣式&段落行距
			// 標題1
			document.add(new Paragraph("綜 合 授 信 契 約 書").addStyle(title));
			// 內文
			document.add(new Paragraph(
					"立綜合授信契約書人(以下簡稱立約人)為向聯邦商業銀行(包括總行及所屬各分支機構，以下簡稱貴行)申請辦理授信業務，茲邀同連帶保證人(以下簡稱保證人)及擔保物提供人與貴行約定，凡立約人與貴行現在(包括過去已發生而現在尚未清償者)及未來基於一定法律關係所生之一切債務，除另訂授信約據及其他約定外，茲同意按本契約各條款履行：")
							.addStyle(normal).setFirstLineIndent(20));
			// 標題2
			document.add(new Paragraph("第壹章、授信共同條款").addStyle(title16));
			// <標題，頁數>
			catalogMap.put("第壹章、授信共同條款", document.getPdfDocument().getNumberOfPages());

			// 標題2 內文
			List list = new List().setFont(baseFont).addStyle(normal);// 有序列表

			list = new List().setFont(baseFont).addStyle(normal);// 有序列表;
			list.add(new ListItem(
					"本綜合授信契約書(以下簡稱本契約)所稱一切債務，係指立約人對貴行所負之借款、透支、貼現、買入光票、墊款、承兌、委任保證、開發信用狀、進出口押匯、保證、票據、信用卡契約、應收帳款承購契約、衍生性金融商品交易契約及特約商店契約等其他各種債務，並包括其利息、遲延利息、違約金、損害賠償及其他有關費用。"));
			list.setListSymbol(new Text("一、"));
			document.add(list);

			list = new List().setFont(baseFont).addStyle(normal);// 有序列表;
			list.add(new ListItem("test2"));
			list.setListSymbol(new Text("二、"));
			document.add(list);

			// 標題2
			document.add(new Paragraph("第貳章、個別授信約定條款").addStyle(title16));
			// <標題，頁數>
			catalogMap.put("第貳章、個別授信約定條款", document.getPdfDocument().getNumberOfPages());

			// 標題3
			document.add(new Paragraph("第一節、營運週轉借款(一般週轉金)").addStyle(title12));

			pdfDoc.close();
			document.close();

			// 生成目录方法，暂时只能生产目录的pdf，还需努力合并
			PdfDocument pdfDoc2 = new PdfDocument(new PdfWriter(dest));
			Document doc2 = new Document(pdfDoc2);// 构建文档对象
			for (Entry<String, Integer> entry : catalogMap.entrySet()) {

				String title1 = entry.getKey();
				String page = entry.getValue() + "";

				if (countInString(title1, ".") == 0) {

					doc2.add(new Paragraph(title1 + "......." + page).addStyle(normal));

				} else if (countInString(title1, ".") == 1) {

					doc2.add(new Paragraph(title1 + "......." + page).addStyle(normal));

				}
			}
			pdfDoc.close();
			doc2.close();

		} catch (Exception e) {
			e.printStackTrace();
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
