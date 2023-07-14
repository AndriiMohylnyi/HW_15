package practice.test;


import driver.WebDriverHolder;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import utils.FirstPropertiesReader;
import utils.MyFilesUtils;

import java.io.IOException;

public class BaseTestClass_Holder_New_Files {
    protected WebDriver driver;

    @BeforeSuite
    public void beforeClass() throws IOException {
        driver = WebDriverHolder.getInstance().getDriver();
        MyFilesUtils.clearFilesFolder();
        MyFilesUtils.clearDownloadsFolder();
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
