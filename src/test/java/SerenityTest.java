import cucumber.api.CucumberOptions;
import net.serenitybdd.cucumber.CucumberWithSerenity;
import net.serenitybdd.junit.runners.SerenityParameterizedRunner;
import net.thucydides.core.annotations.Managed;
import net.thucydides.junit.annotations.Concurrent;
import org.junit.After;
import org.junit.runner.RunWith;
import org.openqa.selenium.WebDriver;

/**
 * Created by dharmens on 5/9/17.
 */

@RunWith(CucumberWithSerenity.class)
//@RunWith(SerenityParameterizedRunner.class)
@Concurrent(threads="3")
@CucumberOptions(features = { "src/test/resources" },
         tags = {"@Smoke"})
         //plugin = {"html:/Users/dharmens/Downloads/Projects/Serenity/target/cucumber-parallel/*"})
public class SerenityTest {

    @Managed(driver = "chrome")
    WebDriver driver;

    @After
    public void tearDown(){
        driver.quit();
    }
}
