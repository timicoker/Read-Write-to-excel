package com.jcg.example;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by timi.
 */
public class WriteExcelFileExample {
    private static final String FILE_PATH = "/Users/timi";
    //We are making use of a single instance to prevent multiple write access to same file.
    private static final WriteExcelFileExample INSTANCE = new WriteExcelFileExample();

    public static WriteExcelFileExample getInstance() {
        return INSTANCE;
    }

    private WriteExcelFileExample() {
    }

    public static void main(String args[]){

        List<Property> propertyList = new ArrayList<Property>();
        propertyList.add(new Property());
        propertyList.add(new Property());
        propertyList.add(new Property());

        writepropertiesListToExcel(propertyList);

    }

    public static void writepropertiesListToExcel(List<Property> propertyList){

        // Using XSSF for xlsx format, for xls use HSSF
        HSSFWorkbook workbook = new HSSFWorkbook();

        Sheet propertiesSheet = workbook.createSheet("properties");

        int rowIndex = 0;
        for(Property property : propertyList){
            Row row = propertiesSheet.createRow(rowIndex++);
            int cellIndex = 0;
            //first place in row is month
            row.createCell(cellIndex++).setCellValue(property.getMonth());

            //second column is detached value
            row.createCell(cellIndex++).setCellValue(property.getDetached());

            //third column is semi detached value
            row.createCell(cellIndex++).setCellValue(property.getSemi());

            //fourth column is terraced value
            row.createCell(cellIndex++).setCellValue(property.getTerraced());
            
            //fourth column is flat value
            row.createCell(cellIndex++).setCellValue(property.getFlat());
        }

        //write this workbook in excel file.
        try {
            FileOutputStream fos = new FileOutputStream(FILE_PATH);
            workbook.write(fos);
            fos.close();

            System.out.println(FILE_PATH + " is successfully written");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }


    }
}
