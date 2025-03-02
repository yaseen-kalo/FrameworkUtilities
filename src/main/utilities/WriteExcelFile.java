import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class WriteExcelFile {
    public static void main(String[] args) {

        XSSFWorkbook workbook = new XSSFWorkbook();
        XSSFSheet Employee = workbook.createSheet("Employee");

        // Step 1: Initialize the map with personData
        Map<String, Object[]> personData = new HashMap<String, Object[]>();
        personData.put("1", new Object[]{"1", "Anja", "Fraunhofer"});
        personData.put("2", new Object[]{"2", "Alice", "Catalysis"});
        personData.put("3", new Object[]{"3", "James", "Deutsche Bahn"});
        personData.put("4", new Object[]{"4", "Jenifer", "Amazon"});
        personData.put("5", new Object[]{"5", "Chris", "Dentolo"});

        // Step 2: Get the set of keys from the map
        Set<String> keys = personData.keySet();

        // Row number in Excel
        int rowNum = 0;
        // Iterate over the keys using a for-each loop
        for(String key : keys){
            // Get the objArr (Object[]) array associated with the key
            Object[] objArr = personData.get(key);
            // Create a new row in the sheet
            Row row = Employee.createRow(rowNum++);
            // Populate the row with data from the Object[]
            int cellNum = 0;
            for (Object obj : objArr) {
                Cell cell = row.createCell(cellNum++);
                if(obj instanceof String){
                cell.setCellValue((String)obj);}
                else if(obj instanceof Integer){
                    cell.setCellValue((Integer)obj);
                }
                else {
                    cell.setCellValue(obj.toString());
                }
            }
            try{
                FileOutputStream writeFile = new FileOutputStream("Employees.xlsx");
                //FOr macusers  /users/customDir/FileName
                workbook.write(writeFile);
            }catch(FileNotFoundException fileNotFound)
            {
                fileNotFound.printStackTrace();
            }catch(IOException ioException){
                ioException.printStackTrace();
            }
        }

    }
}
