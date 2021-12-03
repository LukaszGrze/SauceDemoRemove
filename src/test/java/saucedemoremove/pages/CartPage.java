package saucedemoremove.pages;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.io.File;
import java.io.IOException;
import java.util.List;

public class CartPage {
    private WebDriver driver;

    public CartPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(id = "remove-sauce-labs-backpack")
    WebElement removeBackpack;
    @FindBy(css = ".inventory_item_name")
    WebElement itemName;
    @FindBy(css = ".inventory_item_price")
    WebElement itemPrice;
    @FindBy(className = "removed_cart_item")
    List<WebElement> allElements;
    @FindBy(id = "continue-shopping")
    WebElement continueButton;


    public String checkItem() {
        return itemName.getText();
    }

    public String checkPrice() {
        return itemPrice.getText();
    }

    public int checkIfRemoved() {
        return allElements.size();
    }

    public void removeItem() {
        removeBackpack.click();
    }

    public void getScreenshot() throws IOException {
        File scrFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
        FileUtils.copyFile(scrFile, new File("d:\\screenshot.png"));
    }

    public StorePage continueShopping() {
        continueButton.click();
        return new StorePage(driver);

    }
}
