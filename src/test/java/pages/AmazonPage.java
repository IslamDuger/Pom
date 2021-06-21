package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.ConfigReader;
import utilities.Driver;

import java.util.List;

public class AmazonPage {
    public AmazonPage(){
        PageFactory.initElements(Driver.getDriver(),this);
    }
    @FindBy(xpath = "//table[@class='navFooterMoreOnAmazon']")
    public WebElement table;
    @FindBy(xpath = "//tbody//tr")
    public List<WebElement> tableSatirSayilari;
    @FindBy(xpath = "//tbody//tr[1]//td")
    public List<WebElement> birinciSatirtumSutunSayilari;
    @FindBy(xpath = "//tbody//tr//td")
        public List<WebElement> amazonYazisiAra;
    @FindBy(xpath = "//tbody//tr[5]//td[3]")
    public WebElement homeService;

    @FindBy(xpath = "//tbody//tr//td")
    public List<WebElement>tableTamami;
    public void getamazonPage(){
        Driver.getDriver().get(ConfigReader.getProperty("amazon_url"));
    }
    public void altaGitTabloyuBul(){
        Actions actions=new Actions(Driver.getDriver());
        actions.moveToElement(table);

    }
    public String satirSutundakiBilgiyiGetir(int satirNo, int sutunNo){
        String dataPath="//tbody//tr["+ satirNo +"]//td["+sutunNo+"]";
        return Driver.getDriver().findElement(By.xpath(dataPath)).getText();
    }
}

