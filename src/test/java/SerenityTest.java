import Pages.FlightOptions;
import Pages.PlanTravel;
import cucumber.api.CucumberOptions;
import net.serenitybdd.cucumber.CucumberWithSerenity;
import net.thucydides.core.annotations.DefaultUrl;
import net.thucydides.core.annotations.Managed;
import net.thucydides.core.annotations.Steps;
import org.junit.After;
import org.junit.runner.RunWith;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

/**
 * Created by dharmens on 5/9/17.
 */

@RunWith(CucumberWithSerenity.class)
@CucumberOptions(features = { "src/test/resources" },
         tags = {"@Smoke"},
         plugin = {"html:/Users/dharmens/Downloads/Projects/Serenity/target/cucumber-parallel/*"})
public class SerenityTest {

    @Managed(driver = "chrome")
    WebDriver driver;
}
