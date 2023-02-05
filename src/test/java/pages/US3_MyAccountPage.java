package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

public class US3_MyAccountPage {

    public US3_MyAccountPage(){
        PageFactory.initElements(Driver.getDriver(),this);
    }

    @FindBy(xpath = "(//*[text()='My Account'])[2]")
    public WebElement myAccountBasligi;

    @FindBy(xpath = "//a[@href='https://pearlymarket.com/my-account-2/edit-address/']")
    public WebElement addressesSecenegi;
}
