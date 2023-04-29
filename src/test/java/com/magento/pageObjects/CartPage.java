package com.magento.pageObjects;

import com.magento.utilities.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.w3c.dom.html.HTMLInputElement;

import java.util.List;

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

    ////*[@id="shopping-cart-table"]/tbody[1]
    ////table[contains(@class, 'cart-items')]

   // @FindBy(xpath = "//input[contains(@class, 'cart-qty-input')]")
   // public static WebElement quantityInput;

    public CartPage() {
        PageFactory.initElements(Driver.get(), this);
    }

    public static String getCartTotal() {
        return CartPage.cartTotal.getText();
    }

}
