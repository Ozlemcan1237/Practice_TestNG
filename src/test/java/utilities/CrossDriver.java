package utilities;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;

import java.time.Duration;

public class CrossDriver {

    private CrossDriver(){

    }
    static WebDriver driver;

    public static WebDriver getDriver(String browser) {
        browser=(browser==null) ? ConfigReader.getProperty("browser") : browser;
        //Eger browser'a bir deger atanmamissa ConfigReader daki browser i calistir
        if (driver == null) { //EGER DRIVER'A DEGER ATANMAMISSA DEGER ATA, EGER DEGER ATANMISSSA DRIVER'I AYNI SAYFADA RETURN ET
            switch (browser){
                case "chrome":
                    WebDriverManager.chromedriver().setup();
                    driver = new ChromeDriver();
                    break;
                case "edge":
                    WebDriverManager.edgedriver().setup();
                    driver=new EdgeDriver();
                    break;
                case "safari":
                    WebDriverManager.edgedriver().setup();
                    driver=new SafariDriver();
                    break;
                case "firefox":
                    WebDriverManager.firefoxdriver().setup();
                    driver=new FirefoxDriver();
                    break;
                case "chrome-headless":
                    WebDriverManager.chromedriver().setup();
                    driver = new ChromeDriver(new ChromeOptions().setHeadless(true));
                    break;
            }
            driver.manage().window().maximize();
            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
        }
        return driver;
    }

    public static void closeDriver() {
        if (driver != null) { //DRIVER'A DEGER ATANMISSA
            driver.close();
            driver = null;
        }
    }

    public static void quitDriver() {
        if (driver != null) { //DRIVER'A DEGER ATANMISSA
            driver.quit();
            driver = null;
        }
    }
}

