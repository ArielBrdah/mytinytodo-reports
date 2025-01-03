package com;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import java.util.*;

public class App {

    public void fill_form_test()  throws InterruptedException {
        System.setProperty("webdriver.chrome.driver",
                "C:/Users/ASUS/workspace/automation-project-2024/test-app/chromedriver-win64/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://galmatalon.github.io/tutorials/indexID.html");

        driver.findElement(By.id("firstname")).sendKeys("Ariel");
        driver.findElement(By.id("lastname")).sendKeys("Berdah");
        driver.findElement(By.id("email")).sendKeys("arielbapi@gmail.com");
        driver.findElement(By.id("next")).click();
        Thread.sleep(2000);

        driver.findElement(By.id("Advanced")).click();
        driver.findElement(By.id("next")).click();
        Thread.sleep(2000);

        driver.findElement(By.id("streetname")).sendKeys("argenteuille street");
        driver.findElement(By.id("streetnumber")).sendKeys("34");
        driver.findElement(By.id("city")).sendKeys("Marseille");
        driver.findElement(By.cssSelector("option[value=Argentina]")).click();
        driver.findElement(By.id("finish")).click();
        Thread.sleep(2000);

        driver.findElement(By.id("finish")).click();
        Thread.sleep(2000);

        driver.close();
    }

    public void error_fields_test()  throws InterruptedException {
        System.setProperty("webdriver.chrome.driver",
                "C:/Users/ASUS/workspace/automation-project-2024/test-app/chromedriver-win64/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://galmatalon.github.io/tutorials/indexID.html");

        driver.findElement(By.id("next")).click();
        String error_message = driver.findElement(By.id("firstname-error")).getText();

        if (error_message.contains("required")) {
            System.out.println("the error message is correctly setted:\t" + error_message);
        }
        Thread.sleep(2000);

    }

    public static void forgot_password_salesforce() {

        System.setProperty("webdriver.chrome.driver",
                "C:/Users/ASUS/workspace/automation-project-2024/test-app/chromedriver-win64/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://login.salesforce.com");

        driver.findElement(By.cssSelector("#forgot_password_link")).click();
        driver.findElement(By.cssSelector("#un")).sendKeys("arielbapi@gmail.com");
        driver.findElement(By.cssSelector("#continue")).click();

        String message = driver.findElement(By.cssSelector("#forgotPassForm")).getText();
        System.out.println(message);

    }

    public static int step = 0;
    public static WebDriver driver;

    public static WebElement el(String s){ 
        return App.driver.findElement(By.cssSelector(s));
    }

    public static void log(String s){

        App.step = App.step + 1;
        System.out.println("\t"+App.step+".\t"+s);
    }

    public void advanced_search_ebay() { 
        
        System.setProperty("webdriver.chrome.driver",
                "C:/Users/ASUS/workspace/automation-project-2024/test-app/chromedriver-win64/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        App.driver = driver;
        driver.manage().window().maximize();
        driver.get("https://ebay.com/sch/ebayadvsearch");

        App.log("Fill searching article fields...");
        WebElement search_word = App.el("#_nkw");
        search_word.sendKeys("tent");

        App.log("Fill excluding article fields...");
        WebElement exclude_word = App.el("#_ex_kw");
        exclude_word.sendKeys("black");


        App.log("Check buying it article fields...");
        WebElement cb = App.el("[id='s0-1-17-6[3]-[2]-LH_BIN']");
        System.out.println("before check: "+cb.isSelected());
        WebElement buy_it = App.el("[for='s0-1-17-6[3]-[2]-LH_BIN']");
        System.out.println("after check: "+cb.isSelected());
        
        buy_it.click();

        App.log("Sending search...");
        WebElement search_btn = App.el(".field.adv-keywords__btn-help .btn.btn--primary");
        search_btn.click();


        //get list of all results (there are 50 results)
		List<WebElement> list = driver.findElements(By.cssSelector("#srp-river-results li .s-item__title"));
		//print the length of the list 
		System.out.println("length = " + list.size());
		//print the list of all items
		for (WebElement el : list) {
			System.out.println(el.getText());
		}
		//using regular for, to iterate over the list and print all elements
		for (int i = 0; i < list.size(); i++) {
			System.out.println(list.get(i).getText());
		}
		//click on one of the elements
		list.get(2).click();

        App.log("Go back...");
        driver.navigate().back();

    }


    public void alitalia_get_anchors_find_flight(){

        System.setProperty("webdriver.chrome.driver",
                "C:/Users/ASUS/workspace/automation-project-2024/test-app/chromedriver-win64/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        App.driver = driver;
        driver.manage().window().maximize();
        driver.get("https://alitalia.com/en_il");

        App.log("Connected to Aliatalia...");
        App.log("Accepting cookies:");
        App.el(".iubenda-cs-accept-btn.iubenda-cs-btn-primary").click();
        
        App.log("Loop through all anchors:");
        //get list of all results (there are 50 results)
		List<WebElement> list = driver.findElements(By.cssSelector("a"));
		WebElement flight = null;
        //print the list of all items
		for (WebElement el : list) {
			System.out.println(el.getText());
            if(el.getText().contains("flight") || el.getText().contains("Flight")  ){
                flight = el;
            }

		}
		//click on one of the elements
		App.log("Printing 'flight' link url.");
        System.out.println(flight.getAttribute("href"));

        App.log("Finish...");

    }
    public static void main(String[] args){
        try {
            App app = new App();
            // app.forgot_password_salesforce();
            // app.advanced_search_ebay();
            app.alitalia_get_anchors_find_flight();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
