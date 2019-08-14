
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.neu.servlet;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Iterator;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;

/**
 *
 * @author asthasharma
 */
public class Part6 extends HttpServlet{
    @Override
    protected void doGet(HttpServletRequest req,HttpServletResponse res) throws ServletException, IOException
    {
      
       //String fileName=req.getParameter("csvFileName");
       
       String excelFilePath = "/Users/asthasharma/Downloads/store.xls";
       PrintWriter out = res.getWriter();
      
        FileInputStream inputStream = new FileInputStream(new File(excelFilePath));
        
         
        Workbook workbook = new HSSFWorkbook(inputStream);
        
        Sheet firstSheet = workbook.getSheetAt(0);
        
        Iterator<Row> iterator = firstSheet.iterator();
        
         
        while (iterator.hasNext()) {
            Row nextRow = iterator.next();
            
            Iterator<Cell> cellIterator = nextRow.cellIterator();
             
            while (cellIterator.hasNext()) {
                Cell cell = cellIterator.next();
                 
                switch (cell.getCellType()) {
                    case STRING:
                        out.print(cell.getStringCellValue());
                        break;
                    case BOOLEAN:
                        out.print(cell.getBooleanCellValue());
                        break;
                    case NUMERIC:
                        out.print(cell.getNumericCellValue());
                        break;
                }
                out.print(" - ");
            }
            out.println();
        }
         
        workbook.close();
        inputStream.close();
    }
        }



