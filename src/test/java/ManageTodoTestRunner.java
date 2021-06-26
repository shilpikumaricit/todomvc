import cucumber.junit.Cucumber;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@Cucumber.Options(
        glue = {"todo.stepDefinitions"},
        features = {"src/test/resources/manageTodo.feature"}
)
public class ManageTodoTestRunner {
}
