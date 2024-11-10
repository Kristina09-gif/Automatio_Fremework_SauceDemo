package qa.automation;

import base.TestUtil;
import org.testng.annotations.Test;
import pages.LoginPage;
import pages.ProductsPage;
import static org.testng.AssertJUnit.assertEquals;

public class ProductTest extends TestUtil {

    @Test
    public void addTwoProductsToCartTest() {
        LoginPage loginPage = new LoginPage(driver);
        ProductsPage productPage = loginPage.login("standard_user", "secret_sauce");
        productPage.addFirstProductToCart();
        productPage.addSecondProductToCart();

        assertEquals("The cart should contain 2 items.", 2,productPage.getCartItemCount());
    }
}