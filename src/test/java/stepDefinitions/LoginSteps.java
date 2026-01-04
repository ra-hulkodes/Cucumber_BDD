package stepDefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.safari.SafariDriver;


public class LoginSteps {

     WebDriver driver;

    @Given("user is on login page")
    public void user_is_on_login_page() {
        System.out.println("User is on login page");
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://practicetestautomation.com/practice-test-login/");
    }

    @When("user enters {string} and {string}")
    public void user_enters_username_and_password(String username, String password) {
        driver.findElement(By.id("username")).sendKeys(username);
        driver.findElement(By.id("password")).sendKeys(password);
    }

    @When("user enters invalid {string} and {string}")
    public void user_enters_invalid_username_and_password(String username,String password) {
        System.out.println("user enters invalid username and password");
        driver.findElement(By.id("username")).sendKeys(username);
        driver.findElement(By.id("password")).sendKeys(password);
    }

    @And("user clicks on Submit button")
    public void user_clicks_on_submit_button() {
        System.out.println("user enters username and password");
        driver.findElement(By.id("submit")).click();
    }

    @Then("user should be logged in successfully")
    public void user_should_be_logged_in_successfully() {
        System.out.println("User should be logged in successfully");
        String currentUrl = driver.getCurrentUrl();
        System.out.println(currentUrl);

        if(currentUrl.contains("practice-test-login/")){
            assert false;
        }else {
            assert true;
        }
        driver.close();
    }

    @Then("user should see {string}")
    public void user_should_be_logged_in_successfully_Outline(String result) {
        System.out.println("User should be logged in successfully");
        String currentUrl = driver.getCurrentUrl();
        System.out.println(currentUrl);

        if(currentUrl.contains(result)){
            assert true;
        }else {
            assert false;
        }
        driver.close();
    }


    @Then("user should see an error message")
    public void user_should_see_an_error_message() {
        System.out.println("User should be logged in successfully");
    }


}
