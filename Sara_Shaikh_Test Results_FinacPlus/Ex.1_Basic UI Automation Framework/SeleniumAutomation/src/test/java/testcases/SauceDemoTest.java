package testcases;


import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import objectpages.LoginPage;
import objectpages.ProductPage;
import objectpages.CartPage;
import utils.BaseTest;
import utils.ConfigReader;
import java.io.FileWriter;
import java.io.IOException;



public class SauceDemoTest extends BaseTest {

    private LoginPage loginPage;
    private ProductPage productPage;
    private CartPage cartPage;

    @BeforeMethod
    public void setupPages() {
        loginPage = new LoginPage(driver);
        productPage = new ProductPage(driver);
        cartPage = new CartPage(driver);
    }

    @Test
    public void testLoginAddToCartAndLogout() {
        // Step 1: Login
        loginPage.login(ConfigReader.get("username"), ConfigReader.get("password"));

        // Step 2: Verify login success
        Assert.assertTrue(loginPage.isLoginSuccessful(), "Login failed.");

        // Step 3: Get product details
        String productName = productPage.getFirstProductName();
        String productPrice = productPage.getFirstProductPrice();

        // Step 4: Write product details to a file
        try (FileWriter writer = new FileWriter("productDetails.txt")) {
            writer.write("Product Name: " + productName + "\n");
            writer.write("Product Price: " + productPrice + "\n");
        } catch (IOException e) {
            System.out.println("Error writing to file: " + e.getMessage());
        }

        // Step 5: Add product to cart
        productPage.addFirstProductToCart();

        // Step 6: Verify product in cart
        productPage.goToCart();
        String cartProductName = cartPage.getCartProductName();
        Assert.assertEquals(cartProductName, productName, "Product in cart does not match.");

        // Step 7: Logout
        cartPage.logout();
    }
}
