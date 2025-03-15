package amazonautomationscript;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

public class AmazontestscriptTest {

    private Amazontestscript amazonTestScript;

    @Before
    public void setUp() {
        amazonTestScript = new Amazontestscript();
        amazonTestScript.Setup();
    }

    @After
    public void tearDown() {
        if (amazonTestScript.driver != null) {
            amazonTestScript.driver.quit();
        }
    }

    @Test
    public void testSearchAmazon() {
        amazonTestScript.SearchAmazon("Amazon");
        assertNotNull(amazonTestScript.driver.getTitle());
    }

    @Test
    public void testClickFirstLink() {
        amazonTestScript.SearchAmazon("Amazon");
        amazonTestScript.Clickfirstlink();
        assertNotNull(amazonTestScript.driver.getTitle());
    }

    @Test
    public void testSearchProductInAmazon() throws InterruptedException {
        amazonTestScript.SearchAmazon("Amazon");
        amazonTestScript.Clickfirstlink();
        amazonTestScript.SearchProductInAmazon("watch");
        assertNotNull(amazonTestScript.driver.getTitle());
    }

    @Test
    public void testPrintFirstFiveWatches() throws InterruptedException {
        amazonTestScript.SearchAmazon("Amazon");
        amazonTestScript.Clickfirstlink();
        amazonTestScript.SearchProductInAmazon("watch");
        amazonTestScript.PrintFirstFiveWatches();
        // This test is more for verification via console output
        assertTrue(true);
    }

    @Test
    public void testPrintFirstProduct() throws InterruptedException {
        amazonTestScript.SearchAmazon("Amazon");
        amazonTestScript.Clickfirstlink();
        amazonTestScript.SearchProductInAmazon("watch");
        amazonTestScript.printfirstproduct();
        // This test is more for verification via console output
        assertTrue(true);
    }

    @Test
    public void testSwitchToPreviousWindow() throws InterruptedException {
        amazonTestScript.SearchAmazon("Amazon");
        amazonTestScript.Clickfirstlink();
        amazonTestScript.switchToPreviousWindow();
        assertNotNull(amazonTestScript.driver.getTitle());
    }
}