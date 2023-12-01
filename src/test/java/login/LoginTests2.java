package login;

import base.BaseTests;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import pages.LoginPage;
import reader.ReadDataFromJson;

import java.io.FileNotFoundException;

public class LoginTests2 extends BaseTests {

    @DataProvider
    public Object[][] t2() throws FileNotFoundException {
        readDataFromJson = new ReadDataFromJson();
        return readDataFromJson.readJsonFile().Login1;
    }
    @Test(dataProvider = "t2")
    public void testSuccessfulLogin2(String username,String password) {
        LoginPage loginPage  = homePage.clickOnLoginLink();
        loginPage.loginFeature(username,password);
    }
    @Test(dataProvider = "t2")
    public void testSuccessfulLogin22(String username,String password) {
        LoginPage loginPage  = homePage.clickOnLoginLink();
        loginPage.loginFeature(username,password);
    }
}
