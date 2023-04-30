package com.magento.utilities;

import com.magento.pageObjects.CartPage;
import com.magento.pageObjects.ProductPage;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import static java.sql.DriverManager.getDriver;

public class ProjectUtils {

    public static CartPage cartPage = new CartPage();
    public static ProductPage productPage = new ProductPage();

    public static void searchProduct(String productName) {
        cartPage.searchBox.sendKeys(productName + Keys.ENTER);

        // cartPage.searchButton.click(); // second option


        WebElement productLink = Driver.get().findElement(By.linkText(productName));
        productLink.click();

    }

    public static void selectShippingAddress(String country) throws InterruptedException {
        Thread.sleep(5000);
        assert getDriver() != null;
        getDriver().findElement((SearchContext) By.id("block-shipping-heading")).click();
        Thread.sleep(2000);
        WebElement dropDrownElement = getDriver().findElement((SearchContext) By.name("country_id"));
        Select selectObject = new Select(dropDrownElement);
        selectObject.selectByVisibleText("United Kingdom");
    }

    private static By getDriver() {
        return null;
    }

    public static void updateQuantity(String itemName, int newQuantity) {
        WebElement itemRow = cartPage.cartItemsTable.findElement(By.id("shopping-cart-table"));
        WebElement itemQuantityInput = itemRow.findElement((By) cartPage.quantityInput);
        itemQuantityInput.clear();
        itemQuantityInput.sendKeys(String.valueOf(newQuantity));
        cartPage.cartButton.click();
    }

    public static void addProductToCart(String productName, int quantity) {
        searchProduct(productName);
        setQuantity(quantity);
        addToCart();
        proceedToCheckout();
    }


    public static void selectSize(String selectSize) {
        Select sizeDropdown = new Select(productPage.sizeSelect);
        sizeDropdown.selectByVisibleText(selectSize);
    }


    public static void addToCart() {
        productPage.addToCartButton.click();
    }

    public static void proceedToCheckout() {
        productPage.proceedToCheckoutButton.click();


    }



    public static void productColor(String green) {
        productPage.green.click();
    }

    public static void productName(String name) {
        productPage.productsName.click();
    }

    private static void setQuantity(int quantity) {
    }



}
