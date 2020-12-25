package mk.finki.ukim.mk.lab.selenium;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

public class AddProductPage extends AbstractPage{

    private WebElement name;
    private WebElement description;
    private WebElement manufacturer;
    private WebElement submit;


    public AddProductPage(WebDriver webDriver) {
        super(webDriver);
    }

    public static BalloonsPage addProduct(WebDriver webDriver, String balloonName, String balloonDescription, String manufacturer){
        get(webDriver, "/form");
        AddProductPage addProductPage = PageFactory.initElements(webDriver, AddProductPage.class);
        addProductPage.name.sendKeys(balloonName);
        addProductPage.description.sendKeys(balloonDescription);
        addProductPage.manufacturer.click();
        addProductPage.manufacturer.findElement(By.xpath("//option[. = '" + manufacturer + "']")).click();

        addProductPage.submit.click();
        return PageFactory.initElements(webDriver, BalloonsPage.class);
    }
}
