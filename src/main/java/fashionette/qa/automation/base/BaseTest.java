package fashionette.qa.automation.base;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;
import fashionette.qa.automation.objects.LandingPage;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

public class BaseTest {

    public WebDriver driver;
    public static Properties prop;
    public ExtentHtmlReporter htmlReporter;
    public ExtentReports extent;
    LandingPage landingPageObj = new LandingPage();

    public BaseTest() {
        try {
            prop = new Properties();
            FileInputStream ip = new FileInputStream("src/main/java/fashionette/qa/automation/config.properties");
            prop.load(ip);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void initialization() throws Exception {
        String browserName = prop.getProperty("browserName");

        // Check if parameter passed as 'chrome'
        if (browserName.equals("Chrome")) {
            WebDriverManager.chromedriver().setup();
            ChromeOptions options = new ChromeOptions();
            options.addArguments("--incognito");
            driver = new ChromeDriver(options);
        }

        // Check if parameter passed as 'firefox'
        else if (browserName.equalsIgnoreCase("Firefox")) {
            WebDriverManager.firefoxdriver().setup();
            driver = new FirefoxDriver();
        }

        // Check if parameter passed as 'Edge'
        else if (browserName.equalsIgnoreCase("Edge")) {
            WebDriverManager.edgedriver().setup();
            driver = new EdgeDriver();
        } else {
            throw new Exception("Browser is not correct");
        }

        driver.manage().window().maximize();
        driver.manage().deleteAllCookies();
        driver.manage().timeouts().pageLoadTimeout(Integer.parseInt(prop.getProperty("PAGE_LOAD_TIMEOUT")), TimeUnit.SECONDS);
        driver.manage().timeouts().implicitlyWait(Integer.parseInt(prop.getProperty("IMPLICIT_WAIT")), TimeUnit.SECONDS);

        driver.get(prop.getProperty("url"));
    }

    public void checkIfUrlLaunched(ExtentTest test)
    {
        // Accepting Cookies popup if exists
        if(landingPageObj.acceptCookiesButton(driver).isDisplayed())
        {
            landingPageObj.acceptCookiesButton(driver).click();
        }
        // Checking if the URL is Launched Successfully
        if (driver.getTitle().equals(prop.getProperty("PageTitle")))
            test.info("URL Launched Successfully  :  " + prop.getProperty("url"));
        else
            test.info("Launch URL failed");
    }

    @BeforeTest
    public void generateReport() {
        htmlReporter = new ExtentHtmlReporter("./reports/extent.html");

        htmlReporter.config().setEncoding("utf-8");
        htmlReporter.config().setDocumentTitle("Fashionette REPORTS");
        htmlReporter.config().setReportName("Fashionette Automation Test Results");
        htmlReporter.config().setTheme(Theme.STANDARD);

        extent = new ExtentReports();
        extent.attachReporter(htmlReporter);

        extent.setSystemInfo("Automation Tester", "Vishnudeep Jayam");
        extent.setSystemInfo("Orgainzation", "Fashionette");
        extent.setSystemInfo("Build No", "W2A-1234");

    }

    @AfterTest
    public void endReport() {

        extent.flush();
    }

}

