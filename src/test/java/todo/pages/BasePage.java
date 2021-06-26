package todo.pages;

import org.openqa.selenium.WebDriver;
import todo.infrastructure.Setup;
import todo.infrastructure.Wait;

public class BasePage {
    public static WebDriver driver;
    public  static Wait wait;

    public BasePage() {
        this.driver = Setup.driver;
        this.wait = new Wait(this.driver);
    }
}
