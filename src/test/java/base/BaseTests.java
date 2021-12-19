package base;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import pages.HomePage;

import java.net.MalformedURLException;
import java.net.URL;


public class BaseTests {
    protected WebDriver driver;
    protected HomePage homePage;

    @BeforeMethod
    public void openBrowser() throws MalformedURLException {
        String browser = System.getProperty("browser");
        if(browser != "" && browser != null) {
            if (browser.equalsIgnoreCase("Chrome")) {
                ChromeOptions chromeOptions = new ChromeOptions();
                driver = new RemoteWebDriver(new URL("http://localhost:4444/wd/hub"), chromeOptions);
            } else if (browser.equalsIgnoreCase("Firefox")) {
                FirefoxOptions firefoxOptions = new FirefoxOptions();
                driver = new RemoteWebDriver(new URL("http://localhost:4444/wd/hub"), firefoxOptions);
            } else {
                ChromeOptions chromeOptions = new ChromeOptions();
                driver = new RemoteWebDriver(new URL("http://localhost:4444/wd/hub"), chromeOptions);
            }
        }
        driver.get("https://the-internet.herokuapp.com/");
        driver.manage().window().maximize();
        homePage = PageFactory.initElements(driver,HomePage.class);
    }

    @AfterMethod
    public void closeBrowser(){
        driver.quit();
    }

}
