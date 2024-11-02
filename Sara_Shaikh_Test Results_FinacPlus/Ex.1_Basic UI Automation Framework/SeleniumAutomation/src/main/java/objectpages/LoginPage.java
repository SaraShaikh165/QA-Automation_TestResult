package objectpages;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;




public class LoginPage {
    WebDriver driver;

    // Constructor
    public LoginPage(WebDriver driver) 
    {
        this.driver = driver;
    }
    
    // Locators
     By txt_username_loc = By.id("user-name");
     By txt_password_loc= By.id("password");
     By btn_loginbutton_loc = By.id("login-button");

    
    // Action method
     public void login(String username, String password) {
         driver.findElement(txt_username_loc).sendKeys(username);
         driver.findElement(txt_password_loc).sendKeys(password);
         driver.findElement(btn_loginbutton_loc).click();
         
     }
     
     public boolean isLoginSuccessful() {
         return driver.getCurrentUrl().contains("inventory.html");
     }
    }

	


     