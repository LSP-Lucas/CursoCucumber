package runners;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.BeforeClass;
import org.junit.runner.RunWith;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

@RunWith(Cucumber.class)
@CucumberOptions(
        plugin = "pretty",
        snippets = CucumberOptions.SnippetType.CAMELCASE,
        features="C://Cursos//CursoCucumber//src//test//resources//features",
        glue = {"steps", "config"},
        tags = {"@unitários", "not @ignore"},
        dryRun = false
        )
public class RunnerTest {

}
