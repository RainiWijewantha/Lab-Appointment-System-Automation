package patient;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class Login {

	public static void main(String[] args) throws InterruptedException {

		System.setProperty("webdriver.chrome.driver", "E:\\ICBT - Bsc\\Automation\\Chrome Driver\\chromedriver-win64\\chromedriver.exe");
		Thread.sleep(5000);

		String baseURL = "http://localhost:9090/message";

		ChromeOptions option = new ChromeOptions();
		option.addArguments("--remote-allow-origins=*");
		Thread.sleep(5000);

		WebDriver chromeDriver = new ChromeDriver(option);
		Thread.sleep(5000);

		chromeDriver.manage().window().maximize();
		Thread.sleep(5000);

		chromeDriver.get(baseURL);
		Thread.sleep(5000);
		
		WebElement login = chromeDriver.findElement(By.xpath("//button[normalize-space()='Login']"));
		login.click();
		Thread.sleep(5000);
		
		//No data 
		WebElement Login = chromeDriver.findElement(By.xpath("//button[normalize-space()='Login Now']"));
		Login.click();
		Thread.sleep(5000);
		
		//Correct email & wrong password
		WebElement email = chromeDriver.findElement(By.xpath("//input[@id='email']"));
		email.sendKeys("sashee.wijewantha@gmail.com");
		Thread.sleep(5000);
		
		WebElement password = chromeDriver.findElement(By.xpath("//input[@id='password']"));
		password.sendKeys("raini");
		Thread.sleep(5000);
		
		WebElement Login1 = chromeDriver.findElement(By.xpath("//button[normalize-space()='Login Now']"));
		Login1.click();
		Thread.sleep(5000);
		
		//Wrong email & correct password
		WebElement email1 = chromeDriver.findElement(By.xpath("//input[@id='email']"));
		email1.sendKeys("test@gmail.com");
		Thread.sleep(5000);
		
		WebElement password1 = chromeDriver.findElement(By.xpath("//input[@id='password']"));
		password1.sendKeys("Raini");
		Thread.sleep(5000);
		
		WebElement Login2 = chromeDriver.findElement(By.xpath("//button[normalize-space()='Login Now']"));
		Login2.click();
		Thread.sleep(5000);
		
		//Wrong email & password
		WebElement email2 = chromeDriver.findElement(By.xpath("//input[@id='email']"));
		email2.sendKeys("test@gmail.com");
		Thread.sleep(5000);
		
		WebElement password2 = chromeDriver.findElement(By.xpath("//input[@id='password']"));
		password2.sendKeys("raini");
		Thread.sleep(5000);
		
		WebElement Login3 = chromeDriver.findElement(By.xpath("//button[normalize-space()='Login Now']"));
		Login3.click();
		Thread.sleep(5000);
		
		//Correct details
		WebElement email3 = chromeDriver.findElement(By.xpath("//input[@id='email']"));
		email3.sendKeys("sashee.wijewantha@gmail.com");
		Thread.sleep(5000);
		
		WebElement password3 = chromeDriver.findElement(By.xpath("//input[@id='password']"));
		password3.sendKeys("Raini@123");
		Thread.sleep(5000);
		
		WebElement Login4 = chromeDriver.findElement(By.xpath("//button[normalize-space()='Login Now']"));
		Login4.click();
		Thread.sleep(5000);
	}

}
