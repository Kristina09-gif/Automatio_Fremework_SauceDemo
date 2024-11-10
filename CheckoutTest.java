package qa.automation;

import base.TestUtil;
import org.openqa.selenium.By;
import org.testng.annotations.Test;
import pages.CartPage;
import pages.CheckoutPage;
import pages.LoginPage;
import pages.ProductsPage;
import static org.testng.AssertJUnit.assertTrue;

public class CheckoutTest extends TestUtil {

    @Test
    public void testSuccessfulCheckout() {
        LoginPage loginPage = new LoginPage(driver);
        ProductsPage productsPage = loginPage.login("standard_user", "secret_sauce");

        productsPage.addFirstProductToCart();

        driver.findElement(By.className("shopping_cart_link")).click();
        CartPage cartPage = new CartPage(driver);

        driver.findElement(By.id("checkout")).click();
        CheckoutPage checkoutPage = new CheckoutPage(driver);

        checkoutPage.fillCheckoutInformation("Ivan", "Ivanov", "5000");
        checkoutPage.clickContinue();

        checkoutPage.clickFinish();

        assertTrue("Thank you for your order!", checkoutPage.isPurchaseSuccessful());
    }
}
