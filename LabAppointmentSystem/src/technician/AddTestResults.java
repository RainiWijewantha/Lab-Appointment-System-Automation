package technician;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.Select;

public class AddTestResults {

	public static void main(String[] args) throws InterruptedException {

		System.setProperty("webdriver.chrome.driver", "E:\\ICBT - Bsc\\Automation\\Chrome Driver\\chromedriver-win64\\chromedriver.exe");
		Thread.sleep(5000);

		String baseURL = "http://localhost:9090/testResults";

		ChromeOptions option = new ChromeOptions();
		option.addArguments("--remote-allow-origins=*");
		Thread.sleep(5000);

		WebDriver chromeDriver = new ChromeDriver(option);
		Thread.sleep(5000);

		chromeDriver.manage().window().maximize();
		Thread.sleep(5000);

		chromeDriver.get(baseURL);
		Thread.sleep(5000);

		WebElement patientName = chromeDriver.findElement(By.xpath("//input[@id='patient_name']"));
		patientName.sendKeys("Testing");
		Thread.sleep(5000);

		Select test_type = new Select(chromeDriver.findElement(By.name("test_type")));
		test_type.selectByValue("xRay");
		Thread.sleep(5000);

		WebElement testDate = chromeDriver.findElement(By.xpath("//input[@id='test_date']"));
		testDate.sendKeys("03/15/2024");
		Thread.sleep(5000);

		WebElement file = chromeDriver.findElement(By.xpath("//input[@id='file']"));
		// Specify the path to the file you want to upload
		String filePath = "E:\\ICBT - Bsc\\Semester 1\\Assignments\\CIS6003\\test_result.pdf";
		// Send the file path to the file input field
		file.sendKeys(filePath);
		Thread.sleep(5000);

		WebElement uniqueId = chromeDriver.findElement(By.xpath("//input[@id='unique_id']"));
		uniqueId.sendKeys("REG-ABC20240321224547623005");
		Thread.sleep(5000);

		WebElement add = chromeDriver.findElement(By.xpath("//button[normalize-space()='Submit']"));
		add.click();
	}

}
