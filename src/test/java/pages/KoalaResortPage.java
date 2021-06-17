package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.ConfigReader;
import utilities.Driver;

import java.util.List;

public class KoalaResortPage {
    public KoalaResortPage(){
        PageFactory.initElements(Driver.getDriver(),this);
    }

    @FindBy(linkText = "Log in")
    public WebElement ilkLoginLinki;

    @FindBy(id = "UserName")
    public WebElement kullaniciAdiTextBox;


    @FindBy(id = "Password")
    public WebElement passwordTexBox;

    @FindBy(id = "btnSubmit")
    public WebElement loginButonu;

    @FindBy(xpath = "//*[text()='Try again please']")
    public WebElement girisYapilamadiElementi;

    @FindBy (xpath = "//*[text()='Hotel Management']")
    public WebElement hotelManagement;

    @FindBy (partialLinkText = "Hotel List")
    public WebElement hotelList;

    @FindBy (xpath = "//*[text()='Add Hotel ']")
    public WebElement addHotel;

    @FindBy(id = "Code")
    public WebElement codeTextBox;

    @FindBy(id = "IDGroup")
    public WebElement acilirMenu;

    @FindBy(xpath ="//button[@id='btnSubmit']")
    public WebElement saveButonu;

    @FindBy(xpath = "//div[@class='bootbox-body']")
    public WebElement sonucYazisiElementi;

    @FindBy(xpath = "//*[text()='OK']")
    public WebElement sonOKButonu;

    @FindBy(partialLinkText = "Hotel Rooms")
    public WebElement hotelRooms;

    @FindBy(partialLinkText = "ADD HOTELROOM")
    public WebElement addHotelRoom;

    @FindBy(id = "IDHotel")
    public WebElement idHotelDropdown;
    @FindBy(id="Code")
    public WebElement codeSec;
    @FindBy(id="Name")
    public WebElement nameSelect;

    @FindBy(id="Location")
    public WebElement locationSelect;
    @FindBy(xpath = "//textarea[@dir='ltr']")
    public WebElement descriptionSelect;
    @FindBy(xpath= "//*[@id='Price']")
    public WebElement priceSelect;

    @FindBy(xpath = "//textarea[@dir='ltr']")
    public WebElement roomTextBox;

    @FindBy(linkText = "500")
    public WebElement fiyatBesYuzButonu;

    @FindBy(id = "Price")
    public WebElement priceTextBox;

    @FindBy(id = "IDGroupRoomType")
    public WebElement roomTypeDropdown;

    @FindBy(id = "MaxAdultCount")
    public WebElement maxAdultCount;

    @FindBy(id = "MaxChildCount")
    public WebElement maxChildCount;
    @FindBy(xpath = "//*[@name='IsAvailable']")
    public WebElement isAvailable;

    @FindBy(id="btnSubmit")
    public WebElement saveAddekiButtonu;

    @FindBy(xpath = "//*[text()='HotelRoom was inserted successfully']")
    public WebElement roomCreatedElementi;

    @FindBy(xpath = "//button[@class='btn btn-primary']")
    public WebElement roomCreateSonOK;

    @FindBy(partialLinkText = "Hotel Rooms")
    public WebElement hotelRoomsButonu;

    @FindBy(xpath = "(//*[text()='List Of Hotelrooms'])[2]")
    public WebElement hotelRoomListYaziElementi;


    @FindBy(xpath = "//tbody//tr[1]//td")
    public List<WebElement> birinciSatirDatalar;


    @FindBy(xpath = "//thead//tr[1]//th")
    public List<WebElement> sutunBasliklari;

    @FindBy(xpath = "//tbody")
    public WebElement tbodyWebElement;

    @FindBy(xpath = "//tbody//td")
    public List<WebElement> bodydekiTumDataListesi;

    @FindBy(xpath = "//tbody//tr")
    public List<WebElement> satirlarListesi;

    @FindBy(xpath = "//thead//th")
    public List<WebElement>sutunsayisi;
    @FindBy(xpath ="//thead//tr[1]//t")
    public List<WebElement>sutunverileri;
    @FindBy(xpath = "//tbody//tr")
     public List<WebElement>bodySatirsayisi;
    @FindBy(xpath = "//tbody//tr[4]//td")
    public List<WebElement>dortduncuSatirElementeri;


    public void koalaResortLoginn(){
        Driver.getDriver().get(ConfigReader.getProperty("kr_url"));
        ilkLoginLinki.click();
        kullaniciAdiTextBox.sendKeys(ConfigReader.getProperty("kr_valid_username"));
        passwordTexBox.sendKeys(ConfigReader.getProperty("kr_valid_password"));
        loginButonu.click();
    }

    public void istenenSatiriYazdir(int satirNo){

        // =====  //tbody//tr[3]

        String satirXPath="//tbody//tr[" + (satirNo-1) + "]";

        System.out.println(Driver.getDriver().findElement(By.xpath(satirXPath)).getText());


    }
    public String dataStringBul(int satirNo, int sutunNo){
        // ornek : her 3. satirdaki 2.sutunu bulmak istersek //tbody//tr[3]//td[2] yazabiliriz
        String dataPath="//tbody//tr["+ satirNo +"]//td["+sutunNo+"]";

        return Driver.getDriver().findElement(By.xpath(dataPath)).getText();
    }

    public WebElement dataWebelementiBul(int satirNo, int sutunNo){
        // ornek : her 3. satirdaki 2.sutunu bulmak istersek //tbody//tr[3]//td[2] yazabiliriz
        String dataPath="//tbody//tr["+ satirNo +"]//td["+sutunNo+"]";

        return Driver.getDriver().findElement(By.xpath(dataPath));
    }

    public void istenenHucreyiYazdir(int satirNo, int sutunNo){

        // ornek : 5.satir 4 sutunu yazdir  //tbody//tr[   5   ]//td[   4    ]
        String hucreXPath= "//tbody//tr["+ satirNo +"]//td["+ sutunNo + "]";

        WebElement istenenDataElementi= Driver.getDriver().findElement(By.xpath(hucreXPath));

        System.out.println(istenenDataElementi.getText());
    }




}