package Patient;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.Select;

public class Dashboard {

	public static void main(String[] args) throws InterruptedException {

		System.setProperty("webdriver.chrome.driver", "E:\\ICBT - Bsc\\Automation\\Chrome Driver\\chromedriver-win64\\chromedriver.exe");
		Thread.sleep(5000);

		String baseURL = "http://localhost:9090";
		Thread.sleep(5000);

		ChromeOptions option = new ChromeOptions();
		option.addArguments("--remote-allow-origins=*");
		Thread.sleep(5000);

		WebDriver chromeDriver = new ChromeDriver(option);
		Thread.sleep(5000);

		chromeDriver.manage().window().maximize();
		Thread.sleep(5000);

		chromeDriver.get(baseURL);
		Thread.sleep(5000);

		WebElement displayAppointmentPage = chromeDriver.findElement(By.xpath("(//a[contains(text(),'Request')])[1]"));
		displayAppointmentPage.click();
		Thread.sleep(5000);

		// Switch to the new tab
		String currentWindowHandle = chromeDriver.getWindowHandle();
		for (String windowHandle : chromeDriver.getWindowHandles()) {
			if (!windowHandle.equals(currentWindowHandle)) {
				chromeDriver.switchTo().window(windowHandle);
				break;
			}
		}

		WebElement patientName = chromeDriver.findElement(By.xpath("//input[@id='full_name']"));
		patientName.sendKeys("Test Data");
		Thread.sleep(5000);

		Select test_type = new Select(chromeDriver.findElement(By.name("test_type")));
		test_type.selectByValue("xRay");
		Thread.sleep(5000);

		WebElement date = chromeDriver.findElement(By.xpath("(//input[@id='date'])[1]"));
		date.sendKeys("03/20/2024");
		Thread.sleep(5000);



	}



}
