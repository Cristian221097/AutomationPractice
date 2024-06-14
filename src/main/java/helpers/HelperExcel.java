package helpers;

import org.apache.poi.ss.usermodel.*;
import org.testng.Assert;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class HelperExcel {

    private static HelperExcel instance = null;

    private Workbook workbook;
    private Sheet sheet;
    private Row row;
    private Cell cell;

    private HelperExcel() {
    }

    public static HelperExcel getInstance() {
        if (instance == null) {
            instance = new HelperExcel();
        }
        return instance;
    }

    private void initializeExcelFile(String path, String sheetName) {

        try {
            File file = new File(path);
            InputStream input = new FileInputStream(file);
            workbook = WorkbookFactory.create(input);
            sheet = workbook.getSheet(sheetName);

        } catch (Exception err) {
            System.out.println("Error al inicializar el archivo " + path);
            Assert.fail();
        }

    }

    public List<Map<String, String>> getDataExcel(String path, String nameFile, String sheetName) {
        List<Map<String, String>> result = new ArrayList<>();
        List<String> titleColumn = new ArrayList<>();
        try {
            initializeExcelFile(path + "\\" + nameFile + ".xlsx", sheetName);
            int quantityRows = sheet.getLastRowNum() - sheet.getFirstRowNum();

            for (int r = 0; r < quantityRows; r++) {

                Map<String, String> register = new HashMap<>();
                row = sheet.getRow(r);

                int quantityCells = row.getLastCellNum() - row.getFirstCellNum();
                for (int c = 0; c < quantityCells; c++) {
                    cell = row.getCell(c);

                    String cellValue = getCellValue();
                    setCellDataIntoRegister(register,titleColumn,r,c,cellValue);

                }

                if (!register.isEmpty()) {
                    result.add(register);
                }
            }

        } catch (Exception err) {
            System.out.println("Error al obtener la data del excel: " + nameFile);
            Assert.fail();
        }

        return result;
    }

    private String getCellValue() {
        String cellValue = "";
        try {
            if (cell == null) {
                cellValue = "";
            } else if (cell.getCellType() == CellType.NUMERIC) {
                cellValue = String.valueOf(cell.getNumericCellValue());
            } else if (cell.getCellType() == CellType.STRING) {
                cellValue = cell.getStringCellValue();
            }
        } catch (Exception err) {
            System.out.println("Error al obtener el valor de la celda: " + cell.getStringCellValue());
            Assert.fail();
        }
        return cellValue;
    }

    private void setCellDataIntoRegister( Map<String, String> register,List<String> titleColumn,int r,int c,String cellValue){
        if (r == 0) {
            titleColumn.add(cellValue);
        } else {
            register.put(titleColumn.get(c), cellValue);
        }
    }


}
