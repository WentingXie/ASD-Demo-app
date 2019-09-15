/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package asd.demo.test;

/**
 *
 * @author wentingxie
 */
import org.openqa.selenium.By;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import io.github.bonigarcia.wdm.WebDriverManager;

public class LoginFeature {
    WebDriver driver;
    
    @Given("^I navigate to the login page$")
    public void loginPage() throws Throwable {
        Class<? extends WebDriver> driverClass = FirefoxDriver.class;
        WebDriverManager.getInstance(driverClass).setup();
        driver = driverClass.newInstance();
        driver.get("https://asd-demo-opal.herokuapp.com/login.jsp");
        //driver.close();
    }
       
    @When("^I enter the  username <useremail> and password<password>")
    public void i_fill_in_with(String arg1, String arg2) throws Throwable {
        driver.get("https://asd-demo-opal.herokuapp.com/login.jsp");
        driver.navigate().to(driver.getCurrentUrl());
        driver.findElement(By.name("email")).sendKeys(arg1);
        driver.findElement(By.name("password")).sendKeys(arg2);
        driver.findElement(By.id("user_login")).click();
        //driver.findElement(By.xpath("//*[@id='user_login']")).click();

        //driver.close();
    }
      

    
    @Then("^I click the login<login> button$")
        public void login_button_enabled() throws Throwable {
        if (driver.findElement(By.id("user_login")).isEnabled()) {
        System.out.println("Login button enabled.");
        } else {
        System.out.println("Login button disabled");
        }
        driver.close();
        }
        
    
    @Then("^I should see the LoginServlet page$")
    public void i_should_be_logged_in() throws Throwable {
        System.out.println("User Logged in");
    }
    
    
}
    

