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
public class UITest {

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
    
    @Then("^View Payment Detail")
     public void view_user_details() throws Throwable{
        driver.get("https://asd-demo-opal.herokuapp.com/ListOpalCard");
        driver.navigate().to(driver.getCurrentUrl());
     }
     
     @Then("^Opal card selected")
     public void opal_card_selected() throws Throwable{
        driver.findElement(By.name("select")).click();
     }
     
     @Then("^Type amount of top up$")
     public void Type_amount_of_top_up() throws Throwable {
         driver.findElement(By.name("amount")).sendKeys("100");
         driver.findElement(By.name("topup")).click();
     }
     
     @Then("^View Main Page")
     public void view_main_page() throws Throwable{
        driver.get("https://asd-demo-opal.herokuapp.com/main.jsp");
        driver.navigate().to(driver.getCurrentUrl());
     }
     
     @Then("^View Payment History")
     public void view_payment_history() throws Throwable{
        driver.get("https://asd-demo-opal.herokuapp.com/ListPaymentHistory");
        driver.navigate().to(driver.getCurrentUrl());
     }
     
     @Then("^Search opal card number$")
     public void Search_opal_card_number() throws Throwable {
        driver.findElement(By.name("searchbox")).sendKeys("30");
        driver.findElement(By.name("search")).click();
     }
     
     @Then("^Delete history$")
     public void Delete_history() throws Throwable {
        driver.findElement(By.name("delete")).click();
     }
     
     @Then("^Clear history page$")
     public void Clear_history_page() throws Throwable {
        driver.findElement(By.name("clear")).click();
     }
}
