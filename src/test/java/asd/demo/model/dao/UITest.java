///*
// * To change this license header, choose License Headers in Project Properties.
// * To change this template file, choose Tools | Templates
// * and open the template in the editor.
// */
//package asd.demo.model.dao;
//
//import cucumber.api.java.en.Given;
//import cucumber.api.java.en.Then;
//import cucumber.api.java.en.When;
//import org.openqa.selenium.By;
//import org.openqa.selenium.WebDriver;
//import org.openqa.selenium.firefox.FirefoxDriver;
//import io.github.bonigarcia.wdm.WebDriverManager;
//
///**
// *
// * @author suyixin
// */
//public class UITest {
//
//    WebDriver driver;
//
//    @Given("^open fireFox browser$")
//    public void open() throws Throwable {
//        Class<? extends WebDriver> driverClass = FirefoxDriver.class;
//        WebDriverManager.getInstance(driverClass).setup();
//        driver = driverClass.newInstance();
//        driver.get("https://asd-demo-opal.herokuapp.com/");
//        //driver.navigate().to(driver.getCurrentUrl());
//    }
//
//    @When("^asd-demo-opal is loaded$")
//    public void maven_app_heroku_is_loaded() throws Throwable {
//        driver.get("https://asd-demo-opal.herokuapp.com/login.jsp");
//        driver.navigate().to(driver.getCurrentUrl());    
//    }
//
//    @Then("^login button enabled$")
//    public void login_button_enabled() throws Throwable {
//        driver.findElement(By.name("email")).sendKeys("jimmy@gmail.com");
//        driver.findElement(By.name("password")).sendKeys("1234");
//        driver.findElement(By.name("login")).click();
//    }
//    
//    @Then("^view payment detail$")
//     public void view_payment_detail() throws Throwable{
//        driver.get("https://asd-demo-opal.herokuapp.com/ListOpalCard");
//        driver.navigate().to(driver.getCurrentUrl());
//     }
//     
//     @Then("^opal card selected$")
//     public void opal_card_selected() throws Throwable{
//        driver.findElement(By.name("select")).click();
//     }
//     
//     @Then("^type amount of top up$")
//     public void type_amount_of_top_up() throws Throwable {
//         driver.findElement(By.name("amount")).sendKeys("100");
//         driver.findElement(By.name("topup")).click();
//     }
//     
//     @Then("^view main page$")
//     public void view_main_page() throws Throwable{
//        driver.get("https://asd-demo-opal.herokuapp.com/main.jsp");
//        driver.navigate().to(driver.getCurrentUrl());
//     }
//     
//     @Then("^view payment history$")
//     public void view_payment_history() throws Throwable{
//        driver.get("https://asd-demo-opal.herokuapp.com/ListPaymentHistory");
//        driver.navigate().to(driver.getCurrentUrl());
//     }
//     
//     @Then("^search by opal card number$")
//     public void search_by_opal_card_number() throws Throwable {
//        driver.findElement(By.name("searchbox")).sendKeys("30");
//        driver.findElement(By.name("search")).click();
//     }
//     
//     @Then("^delete history$")
//     public void delete_history() throws Throwable {
//        driver.findElement(By.name("delete")).click();
//     }
//     
//     @Then("^clear history page$")
//     public void clear_history_page() throws Throwable {
//        driver.findElement(By.name("clear")).click();
//     }
//}
