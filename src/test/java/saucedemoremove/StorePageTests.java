package saucedemoremove;

import org.junit.Assert;
import org.junit.Test;

import java.io.IOException;

public class StorePageTests extends StorePageBase {

    @Test
    public void storePageTests() throws IOException {
        storePage = loginPage.login(username, password);
        storePage.selectFromDropdown();
        storePage.selectProduct();
        cartPage = storePage.selectCartIcon();
        Assert.assertEquals(productName, cartPage.checkItem());
        Assert.assertEquals(productPrice, cartPage.checkPrice());
        cartPage.removeItem();
        Assert.assertEquals(1, cartPage.checkIfRemoved());
        cartPage.getScreenshot();
        storePage = cartPage.continueShopping();
        storePage.logOut();

    }
}