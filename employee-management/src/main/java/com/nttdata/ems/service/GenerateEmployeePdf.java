package com.nttdata.ems.service;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.util.Date;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfWriter;
import com.nttdata.ems.model.Employee;

@Service
public class GenerateEmployeePdf {

	@Value("${spring.datasource.username}")
	private String dbUsername;

	public static void generatePdf(Employee emp) throws FileNotFoundException {
		// file location.
		String fileName = "c:\\Users\\clayTR\\Desktop\\TestPdf\\employee_" + emp.getFirstName() + "_"
				+ emp.getLastName() + ".pdf";
		Document document = new Document();
		try {
			PdfWriter.getInstance(document, new FileOutputStream(fileName));
			document.open();

			document.add(new Paragraph(" Employee info of " + emp.getFirstName() + " " + emp.getLastName()));
			document.add(new Paragraph(" "));
			document.add(new Paragraph(" "));
			document.add(new Paragraph(" "));

			document.add(new Paragraph(" Created at: " + new Date()));
			document.add(new Paragraph(" "));
			document.add(new Paragraph(" "));
			document.add(new Paragraph(" "));
			document.add(new Paragraph(" "));
			document.add(new Paragraph(" "));
			document.add(new Paragraph(" Employee ID: " + emp.getEmployeeID()));
			document.add(new Paragraph(" Employee FirstName: " + emp.getFirstName()));
			document.add(new Paragraph(" Employee LASTNAME: " + emp.getLastName()));

		} catch (DocumentException e) {
			e.printStackTrace();
		} finally {
			document.close();
		}
	}

}
