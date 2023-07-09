package practice.test;


import driver.WebDriverHolder;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeSuite;
import utils.FirstPropertiesReader;

public class BaseTestClass_Holder_New {
    protected WebDriver driver;

    @BeforeSuite
    public void beforeClass() {
//        WebDriverHolder.getInstance().getDriver();
        driver = WebDriverHolder.getInstance().getDriver();
    }

    @AfterSuite
    public void afterClass() {
        WebDriverHolder.getInstance().driverQuit();
    }

    public void goToUrl(String url) {
        WebDriverHolder.getInstance().getDriver().get(url);
    }

    public void goToUrl() {
        goToUrl(FirstPropertiesReader.getInstance().getProperties("app.base.url"));
    }

    public void goToPart(String part) {
        goToUrl(FirstPropertiesReader.getInstance().getProperties("app.base.url") + part);
    }
}
