package qa.automation;

import base.TestUtil;
import com.opencsv.exceptions.CsvException;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import pages.LoginPage;
import pages.ProductsPage;
import utils.CsvHelper;

import java.io.IOException;


public class ProductTest extends TestUtil {

    @Test
    public void addItemToTheCart() {
        LoginPage loginPage = new LoginPage(driver);
        ProductsPage productPage = loginPage.login("standard_user", "secret_sauce");
        //productPage.addItemToTheCart("onesie");
        String[] items = {"backpack", "bike-light"};
        for (String item : items) {
            productPage.addItemToTheCart(item);
        }
        int itemsInCart = productPage.getItemsInTheCart();
        assert itemsInCart == items.length : "Items in cart mismatch!";



        //Assert.assertEquals(productPage.getItemsInTheCart(), 1, "Because we have only one item to far");
        }


}

