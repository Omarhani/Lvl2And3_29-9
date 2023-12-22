package base;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.testng.ITestResult;
import org.testng.annotations.*;
import pages.HomePage;
import reader.ReadDataFromJson;
import utils.ScreenRecorderUtil;
import utils.UtilsTests;
import java.lang.reflect.Method;

public class BaseTests {
    WebDriver driver;
    protected ReadDataFromJson readDataFromJson;
    UtilsTests utilsTests;
    protected HomePage homePage;
    ChromeOptions chromeOptions ;
    FirefoxOptions firefoxOptions;

    @BeforeClass
    @Parameters("browser")
    public void setUp(String browser) {
        readDataFromJson = new ReadDataFromJson();
        setUpBrowser(browser);

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
    @BeforeMethod
    public void goHome(Method method) throws Exception {
        driver.get(readDataFromJson.readJsonFile().URL);
        ScreenRecorderUtil.startRecord(method.getName());
    }
    @AfterMethod
    public void afterMethod(Method method, ITestResult result) throws Exception {
        utilsTests = new UtilsTests(driver);
        utilsTests.takeScreenShot(method);
        ScreenRecorderUtil.stopRecord();
        utilsTests.setStatus(method,result);
    }
    @BeforeSuite
    public void beforeSuite(){
        utilsTests = new UtilsTests(driver);
        utilsTests.createReport();
    }

    @AfterSuite
    public void afterSuite(){
        utilsTests = new UtilsTests(driver);
        utilsTests.flushReport();
    }

}
