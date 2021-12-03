package saucedemoremove.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class StorePage {
    private WebDriver driver;

    public StorePage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(id = "add-to-cart-sauce-labs-backpack")
    WebElement addBackpack;
    @FindBy(id = "shopping_cart_container")
    WebElement cartIconLink;
    @FindBy(xpath = "//select[@class='product_sort_container']")
    WebElement sortContainer;
    @FindBy(id = "react-burger-menu-btn")
    WebElement burgerMenu;
    @FindBy(id = "logout_sidebar_link")
    WebElement logoutButton;


    public void selectFromDropdown() {
        sortContainer.click();
        new Select(sortContainer).selectByValue("lohi");
    }

    public void selectProduct() {
        addBackpack.click();
    }

    public void logOut() {
        burgerMenu.click();
        logoutButton.click();

    }

    public CartPage selectCartIcon() {
        cartIconLink.click();
        return new CartPage(driver);
    }
}
