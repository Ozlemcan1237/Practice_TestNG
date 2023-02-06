package tests;

import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.*;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.ReusableMethods;

public class US3_ShippingAddressTest {

    US3_PearlyMarketHomePage us3_pearlyMarketHomePage;
    US3_MyAccountPage us3_myAccountPage;
    US3_AddressesPage us3_addressesPage;
    US3_ShippingAddressesPage us3_shippingAddressesPage;

    @Test
    public void shippingAddressTest01() {
        us3_pearlyMarketHomePage = new US3_PearlyMarketHomePage();
        us3_myAccountPage = new US3_MyAccountPage();
        us3_addressesPage = new US3_AddressesPage();
        us3_shippingAddressesPage = new US3_ShippingAddressesPage();

        Driver.getDriver().get(ConfigReader.getProperty("pearly_url"));
        ReusableMethods.waitFor(3);

        Assert.assertTrue(us3_pearlyMarketHomePage.anaSayfaDogrulama.isDisplayed());
        ReusableMethods.waitFor(1);

        us3_pearlyMarketHomePage.signIn.click();
        us3_pearlyMarketHomePage.username.sendKeys(ConfigReader.getProperty("pearly_username_me"));
        us3_pearlyMarketHomePage.password.sendKeys(ConfigReader.getProperty("pearly_password_me"));
        us3_pearlyMarketHomePage.signInButton.click();
        ReusableMethods.waitFor(3);

        us3_pearlyMarketHomePage.signOut.click();
        Assert.assertTrue(us3_myAccountPage.myAccountBasligi.isDisplayed());

        us3_myAccountPage.addressesSecenegi.click();
        ReusableMethods.waitFor(3);
        Assert.assertTrue(us3_addressesPage.addressesSayfasi.isDisplayed());
        ReusableMethods.waitFor(3);

        Actions actions = new Actions(Driver.getDriver());
        us3_addressesPage.addButton2.click();

        us3_shippingAddressesPage.firstNameShipping.sendKeys("Gonca", Keys.TAB, "Gungor", Keys.TAB, "darien lake ltd");
        us3_shippingAddressesPage.countryRegionShipping.click();
        actions.sendKeys("United States (US)", Keys.ENTER).build().perform();

        ReusableMethods.waitFor(3);
        us3_shippingAddressesPage.streetAddressShipping.sendKeys("Corfu 456", Keys.TAB, Keys.TAB, "Rachester");

        actions.sendKeys(Keys.PAGE_DOWN, Keys.PAGE_DOWN).perform();
        us3_shippingAddressesPage.stateShipping.click();
        us3_shippingAddressesPage.stateShipping.sendKeys("New York", Keys.ENTER);
        ReusableMethods.waitFor(3);

        us3_shippingAddressesPage.zipCodeShipping.sendKeys("10001", Keys.TAB, "123456");

        us3_shippingAddressesPage.saveAddressButtonShipping.click();
        Assert.assertTrue(us3_shippingAddressesPage.onayYazisiShipping.isDisplayed());

        Driver.closeDriver();
    }
}