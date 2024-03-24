package patient;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Payment {

	public static void main(String[] args) throws InterruptedException {

		System.setProperty("webdriver.chrome.driver", "E:\\ICBT - Bsc\\Automation\\Chrome Driver\\chromedriver-win64\\chromedriver.exe");

		ChromeOptions option = new ChromeOptions();
		option.addArguments("--remote-allow-origins=*");

		WebDriver chromeDriver = new ChromeDriver(option);
		chromeDriver.manage().window().maximize();

		String baseURL = "http://localhost:9090/payment";
		chromeDriver.get(baseURL);
		Thread.sleep(5000);

		WebDriverWait wait = new WebDriverWait(chromeDriver, Duration.ofSeconds(2000)); 
		
		//No data
		WebElement pay = chromeDriver.findElement(By.xpath("//button[normalize-space()='Pay']"));
		pay.click();
		Thread.sleep(5000);
		
		pay = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[normalize-space()='Pay']")));

		//invalid length of card number & invalid length of vcc
		WebElement card_number = chromeDriver.findElement(By.xpath("//input[@id='number']"));
		card_number.sendKeys("0123456789");
		Thread.sleep(5000);

		WebElement card_holder = chromeDriver.findElement(By.xpath("//input[@id='card_name']"));
		card_holder.sendKeys("W.A.Saman");
		Thread.sleep(5000);

		WebElement vcc = chromeDriver.findElement(By.xpath("//input[@id='vcc']"));
		vcc.sendKeys("12");
		Thread.sleep(5000);

		WebElement expired_date = chromeDriver.findElement(By.xpath("//input[@id='expr_date']"));
		expired_date.sendKeys("03/28");
		Thread.sleep(5000);

		WebElement email = chromeDriver.findElement(By.xpath("//input[@id='email']"));
		email.sendKeys("sashee.wijewantha@gmail.com");
		Thread.sleep(5000);

		pay.click();
		Thread.sleep(5000);

		// Wait for the page to refresh or navigate
		// Then, re-locate the elements
		card_number = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@id='number']")));
		card_holder = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@id='card_name']")));
		vcc = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@id='vcc']")));
		expired_date = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@id='expr_date']")));
		email = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@id='email']")));
		pay = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[normalize-space()='Pay']")));

		// Clear form fields
		card_number.clear();
		card_holder.clear();
		vcc.clear();
		expired_date.clear();
		email.clear();

		//invalid format of date
		card_number.sendKeys("0123456789012345");
		Thread.sleep(5000);

		card_holder.sendKeys("W.A.Saman");
		Thread.sleep(5000);

		vcc.sendKeys("123");
		Thread.sleep(5000);

		expired_date.sendKeys("32/03");
		Thread.sleep(5000);

		email.sendKeys("sashee.wijewantha@gmail.com");
		Thread.sleep(5000);

		pay.click();
		Thread.sleep(5000);

		// Wait for the page to refresh or navigate
		// Then, re-locate the elements
		card_number = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@id='number']")));
		card_holder = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@id='card_name']")));
		vcc = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@id='vcc']")));
		expired_date = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@id='expr_date']")));
		email = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@id='email']")));
		pay = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[normalize-space()='Pay']")));

		// Clear form fields
		card_number.clear();
		card_holder.clear();
		vcc.clear();
		expired_date.clear();
		email.clear();

		//correct details
		card_number.sendKeys("0123456789012345");
		Thread.sleep(5000);

		card_holder.sendKeys("W.A.Saman");
		Thread.sleep(5000);

		vcc.sendKeys("123");
		Thread.sleep(5000);

		expired_date.sendKeys("07/29");
		Thread.sleep(5000);

		email.sendKeys("sashee.wijewantha@gmail.com");
		Thread.sleep(5000);

		pay.click();
		Thread.sleep(5000);

	}

}
