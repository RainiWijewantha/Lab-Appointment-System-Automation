package systemAdmin;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class AdminLogin {

	public static void main(String[] args) throws InterruptedException {

		System.setProperty("webdriver.chrome.driver", "E:\\ICBT - Bsc\\Automation\\Chrome Driver\\chromedriver-win64\\chromedriver.exe");
		Thread.sleep(5000);

		String baseURL = "http://localhost:9090/adminLogin";

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

		WebElement userName = chromeDriver.findElement(By.xpath("//input[@id='username']"));

		WebElement password = chromeDriver.findElement(By.xpath("//input[@id='password']"));

		WebElement login = chromeDriver.findElement(By.xpath("//button[normalize-space()='Login Now']"));

		//No data
		login.click();
		Thread.sleep(5000);

		// Wait for the page to refresh or navigate
		// Then, re-locate the elements
		userName = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@id='username']")));
		password = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@id='password']")));
		login = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[normalize-space()='Login Now']")));

		//correct username and wrong password
		userName.sendKeys("SysAdmin");
		Thread.sleep(5000);

		password.sendKeys("SysAdminABC@123");
		Thread.sleep(5000);

		login.click();
		Thread.sleep(5000);

		// Wait for the page to refresh or navigate
		// Then, re-locate the elements
		userName = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@id='username']")));
		password = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@id='password']")));
		login = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[normalize-space()='Login Now']")));

		//wrong username and correct password
		userName.sendKeys("SysAdministrator");
		Thread.sleep(5000);

		password.sendKeys("SysAdmin-ABC@123");
		Thread.sleep(5000);

		login.click();
		Thread.sleep(5000);

		// Wait for the page to refresh or navigate
		// Then, re-locate the elements
		userName = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@id='username']")));
		password = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@id='password']")));
		login = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[normalize-space()='Login Now']")));

		//wrong username and password
		userName.sendKeys("SysAdministrator");
		Thread.sleep(5000);

		password.sendKeys("SysAdminABC@123");
		Thread.sleep(5000);

		login.click();
		Thread.sleep(5000);

		// Wait for the page to refresh or navigate
		// Then, re-locate the elements
		userName = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@id='username']")));
		password = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@id='password']")));
		login = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[normalize-space()='Login Now']")));

		//correct credentials
		userName.sendKeys("SysAdmin");
		Thread.sleep(5000);

		password.sendKeys("SysAdmin-ABC@123");
		Thread.sleep(5000);

		login.click();
	}

}
