package utilities;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;

import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;

public class TestBaseCross {
    protected ExtentReports extentReports;//Raporlamayı başlatırız
    protected ExtentHtmlReporter extentHtmlReporter;//Raporumu HTLM formatında düzenler
    protected ExtentTest extentTest; //Test aşamalarına extentTest objesi ile bilgi ekleriz

    protected WebDriver driver;
    @Parameters("browser")
    @BeforeClass
    public void setup(@Optional String browser) { //@Parameters kullaninca @Optinal kullanmak zorundayiz
        driver = CrossDriver.getDriver(browser);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
        //------------------------------------------------------------
        extentReports = new ExtentReports();
        String tarih = new SimpleDateFormat("hh_mm_ss_ddMMyyyy").format(new Date());
        String dosyaYolu = "target/ExtentReports/htmlreport"+tarih+".html";
        extentHtmlReporter = new ExtentHtmlReporter(dosyaYolu);
        extentReports.attachReporter(extentHtmlReporter);
//Raporda gözükmesini istediğimiz bilgiler için
        extentReports.setSystemInfo("BootCamp","Deneme");
        extentReports.setSystemInfo("Tester","Erol");
        extentHtmlReporter.config().setDocumentTitle("Extent Report");
        extentHtmlReporter.config().setReportName("Test Sonucu");
    }
    @AfterClass
    public void tearDown() {
        extentReports.flush();
        CrossDriver.quitDriver();
    }
}
