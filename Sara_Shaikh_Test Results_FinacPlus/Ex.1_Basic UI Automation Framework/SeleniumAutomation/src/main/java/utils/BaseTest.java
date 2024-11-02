package utils;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class BaseTest {

    protected WebDriver driver;

    @BeforeClass
    public void setup() {
        // Retrieve the ChromeDriver path from the configuration file
        String chromeDriverPath = ConfigReader.get("chrome.driver.path");
        
        // Set the system property for ChromeDriver
        System.setProperty("webdriver.chrome.driver", chromeDriverPath);
        
        // Initialize ChromeDriver
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        
        // Make sure 'base.url' is defined in your config.properties file
        driver.get(ConfigReader.get("base.url"));
    }
    @Test
    public void testLoginAddToCartAndLogout() {
        // Your login and add to cart code here

        // Call the logout method
        logout();
    }

    public void logout() {
        // Create a new WebDriverWait instance
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));// wait for up to 10 seconds
        
        // Wait until the logout link is clickable
        WebElement logoutLink = wait.until(ExpectedConditions.elementToBeClickable(By.id("logout_sidebar_link")));
        
        // Now you can safely click the logout link
        logoutLink.click();
    }

    @AfterClass
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}
