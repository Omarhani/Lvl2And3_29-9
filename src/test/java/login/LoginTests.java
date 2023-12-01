package login;

import base.BaseTests;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import reader.ReadDataFromJson;

import java.io.FileNotFoundException;

public class LoginTests extends BaseTests {

    @DataProvider
    public Object[][] t2() throws FileNotFoundException {
        readDataFromJson = new ReadDataFromJson();
        return readDataFromJson.readJsonFile().Login1;
    }
    @Test(dataProvider = "t2")
    public void t1(String username,String password) {
        System.out.println(username);
        System.out.println(password);
    }
    @Test
    public void testSuccessfulLogin() {

    }
}
