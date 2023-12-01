package base;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import pages.HomePage;
import reader.ReadDataFromJson;

import java.io.FileNotFoundException;

public class BaseTests {
    WebDriver driver;
    protected ReadDataFromJson readDataFromJson;
    protected HomePage homePage;
    ChromeOptions chromeOptions ;
    FirefoxOptions firefoxOptions;

    @BeforeClass
    @Parameters("browser")
    public void setUp(String browser) throws FileNotFoundException {
        readDataFromJson = new ReadDataFromJson();
        setUpBrowser(browser);
        driver.get(readDataFromJson.readJsonFile().URL);
        homePage = new HomePage(driver);
    }
    @Parameters("browser")
    private void setUpBrowser(String browser){
        if (browser.equalsIgnoreCase("Chrome")){
            driver = new ChromeDriver();
        } else if (browser.equalsIgnoreCase("firefox")) {
            driver = new FirefoxDriver();
        } else if (browser.equalsIgnoreCase("headlessChrome")) {
            chromeOptions = new ChromeOptions();
            chromeOptions.addArguments("--headless");
            driver = new ChromeDriver(chromeOptions);
        } else if (browser.equalsIgnoreCase("headlessFirefox")) {
            firefoxOptions = new FirefoxOptions();
            firefoxOptions.addArguments("--headless");
            driver = new FirefoxDriver(firefoxOptions);
        }
    }
    @AfterClass
    public void tearDown(){
        driver.quit();
    }
}
