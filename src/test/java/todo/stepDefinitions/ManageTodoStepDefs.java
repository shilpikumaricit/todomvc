package todo.stepDefinitions;

import cucumber.annotation.en.Given;
import todo.BaseTests;

public class ManageTodoStepDefs extends BaseTests {
    @Given("User navigates to the website")
    public void navigateToWebsite(){
        driver.get(System.getProperty("url"));
    }

}
