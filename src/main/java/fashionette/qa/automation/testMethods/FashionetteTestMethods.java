package fashionette.qa.automation.testMethods;

import fashionette.qa.automation.objects.*;
import fashionette.qa.automation.utils.CommonMethods;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import static fashionette.qa.automation.base.BaseTest.prop;

public class FashionetteTestMethods {

    LandingPage landingPageObjet = new LandingPage();
    LoginPage loginPageObj = new LoginPage();
    SearchResults searchResultsObj = new SearchResults();
    MyAccount myAccountObj = new MyAccount();
    CartSummary cartSummaryObj = new CartSummary();
    CommonMethods commonMethodsObj = new CommonMethods();

    /**
     * This method is to add product to cart and verify it
     *
     * @param driver - Webdriver Object
     */

    public boolean addProductToCartAndVerify(WebDriver driver) throws InterruptedException {

        // Adding product to cart
        String productname = addProductToCart(driver);

        // Logging in
        login(driver);

        // Verify the product in the cart
        searchResultsObj.goToCartLink(driver).click();
        Assert.assertTrue(cartSummaryObj.cartProductDetails(driver).getText().contains(productname));

        cartSummaryObj.clearCart(driver).click();

        return true;
    }

    /**
     * This method is to add product to cart and verify it
     *
     * @param driver - Webdriver Object
     */

    public boolean modifyUserInformation(WebDriver driver, String fname, String lname) throws InterruptedException {

        try {
            //  Logging in
            login(driver);

            if (!myAccountObj.personalData(driver).isDisplayed()) {
                myAccountObj.ordersData(driver).click();
            }

            //Editing the personal information
            myAccountObj.personalData(driver).click();
            myAccountObj.edit(driver).click();

            myAccountObj.firstName(driver).clear();
            myAccountObj.firstName(driver).sendKeys(fname);

            myAccountObj.lastname(driver).clear();
            myAccountObj.lastname(driver).sendKeys(lname);

            myAccountObj.save(driver).click();
            Thread.sleep(3000);
            driver.navigate().refresh();
            String customerInformation = myAccountObj.accountUserName(driver).getText();
            Assert.assertTrue(customerInformation.contains(fname));

            return true;
        }
        catch (Exception e)
        {
            e.printStackTrace();
            return false;
        }
    }

    /**
     * This method is to apply Voucher Code to product in cart and verify it
     *
     * @param driver - Webdriver Object
     */

    public boolean applyVoucher(WebDriver driver) throws InterruptedException {

        // Logging in
        login(driver);

        // Adding Product To Cart
        addProductToCart(driver);

        // Go to cart
        searchResultsObj.goToCartLink(driver).click();

        // Applying Voucher Link
        cartSummaryObj.redeemLink(driver).click();
        cartSummaryObj.voucherInput(driver).sendKeys(commonMethodsObj.getData("voucherCode"));
        loginPageObj.loginButton(driver).click();

        double subTotal = Double.parseDouble(cartSummaryObj.subTotal(driver).getText().replaceAll("[^0-9\\.]", ""));
        double voucherDiscount = Double.parseDouble(cartSummaryObj.voucherDiscount(driver).getText().replaceAll("[^0-9\\.]", ""));
        double total = Double.parseDouble(cartSummaryObj.total(driver).getText().replaceAll("[^0-9\\.]", ""));

        // Verifying if the Voucher discount is applied
        Assert.assertTrue(subTotal - voucherDiscount == total && total < subTotal);

        cartSummaryObj.clearCart(driver).click();

        return true;
    }

    /**
     * This method is to add product to cart
     * @param driver - Webdriver Object
     */

    public String  addProductToCart(WebDriver driver) {

        // Searching for product to add to cart
        landingPageObjet.searchLink(driver).click();
        landingPageObjet.searchInputField(driver).sendKeys("Handbags");

        // Adding to cart
        searchResultsObj.selectItem(driver).click();
        searchResultsObj.addToCartButton(driver).click();

        return searchResultsObj.getSelectedProductName(driver).getText();
    }

    /**
     * This method is to login
     * @param driver - Webdriver Object
     */

    public void login(WebDriver driver) throws InterruptedException {

        // Clicking on Login icon
        loginPageObj.loginIcon(driver).click();

        // Entering the email and password details
        Thread.sleep(2000);
        loginPageObj.emailInput(driver).sendKeys(prop.getProperty("username"));
        loginPageObj.passwordInput(driver).sendKeys(prop.getProperty("Password"));

        // Clicking on the Submit button
        loginPageObj.loginButton(driver).click();

    }

}

