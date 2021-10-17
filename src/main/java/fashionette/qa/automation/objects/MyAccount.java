package fashionette.qa.automation.objects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class MyAccount {

    public WebElement ordersData(WebDriver driver) {
        return driver.findElement(By.xpath("//div[@class='account-ordersdata']/a"));
    }

    public WebElement personalData(WebDriver driver) {
        return driver.findElement(By.xpath("//div[@class='account-personaldata']/a"));
    }

    public WebElement edit(WebDriver driver) {
        return driver.findElement(By.xpath("//div[contains(text(),'Edit')]"));
    }

    public WebElement firstName(WebDriver driver) {
        return driver.findElement(By.xpath("//input[@name='firstName']"));
    }

    public WebElement lastname(WebDriver driver) {
        return driver.findElement(By.xpath("//input[@name='lastName']"));
    }

    public WebElement save(WebDriver driver) {
        return driver.findElement(By.xpath("//div[text()='Save']"));
    }

    public WebElement accountUserName(WebDriver driver) {
        return driver.findElement(By.xpath("//span[@class='account__firstname']"));
    }

}
