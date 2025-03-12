
package amazonautomationscript;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.WebElement;
import java.util.List;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;

class Amazontestscript{
	WebDriver driver;
	
	public void Setup() {
		driver=new ChromeDriver();
		driver.get("https://www.google.com");
		System.out.println("Page Title :"+ driver.getTitle());
	}
	
	public void SearchAmazon( String query) {
		JavascriptExecutor js = (JavascriptExecutor) driver;
        WebElement searchBox = (WebElement) js.executeScript("return document.querySelector('textarea[name=\"q\"]');");

        // Type "Amazon website" into the search box
        searchBox.sendKeys(query);

        // Submit the search
        searchBox.submit();
        System.out.println("Page tile after search"+driver.getTitle());
	}
	
	
	public void Clickfirstlink() {
	    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(50));
	    JavascriptExecutor js = (JavascriptExecutor) driver;

	    // Wait for the element to be present in the DOM
	    wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector(".v5yQqb a")));

	    
	    WebElement firstResult = (WebElement) js.executeScript("return document.querySelector('.v5yQqb a')");

	    // Click the element
	    
	    firstResult.click();

	    System.out.println("Now you can search your product!!");

	}
	
	public void SearchProductInAmazon(String product) throws InterruptedException {
		JavascriptExecutor js=(JavascriptExecutor) driver;
		WebElement searchproduct=(WebElement) js.executeScript("return document.querySelector('#twotabsearchtextbox')");
		searchproduct.sendKeys(product);
		Thread.sleep(6000);
		WebElement submit=(WebElement) js.executeScript("return document.querySelector('#nav-search-submit-button')");
		submit.click();
		
	}
	
	public void PrintFirstFiveWatches() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        JavascriptExecutor js = (JavascriptExecutor) driver;

        // Wait until the product results load
        wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector(".s-title-instructions-style")));

        // Use JavaScript to get the first 5 product names
        List<WebElement> watches = (List<WebElement>) js.executeScript(
                "return Array.from(document.querySelectorAll('.s-title-instructions-style')).slice(0,5);"
        );

        // Print the watch names
        System.out.println("First 5 Watches:");
        for (int i = 0; i < watches.size(); i++) {
            System.out.println((i + 1) + ". " + watches.get(i).getText());
        }
    }
	 public void printfirstproduct() {
		 WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
	        JavascriptExecutor js = (JavascriptExecutor) driver;
	        WebElement firstproduct=(WebElement) js.executeScript("return document.querySelector(\"h2[aria-label] span\")");
	        firstproduct.click();
	        System.out.println("product 1 selected !!");
	        WebElement productdetails=(WebElement) js.executeScript("return document.querySelector('.product-facts-title').textContent;");
	        System.out.println(productdetails);
	 }
	
	public static void main(String args[]) throws InterruptedException {
		Amazontestscript myScript=new Amazontestscript();
		myScript.Setup();
		myScript.SearchAmazon("Amazon");
		myScript.Clickfirstlink();
		myScript.SearchProductInAmazon("watch");
		Thread.sleep(7000);
		myScript.PrintFirstFiveWatches();
		myScript.printfirstproduct();
		
	}
	
}