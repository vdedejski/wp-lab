package mk.finki.ukim.mk.lab.selenium;

import lombok.Getter;
import org.openqa.selenium.WebDriver;

@Getter
public class AbstractPage {

    protected WebDriver webDriver;

    static void get (WebDriver webDriver, String relativeUrl){
        String url = System.getProperty("geb.build.baseUrl", "http://localhost:9999") + relativeUrl;
        webDriver.get(url);
        System.out.println(url);
    }

    public AbstractPage(WebDriver webDriver) {
        this.webDriver = webDriver;
    }
}
