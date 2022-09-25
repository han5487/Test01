package com.ubot.lis.function.api3;

import com.itextpdf.io.font.PdfEncodings;
import com.itextpdf.kernel.font.PdfFont;
import com.itextpdf.kernel.font.PdfFontFactory;
import com.itextpdf.kernel.pdf.PdfDocument;
import com.itextpdf.kernel.pdf.PdfWriter;
import com.itextpdf.kernel.pdf.canvas.PdfCanvas;
import com.itextpdf.layout.Document;
import com.itextpdf.layout.Style;
import com.itextpdf.layout.element.Cell;
import com.itextpdf.layout.element.Paragraph;
import com.itextpdf.layout.element.Table;
import com.itextpdf.layout.element.Text;
import com.itextpdf.layout.property.TextAlignment;
import com.itextpdf.layout.property.UnitValue;

import com.itextpdf.layout.element.List;
import com.itextpdf.layout.element.ListItem;
import com.itextpdf.layout.property.ListNumberingType;

/*
 * 本票pdf
 */
public class Test {

	public static void main(String[] args) {
		createPdf("F:\\司資料\\Test\\本票.pdf");
	}

	public static void createPdf(String dest) {

		try {
			PdfDocument pdfDoc = new PdfDocument(new PdfWriter(dest));

			// 設定中文字體 (若無此設定值會無法顯示中文)
			PdfFont baseFont = PdfFontFactory.createFont("C:/Windows/Fonts/simsun.ttc,1", PdfEncodings.IDENTITY_H);

			// 設定字形.字體大小20.粗體.本文置中
			Style title = new Style().setFont(baseFont).setFontSize(20).setBold()
					.setTextAlignment(TextAlignment.CENTER);
			// 設定字形.字體大小10
			Style normal = new Style().setFont(baseFont).setFontSize(10);

			// Create a page
			pdfDoc.addNewPage();
			// 長寬
			float width = pdfDoc.getDefaultPageSize().getWidth();
			float height = pdfDoc.getDefaultPageSize().getHeight();
			// Define a PdfCanvas instance
			PdfCanvas canvas = new PdfCanvas(pdfDoc.getFirstPage());
			// Add a rectangle
			// 最外面兩層
			canvas.rectangle(25, 25, 545, 792);
			canvas.setLineWidth(3).stroke();
			canvas.rectangle(30, 30, 535, 782);
			canvas.setLineWidth(1).stroke();

			// Initialize document
			Document document = new Document(pdfDoc);
			// 新增段落文字&設定樣式&段落行距
			document.add(new Paragraph("本 票").addStyle(title));

			// 設定表格欄位數及寬度百分比
			float[] colWidths = new float[] { 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1,
					1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1 };

			Table table = new Table(UnitValue.createPercentArray(colWidths)).useAllAvailableWidth();
			Cell cell = new Cell();

			cell = new Cell(1, 50)
					.add(new Paragraph("口口口口口口口口口口口口口口口口口口口口口口口口口口口口口口口口口口口口口口口口口口口口口口口口口").addStyle(normal));
			table.addCell(cell);

			cell = new Cell(1, 50).add(new Paragraph("憑票准於中　華　民　國　　　　　　年　　　　　　月　　　　　　日支付").addStyle(normal));
			table.addCell(cell);

			cell = new Cell(1, 50).add(new Paragraph("聯邦商業銀行　　　　　　　　　　　　或其指定人").addStyle(normal));
			table.addCell(cell);

			cell = new Cell(1, 50).add(new Paragraph("").addStyle(normal));
			table.addCell(cell);

			cell = new Cell(1, 50).add(new Paragraph("新　臺　幣").addStyle(normal));
			table.addCell(cell);

			List list1 = new List();
			list1 = new List().setListSymbol(ListNumberingType.DECIMAL).setFont(baseFont);// 有序列表
			list1.add(new ListItem("本票據利息依下列第  項約定利率計付。").setListSymbol(new Text("一、")));

			cell = new Cell(1, 50).add(list1);
			table.addCell(cell);

			List list2 = new List().setListSymbol(ListNumberingType.DECIMAL).setFont(baseFont);// 有序列表

			list2.add(new ListItem(
					"利息自發票日起依　貴行□基準利率(季)  □基準利率(月) □均利型指數利率(季)  □均利型指數利率(月)％加碼年息     ％計算（目前為年息     ％），□惟最低不得低於年息   %，按月計付，上開利率同意採固定方式計息。"));
			list2.add(new ListItem(
					"利息自發票日起依　貴行□基準利率(季)  □基準利率(月) □均利型指數利率(季)  □均利型指數利率(月)      ％加碼年息     ％計算（目前為年息     ％），按月計付，上開利率同意隨　貴行□基準利率(季)  □基準利率(月)  □均利型指數利率(季)  □均利型指數利率(月)變動而調整。"));
			list2.add(new ListItem(
					"利息自發票日起至民國　年 月 日止　依□年利率　　　％固定計算  □貴行公告之□均利型指數利率(季)□均利型指數利率(月)加碼年息　　　％□固定□浮動計息（目前為年息　　　　％），自民國　年　月　日起至民國　年 月 日止　依□年利率　　　％固定計算 □貴行公告之□均利型指數利率(季)  □均利型指數利率(月)加碼年息　　　％□固定□浮動計息（目前為年息　　　　％），另自民國　年　月　日起改按 貴行公告之□均利型指數利率(季)  □均利型指數利率(月)加碼年息     ％□固定□浮動計息(目前為年利率      ％)，按月計付，上開利率同意隨  貴行公告之□均利型指數利率(季)  □均利型指數利率(月)變動而調整。"));
			list2.add(new ListItem(
					"利息自發票日起依中華郵政（股）公司　年期定期儲金存款□固定□機動利率　　　％　  碼年息　　　％計息(目前為年息　　　％)，按月計付，上開利率同意隨中華郵政（股）公司　年期定期儲金存款利率變動而調整。"));
			list2.add(new ListItem(
					"利息自發票日起依國家發展委員會 □中長期資金融資利率　　　％ □中長期資金運用利率    ％加碼年息％計息(目前為年息　　％)，按月計付，上開利率同意隨國家發展委員會□中長期資金融資利率□中長期資金運用利率變動而調整。"));
			list2.add(new ListItem("利息自發票日起依年息 ％固定計息，按月計付。"));
			list2.add(new ListItem(""));

			cell = new Cell(1, 50).add(list2.setMarginLeft(20));
			table.addCell(cell);

			list1 = new List().setListSymbol(ListNumberingType.DECIMAL).setFont(baseFont);// 有序列表
			list1.add(new ListItem("前條約定之利息，如蒙　貴行同意暫按較低利率優惠計息者，貴行並得視情形減少或中止優惠，恢復按原約定利率計息。")
					.setListSymbol(new Text("二、")));
			cell = new Cell(1, 50).add(list1);
			table.addCell(cell);

			list1 = new List().setListSymbol(ListNumberingType.DECIMAL).setFont(baseFont);// 有序列表
			list1.add(new ListItem(
					"逾期付息或到期未履行債務時，自逾期之日起，除依下列第　項約定計付遲延利息外，就約定為第一項者，並依第四條所列計算基準，逾期六個月以內依第一條約定利率百分之十，逾期超過六個月部分依第一條約定利率百分之二十計付違約金：")
							.setListSymbol(new Text("三、")));
			list1.add(new ListItem("１.按第一條約定利率。").setListSymbol(""));
			list1.add(new ListItem("２.按  貴行基準利率(季)加碼年息  %計算。").setListSymbol(""));
			list1.add(new ListItem("３.").setListSymbol(""));
			cell = new Cell(1, 50).add(list1);
			table.addCell(cell);

			list1 = new List().setListSymbol(ListNumberingType.DECIMAL).setFont(baseFont);// 有序列表
			list1.add(new ListItem("第三條違約金之計算基準：").setListSymbol(new Text("四、")));
			list1.add(new ListItem("１.借款期間未屆至者，本金自應還款日起、利息自應繳息日起，依當期應攤還本金或當期應繳利息金額計付。").setListSymbol(""));
			list1.add(new ListItem("２.借款期間屆至或經 貴行主張加速條款視為到期者，自借款到期日或視為到期經列報逾期放款日（以孰先屆至為準）起，依未償還本金餘額計付。")
					.setListSymbol(""));
			cell = new Cell(1, 50).add(list1);
			table.addCell(cell);

			list1 = new List().setListSymbol(ListNumberingType.DECIMAL).setFont(baseFont);// 有序列表
			list1.add(new ListItem("此票免除作成拒絕證書。").setListSymbol(new Text("五、")));
			cell = new Cell(1, 50).add(list1);
			table.addCell(cell);

			list1 = new List().setListSymbol(ListNumberingType.DECIMAL).setFont(baseFont);// 有序列表
			list1.add(new ListItem("付款地：").setListSymbol(new Text("六、")));
			cell = new Cell(1, 50).add(list1);
			table.addCell(cell);

			cell = new Cell(1, 50).add(new Paragraph("此  據 ").addStyle(normal));
			table.addCell(cell);

			cell = new Cell(1, 50)
					.add(new Paragraph("發　票　人：　　　　　　    　                                            　（簽章）  ")
							.addStyle(normal));
			table.addCell(cell);

			cell = new Cell(1, 50).add(new Paragraph("住      址：").addStyle(normal));
			table.addCell(cell);

			cell = new Cell(1, 50)
					.add(new Paragraph("共同發票人：　　　　　　　                                                　（簽章）")
							.addStyle(normal));
			table.addCell(cell);

			cell = new Cell(1, 50).add(new Paragraph("住　　　址：").addStyle(normal));
			table.addCell(cell);

			cell = new Cell(1, 50)
					.add(new Paragraph("共同發票人：　　　　　　　                                                  （簽章）")
							.addStyle(normal));
			table.addCell(cell);

			cell = new Cell(1, 50).add(new Paragraph("住　　　址：").addStyle(normal));
			table.addCell(cell);

			cell = new Cell(1, 50)
					.add(new Paragraph("中　華　民　國　    　  　     　　年　　           　　　月　　          　　　日").addStyle(normal));
			table.addCell(cell);

			cell = new Cell(1, 50)
					.add(new Paragraph("發票人（含共同發票人）確認前開條款內容業經合理時間審閱並同意，且由發票人收執影本乙份，特此簽章：").addStyle(normal));
			table.addCell(cell);

			cell = new Cell(1, 5).add(new Paragraph("科目").addStyle(normal).setTextAlignment(TextAlignment.CENTER));
			table.addCell(cell);

			cell = new Cell(1, 5).add(new Paragraph("口口口").addStyle(normal).setTextAlignment(TextAlignment.CENTER));
			table.addCell(cell);

			cell = new Cell(1, 5).add(new Paragraph("帳號").addStyle(normal).setTextAlignment(TextAlignment.CENTER));
			table.addCell(cell);

			cell = new Cell(1, 5).add(new Paragraph("口口口").addStyle(normal).setTextAlignment(TextAlignment.CENTER));
			table.addCell(cell);

			cell = new Cell(1, 5).add(new Paragraph("AO(助理)").addStyle(normal).setTextAlignment(TextAlignment.CENTER));
			table.addCell(cell);

			cell = new Cell(1, 5).add(new Paragraph("口口口").addStyle(normal).setTextAlignment(TextAlignment.CENTER));
			table.addCell(cell);

			cell = new Cell(1, 5).add(new Paragraph("經辦").addStyle(normal).setTextAlignment(TextAlignment.CENTER));
			table.addCell(cell);

			cell = new Cell(1, 5).add(new Paragraph("口口口").addStyle(normal).setTextAlignment(TextAlignment.CENTER));
			table.addCell(cell);

			cell = new Cell(1, 5).add(new Paragraph("核定").addStyle(normal).setTextAlignment(TextAlignment.CENTER));
			table.addCell(cell);

			cell = new Cell(1, 5).add(new Paragraph("口口口").addStyle(normal).setTextAlignment(TextAlignment.CENTER));
			table.addCell(cell);

			cell = new Cell(1, 5).add(new Paragraph("授信號碼").addStyle(normal).setTextAlignment(TextAlignment.CENTER));
			table.addCell(cell);
			cell = new Cell(1, 10).add(new Paragraph("口口口").addStyle(normal).setTextAlignment(TextAlignment.CENTER));
			table.addCell(cell);
			cell = new Cell(1, 5).add(new Paragraph("電話").addStyle(normal).setTextAlignment(TextAlignment.CENTER));
			table.addCell(cell);
			cell = new Cell(1, 10).add(new Paragraph("口口口").addStyle(normal).setTextAlignment(TextAlignment.CENTER));
			table.addCell(cell);
			cell = new Cell(1, 20)
					.add(new Paragraph("02201U 109.7修訂").addStyle(normal).setTextAlignment(TextAlignment.CENTER));
			table.addCell(cell);

			document.add(table);

			document.close();

		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
