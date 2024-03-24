package technician;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

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

		WebDriverWait wait = new WebDriverWait(chromeDriver, Duration.ofSeconds(2000)); 

		WebElement patientName = chromeDriver.findElement(By.xpath("//input[@id='patient_name']"));
		Select test_type = new Select(chromeDriver.findElement(By.name("test_type")));
		WebElement testDate = chromeDriver.findElement(By.xpath("//input[@id='test_date']"));
		WebElement file = chromeDriver.findElement(By.xpath("//input[@id='file']"));
		WebElement uniqueId = chromeDriver.findElement(By.xpath("//input[@id='unique_id']"));
		WebElement add = chromeDriver.findElement(By.xpath("//button[normalize-space()='Submit']"));

		//no data
		add.click();

		// Wait for the page to refresh or navigate
		// Then, re-locate the elements
		patientName = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@id='patient_name']")));
		test_type =  new Select(wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("test_type"))));
		testDate = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@id='test_date']")));
		file = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@id='file']")));
		uniqueId = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@id='unique_id']")));
		add = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[normalize-space()='Submit']")));

		//different file format
		patientName.sendKeys("Testing");
		Thread.sleep(5000);

		test_type.selectByValue("xRay");
		Thread.sleep(5000);

		testDate.sendKeys("03/15/2024");
		Thread.sleep(5000);

		// Specify the path to the file you want to upload
		String filePath = "E:\\ICBT - Bsc\\Semester 1\\Assignments\\CIS6003\\moodle.docx";
		// Send the file path to the file input field
		file.sendKeys(filePath);
		Thread.sleep(5000);

		uniqueId.sendKeys("REG-ABC20240321224547623005");
		Thread.sleep(5000);

		add.click();
		Thread.sleep(5000);

		// Wait for the page to refresh or navigate
		// Then, re-locate the elements
		patientName = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@id='patient_name']")));
		test_type = new Select(wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("test_type"))));
		testDate = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@id='test_date']")));
		file = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@id='file']")));
		uniqueId = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@id='unique_id']")));
		add = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[normalize-space()='Submit']")));
		
		//clear data
		patientName.clear();
		testDate.clear();
		file.clear();
		uniqueId.clear();

		//correct data
		patientName.sendKeys("Testing");
		Thread.sleep(5000);

		test_type.selectByValue("xRay");
		Thread.sleep(5000);

		testDate.sendKeys("03/15/2024");
		Thread.sleep(5000);

		// Specify the path to the file you want to upload
		String filePath1 = "E:\\ICBT - Bsc\\Semester 1\\Assignments\\CIS6003\\test_result.pdf";
		// Send the file path to the file input field
		file.sendKeys(filePath1);
		Thread.sleep(5000);

		uniqueId.sendKeys("REG-ABC20240321224547623005");
		Thread.sleep(5000);

		add.click();
	}

}
