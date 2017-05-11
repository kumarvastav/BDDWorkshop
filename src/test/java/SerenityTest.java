import cucumber.api.CucumberOptions;
import net.serenitybdd.cucumber.CucumberWithSerenity;
import net.thucydides.core.annotations.Managed;
import org.junit.After;
import org.junit.runner.RunWith;
import org.openqa.selenium.WebDriver;

/**
 * Created by dharmens on 5/9/17.
 */

@RunWith(CucumberWithSerenity.class)
@CucumberOptions(features = { "src/test/resources" },
         tags = {"@Smoke"})
public class SerenityTest {

    @Managed(driver = "chrome")
    WebDriver driver;

    @After
    public void tearDown(){
        driver.quit();
    }
}
