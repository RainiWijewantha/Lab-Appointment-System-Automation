package patient;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class DownloadReports {

	public static void main(String[] args) throws InterruptedException {

		System.setProperty("webdriver.chrome.driver", "E:\\ICBT - Bsc\\Automation\\Chrome Driver\\chromedriver-win64\\chromedriver.exe");
		Thread.sleep(5000);

		String baseURL = "http://localhost:9090";

		ChromeOptions option = new ChromeOptions();
		option.addArguments("--remote-allow-origins=*");
		Thread.sleep(5000);

		WebDriver chromeDriver = new ChromeDriver(option);
		Thread.sleep(5000);

		chromeDriver.manage().window().maximize();
		Thread.sleep(5000);

		chromeDriver.get(baseURL);
		Thread.sleep(5000);
		
		WebElement reports = chromeDriver.findElement(By.xpath("//a[normalize-space()='Reports']"));
		reports.click();
		Thread.sleep(5000);
		
		// Switch to the new tab
		String currentWindowHandle = chromeDriver.getWindowHandle();
		for (String windowHandle : chromeDriver.getWindowHandles()) {
		    if (!windowHandle.equals(currentWindowHandle)) {
		        chromeDriver.switchTo().window(windowHandle);
		        break;
		    }
		}
		
		WebElement download = chromeDriver.findElement(By.xpath("(//i[@class='fa-solid fa-download ms-5'])[2]"));
		download.click();
	}

}
