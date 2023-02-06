package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

public class US3_BillingAddressesPage {


    public US3_BillingAddressesPage(){
        PageFactory.initElements(Driver.getDriver(),this);
    }

    @FindBy(xpath = "//*[@id='billing_first_name']")
    public WebElement firstName;

    @FindBy(xpath = "//*[@id='billing_last_name']")
    public WebElement lastName;

    @FindBy(xpath = "//*[@id='billing_company']")
    public WebElement companyName;

    @FindBy(id = "select2-billing_country-container")
    public WebElement countryRegion;

    @FindBy(xpath = "//*[@title='Venezuela']")
    public WebElement venezuela;

    @FindBy(xpath = "//*[@id='billing_address_1']")
    public WebElement streetAddress;

    @FindBy(xpath = "//*[@id='billing_city']")
    public WebElement townCity;

    @FindBy(xpath = "//*[@id='select2-billing_state-container']")
    public WebElement state;

    @FindBy(xpath = "//*[@id='billing_postcode']")
    public WebElement zipCode;

    @FindBy(xpath = "//*[@id='billing_phone']")
    public WebElement phone;

    @FindBy(xpath = "//*[@id='billing_email']")
    public WebElement emailAddress;

    @FindBy(xpath = "//*[text()='Save address']")
    public WebElement saveAddress;

    @FindBy(xpath = "//*[@role='alert']")
    public WebElement onayYazisiBilling;

}
