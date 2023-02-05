package tests;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.*;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.ReusableMethods;

public class US3_Test {

    US3_PearlyMarketHomePage us3_pearlyMarketHomePage;
    US3_MyAccountPage us3_myAccountPage;
    US3_AddressesPage us3_addressesPage;
    US3_BillingAddressesPage us3_billingAddressesPage;
    US3_ShippingAddressesPage us3_shippingAddressesPage;

    @Test
    public void test01() {
        us3_pearlyMarketHomePage = new US3_PearlyMarketHomePage();
        us3_myAccountPage = new US3_MyAccountPage();
        us3_addressesPage = new US3_AddressesPage();
        us3_billingAddressesPage = new US3_BillingAddressesPage();
        us3_shippingAddressesPage = new US3_ShippingAddressesPage();


        Driver.getDriver().get(ConfigReader.getProperty("pearly_url"));
        ReusableMethods.waitFor(3);

        Assert.assertTrue(us3_pearlyMarketHomePage.anaSayfaDogrulama.isDisplayed());

        us3_pearlyMarketHomePage.signIn.click();

        us3_pearlyMarketHomePage.username.sendKeys(ConfigReader.getProperty("pearly_username"));
        us3_pearlyMarketHomePage.password.sendKeys(ConfigReader.getProperty("pearly_password"));
        us3_pearlyMarketHomePage.signInButton.click();
        ReusableMethods.waitFor(5);

        us3_pearlyMarketHomePage.signOut.click();
        Assert.assertTrue(us3_myAccountPage.myAccountBasligi.isDisplayed());

        us3_myAccountPage.addressesSecenegi.click();
        ReusableMethods.waitFor(3);
        Assert.assertTrue(us3_addressesPage.addressesSayfasi.isDisplayed());

        ReusableMethods.waitFor(3);
        Actions actions = new Actions(Driver.getDriver());
        actions.sendKeys(Keys.PAGE_DOWN).perform();
        us3_addressesPage.editYourBillingAddressButton.click();

        ReusableMethods.waitFor(3);
        us3_billingAddressesPage.firstName.clear();
        us3_billingAddressesPage.firstName.sendKeys("Gonca", Keys.TAB);
        us3_billingAddressesPage.lastName.clear();
        us3_billingAddressesPage.lastName.sendKeys("Gungor", Keys.TAB);
        us3_billingAddressesPage.companyName.clear();
        us3_billingAddressesPage.companyName.sendKeys("darien lake ltd", Keys.TAB);

        ReusableMethods.waitFor(3);
        us3_billingAddressesPage.countryRegion.click();
        actions.sendKeys(Keys.ARROW_DOWN,Keys.ARROW_DOWN,Keys.ARROW_DOWN,Keys.ARROW_DOWN,
                Keys.ARROW_DOWN,Keys.ARROW_DOWN,Keys.ENTER).perform();

        Driver.closeDriver();

    }
}
