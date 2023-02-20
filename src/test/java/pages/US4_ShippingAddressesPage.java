package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

public class US4_ShippingAddressesPage {

    public US4_ShippingAddressesPage(){
        PageFactory.initElements(Driver.getDriver(),this);
    }

    @FindBy(xpath = "//*[@id='shipping_first_name']")
    public WebElement firstNameShipping;

    @FindBy(xpath = "//*[@id='shipping_last_name']")
    public WebElement lastNameShipping;

    @FindBy(xpath = "//*[@id='shipping_company']")
    public WebElement companyNameShipping;

    @FindBy(xpath = "//*[@id='select2-shipping_country-container']")
    public WebElement countryRegionShipping;

    @FindBy(xpath = "//*[@id='shipping_address_1']")
    public WebElement streetAddressShipping;

    @FindBy(xpath = "//*[@id='shipping_city']")
    public WebElement townCityShipping;

    @FindBy(xpath = "//*[@aria-label='State']")
    public WebElement stateShipping;

    @FindBy(xpath = "//*[@id='shipping_postcode']")
    public WebElement zipCodeShipping;

    @FindBy(xpath = "//*[text()='Save address']")
    public WebElement saveAddressButtonShipping;

    @FindBy(xpath = "//*[@role='alert']")
    public WebElement onayYazisiShipping;

    @FindBy(xpath = "//*[@class='woocommerce-notices-wrapper']")
    public WebElement hataYazilari;
}
