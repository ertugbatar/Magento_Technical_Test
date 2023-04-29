package com.magento.pageObjects;

import com.magento.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SearchResults {

    @FindBy(xpath = "//input[@type='number' and @name='qty']")
    public WebElement quantity;

    @FindBy(xpath = "//div[@option-id='53']")
    public WebElement greenColor;

    @FindBy(xpath = "//div[@id='option-label-color-93-item-60']")
    public WebElement yellowColor;

    @FindBy(xpath = "//span[.='Add to Cart']")
    public WebElement addToCart;

    @FindBy(xpath = "(//li[@class='item product product-item'])[1]")
    public WebElement firstItem;

    @FindBy(xpath = "//img[@alt='Quest Lumaflex™ Band']")
    public WebElement LumaBand;




    @FindBy(xpath = "//div[@option-label='M']")
    public WebElement sizeM;

    @FindBy(xpath = "//div[@id='option-label-size-143-item-167']")
    public WebElement sizeS;


    public SearchResults(){
        PageFactory.initElements(Driver.get(), this);
    }


    public void updateQuantity(String itemName, int qty) {
        updateQuantity(itemName, qty);

    }
}
