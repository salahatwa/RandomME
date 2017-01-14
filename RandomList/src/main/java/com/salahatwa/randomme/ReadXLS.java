/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.salahatwa.randomme;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Random;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

/**
 *
 * @author Salah Atwa SingleTon design Pattern
 */
public class ReadXLS {

    /**
     * static to enhance memory and locate object only once at memory object
     * create only once
     */
    private static ReadXLS readXLS = new ReadXLS();

    /**
     * To prevent access from outside class
     */
    private ReadXLS() {
    }

    /**
     * @return instance of static object
     */
    public static ReadXLS getInstance() {
        return readXLS;
    }

    /**
     * @param filePath
     * @return  list of Readed cells from xlsx
     */
    public List<ReadedBean> readXLSFromFile(String filePath) {
        List<ReadedBean> data = new ArrayList();
        FileInputStream fis = null;
        try {
            fis = new FileInputStream(filePath);
            // Using XSSF for xlsx format, for xls use HSSF

            Workbook workbook = new XSSFWorkbook(fis);

            int numberOfSheets = workbook.getNumberOfSheets();

            //looping over each workbook sheet
            for (int i = 0; i < numberOfSheets; i++) {
                Sheet sheet = workbook.getSheetAt(i);
                Iterator rowIterator = sheet.iterator();

                //iterating over each row
                while (rowIterator.hasNext()) {

                    ReadedBean readedBean = new ReadedBean();
                    Row row = (Row) rowIterator.next();
                    Iterator cellIterator = row.cellIterator();
                    //Iterating over each cell (column wise)  in a particular row.
                    while (cellIterator.hasNext()) {
                        Cell cell = (Cell) cellIterator.next();

                        if (Cell.CELL_TYPE_STRING == cell.getCellType())
                        {
                           if (cell.getColumnIndex() == 0)
                           {
                            readedBean.setCell(cell.getStringCellValue());
                           }

                        }
                        else if (Cell.CELL_TYPE_NUMERIC == cell.getCellType()) 
                        {
                           
                            if (cell.getColumnIndex() == 0)
                            {
                                 readedBean.setCell(String.valueOf((int)cell.getNumericCellValue()));
                            } 
//                           
                        }
                    }
                    System.out.println(readedBean.getCell());
                    data.add(readedBean);
                }
            }
            fis.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return data;
    }
    
 
}
