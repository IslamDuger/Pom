package examples;

import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;
import pages.KoalaResortPage;
import utilities.ConfigReader;
import utilities.Driver;

public class Ex04_CreatHotelRoom {
    @Test
    public void creatHotelRoom(){
//Create class HotelRoomCreation
        KoalaResortPage koalaResortPage=new KoalaResortPage();
        koalaResortPage.koalaResortLoginn();

//Click on Hotel Management
       koalaResortPage.hotelManagement.click();
//Click on Hotel Rooms
        koalaResortPage.hotelRooms.click();
//Click on Add Hotel Room
        koalaResortPage.addHotelRoom.click();
//Enter All required fields
        Select select=new Select(koalaResortPage.idHotelDropdown);
        select.selectByIndex(21);
        Actions actions=new Actions(Driver.getDriver());
        actions.sendKeys(koalaResortPage.codeSec, ConfigReader.getProperty("kr_code")).
                sendKeys(Keys.TAB).
                sendKeys(koalaResortPage.nameSelect,ConfigReader.getProperty("kr_customer_name")).
                sendKeys(Keys.TAB).
                sendKeys(koalaResortPage.locationSelect,ConfigReader.getProperty("kr_customer_adress")).
                sendKeys(koalaResortPage.descriptionSelect,ConfigReader.getProperty("kr_room_text")).
                sendKeys(Keys.TAB).
                dragAndDrop(koalaResortPage.fiyatBesYuzButonu,koalaResortPage.priceSelect).
                perform();
        Select roomType=new Select(koalaResortPage.roomTypeDropdown);
        roomType.selectByValue("322");
        actions.sendKeys(koalaResortPage.maxAdultCount,ConfigReader.getProperty("kr_adult_count")).
                sendKeys(Keys.TAB).
                sendKeys(koalaResortPage.maxChildCount,ConfigReader.getProperty("kr_child_count")).
                sendKeys(Keys.TAB).
                click(koalaResortPage.isAvailable).
                sendKeys(Keys.TAB).
                click(koalaResortPage.saveAddekiButtonu).
                perform();
     //To enter a price, we can send keys
//Click Save
//Verify the message: HotelRoom was inserted successfully
//Click OK
        Driver.closeDriver();

    }
}
