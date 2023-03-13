package cydeo;

import static org.junit.Assert.fail;

import io.cucumber.java.After;
import io.cucumber.java.Scenario;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import java.util.concurrent.TimeUnit;


public class StepDefs { // thi sis a test 7;30 am // 7:43 am again // 7;48 am  // 8:33 am change 

    @Given("^I am on the home page$") // edit from git hub 7;39 am 
    public void i_am_on_the_home_page() throws Throwable {
        Driver.getDriver().manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        Driver.getDriver().manage().window().maximize();
        Driver.getDriver().get("http://etsy.com");

    }

    @When("^I search for \"([^\"]*)\"$")
    public void i_search_for(String search) throws Throwable {
        Driver.getDriver().findElement(By.cssSelector("[id*='search-query']")).sendKeys(search + Keys.ENTER);
    } // 8;42 update // 9;03 update

    @Then("^I should see the results$") // 8;53 update
    public void i_should_see_the_results() throws Throwable {
        Thread.sleep(2000);
        Assert.assertTrue(Driver.getDriver().getCurrentUrl().contains("search"));
    }

    @Then("^I should see more results$")
    public void i_should_see_more_results() throws Throwable {
        Thread.sleep(2000);
        Assert.assertTrue(Driver.getDriver().getCurrentUrl().contains("search"));
    }

    @After
    public void tearDown(Scenario scenario) {
        if (scenario.isFailed()) {
            final byte[] screenshot = ((TakesScreenshot) Driver.getDriver()).getScreenshotAs(OutputType.BYTES);
            scenario.attach(screenshot, "image/png", scenario.getName());
        }
        Driver.closeDriver();
    }

}
