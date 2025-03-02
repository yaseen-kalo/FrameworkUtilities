import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Iterator;

public class ReadExcelFile {
    public static void main(String[] args) {
        try
        {
            FileInputStream readFile = new FileInputStream("Employees.xlsx");
            XSSFWorkbook workbook = new XSSFWorkbook(readFile);
            XSSFSheet Employee = workbook.getSheet("Employee");

            Row row;
            Cell cell;
            Iterator<Row> rowIterator = Employee.rowIterator();{
                while (rowIterator.hasNext()) {
                    row = rowIterator.next();
                    Iterator<Cell> cellIterator = row.cellIterator();
                    while (cellIterator.hasNext()) {
                        cell = cellIterator.next();
                        System.out.print(cell.toString() + "\t"); // Print cell value
                    }
                    System.out.println(); // Move to the next line after printing a row
                }
        }

        }catch (FileNotFoundException fileNotFoundException){
            fileNotFoundException.printStackTrace();
        }catch (IOException ioException){
            ioException.printStackTrace();
        }
    }
}
