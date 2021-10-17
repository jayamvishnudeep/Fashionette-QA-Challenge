package fashionette.qa.automation.utils;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class TakeScreenshot {

    /**
     * This method is to take screenshots
     *
     * @param driver         - Webdriver Object
     * @param screenShotName
     */

    public static void captureScreenshot(WebDriver driver, String screenShotName) {

        try {
            TakesScreenshot ts = (TakesScreenshot) driver;

            File source = ts.getScreenshotAs(OutputType.FILE);

            String timestamp = new SimpleDateFormat("yyyy_MM_dd__hh_mm_ss").format(new Date());

            FileUtils.copyFile(source, new File("src/main/java/fashionette/qa/automation/data/screenshots/" + screenShotName + timestamp + ".png"));

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
