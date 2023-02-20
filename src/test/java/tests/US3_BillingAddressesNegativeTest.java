package tests;

import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.US3_BillingAddressesPage;
import utilities.Driver;
import utilities.PearlyReusableMethods;
import utilities.ReusableMethods;

public class US3_BillingAddressesNegativeTest {

    @Test
    public void billingAddressNegativeTest01() {

        PearlyReusableMethods.anaSayfayaGiris();
        ReusableMethods.waitFor(3);

        US3_BillingAddressesPage us3_billingAddressesPage = new US3_BillingAddressesPage();
        us3_billingAddressesPage.firstName.clear();
        us3_billingAddressesPage.firstName.sendKeys(Keys.TAB);
        us3_billingAddressesPage.lastName.clear();
        us3_billingAddressesPage.lastName.sendKeys("Gungor", Keys.TAB);
        us3_billingAddressesPage.companyName.clear();
        us3_billingAddressesPage.companyName.sendKeys("darien lake ltd", Keys.TAB);

        ReusableMethods.waitFor(3);
        Actions actions = new Actions(Driver.getDriver());
        us3_billingAddressesPage.countryRegion.click();
        actions.sendKeys(Keys.ARROW_DOWN, Keys.ARROW_DOWN, Keys.ARROW_DOWN, Keys.ARROW_DOWN,
                Keys.ARROW_DOWN, Keys.ARROW_DOWN, Keys.ENTER).perform();

        ReusableMethods.waitFor(3);
        us3_billingAddressesPage.streetAddress.clear();
        us3_billingAddressesPage.streetAddress.sendKeys("Corfu 456", Keys.TAB, Keys.TAB);
        ReusableMethods.waitFor(3);

        us3_billingAddressesPage.townCity.clear();
        us3_billingAddressesPage.townCity.sendKeys("Rachester");
        ReusableMethods.waitFor(3);

        us3_billingAddressesPage.state.click();
        actions.sendKeys(Keys.ARROW_DOWN, Keys.ARROW_DOWN, Keys.ENTER).perform();

        us3_billingAddressesPage.zipCode.clear();
        us3_billingAddressesPage.zipCode.sendKeys("10001", Keys.TAB);

        us3_billingAddressesPage.phone.clear();
        us3_billingAddressesPage.phone.sendKeys("123456");
        ReusableMethods.waitFor(4);

        String actualEmail = "pearlymarketplace@gmail.com";
        String expectedEmail = us3_billingAddressesPage.emailAddress.getText();
        ReusableMethods.waitFor(4);
        Assert.assertNotEquals(expectedEmail, actualEmail);

        us3_billingAddressesPage.saveAddress.click();
        ReusableMethods.waitFor(5);
        assert us3_billingAddressesPage.firstNameHataYazisi.isDisplayed();

        Driver.closeDriver();
    }
}