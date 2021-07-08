package todo.stepDefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import todo.pages.BasePage;
import todo.pages.HomePage;

public class ManageTodoStepDefs extends BasePage {

    private HomePage homePage;

    public ManageTodoStepDefs() {
        this.homePage = new HomePage();
    }

    @Given("User navigates to the website")
    public void navigateToWebsite() {
        homePage.goToHomePage();
    }

    @When("^a user enter todo \"([^\"]*)\"$")
    public void addTodoItem(String todo) {
        this.homePage.addTodoItem(todo);
    }

    @Then("^\"([^\"]*)\" is displayed in the first \"([^\"]*)\" results$")
    public void isDisplayedInTheFirstResults(String expectedResult, int nbOfResultsToSearch) {
        Assert.assertTrue(expectedResult + " wasn't found in the first " + nbOfResultsToSearch + " results.",
                this.homePage.isInResults(expectedResult, nbOfResultsToSearch));
    }

    @Then("^User is displayed with \"([^\"]*)\" results$")
    public void isDisplayedWithResults(int nbOfResultsToSearch) {
        Assert.assertTrue(nbOfResultsToSearch + " results.",
                this.homePage.isDisplayedWithResults(nbOfResultsToSearch));
    }

    @Then("user click on All button")
    public void clickOnAllButton() {
        this.homePage.clickOnAllButton();
    }

    @Then("user click on Active button")
    public void clickOnActiveButton() {
        this.homePage.clickOnActiveButton();
    }

    @Then("^\"([^\"]*)\" is displayed in the results")
    public void isDisplayedInTheResults(String expectedResult) {
        Assert.assertTrue(expectedResult + " was found in the first " + " results.",
                this.homePage.isDisplayedInTheResults(expectedResult));
    }

    @When("^user click on radio button for todo item \"([^\"]*)\"$")
    public void removeTodo(String todo) {
        this.homePage.removeTodo(todo);
    }

    @Then("^\"([^\"]*)\" is removed from the Active todo list")
    public void isRemovedFromTheFirstResults(String expectedResult) {
        Assert.assertTrue(expectedResult + " was found in the first ",
                this.homePage.isRemovedFromTheFirstResults(expectedResult));
    }

    @Then("^\"([^\"]*)\" todo is displayed in \"([^\"]*)\" results$")
    public void verifyNumberOfTodo(int nbOfResultsToSearch, String actionButton) {
        Assert.assertTrue(this.homePage.verifyNumberOfTodo(nbOfResultsToSearch, actionButton));
    }

}
