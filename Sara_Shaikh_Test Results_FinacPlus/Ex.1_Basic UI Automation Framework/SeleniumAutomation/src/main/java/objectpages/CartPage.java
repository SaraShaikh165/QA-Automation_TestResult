package objectpages;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;



	public class CartPage {
	    WebDriver driver;

	    // Locators
	     By cartProductName = By.className("inventory_item_name");

	    // Constructor
	    public CartPage(WebDriver driver) {
	        this.driver = driver;
	    }

	    // Page actions
	    public String getCartProductName() {
	        return driver.findElement(cartProductName).getText();
	    }
	    public void logout() {
	        // Click on the burger menu button to open the sidebar
	        driver.findElement(By.id("react-burger-menu-btn")).click();

	        // Wait for the logout link to be visible
	        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
	        WebElement logoutLink = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("logout_sidebar_link")));

	        // Click on the logout link
	        logoutLink.click();
	    }
	}

	

