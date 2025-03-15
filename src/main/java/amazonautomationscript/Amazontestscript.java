
package amazonautomationscript;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.List;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;

class Amazontestscript{
	WebDriver driver;
	
//	public void Setup() {
//		driver=new ChromeDriver();
//		driver.get("https://www.google.com");
//		System.out.println("Page Title :"+ driver.getTitle());
//	}
	public void Setup() {
	    // Set the path to chromedriver.exe
	    System.setProperty("webdriver.chrome.driver", "C:\\Users\\91790\\Downloads\\chromedriver-win32\\chromedriver-win32\\chromedriver.exe");
	    driver = new ChromeDriver();
	    driver.get("https://www.google.com");
	    System.out.println("Page Title :" + driver.getTitle());
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
//	
//	
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
//	
	public void SearchProductInAmazon(String product) throws InterruptedException {
		JavascriptExecutor js=(JavascriptExecutor) driver;
		WebElement searchproduct=(WebElement) js.executeScript("return document.querySelector('#twotabsearchtextbox')");
		searchproduct.sendKeys(product);
		Thread.sleep(6000);
		WebElement submit=(WebElement) js.executeScript("return document.querySelector('#nav-search-submit-button')");
		submit.click();
		
	}
//	
	public void PrintFirstFiveWatches() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(500));
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
//	
//
	
	public void switchToPreviousWindow() {
	    // Get all window handles
	    List<String> windowHandlesList = new ArrayList<>(driver.getWindowHandles());

	    // Switch to the first window (Google search)
	    driver.switchTo().window(windowHandlesList.get(0));

	    System.out.println("Switched back to the previous window.");
	}

	 public void printfirstproduct() throws InterruptedException {
		 WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(800));
	        JavascriptExecutor js = (JavascriptExecutor) driver;
	        WebElement firstproduct=(WebElement) js.executeScript("return document.querySelector(\"h2[aria-label] span\")");
	        String prod1_name=(String) js.executeScript("return document.querySelectorAll('h2.a-size-base-plus.a-color-base.a-text-normal span')[0].innerText");
	        firstproduct.click();
	        System.out.println("product 1 selected --> "+prod1_name);
	        Thread.sleep(1000);
	        //driver.navigate().back();
	        //switchToPreviousWindow();
//	        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".product-facts-title")));
//	        //String productdetails=(String) js.executeScript("return document.querySelector('.product-facts-title')");
//	      
//	        String productdetails = (String) js.executeScript("return document.querySelector('.product-facts-title')?.innerText || 'No product details found';");
//
//	        
//	        System.out.println(productdetails);
	        
	 }
	 public void printsecondproduct() throws InterruptedException {
		 WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(400));
		 	JavascriptExecutor js=(JavascriptExecutor) driver;
		 	WebElement secondproduct=(WebElement) js.executeScript("return document.querySelectorAll('h2.a-size-base-plus.a-spacing-none.a-color-base.a-text-normal span')[1]");
		 	String prod2_name=(String) js.executeScript("return document.querySelectorAll('h2.a-size-base-plus.a-color-base.a-text-normal span')[1].innerText");
	        secondproduct.click();
	        System.out.println("product 2 selected --> "+prod2_name);
	        Thread.sleep(1000);
	        //driver.navigate().back();
	        //switchToPreviousWindow();
	 }
public void printthirdproduct() throws InterruptedException {
	WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(400));
 	JavascriptExecutor js=(JavascriptExecutor) driver;
 	WebElement product3=(WebElement) js.executeScript("return document.querySelectorAll('h2.a-size-base-plus.a-spacing-none.a-color-base.a-text-normal span')[2]");
 	String prod3_name=(String) js.executeScript("return document.querySelectorAll('h2.a-size-base-plus.a-color-base.a-text-normal span')[2].innerText");
    product3.click();
    System.out.println("product 3 selected --> "+prod3_name);
    Thread.sleep(1000);
}

public void printfourthproduct() throws InterruptedException {
	WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(400));
 	JavascriptExecutor js=(JavascriptExecutor) driver;
 	WebElement product4=(WebElement) js.executeScript("return document.querySelectorAll('h2.a-size-base-plus.a-spacing-none.a-color-base.a-text-normal span')[3]");
 	String prod4_name=(String) js.executeScript("return document.querySelectorAll('h2.a-size-base-plus.a-color-base.a-text-normal span')[3].innerText");
    product4.click();
    System.out.println("product 4 selected  --> "+prod4_name);
    Thread.sleep(1000);
}
    
public void printfifthproduct() throws InterruptedException {
	WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(400));
 	JavascriptExecutor js=(JavascriptExecutor) driver;
 	WebElement product5=(WebElement) js.executeScript("return document.querySelectorAll('h2.a-size-base-plus.a-spacing-none.a-color-base.a-text-normal span')[4]");
 	String prod5_name=(String) js.executeScript("return document.querySelectorAll('h2.a-size-base-plus.a-color-base.a-text-normal span')[4].innerText");
    product5.click();
    System.out.println("product 5 selected --> "+ prod5_name);
    Thread.sleep(1000);
} 
//	
//	
//
//	
//	public static void main(String args[]) throws InterruptedException {
//		Amazontestscript myScript=new Amazontestscript();
//		myScript.Setup();
//		myScript.SearchAmazon("Amazon");
//		myScript.Clickfirstlink();
//		myScript.SearchProductInAmazon("watch");
//		Thread.sleep(7000);
//		myScript.PrintFirstFiveWatches();
//		myScript.printfirstproduct();
//		myScript.switchToPreviousWindow();
//		myScript.printsecondproduct();
//		Thread.sleep(2000);
//		myScript.switchToPreviousWindow();
//		myScript.printthirdproduct();
//		Thread.sleep(2000);
//		myScript.switchToPreviousWindow();
//		myScript.printfourthproduct();
//		Thread.sleep(2000);
//		myScript.switchToPreviousWindow();
//        myScript.printfifthproduct();
//	}
	
}

