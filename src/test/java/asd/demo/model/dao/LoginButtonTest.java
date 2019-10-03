/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package asd.demo.model.dao;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.chrome.ChromeDriver;

/**
 *
 * @author suyixin
 */
public class LoginButtonTest {

    WebDriver driver;

    @Given("^Open FireFox browser$")
    public void open() throws Throwable {
        Class<? extends WebDriver> driverClass = FirefoxDriver.class;
        WebDriverManager.getInstance(driverClass).setup();
        driver = driverClass.newInstance();
        driver.get("https://asd-demo-opal.herokuapp.com/");
        //driver.navigate().to(driver.getCurrentUrl());
    }

    @When("^asd-demo-opal is loaded$")
    public void maven_app_heroku_is_loaded() throws Throwable {
        driver.get("https://asd-demo-opal.herokuapp.com/login.jsp");
        driver.navigate().to(driver.getCurrentUrl());
        
    }

   
    @Then("^Login button enabled$")
     public void login_button_enabled() throws Throwable {
     driver.findElement(By.name("email")).sendKeys("jimmy@gmail.com");
     driver.findElement(By.name("password")).sendKeys("1234");
     driver.findElement(By.name("login")).click();
    
}
    @Then("^view_user_details$")
     public void view_user_details() throws Throwable{
     driver.get("https://asd-demo-opal.herokuapp.com/edit_user.jsp");
     driver.navigate().to(driver.getCurrentUrl());
     }
     
      @Then("^add_feedback_form")
    public void add_feedback_form() throws Throwable {
        driver.get("https://asd-demo-opal.herokuapp.com/feedback.jsp");
        driver.navigate().to(driver.getCurrentUrl());
    }

    @Then("^add_feedback")
    public void add_feedback() throws Throwable {
        driver.findElement(By.name("opalCardNo")).sendKeys("1234568546213578");
        driver.findElement(By.name("firstName")).sendKeys("John");
        driver.findElement(By.name("lastName")).sendKeys("Doe");
        driver.findElement(By.name("address")).sendKeys("New York");

        driver.findElement(By.name("city")).sendKeys("New York");
        driver.findElement(By.name("pinCode")).sendKeys("1234");
        driver.findElement(By.name("state")).sendKeys("NY");
        driver.findElement(By.name("email")).sendKeys("jhon@gmail.com");
        driver.findElement(By.name("enqueryType")).sendKeys("General feedback");
        driver.findElement(By.name("enquery")).sendKeys("Testing");

        driver.findElement(By.name("post")).click();
        driver.close();

    }
}
