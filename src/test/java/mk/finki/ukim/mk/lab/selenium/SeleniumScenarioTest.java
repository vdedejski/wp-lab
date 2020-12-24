package mk.finki.ukim.mk.lab.selenium;

import mk.finki.ukim.mk.lab.model.Balloon;
import mk.finki.ukim.mk.lab.model.User;
import mk.finki.ukim.mk.lab.service.AuthService;
import mk.finki.ukim.mk.lab.service.BalloonService;
import mk.finki.ukim.mk.lab.service.ManufacturerService;
import org.junit.Test;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.htmlunit.HtmlUnitDriver;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

import java.util.ArrayList;
import java.util.List;

@ActiveProfiles(profiles = "test")
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.DEFINED_PORT)
public class SeleniumScenarioTest {

    @Autowired
    private BalloonService balloonService;

    @Autowired
    private ManufacturerService manufacturerService;

    @Autowired
    private AuthService authService;

    private HtmlUnitDriver htmlUnitDriver;

    private static List<Balloon> balloonList;

    private static User adminUser;

    private static String admin = "admin";

    private static boolean dataInitialized = false;

    @BeforeEach
    private void setup() {
        this.htmlUnitDriver = new HtmlUnitDriver(true);
        initData();
    }

    @AfterEach
    public void destroy() {
        if (this.htmlUnitDriver != null) {
            this.htmlUnitDriver.close();
        }
    }

    private void initData() {
        if (!dataInitialized) {
            balloonList = new ArrayList<>();
            balloonList.add(new Balloon("test", "testDescription"));

            adminUser = authService.getUser("admin");
            dataInitialized = true;
        }
    }

    @Test
    public void testButtonsIfNotLoggedIn() {
        BalloonsPage balloonsPage = BalloonsPage.to(this.htmlUnitDriver);
        balloonsPage.assertElement(0, 0, 0, 0, 0);

        LoginPage loginPage = LoginPage.openLogin(this.htmlUnitDriver);
        balloonsPage = LoginPage.doLogin(this.htmlUnitDriver, loginPage, "admin", "admin");
        balloonsPage.assertElement(0, 0, 0, 0, 1);
    }

}
