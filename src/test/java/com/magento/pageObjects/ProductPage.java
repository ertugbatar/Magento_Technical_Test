package com.magento.pageObjects;

import com.magento.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ProductPage extends HomePage {

    //It provides methods for interacting with the various elements on the product page, such as the product name, description, images, reviews, and price.
    //In Cucumber, the Product is typically used in step definitions to select a product, view its details, and add it to the cart.

    @FindBy(xpath = "//div[@id='option-label-size-143-item-168']")
    public WebElement sizeSelect;
    ////div[@class='swatch-opt-1572']//div[@id='option-label-size-143-item-168']

    @FindBy(xpath = "//input[@id='cart-117004-qty']")
    public WebElement quantityInput;

    @FindBy(xpath = "//div[@id='option-label-color-93-item-53']")
    public WebElement green;

    @FindBy(xpath = "//span[normalize-space()='Add to Cart']")
    public WebElement addToCartButton;

    @FindBy(xpath = "//a[contains(@class, 'action primary checkout')]")
    public WebElement proceedToCheckoutButton;

    @FindBy (xpath = "//span[@class='counter-number'] ")
    public WebElement ClickToBasket;


    public WebElement productsName;


    public ProductPage() {
        PageFactory.initElements(Driver.get(), this);

    }
}

