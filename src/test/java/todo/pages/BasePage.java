package todo.pages;

import org.apache.log4j.LogManager;
import org.openqa.selenium.WebDriver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import todo.infrastructure.Setup;
import todo.infrastructure.Wait;

public class BasePage {
    public static WebDriver driver;
    public  static Wait wait;
    private final Logger log = LoggerFactory.getLogger(BasePage.class);

    public BasePage() {
        log.info("Base Page");
        this.driver = Setup.driver;
        this.wait = new Wait(this.driver);
    }
}
