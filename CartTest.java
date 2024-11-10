package qa.automation;

import base.TestUtil;
import org.openqa.selenium.By;
import org.testng.annotations.Test;
import pages.CartPage;
import pages.LoginPage;
import pages.ProductsPage;
import static org.testng.AssertJUnit.assertTrue;

public class CartTest extends TestUtil {

    @Test
    public void validateCartPageWithOneProduct() {
        LoginPage loginPage = new LoginPage(driver);
        ProductsPage productsPage = loginPage.login("standard_user", "secret_sauce");

        productsPage.addFirstProductToCart();

        driver.findElement(By.className("shopping_cart_link")).click();
        CartPage cartPage = new CartPage(driver);

        assertTrue("The product should be in the cart.", cartPage.isProductInCart("Sauce Labs Backpack"));

        assertTrue("There should be one product in the cart.", cartPage.hasOneProductInCart());
    }
}
