package tests.day19ExcelAutomation;

import org.apache.poi.ss.usermodel.*;
import org.testng.annotations.Test;
import utilities.ConfigReader;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class ReadExcel {
    @Test
    public void readExcel() throws IOException {
        String excelPath="src/test/Resources/ulkeler.xlsx";
        FileInputStream fileInputStream=new FileInputStream(excelPath);

        //excel oldugu icin workbook olusturmak gerekiyor.
        Workbook workbook= WorkbookFactory.create(fileInputStream);
        //excelin yapisi geregi workbook icinde sheet secmeliyiz
        Sheet sheet=workbook.getSheet("sayfa1");
        //sayfadan sonra satira ulasmaliyiz
        //satir icin index girmeliyiz ,index 0 dan baslar
        //ornegin 4.celle gitmek istiyorsak index:3 olur.
        Row row=sheet.getRow(4);
        //satir icin index girmeliyiz ,index 0 dan baslar
        //ornegin 5.celle gitmek istiyorsak index:4 olur.
        Cell cell=row.getCell(3);
        //suanda cell variable inin icindeki workbook/sayfa1/5.satir/4.cell bilgisi var.
        System.out.println(cell);


    }
@Test
    public void readExcel2() throws IOException {
        //1.method da cell e ulasmak icin fis,werbook,sheet,row,cell olusturduk
        // ama celle ulasmak icin daha kisa bir yol olarak
        //fis ve werkbook olusturmak zorundayiz.
        //Cell cell=workb
        FileInputStream fileInputStream=new FileInputStream(ConfigReader.getProperty("excelPath"));
        Workbook workbook=WorkbookFactory.create(fileInputStream);
        Cell istenenHucre=workbook.getSheet(ConfigReader.getProperty("excel_sayfa_ismi")).
                           getRow(Integer.parseInt(ConfigReader.getProperty("excel_sayfa_index"))).
                           getCell(Integer.parseInt(ConfigReader.getProperty("excel_cell_index")));

    System.out.println(istenenHucre);

    //hucredeki bilginin ilk harfini yazdirin
    //eger celldeki bilgiyi sadece yazdirmak icinsout(cell) yazabiliriz.
    //ama celldeki bilgi uzerinde manipulation yapmak istersek
    //oncelikle toString() methodu ile Celli dataCasting (string )yapmaliyiz.

    System.out.println(istenenHucre.toString().substring(0,1));

    //excel sayfa1 deki satir sayisini bulun
    System.out.println(workbook.getSheet(ConfigReader.getProperty("excel_sayfa_ismi")).getLastRowNum());

    System.out.println(workbook.getSheet(ConfigReader.getProperty("excel_sayfa_ismi")).getPhysicalNumberOfRows());
}

}
