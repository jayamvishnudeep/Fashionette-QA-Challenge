package fashionette.qa.automation;

import fashionette.qa.automation.base.BaseTest;
import fashionette.qa.automation.testMethods.FashionetteTestMethods;
import fashionette.qa.automation.utils.CommonMethods;
import fashionette.qa.automation.utils.TakeScreenshot;
import com.aventstack.extentreports.ExtentTest;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class FashionetteTests extends BaseTest {

  FashionetteTestMethods fashionetteTestMethodsObj = new FashionetteTestMethods();
  CommonMethods readCsvdataObj = new CommonMethods();


  public String fname = "Test"+readCsvdataObj.generateRandomChars();
  public  String lname = "Sample"+readCsvdataObj.generateRandomChars();

    @BeforeMethod
    public void setUp() throws Exception {
        initialization();
    }

    /**
     * Scenario 1
     * This test is to
     */
    @Test(enabled = true, priority = 1 ,description = "Adding a product to cart and logging in and verifying the cart details")
    public void addproductToCartAndLogin() {

        ExtentTest test = extent.createTest("Add Product To Cart And Verify");
        checkIfUrlLaunched(test);

        //Running The Test To Register A New User
        try {
            if (fashionetteTestMethodsObj.addProductToCartAndVerify(driver)) {
                test.info("Product Added To Cart Successfully");
                test.pass("TEST PASSED");
            }
            else
                test.fail("TEST FAILED");

            //Signing out
            //test.info("Logged Out");


        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * Scenario 2
     * This test is to Modify User Information
     */
    @Test(enabled = true, priority = 1 ,description = "Modify user Information")
    public void modifyUserInformation() {

        ExtentTest test1 = extent.createTest("Modify User Information");
        checkIfUrlLaunched(test1);

        //Running The Test To Register A New User
        try {
            if (fashionetteTestMethodsObj.modifyUserInformation(driver, fname , lname)) {
                test1.info("User Information Modified Successfully");
                test1.info("User First Name : "+fname);
                test1.info("User Surname is : "+lname);
                test1.pass("TEST PASSED");
            }
            else
                test1.fail("TEST FAILED");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * Scenario 3
     * This test is to apply a voucher
     */
    @Test(enabled = true, priority = 1 ,description = "Apply a Voucher")
    public void applyaVoucher() {

        ExtentTest test = extent.createTest("Apply a Voucher");
        checkIfUrlLaunched(test);

        //Running The Test To apply a voucher
        try {
            if (fashionetteTestMethodsObj.applyVoucher(driver)) {
                test.info("Voucher Applied Successfully");
                test.pass("TEST PASSED");
            }
            else
                test.fail("TEST FAILED");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @AfterMethod
    public void tearDown(ITestResult result) {

        if (ITestResult.FAILURE == result.getStatus()) {
            TakeScreenshot.captureScreenshot(driver, "Error");
        }
        driver.quit();
    }
}
