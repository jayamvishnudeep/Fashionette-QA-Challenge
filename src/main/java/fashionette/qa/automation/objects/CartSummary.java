package fashionette.qa.automation.objects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class CartSummary {

    public WebElement cartProductDetails(WebDriver driver) {
        return driver.findElement(By.xpath("//div[@class='cart-item--description']"));
    }

    public WebElement redeemLink(WebDriver driver) {
        return driver.findElement(By.xpath("//a[@class='cart__sum__voucher-link']"));
    }

    public WebElement subTotal(WebDriver driver) {
        return driver.findElement(By.xpath("//td[@class='text__right typography__type-2 cart__subtotal']"));
    }

    public WebElement voucherDiscount(WebDriver driver) {
        return driver.findElement(By.xpath("//span[@data-code='qachallenge']"));
    }

    public WebElement voucherInput(WebDriver driver) {
        return driver.findElement(By.xpath("//input[@name='voucherCode']"));
    }

    public WebElement total(WebDriver driver) {
        return driver.findElement(By.xpath("//td[@id='cart__total']"));
    }

    public WebElement clearCart(WebDriver driver) {
        return driver.findElement(By.xpath("//i[@class='icon icon--inline icon--cross']"));
    }

}
