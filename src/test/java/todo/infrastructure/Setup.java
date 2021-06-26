package todo.infrastructure;

import io.cucumber.java.Before;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

public class Setup {

    public static WebDriver driver;

    @Before
    public void setWebDriver() {

        String browser = System.getProperty("browser");
        loadTestProperties();
        if (browser == null) {
            browser = "chrome";
        }
        switch (browser) {
            case "chrome":
                ChromeOptions chromeOptions = new ChromeOptions();
                chromeOptions.addArguments("['start-maximized']");
                driver = new ChromeDriver(chromeOptions);
                break;
            case "firefox":
                driver = new FirefoxDriver();
                driver.manage().window().maximize();
                break;
            default:
                throw new IllegalArgumentException("Browser \"" + browser + "\" isn't supported.");
        }
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
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
