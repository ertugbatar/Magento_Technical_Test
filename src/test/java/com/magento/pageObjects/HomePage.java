package com.magento.pageObjects;

import com.magento.utilities.Driver;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage {

   // The Homepage might also include methods for displaying personalized content based on the user's browsing history
  //  Using the Homepage can help to make Cucumber scenarios more readable and maintainable by encapsulating the logic for interacting with the homepage in a separate class.
    @FindBy(id = "search")
    public WebElement searchBox;

    @FindBy(xpath = "//button[@title='Search']")
    public WebElement searchButton;

    public void search(String searchKeyword){

        searchBox.sendKeys(searchKeyword + Keys.ENTER);
    }


    public HomePage() {
        PageFactory.initElements(Driver.get(), this);
    }

}
