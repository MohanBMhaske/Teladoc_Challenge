package StepDefination;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.cucumber.java.en.Then;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import java.time.Duration;
import java.util.List;

import org.junit.Assert;

public class WebtablesSteps {
	
	WebDriver driver;

    @Given("the user is on the webtables page")
    public void the_user_is_on_the_webtables_page() {
        // Initialize the WebDriver (assuming ChromeDriver here)
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().window().maximize();
        driver.get("http://www.way2automation.com/angularjs-protractor/webtables/");
 }
    
    @When("the user adds a new user with Firstname {string},LastName {string}, username {string}, password {string} email {string} and Mobile Number is {string}")
    public void the_user_adds_a_new_user_with_firstname_last_name_username_password_email_and_mobile_number_is(String firstName, String lastName, String userName, String password, String email, String mobNo) {
        // Write code here that turns the phrase above into concrete actions
        driver.findElement(By.xpath("//button[@type='add']")).click();
        
        // Fill out the form and submit it
        driver.findElement(By.xpath("//input[@name='FirstName']")).sendKeys(firstName);
        driver.findElement(By.xpath("//input[@name='LastName']")).sendKeys(lastName); // assuming last name is static or can be adjusted
        driver.findElement(By.xpath("//input[@name='UserName']")).sendKeys(userName);
        driver.findElement(By.xpath("//input[@name='Password']")).sendKeys(password);
        driver.findElement(By.xpath("//td/label[1]/input[@name='optionsRadios']")).click(); // Select Customer
        WebElement ddRole = driver.findElement(By.xpath("//td/select[@name='RoleId']"));
        Select sel = new Select(ddRole);
        sel.selectByVisibleText("Admin");
        driver.findElement(By.xpath("//input[@name='Email']")).sendKeys(email); // example department
        driver.findElement(By.xpath("//td/input[@name='Mobilephone']")).sendKeys(mobNo);
        
        driver.findElement(By.xpath("//div/button[@ng-click=\"save(user)\"]")).click();
        
    }

    @Then("the user should see {string} in the table")
    public void the_user_should_see_in_the_table(String name) {
        WebElement table = driver.findElement(By.xpath("//table/tbody/tr/td[contains(text(),'"+name+"')]"));
        boolean userExists = table.getText().contains(name);
        Assert.assertTrue("User not found in the table", userExists);
        System.out.println(name+" is Exist in the tabel");
        driver.quit();
    }

    @When("the user deletes the user with name {string}")
    public void the_user_deletes_the_user_with_name(String name) {
        driver.findElement(By.xpath("//td[text()='"+name+"']//following::td[9]/button")).click();
        
      driver.findElement(By.xpath("//div/button[2]")).click();
    }

    @Then("the user should not see {string} in the table")
    public void the_user_should_not_see_in_the_table(String name) {
       List<WebElement> table = driver.findElements(By.xpath("//table/tbody/tr/td[contains(text(),'"+name+"')]"));
        boolean a= (boolean) table.isEmpty();
        System.out.println(a);
        Assert.assertTrue("User should not be in the table", a);
        driver.quit();
    }

}
