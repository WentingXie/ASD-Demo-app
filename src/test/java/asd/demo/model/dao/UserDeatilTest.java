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
public class UserDeatilTest {

    WebDriver driver;

    @Given("^Open FireFox browser$")
    public void open() throws Throwable {
        Class<? extends WebDriver> driverClass = FirefoxDriver.class;
     
        WebDriverManager.getInstance(driverClass).setup();
        driver = driverClass.newInstance();
        driver.get("https://asd-demo-opal.herokuapp.com/edit_user.jsp");
        //driver.navigate().to(driver.getCurrentUrl());
    }

    @When("^maven-app-heroku is loaded$")
    public void maven_app_heroku_is_loaded() throws Throwable {
        driver.get("https://asd-demo-opal.herokuapp.com/edit_user.jsp");
        driver.navigate().to(driver.getCurrentUrl());

    }

    @Then("^Save button enabled$")
    
    public void Save_button_enabled() throws Throwable {
      
    }
    

}
