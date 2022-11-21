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
        plugin = {"pretty", "html:target/report-html", "json:target/report.json"},
        snippets = CucumberOptions.SnippetType.CAMELCASE,
        features="C://Cursos//CursoCucumber//src//test//resources//features",
        glue = {"steps", "config"},
        tags = {"@funcionais"},
        dryRun = false
)
public class RunnerFuncionalTest {

    @BeforeClass
    public static void reset() {
        System.setProperty("webdriver.chrome.driver", "C://Estudos//chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.get("https://seubarriga.wcaquino.me");
        driver.findElement(By.id("email")).sendKeys("lucassppedroso@gmail.com");
        driver.findElement(By.name("senha")).sendKeys("12345");
        driver.findElement(By.tagName("button")).click();
        driver.findElement(By.linkText("reset")).click();
        driver.quit();
    }
}
