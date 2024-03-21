package systemAdmin;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class DeleteUser {

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
		
		WebElement user = chromeDriver.findElement(By.xpath("//a[@data-target='#collapseTwo']"));
		user.click();
		Thread.sleep(5000);
		
		WebElement userData = chromeDriver.findElement(By.xpath("//a[normalize-space()='User Data']"));
		userData.click();
		Thread.sleep(5000);
		
		WebElement delete = chromeDriver.findElement(By.xpath("(//i[@class='fa-solid fa-trash ms-4'])[1]"));
		delete.click();
	}

}
