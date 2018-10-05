package com.jcg.example;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * created by timi on 10-04-18
 */
public class ReadExcelFileExample {

    private static final String FILE_PATH = "/Users/timi/Projects/";

    public static void main(String args[]) {

        List<Property> PropertyList = getPropertysListFromExcel();

        System.out.println(PropertyList);
    }

    @SuppressWarnings({ "deprecation" })
	private static List<Property> getPropertysListFromExcel() {
        List<Property> PropertyList = new ArrayList<Property>();
        FileInputStream fis = null;
        try {
            fis = new FileInputStream(FILE_PATH);

            // Using HSSF for xlsx format, for xls use HSSF
            HSSFWorkbook workbook = new HSSFWorkbook(fis);

            int numberOfSheets = workbook.getNumberOfSheets();

            //looping over each workbook sheet
            for (int i = 0; i < numberOfSheets; i++) {
                Sheet sheet = workbook.getSheetAt(i);
                Iterator<Row> rowIterator = sheet.iterator();

                //iterating over each row
                while (rowIterator.hasNext()) {

                    Property Property = new Property();
                    Row row = rowIterator.next();
                    Iterator<Cell> cellIterator = row.cellIterator();

                    //Iterating over each cell (column wise)  in a particular row.
                    while (cellIterator.hasNext()) {

                        Cell cell = cellIterator.next();
                        //The Cell Containing String will is month.
                        if (Cell.CELL_TYPE_STRING == cell.getCellType()) {
                            Property.setMonth(cell.getStringCellValue());

                            //The Cell Containing numeric value will contain marks
                        } else if (Cell.CELL_TYPE_NUMERIC == cell.getCellType()) {

                            //Cell with index 1 contains Detached value
                            if (cell.getColumnIndex() == 1) {
                                Property.setDetached(String.valueOf(cell.getNumericCellValue()));
                            }
                            //Cell with index 2 contains Semi-detached value
                            else if (cell.getColumnIndex() == 2) {
                                Property.setSemi(String.valueOf(cell.getNumericCellValue()));
                            }
                            //Cell with index 3 contains Terraced value
                            else if (cell.getColumnIndex() == 3) {
                                Property.setTerraced(String.valueOf(cell.getNumericCellValue()));
                            }
                            //Cell with index 4 contains Flat value
                            else if (cell.getColumnIndex() == 3) {
                                Property.setFlat(String.valueOf(cell.getNumericCellValue()));
                            }
                        }
                    }
                    //end iterating a row, add all the elements of a row in list
                    PropertyList.add(Property);
                }
            }
            
            //close the file
            fis.close();

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return PropertyList;
    }


}
