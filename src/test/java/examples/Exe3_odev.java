package examples;

import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;
import pages.KoalaResortLoginPage;
import pages.KoalaResortPage;
import utilities.ConfigReader;
import utilities.Driver;

public class Exe3_odev {

 /*
    login() metodun oluşturun ve oturum açın.
    ● http://qa-environment.koalaresorthotels.com /admin/HotelRoomAdmin adresine gidin
                ○ Username : manager
                ○ Password : Manager1!
    ● table() metodu oluşturun
                ○ Tüm table body’sinin boyutunu(sutun sayisi) bulun. /tbody
                ○ Table’daki tum body’I ve başlıkları(headers) konsolda yazdırın.
    ● printRows() metodu oluşturun //tr
                ○ table body’sinde bulunan toplam satir(row) sayısını bulun.
                ○ Table body’sinde bulunan satirlari(rows) konsolda yazdırın.
                ○ 4.satirdaki(row) elementleri konsolda yazdırın.
     */
@Test
    public void table() {

    KoalaResortPage koalaResortPage = new KoalaResortPage();
    koalaResortPage.koalaResortLoginn();
//     ● table() metodu oluşturun
//                ○ Tüm table body’sinin boyutunu(sutun sayisi) bulun. /tbody
    System.out.println(koalaResortPage.sutunsayisi.size());

//   ○ Table’daki tum body’I ve başlıkları(headers) konsolda yazdırın.
    for (WebElement each : koalaResortPage.sutunverileri) {
        System.out.println(each.getText());
    }
}
@Test
    public void printRows() {
    KoalaResortPage koalaResortPage=new KoalaResortPage();
    koalaResortPage.koalaResortLoginn();
//  ● printRows() metodu oluşturun //tr
//  ○ table body’sinde bulunan toplam satir(row) sayısını bulun.
    System.out.println(koalaResortPage.bodySatirsayisi.size());

//  ○ Table body’sinde bulunan satirlari(rows) konsolda yazdırın.
    for (WebElement each: koalaResortPage.bodySatirsayisi)
        System.out.println(each.getText());
//  ○ 4.satirdaki(row) elementleri konsolda yazdırın.
    for (WebElement each:koalaResortPage.dortduncuSatirElementeri){
        System.out.println(each.getText());
    }
    System.out.println(koalaResortPage.bodySatirsayisi.get(3).getText());


}

}
