package fashionette.qa.automation.objects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class SearchResults {

    public WebElement selectItem(WebDriver driver) {
        return driver.findElement(By.xpath("//div[@data-listing-name='search_results']/div//a"));
    }

    public WebElement getSelectedProductName(WebDriver driver) {
        return driver.findElement(By.xpath("//div[@class=\"container\"]//h1/small"));
    }

    public WebElement addToCartButton(WebDriver driver) {
        return driver.findElement(By.xpath("(//div[contains(text(),'Add to cart')])[last()]"));
    }

    public WebElement goToCartLink(WebDriver driver) {
        return driver.findElement(By.xpath("//span[@title='Go to Cart']/parent::a"));
    }

}
