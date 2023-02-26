package tests;

import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.*;
import utilities.Driver;
import utilities.PearlyReusableMethods;
import utilities.ReusableMethods;

public class US4_ShippingAddressTest {

    @Test
    public void shippingAddressTest01() {
        PearlyReusableMethods.anaSayfayaGiris2();

        US4_ShippingAddressesPage us4_shippingAddressesPage = new US4_ShippingAddressesPage();
        Actions actions = new Actions(Driver.getDriver());
        us4_shippingAddressesPage.firstNameShipping.sendKeys("Gonca", Keys.TAB, "Gungor", Keys.TAB, "darien lake ltd");
        us4_shippingAddressesPage.countryRegionShipping.click();
        actions.sendKeys("United States (US)", Keys.ENTER).build().perform();

        ReusableMethods.waitFor(3);
        us4_shippingAddressesPage.streetAddressShipping.sendKeys("Corfu 456", Keys.TAB, Keys.TAB, "Rachester");

        actions.sendKeys(Keys.PAGE_DOWN, Keys.PAGE_DOWN).perform();
        ReusableMethods.waitFor(2);
        us4_shippingAddressesPage.stateShipping.click();
        us4_shippingAddressesPage.stateShipping.sendKeys("New York", Keys.ENTER);
        ReusableMethods.waitFor(3);

        us4_shippingAddressesPage.zipCodeShipping.sendKeys("10001", Keys.TAB, "123456");

//        us4_shippingAddressesPage.saveAddressButtonShipping.click();
//        Assert.assertTrue(us4_shippingAddressesPage.onayYazisiShipping.isDisplayed());

        Driver.closeDriver();
    }
}