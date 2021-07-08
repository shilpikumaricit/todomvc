package todo.pages;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;
import java.util.stream.IntStream;


public class HomePage extends BasePage {

    public static final String URL = "url";
    public static final String TODO_ADDED_INPUT = "//ul[@class='todo-list']/li";
    private static final Logger logger = LoggerFactory.getLogger(HomePage.class);
    @FindBy(xpath = "//header/input[1]")
    private WebElement todoInput;

    @FindBy(xpath = TODO_ADDED_INPUT)
    private List<WebElement> results;

    @FindBy(xpath = "//a[contains(text(),'All')]")
    private WebElement allButton;

    @FindBy(xpath = "//a[contains(text(),'Active')]")
    private WebElement activeButton;

    @FindBy(xpath = "//div[@class='view']/input[@type='checkbox']")
    private WebElement todoRadioButton;


    public HomePage() {
        PageFactory.initElements(driver, this);
    }

    public void goToHomePage() {
        driver.get(System.getProperty(URL));
    }

    public void addTodoItem(String todo) {
        logger.info(todo);
        this.todoInput.sendKeys(todo);
        this.todoInput.sendKeys(Keys.ENTER);
    }

    public boolean isInResults(String expectedResult, int nbOfResultsToSearch) {
        logger.info("nbOfResultsToSearch:: " + expectedResult);
        logger.info("nbOfResultsToSearch:: " + nbOfResultsToSearch);
        allButton.click();
        return IntStream.range(0, Math.min(this.results.size(), nbOfResultsToSearch))
                .anyMatch(index -> this.results.get(index).getText().contains(expectedResult));
    }

    public boolean isDisplayedWithResults(int nbOfResultsToSearch) {
        logger.info("nbOfResultsToSearch:: " + nbOfResultsToSearch);
        allButton.click();
        return results.size() == nbOfResultsToSearch;
    }

    public void clickOnAllButton() {
        allButton.click();
    }

    public void clickOnActiveButton() {
        activeButton.click();
    }

    public void removeTodo(String todo) {
        todoRadioButton.click();
    }

    public boolean isRemovedFromTheFirstResults(String expectedResult) {
        logger.info("nbOfResultsToSearch:: " + expectedResult);
        activeButton.click();
        return results.stream().filter(we -> we.getText().equals(expectedResult)).count() == 0;
    }

    public boolean isDisplayedInTheResults(String expectedResult) {
        logger.info("nbOfResultsToSearch:: " + expectedResult);
        activeButton.click();
        return results.stream().filter(we -> we.getText().equals(expectedResult)).count() == 1;

    }

    public boolean verifyNumberOfTodo(int nbOfResultsToSearch, String actionButton) {
        logger.info("nbOfResultsToSearch:: " + nbOfResultsToSearch);
        logger.info("actionButton:: " + actionButton);
        if (actionButton.equals("Active")) {
            activeButton.click();
        } else if (actionButton.equals("All")) {
            allButton.click();
        }
        return results.size() == nbOfResultsToSearch;
    }
}
