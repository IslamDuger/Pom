package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

public class TestAdressLoginPage {
    //This is 1ist class
    //This class should have only TestAddressLoginPage object
    //We can also add major method in this class


    //1.Creat constructor
    public void TestAdressLoginPage() {
        //    PageFactory.initElements() will initilize this page object;

        PageFactory.initElements(Driver.getDriver(), this);

    }
      //2.@Findy:Used to find elements
    //Normal Way:
    //    WebElement username=driver.findelement(By.id("username");
     @FindBy(id="sesion_email")
                WebElement email;

     @FindBy(id="session_password")
                WebElement password;
     @FindBy(xpath = "//input[@type='submit']")
             WebElement singInButton;

}
