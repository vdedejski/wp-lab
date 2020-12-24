package mk.finki.ukim.mk.lab.selenium;

import lombok.Getter;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

@Getter
public class BalloonsPage extends AbstractPage{

    public BalloonsPage(WebDriver webDriver) {
        super(webDriver);
    }

    @FindBy(css = "tr[class=balloon]")
    private List<WebElement> productRows;

    @FindBy(css = ".delete-product")
    private List<WebElement> deleteButton;

    @FindBy(css = ".edit-product")
    private List<WebElement> editButton;

    @FindBy(css = ".add-to-cart")
    private List<WebElement> addToCartButton;

    @FindBy(css = ".add-balloon")
    private List<WebElement> addBalloon;

    public static BalloonsPage to(WebDriver webDriver){
        get(webDriver, "/balloons");
        return PageFactory.initElements(webDriver, BalloonsPage.class);
    }

    public void assertElement(int ballonsNumber, int deleteButtons, int editButtons, int addToCartButtons, int addButtons){
        Assert.assertEquals("rows do not match", ballonsNumber, this.getProductRows().size());
        Assert.assertEquals("delete do not match", deleteButtons, this.getDeleteButton().size());
        Assert.assertEquals("edit do not match", editButtons, this.getEditButton().size());
        Assert.assertEquals("cart do not match", addToCartButtons, this.getAddToCartButton().size());
        Assert.assertEquals("add is visible", addButtons, this.getAddBalloon().size());

    }

}
