package com.pack.pdf;
import java.util.List;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import javax.servlet.http.HttpServletResponse;

import com.itextpdf.text.*;

import com.itextpdf.text.Font;

import com.itextpdf.text.Paragraph;

import com.itextpdf.text.pdf.PdfPCell;

import com.itextpdf.text.pdf.PdfPTable;

import com.itextpdf.text.pdf.PdfWriter;
import com.pack.model.Question;

public class UserPDFView extends AbstractITextPdfView {

	protected void buildPdfDocument(Map<String, Object> model, Document doc,

			PdfWriter writer, HttpServletRequest request, HttpServletResponse response)

			throws Exception {

		// get data model which is passed by the Spring container

		List<Question> listBooks = (List<Question>) model.get("QuestionList");

		doc.add(new Paragraph("Recommended books for Spring framework"));

		PdfPTable table = new PdfPTable(2);

		table.setWidthPercentage(100.0f);

		table.setWidths(new float[] { 3.0f, 2.0f });

		table.setSpacingBefore(10);

		// define font for table header row

		Font font = FontFactory.getFont(FontFactory.TIMES_ITALIC);

		font.setColor(BaseColor.WHITE);

		// define table header cell

		PdfPCell cell = new PdfPCell();

		cell.setBackgroundColor(BaseColor.GREEN);

		cell.setPadding(2);

		// write table header

		cell.setPhrase(new Phrase("Question", font));

		table.addCell(cell);

		cell.setPhrase(new Phrase("Right_Answer", font));

		table.addCell(cell);

		// write table row data

		for (Question aBook : listBooks) {

			table.addCell(aBook.getQuestion_text());

			table.addCell(aBook.getRight_answer());

		}

		doc.add(table);

	}

}