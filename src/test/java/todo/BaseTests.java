package todo;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterSuite;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class BaseTests {
    public static WebDriver driver;


    public BaseTests() {
        loadTestProperties();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
    }

    @AfterSuite
    public static void closeBrowser() {
        driver.quit();
    }

    private static void loadTestProperties(){
        try (InputStream input = new FileInputStream("src/test/resources/config.properties")) {
            Properties prop = new Properties();
            prop.load(input);
            System.setProperty("url",prop.getProperty("url"));
            System.setProperty("webdriver.chrome.driver", prop.getProperty("webdriver.chrome.driver"));

        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }
}
