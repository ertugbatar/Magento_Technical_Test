package com.magento.pageObjects;

import com.magento.utilities.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.w3c.dom.html.HTMLInputElement;


//Using the CartPage can help to make Cucumber scenarios more readable and maintainable by encapsulating the logic for interacting with the cart page in a separate class.

public class CartPage extends HomePage {

    public static HTMLInputElement quantity;
    @FindBy(id = "deliveryCountry")
    public WebElement deliveryCountrySelect;

    @FindBy(xpath = "//*[@id=\"cart-totals\"]/div/table/tbody/tr[3]")
    public static WebElement cartTotal;
   // @FindBy(xpath = "//span[contains(@class, 'cart-total')]")
  //  public WebElement cartTotal1;


    @FindBy(id = "cart-button")
    public WebElement cartButton;

    @FindBy(xpath = "*[@id=\"shopping-cart-table\"]/tbody[1]")
    public WebElement cartItemsTable;
    public Object quantityInput;

    public CartPage() {
        PageFactory.initElements(Driver.get(), this);
    }

    public static String getCartTotal() {
        return CartPage.cartTotal.getText();
    }

}
