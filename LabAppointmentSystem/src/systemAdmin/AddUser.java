package systemAdmin;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class AddUser {

	public static void main(String[] args) throws InterruptedException {

		System.setProperty("webdriver.chrome.driver", "E:\\ICBT - Bsc\\Automation\\Chrome Driver\\chromedriver-win64\\chromedriver.exe");
		Thread.sleep(5000);

		String baseURL = "http://localhost:9090/adminDashboard";

		ChromeOptions option = new ChromeOptions();
		option.addArguments("--remote-allow-origins=*");
		Thread.sleep(5000);

		WebDriver chromeDriver = new ChromeDriver(option);
		Thread.sleep(5000);

		chromeDriver.manage().window().maximize();
		Thread.sleep(5000);

		chromeDriver.get(baseURL);
		Thread.sleep(5000);

		WebDriverWait wait = new WebDriverWait(chromeDriver, Duration.ofSeconds(2000)); 

		WebElement user = chromeDriver.findElement(By.xpath("//a[@data-target='#collapseTwo']"));
		user.click();
		Thread.sleep(5000);

		WebElement addUser = chromeDriver.findElement(By.xpath("//a[contains(text(),'Add')]"));
		addUser.click();
		Thread.sleep(5000);

		// Switch to the new tab
		String currentWindowHandle = chromeDriver.getWindowHandle();
		for (String windowHandle : chromeDriver.getWindowHandles()) {
			if (!windowHandle.equals(currentWindowHandle)) {
				chromeDriver.switchTo().window(windowHandle);
				break;
			}
		}

		//no data
		WebElement regiter = chromeDriver.findElement(By.xpath("//button[normalize-space()='Register Now']"));
		regiter.click();
		Thread.sleep(5000);

		regiter = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[normalize-space()='Register Now']")));

		//incorrect email address format
		WebElement fullName = chromeDriver.findElement(By.xpath("//input[@id='full_name']"));
		fullName.sendKeys("Testing");
		Thread.sleep(5000);

		WebElement email = chromeDriver.findElement(By.xpath("//input[@id='email']"));
		email.sendKeys("test@gmailcom");
		Thread.sleep(5000);

		WebElement address = chromeDriver.findElement(By.xpath("//input[@id='address']"));
		address.sendKeys("Test");
		Thread.sleep(5000);

		WebElement phoneNumber = chromeDriver.findElement(By.xpath("//input[@id='phone_number']"));
		phoneNumber.sendKeys("0745698123");
		Thread.sleep(5000);

		regiter.click();
		Thread.sleep(5000);

		// Wait for the page to refresh or navigate
		// Then, re-locate the elements
		fullName = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@id='full_name']")));
		email = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@id='email']")));
		address = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@id='address']")));
		phoneNumber = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@id='phone_number']")));
		regiter = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[normalize-space()='Register Now']")));

		// Clear form fields
		fullName.clear();
		email.clear();
		address.clear();
		phoneNumber.clear();

		//email exist
		fullName.sendKeys("Testing");
		Thread.sleep(5000);

		email.sendKeys("sashee.wijewantha@gmail.com");
		Thread.sleep(5000);

		address.sendKeys("Test");
		Thread.sleep(5000);

		phoneNumber.sendKeys("0745698123");
		Thread.sleep(5000);

		regiter.click();
		Thread.sleep(5000);

		// Wait for the page to refresh or navigate
		// Then, re-locate the elements
		fullName = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@id='full_name']")));
		email = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@id='email']")));
		address = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@id='address']")));
		phoneNumber = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@id='phone_number']")));
		regiter = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[normalize-space()='Register Now']")));

		// Clear form fields
		fullName.clear();
		email.clear();
		address.clear();
		phoneNumber.clear();

		//correct details
		fullName.sendKeys("Testing");
		Thread.sleep(5000);

		email.sendKeys("testing@gmail.com");
		Thread.sleep(5000);

		address.sendKeys("Test");
		Thread.sleep(5000);

		phoneNumber.sendKeys("0745698123");
		Thread.sleep(5000);

		regiter.click();
		Thread.sleep(5000);
	}

}
