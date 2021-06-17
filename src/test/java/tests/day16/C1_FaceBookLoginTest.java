package tests.day16;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;
import pages.FacebookLoginPage;
import utilities.TestBase;

public class C1_FaceBookLoginTest extends TestBase {
    @Test (groups = {"mini_regression","smoke"})
    public void gelenekselTest(){
        driver.get("https://facebook.com");
        driver.findElement(By.xpath("//*[@title='Alles accepteren']")).click();
        WebElement emailText= driver.findElement(By.id("email"));
        emailText.sendKeys("selam@gmail.com");
        WebElement paaswordText= driver.findElement(By.id("pass"));
        paaswordText.sendKeys("1234");
        driver.findElement(By.xpath("//button[@name='login']")).click();


    }
    @Test (groups = "mini_regression")
    public void pageIleTest(){
        driver.get("https://facebook.com");

        FacebookLoginPage facebookLoginPage=new FacebookLoginPage(driver);
        facebookLoginPage.cookies.click();
        facebookLoginPage.emailTextBox.sendKeys("selam@gmail.com");
        facebookLoginPage.passwordTexBox.sendKeys("12334");
        facebookLoginPage.sendbutton.click();


    }
}
