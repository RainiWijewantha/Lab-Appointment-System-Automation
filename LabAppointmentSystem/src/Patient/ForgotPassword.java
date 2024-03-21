package patient;

import java.time.Duration;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ForgotPassword {

	public static void main(String[] args) throws InterruptedException {

		System.setProperty("webdriver.chrome.driver", "E:\\ICBT - Bsc\\Automation\\Chrome Driver\\chromedriver-win64\\chromedriver.exe");

		ChromeOptions option = new ChromeOptions();
		option.addArguments("--remote-allow-origins=*");

		WebDriver chromeDriver = new ChromeDriver(option);
		chromeDriver.manage().window().maximize();

		String baseURL = "http://localhost:9090/patientLogin";
		chromeDriver.get(baseURL);
		Thread.sleep(5000);

		//WebDriverWait wait = new WebDriverWait(chromeDriver, Duration.ofSeconds(2000)); 

		WebElement forgot_password = chromeDriver.findElement(By.xpath("//a[contains(text(),'Forgot')]"));
		forgot_password.click();
		Thread.sleep(5000);

		WebElement email = chromeDriver.findElement(By.xpath("//input[@id='email']"));
		email.sendKeys("sashee.wijewantha@gmail.com");
		Thread.sleep(5000);

		WebElement submit = chromeDriver.findElement(By.xpath("//button[normalize-space()='Submit']"));
		submit.click();
		Thread.sleep(5000);

		


	}

}
