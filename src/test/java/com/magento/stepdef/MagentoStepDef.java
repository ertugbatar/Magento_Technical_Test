package com.magento.stepdef;

import com.magento.pageObjects.CartPage;
import com.magento.pageObjects.ProductPage;
import com.magento.pageObjects.SearchResults;
import com.magento.utilities.ConfigurationReader;
import com.magento.utilities.Driver;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;

import java.time.Instant;


public class MagentoStepDef {

    ProductPage productPage = new ProductPage();
    SearchResults searchResults = new SearchResults();


    @Given("I am on the homepage")
    public void open_the_website() {
        Driver.get().get(ConfigurationReader.getProperty("url"));

    }


    @When("I add {string} to the cart with quanitiy {string}")
    public void iAddToTheCartWithQuanitiy(String productName, String selectQty) throws InterruptedException {

        productPage.search(productName + Keys.ENTER);

        searchResults.firstItem.click();

        searchResults.quantity.clear();
        //  homePage.searchBox.sendKeys(productName);
        searchResults.quantity.sendKeys(selectQty);
        searchResults.sizeM.click();
        Thread.sleep(2000);
        searchResults.greenColor.click();
        Thread.sleep(3000);
        searchResults.addToCart.click();
        Thread.sleep(4000);

        WebElement showCart = Driver.get().findElement(By.xpath("//a[@class='action showcart']"));
        showCart.click();
        Thread.sleep(5000);
        WebElement viewCart = Driver.get().findElement(By.xpath("//*[@id=\"minicart-content-wrapper\"]/div[2]/div[5]/div/a"));
        viewCart.click();


    }

    @When("I select {string} as the shipping address")
    public void i_select_as_the_shipping_address(String shippingAddress) throws InterruptedException {
        Thread.sleep(5000);
        WebElement editToCart = Driver.get().findElement((By.id("block-shipping-heading")));
        editToCart.click();

        Thread.sleep(2000);
        WebElement dropDrownElement = Driver.get().findElement(By.name("country_id"));
        Select selectObject = new Select(dropDrownElement);
        selectObject.selectByVisibleText("United Kingdom");
        }

    @Then("the cart total should be {string}")
    public void the_cart_total_should_be(String string) throws InterruptedException {
        Thread.sleep(4000);
       // String cartTotal = CartPage.cartTotal.getText();
      //  Assert.assertEquals("Cart is incorrect", "$92.00", cartTotal);
        // Find the cart total element and get its text
        WebElement cartTotalElement = Driver.get().findElement(By.xpath("//*[@id=\"cart-totals\"]/div/table/tbody/tr[4]"));
        String cartTotal = cartTotalElement.getText();

        // Check that the cart total is correct
        Assert.assertEquals("Cart is correct", "Order Total $92.00", cartTotal );
    }

    @When("I update the quantity of {string} to {string}")
    public void i_update_the_quantity_of_to(String itemName, String qty) throws InterruptedException {

       Thread.sleep(3000);
      WebElement editItem =Driver.get().findElement(By.xpath("/html[1]/body[1]/div[1]/main[1]/div[3]/div[1]/div[2]/form[1]/div[1]/table[1]/tbody[1]/tr[2]/td[1]/div[1]/a[1]"));
      editItem.click();
      Thread.sleep(2000);
      WebElement quantity = Driver.get().findElement(By.xpath("//input[@id='qty']"));
      quantity.clear();
      Thread.sleep(3000);
      quantity.sendKeys("3");
      WebElement updateButton = Driver.get().findElement(By.id("product-updatecart-button"));
      updateButton.click();
    }

    @When("I add to quantity {string} {string} to chart")
    public void i_add_to_quantity_to_chart(String productName, String selectQty) throws InterruptedException {
        Thread.sleep(3000);
        productPage.search("Gwyn Endurance Tee" + Keys.ENTER);
        searchResults.firstItem.click();

        searchResults.quantity.clear();
        //  homePage.searchBox.sendKeys(productName);
        searchResults.quantity.sendKeys("1");
        searchResults.sizeS.click();
        Thread.sleep(2000);
        searchResults.yellowColor.click();
        Thread.sleep(3000);
        searchResults.addToCart.click();
        Thread.sleep(2000);

    }

    @When("I add again {string} to the cart with quantity {string}")
    public void i_add_again_to_the_cart_with_quantity(String productName, String selectQty) throws InterruptedException {
        productPage.search(productName + Keys.ENTER);
        searchResults.LumaBand.click();
        searchResults.quantity.clear();
        //  homePage.searchBox.sendKeys(productName);
        searchResults.quantity.sendKeys(selectQty);
        Thread.sleep(2000);
        searchResults.addToCart.click();
        WebElement showCart = Driver.get().findElement(By.xpath("//a[@class='action showcart']"));
        showCart.click();
        Thread.sleep(5000);
        WebElement viewCart = Driver.get().findElement(By.xpath("//*[@id=\"minicart-content-wrapper\"]/div[2]/div[5]/div/a"));
        viewCart.click();


    }

    @Then("the latest cart total should be {string}")
    public void the_latest_cart_total_should_be(String string) throws InterruptedException {
         // String cartTotal = CartPage.getCartTotal();
          // Assert.assertEquals("Cart total is incorrect", cartTotal, "$116.00");
        Thread.sleep(5000);
        WebElement cartTotalElement1 = Driver.get().findElement(By.xpath("//span[normalize-space()='$140.00']"));

        String cartTotal = cartTotalElement1.getText();

        // Check that the cart total is correct
        Assert.assertEquals("Cart is correct", "$140.00", cartTotal );


    }




}

