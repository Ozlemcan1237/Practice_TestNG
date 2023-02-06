package tests;

import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.*;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.ReusableMethods;

public class US3_BillingAddressTest {

    US3_PearlyMarketHomePage us3_pearlyMarketHomePage;
    US3_MyAccountPage us3_myAccountPage;
    US3_AddressesPage us3_addressesPage;
    US3_BillingAddressesPage us3_billingAddressesPage;
    US3_ShippingAddressesPage us3_shippingAddressesPage;

    @Test
    public void billingAddressTest01() {
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
        ReusableMethods.waitFor(3);
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

        ReusableMethods.waitFor(3);
        us3_billingAddressesPage.streetAddress.clear();
        us3_billingAddressesPage.streetAddress.sendKeys("Corfu 456",Keys.TAB, Keys.TAB);
        ReusableMethods.waitFor(3);

        us3_billingAddressesPage.townCity.clear();
        us3_billingAddressesPage.townCity.sendKeys("Rachester");
        ReusableMethods.waitFor(3);

        us3_billingAddressesPage.state.click();
        actions.sendKeys(Keys.ARROW_DOWN,Keys.ARROW_DOWN,Keys.ENTER).perform();

        us3_billingAddressesPage.zipCode.clear();
        us3_billingAddressesPage.zipCode.sendKeys("10001",Keys.TAB);

        us3_billingAddressesPage.phone.clear();
        us3_billingAddressesPage.phone.sendKeys("123456");
        ReusableMethods.waitFor(3);

        String actualEmail = "pearlymarketplace@gmail.com";
        String expectedEmail = us3_billingAddressesPage.emailAddress.getText();
        Assert.assertNotEquals(expectedEmail,actualEmail);
        ReusableMethods.waitFor(3);

        us3_billingAddressesPage.saveAddress.click();
        ReusableMethods.waitFor(3);

        Assert.assertTrue(us3_shippingAddressesPage.onayYazisiShipping.isDisplayed());

        Driver.closeDriver();
    }
}
