package objectpages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;



	public class ProductPage {
	    WebDriver driver;

	    // Locators
	     By firstProductName = By.className("inventory_item_name");
	     By firstProductPrice = By.className("inventory_item_price");
	     By addToCartButton = By.id("add-to-cart-sauce-labs-backpack");
	     By cartButton = By.className("shopping_cart_link");

	    // Constructor
	    public ProductPage(WebDriver driver) {
	        this.driver = driver;
	    }

	    // Page actions
	    public String getFirstProductName() {
	        return driver.findElement(firstProductName).getText();
	    }

	    public String getFirstProductPrice() {
	        return driver.findElement(firstProductPrice).getText();
	    }

	    public void addFirstProductToCart() {
	        driver.findElement(addToCartButton).click();
	    }

	    public void goToCart() {
	        driver.findElement(cartButton).click();
	    }
	


	}


