package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

public class US3_AddressesPage {

    public US3_AddressesPage(){
        PageFactory.initElements(Driver.getDriver(),this);
    }

    @FindBy(xpath = "//*[@class='icon-box-content']")
    public WebElement addressesSayfasi;

    @FindBy(xpath = "(//*[text()='Add'])[1]")
    public WebElement addButton;

    @FindBy(xpath = "(//*[text()='Add'])[2]")
    public WebElement addButton2;

    @FindBy(xpath = "//*[text()='Edit Your Billing Address']")
    public WebElement editYourBillingAddressButton;

    @FindBy(xpath = "//*[text()='Edit Your Shipping Address']")
    public WebElement editYourShippingAddressButton;
}
