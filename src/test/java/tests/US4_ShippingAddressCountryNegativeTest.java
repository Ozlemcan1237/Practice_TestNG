package tests;

import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.US3_BillingAddressesPage;
import pages.US4_ShippingAddressesPage;
import utilities.Driver;
import utilities.PearlyReusableMethods;
import utilities.ReusableMethods;

public class US4_ShippingAddressCountryNegativeTest {

     @Test
      public void shippingAddressCountryNegativeTest(){
        PearlyReusableMethods.anaSayfayaGiris2();
        US3_BillingAddressesPage us3_billingAddressesPage = new US3_BillingAddressesPage();
        US4_ShippingAddressesPage us4_shippingAddressesPage = new US4_ShippingAddressesPage();

         Actions actions = new Actions(Driver.getDriver());
         us4_shippingAddressesPage.firstNameShipping.sendKeys("Gonca", Keys.TAB, "Gungor", Keys.TAB, "darien lake ltd");
         us4_shippingAddressesPage.countryRegionShipping.click();
         actions.sendKeys("El Salvador", Keys.ENTER).build().perform();

         ReusableMethods.waitFor(3);
         us4_shippingAddressesPage.streetAddressShipping.sendKeys("Dos Santos", Keys.TAB, Keys.TAB, "San Salvador");

         actions.sendKeys(Keys.PAGE_DOWN, Keys.PAGE_DOWN).perform();
         ReusableMethods.waitFor(2);
         Assert.assertTrue(us4_shippingAddressesPage.state2.isDisplayed());
         Assert.assertTrue(us4_shippingAddressesPage.stateShipping.isDisplayed());
         Driver.closeDriver();
     }
}
