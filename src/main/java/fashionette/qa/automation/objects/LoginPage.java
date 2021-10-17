package fashionette.qa.automation.objects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LoginPage {

    public WebElement loginIcon(WebDriver driver) {
        return driver.findElement(By.xpath("//a[@title='Login']"));
    }

    public WebElement emailInput(WebDriver driver) {
        return driver.findElement(By.xpath("//input[@name='email']"));
    }

    public WebElement passwordInput(WebDriver driver) {
        return driver.findElement(By.xpath("//input[@name='password']"));
    }

    public WebElement loginButton(WebDriver driver) {
        return driver.findElement(By.xpath("//button[@type='submit']"));
    }

}
