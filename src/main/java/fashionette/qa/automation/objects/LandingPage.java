package fashionette.qa.automation.objects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LandingPage {

    public WebElement acceptCookiesButton(WebDriver driver) {
        return driver.findElement(By.xpath("//button[@aria-label='ACCEPT']"));
    }

    public WebElement searchLink(WebDriver driver) {
        return driver.findElement(By.xpath("//a[@title='Search']"));
    }

    public WebElement searchInputField(WebDriver driver) {
        return driver.findElement(By.xpath("//input[@type='search']"));
    }

}
