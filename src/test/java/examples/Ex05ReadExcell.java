package examples;

import org.apache.poi.ss.usermodel.*;
import org.testng.annotations.Test;
import utilities.ConfigReader;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class Ex05ReadExcell {
    @Test
    public void readerExcell() throws IOException {
        String excelPath="src/test/Resources/ulkeler.xlsx";
        FileInputStream fileInputStream=new FileInputStream(excelPath);
        Workbook workbook= WorkbookFactory.create(fileInputStream);
        Sheet sheet=workbook.getSheet("sayfa1");
        Row row=sheet.getRow(4);
        Cell cell=row.getCell(3);
        System.out.println(cell);
    }
    @Test
    public void readExcel02() throws IOException {
        FileInputStream fileInputStream=new FileInputStream(ConfigReader.getProperty("excelPath"));
        Workbook workbook=WorkbookFactory.create(fileInputStream);
        Cell istenenHucre=workbook.getSheet(ConfigReader.getProperty("excel_sayfa_ismi")).
                          getRow(Integer.parseInt(ConfigReader.getProperty("excel_sayfa_index"))).
                          getCell(Integer.parseInt(ConfigReader.getProperty("excel_cell_index")));
        System.out.println(istenenHucre);
    workbook.close();
    fileInputStream.close();
    }

}
