package utilities;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;

import java.time.Duration;

public class Driver {
    /*
       Driver daki temel mantık extents yöntemiyle değil yani TestBase class'ına extent etmek yerine
   Driver class'ından statik methodlar kullanarak driver oluştururuz.
   1-İlk olarak public static WebDriver getDriver() methodu oluşturmak. Bu method bize bir driver getirecek
   2-Driver'i kapatacağımız zaman da public static void closeDriver() methodu oluşturmak. İstediğimiz zaman
   bu methodla driver'i kapatacağız
    */
    private Driver(){

    }
    static WebDriver driver;

    public static WebDriver getDriver() {
        if (driver == null) { //EGER DRIVER'A DEGER ATANMAMISSA DEGER ATA, EGER DEGER ATANMISSSA DRIVER'I AYNI SAYFADA RETURN ET
            switch (ConfigReader.getProperty("browser")){
                case "chrome":
//                    WebDriverManager.chromedriver().setup();
//                    driver = new ChromeDriver();
                    ChromeOptions co = new ChromeOptions();
                    co.addArguments("--remote-allow-origins=*");
                    driver = new ChromeDriver(co);

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
            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
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