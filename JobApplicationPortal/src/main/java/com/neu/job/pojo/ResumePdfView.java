package com.neu.job.pojo;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.view.document.AbstractPdfView;

import com.lowagie.text.Document;
import com.lowagie.text.pdf.PdfWriter;
import com.lowagie.text.Paragraph;

public class ResumePdfView extends AbstractPdfView {

	@Override
	protected void buildPdfDocument(Map<String, Object> model, Document document, PdfWriter writer,
			HttpServletRequest request, HttpServletResponse response) throws Exception {
		// TODO Auto-generated method stub
		String resumeData=(String) model.get("resume");
		System.out.println("resume data in pojo before adding to paragraph:"+resumeData );
		
		Paragraph p=new Paragraph(resumeData);
		
		System.out.println("resume data in pojo:"+p );
		document.add(p);
		
		
	}

}
