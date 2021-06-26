import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        plugin = {"pretty",
                "json:target/cucumber_json_reports/manageTodo.json",
                "html:target/manageTodo-html"},
        strict = true,
        glue = {"todo.stepDefinitions", "todo.infrastructure"},
        features = {"src/test/resources/features/manageTodo.feature"}
)
public class ManageTodoTestRunner {
}
