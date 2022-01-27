import io.cucumber.junit.CucumberOptions;
import io.cucumber.testng.AbstractTestNGCucumberTests;

@CucumberOptions(
        plugin = {"pretty",
                "json:target/cucumber_json_reports/manageTodo.json",
                "html:target/manageTodo-html"},
        strict = true,
        glue = {"todo.stepDefinitions", "todo.infrastructure"},
        features = {"src/test/resources/features/manageTodo.feature"}
)
public class ManageTodoTestRunner extends AbstractTestNGCucumberTests {
}
