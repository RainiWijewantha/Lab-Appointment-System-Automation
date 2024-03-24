package patient;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Register {

	public static void main(String[] args) throws InterruptedException {

		System.setProperty("webdriver.chrome.driver", "E:\\ICBT - Bsc\\Automation\\Chrome Driver\\chromedriver-win64\\chromedriver.exe");

		ChromeOptions option = new ChromeOptions();
		option.addArguments("--remote-allow-origins=*");

		WebDriver chromeDriver = new ChromeDriver(option);
		chromeDriver.manage().window().maximize();

		String baseURL = "http://localhost:9090/patientLogin";
		chromeDriver.get(baseURL);
		Thread.sleep(5000);

		WebDriverWait wait = new WebDriverWait(chromeDriver, Duration.ofSeconds(2000)); 

		// Click on "Register here" link
		WebElement registerLink = chromeDriver.findElement(By.xpath("//a[normalize-space()='Register here']"));
		registerLink.click();
		Thread.sleep(5000);

		//No data
		WebElement registerButton = chromeDriver.findElement(By.xpath("//button[normalize-space()='Register Now']"));
		registerButton.click();
		Thread.sleep(5000);

		// Wait for the page to refresh or navigate
		// Then, re-locate the elements
		registerButton = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[normalize-space()='Register Now']")));

		//incorrect email format
		WebElement fullName = chromeDriver.findElement(By.xpath("//input[@id='full_name']"));
		fullName.sendKeys("Test1");
		Thread.sleep(5000);

		WebElement email = chromeDriver.findElement(By.xpath("//input[@id='email']"));
		email.sendKeys("test@gmailcom");
		Thread.sleep(5000);

		WebElement address = chromeDriver.findElement(By.xpath("//input[@id='address']"));
		address.sendKeys("Matara");
		Thread.sleep(5000);

		WebElement phoneNumber = chromeDriver.findElement(By.xpath("//input[@id='phone_number']"));
		phoneNumber.sendKeys("0785236984");
		Thread.sleep(5000);

		WebElement password = chromeDriver.findElement(By.xpath("//input[@id='password']"));
		password.sendKeys("Test");
		Thread.sleep(5000);

		WebElement confirmPassword = chromeDriver.findElement(By.xpath("//input[@id='confirm_password']"));
		confirmPassword.sendKeys("Test");
		Thread.sleep(5000);

		// Click on "Register Now" button
		registerButton.click();

		// Wait for the page to refresh or navigate
		// Then, re-locate the elements
		fullName = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@id='full_name']")));
		email = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@id='email']")));
		address = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@id='address']")));
		phoneNumber = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@id='phone_number']")));
		password = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@id='password']")));
		confirmPassword = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@id='confirm_password']")));
		registerButton = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[normalize-space()='Register Now']")));

		// Clear form fields
		fullName.clear();
		email.clear();
		address.clear();
		phoneNumber.clear();

		//Email exists
		fullName.sendKeys("Test1");
		Thread.sleep(5000);

		email.sendKeys("test@gmail.com");
		Thread.sleep(5000);

		address.sendKeys("Matara");
		Thread.sleep(5000);

		phoneNumber.sendKeys("0785236984");
		Thread.sleep(5000);

		password.sendKeys("Test");
		Thread.sleep(5000);

		confirmPassword.sendKeys("Test");
		Thread.sleep(5000);

		registerButton.click();

		// Wait for the page to refresh or navigate
		// Then, re-locate the elements
		fullName = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@id='full_name']")));
		email = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@id='email']")));
		address = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@id='address']")));
		phoneNumber = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@id='phone_number']")));
		password = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@id='password']")));
		confirmPassword = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@id='confirm_password']")));
		registerButton = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[normalize-space()='Register Now']")));

		// Clear form fields
		fullName.clear();
		email.clear();
		address.clear();
		phoneNumber.clear();

		//Password not match
		fullName.sendKeys("Test1");
		Thread.sleep(5000);

		email.sendKeys("test@gmail.com");
		Thread.sleep(5000);

		address.sendKeys("Matara");
		Thread.sleep(5000);

		phoneNumber.sendKeys("0785236984");
		Thread.sleep(5000);

		password.sendKeys("Test1");
		Thread.sleep(5000);

		confirmPassword.sendKeys("Test");
		Thread.sleep(5000);

		registerButton.click();

		// Wait for the page to refresh or navigate
		// Then, re-locate the elements
		fullName = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@id='full_name']")));
		email = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@id='email']")));
		address = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@id='address']")));
		phoneNumber = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@id='phone_number']")));
		password = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@id='password']")));
		confirmPassword = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@id='confirm_password']")));
		registerButton = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[normalize-space()='Register Now']")));

		// Clear form fields
		fullName.clear();
		email.clear();
		address.clear();
		phoneNumber.clear();

		//Correct details
		fullName.sendKeys("Test1");
		Thread.sleep(5000);

		email.sendKeys("sashee.raini@gmail.com");
		Thread.sleep(5000);

		address.sendKeys("Matara");
		Thread.sleep(5000);

		phoneNumber.sendKeys("0785236984");
		Thread.sleep(5000);

		password.sendKeys("Test");
		Thread.sleep(5000);

		confirmPassword.sendKeys("Test");
		Thread.sleep(5000);

		registerButton.click();

	}

}
