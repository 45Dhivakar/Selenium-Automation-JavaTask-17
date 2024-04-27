package Maven.Testing;

import java.time.Duration;

import org.openqa.selenium.By;

import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
//import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.WebDriverWait;

public class SnapdealTest {
	
	public  SnapdealTest() {
		
		// Set the path to chromedriver.exe
        System.setProperty("Webdriver.gecko.driver","C:\\Users\\Dell\\Downloads\\geckodriver-v0.34.0-win64.exe");
    
		
	}
	String url = "https://www.snapdeal.com/";
	String singnInXpath = "//span[text()='Sign In']";
	String loginXpath = "//a[text()='login']";
	String emailFeildID= "userName";
	String  checkUserID = "//button[@id='checkUser']";
	//String passWordField = "//input[@placeholder='password']";
	
	
	//Initialize FirefoxDriver
    WebDriver driver = new FirefoxDriver();
    
    
    public void launchSnapDeal() {
    	
    	try {
    	
    	driver.get(url);
    	driver.findElement(By.xpath(singnInXpath)).click();
        driver.findElement(By.xpath(loginXpath)).click();
    	driver.findElement(By.name("iframeLogin"));
    	driver.switchTo().frame(2);
    	driver.findElement(By.id(emailFeildID)).sendKeys("b.e.dhivakar03@gmail.com");
    	driver.findElement(By.xpath(checkUserID)).click();
    	//driver.findElement(By.id(passWordField)).sendKeys("#123@");
    	driver.manage().window().maximize();
    }catch (Exception e) {
    	System.out.println("An error occurred during navigation:" + e.getMessage());
    	e.printStackTrace();
    	return;
    }
    }

    public static void main(String[] args) {
       
    	SnapdealTest snap = new SnapdealTest();
    	snap.launchSnapDeal();	
    	
    	try {
    		Thread.sleep(5000);
    	}catch (InterruptedException e) {
    		e.printStackTrace();
    	}
    	
    	// Wait for verification message element to be visible
        WebDriver driver = snap.getDriver();
    	WebDriverWait wait = new  WebDriverWait(driver,Duration.ofSeconds(50));
        WebElement verificationMessageElement = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='forgot-password']")));
        
        // Extract text from verification message element
        String verificationMessage = verificationMessageElement.getText();
        
        
     // Print verification message
        if (verificationMessage.contains("My Orders")) {
            System.out.println("Login successful! Verification message: " + verificationMessage);
        } else {
            System.out.println("Login unsuccessful! Verification message: " + verificationMessage);
        }
        
       
        
        driver.quit();
         
        }

	private WebDriver getDriver() {
		
		return driver;
	}
   
  
    }

