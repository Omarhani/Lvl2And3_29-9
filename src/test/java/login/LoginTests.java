package login;

import base.BaseTests;
import org.testng.annotations.Test;
import reader.ReadDataFromJson;

import java.io.FileNotFoundException;

public class LoginTests extends BaseTests {


    @Test
    public void t1() throws FileNotFoundException {
        readDataFromJson = new ReadDataFromJson();
        System.out.println(readDataFromJson.readJsonFile().URL);
        System.out.println(readDataFromJson.readJsonFile().Login.ValidCredentials.Username);
        System.out.println(readDataFromJson.readJsonFile().Login.ValidCredentials.Password);


        System.out.println(readDataFromJson.readJsonFile().Login.InvalidCredentials.InvalidUsername.Username);
        System.out.println(readDataFromJson.readJsonFile().Login.InvalidCredentials.InvalidUsername.Password);


        System.out.println(readDataFromJson.readJsonFile().Login.InvalidCredentials.InvalidPassword.Username);
        System.out.println(readDataFromJson.readJsonFile().Login.InvalidCredentials.InvalidPassword.Password);
    }
    @Test
    public void testSuccessfulLogin() {
        homePage.clickOnLoginLink();
    }
}
