package technician;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class TechnicianLogin {

	public static void main(String[] args) throws InterruptedException {

		System.setProperty("webdriver.chrome.driver", "E:\\ICBT - Bsc\\Automation\\Chrome Driver\\chromedriver-win64\\chromedriver.exe");
		Thread.sleep(5000);

		String baseURL = "http://localhost:9090/technicianLogin";

		ChromeOptions option = new ChromeOptions();
		option.addArguments("--remote-allow-origins=*");
		Thread.sleep(5000);

		WebDriver chromeDriver = new ChromeDriver(option);
		Thread.sleep(5000);

		chromeDriver.manage().window().maximize();
		Thread.sleep(5000);

		chromeDriver.get(baseURL);
		Thread.sleep(5000);
		
		WebElement userName = chromeDriver.findElement(By.xpath("//input[@id='username']"));
		userName.sendKeys("TechAdmin");
		Thread.sleep(5000);
		
		WebElement password = chromeDriver.findElement(By.xpath("//input[@id='password']"));
		password.sendKeys("Tech_admin@ABC@123");
		Thread.sleep(5000);
		
		WebElement login = chromeDriver.findElement(By.xpath("//button[normalize-space()='Login Now']"));
		login.click();
	}

}
