package tests;

import org.testng.annotations.Test;
import pages.US3_BillingAddressesPage;
import pages.US4_ShippingAddressesPage;
import utilities.Driver;
import utilities.PearlyReusableMethods;
import utilities.ReusableMethods;

public class US4_ShippingAddressNegativeTest {

    @Test
    public void shippingAddressNegativeTest01(){
        PearlyReusableMethods.anaSayfayaGiris2();
        US3_BillingAddressesPage us3_billingAddressesPage = new US3_BillingAddressesPage();
        US4_ShippingAddressesPage us4_shippingAddressesPage = new US4_ShippingAddressesPage();
        ReusableMethods.clickByJS(us3_billingAddressesPage.saveAddress);
        ReusableMethods.waitFor(5);
        assert us4_shippingAddressesPage.hataYazilari.isDisplayed();
        Driver.closeDriver();
    }
}
