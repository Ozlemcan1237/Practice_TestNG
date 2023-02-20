package utilities;

import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import pages.*;

public class PearlyReusableMethods {
    static US3_PearlyMarketHomePage us3_pearlyMarketHomePage;
    static US3_MyAccountPage us3_myAccountPage;
    static US3_AddressesPage us3_addressesPage;
    static US3_BillingAddressesPage us3_billingAddressesPage;
    static US4_ShippingAddressesPage us4_shippingAddressesPage;
    public static void anaSayfayaGiris(){

        us3_pearlyMarketHomePage = new US3_PearlyMarketHomePage();
        us3_myAccountPage = new US3_MyAccountPage();
        us3_addressesPage = new US3_AddressesPage();
        us3_billingAddressesPage = new US3_BillingAddressesPage();

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
        ReusableMethods.waitFor(4);
        Assert.assertTrue(us3_addressesPage.addressesSayfasi.isDisplayed());
        ReusableMethods.waitFor(4);
        Actions actions = new Actions(Driver.getDriver());
        actions.sendKeys(Keys.PAGE_DOWN).perform();
        ReusableMethods.waitFor(3);
        us3_addressesPage.editYourBillingAddressButton.click();
    }

    public static void anaSayfayaGiris2(){

        us3_pearlyMarketHomePage = new US3_PearlyMarketHomePage();
        us3_myAccountPage = new US3_MyAccountPage();
        us3_addressesPage = new US3_AddressesPage();
        us3_billingAddressesPage = new US3_BillingAddressesPage();
        us4_shippingAddressesPage=new US4_ShippingAddressesPage();

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
    }
}
