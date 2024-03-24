package patient;

import java.time.Duration;
import java.util.List;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.testing.framework.EmailUtils;

public class ForgotPassword {

	public static void main(String[] args) throws Exception {

		String OTP;

		System.setProperty("webdriver.chrome.driver", "E:\\ICBT - Bsc\\Automation\\Chrome Driver\\chromedriver-win64\\chromedriver.exe");

		ChromeOptions option = new ChromeOptions();
		option.addArguments("--remote-allow-origins=*");

		WebDriver chromeDriver = new ChromeDriver(option);
		chromeDriver.manage().window().maximize();

		String baseURL = "http://localhost:9090/patientLogin";
		chromeDriver.get(baseURL);
		Thread.sleep(5000);

		WebDriverWait wait = new WebDriverWait(chromeDriver, Duration.ofSeconds(2000)); 

		WebElement forgot_password = chromeDriver.findElement(By.xpath("//a[contains(text(),'Forgot')]"));
		forgot_password.click();
		Thread.sleep(5000);

		WebElement email = chromeDriver.findElement(By.xpath("//input[@id='email']"));
		email.sendKeys("sashee.wijewantha@gmail.com");
		Thread.sleep(5000);

		WebElement submit = chromeDriver.findElement(By.xpath("//button[normalize-space()='Submit']"));
		submit.click();
		Thread.sleep(5000);

		EmailUtils emailUtils = new EmailUtils();

		Properties prop = new Properties();

		prop.setProperty("to", "sashee.wijewantha@gmail.com");
		prop.setProperty("gmail_from", "abc.laboratory.services@gmail.com");
		prop.setProperty("gmail_username", "sashee.wijewantha@gmail.com");
		prop.setProperty("gmail_password", "zvww mduc ybrc qpfo");
		prop.setProperty("gmail_port", "587");

		@SuppressWarnings("unchecked")
		List<String> emailText = emailUtils.getUnreadMessageByFromEmail(emailUtils.connectToGmail(prop), "Inbox", "abc.laboratory.services@gmail.com", "Password Reset OTP");

		//int no_of_emails = emailText.size();

		//Incorrect OTP code
		/*
		if(no_of_emails < 1) {
			throw new Exception("No OTP received");

		} else {
			String regex = "[^\\d]+";
			String[] arrOTP = emailText.get(no_of_emails-2).split(regex);
			OTP = arrOTP[1];
			System.out.println("OTP is: "+OTP);
		}

		WebElement verifyOTP = chromeDriver.findElement(By.xpath("//input[@placeholder='OTP']"));
		verifyOTP.sendKeys(OTP);
		Thread.sleep(5000);

		WebElement verify = chromeDriver.findElement(By.xpath("//button[normalize-space()='Verify']"));
		verify.click();
		Thread.sleep(5000);

		// Wait for the page to refresh or navigate
		// Then, re-locate the elements
		verifyOTP = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@id='full_name']")));
		verify = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@id='email']")));
		 */
		//Correct OTP code
		//EmailUtils emailUtiles = new EmailUtils();

		//Properties properties = new Properties();

		//		properties.setProperty("to", "sashee.wijewantha@gmail.com");
		//		properties.setProperty("gmail_from", "abc.laboratory.services@gmail.com");
		//		properties.setProperty("gmail_username", "sashee.wijewantha@gmail.com");
		//		properties.setProperty("gmail_password", "zvww mduc ybrc qpfo");
		//		properties.setProperty("gmail_port", "587");

		//@SuppressWarnings("unchecked")
		//List<String> email_Text = emailUtiles.getUnreadMessageByFromEmail(emailUtiles.connectToGmail(prop), "Inbox", "abc.laboratory.services@gmail.com", "Password Reset OTP");

		int noOf_emails = emailText.size();

		if(noOf_emails < 1) {
			throw new Exception("No OTP received");

		} else {
			String regex = "[^\\d]+";
			String[] arrOTP = emailText.get(noOf_emails-1).split(regex);
			OTP = arrOTP[1];
			System.out.println("OTP is: "+OTP);
		}

		WebElement verifyOTP = chromeDriver.findElement(By.xpath("//input[@placeholder='OTP']"));
		verifyOTP.sendKeys(OTP);
		Thread.sleep(5000);

		WebElement verify = chromeDriver.findElement(By.xpath("//button[normalize-space()='Verify']"));
		verify.click();
		Thread.sleep(5000);

		//incorrect password
		WebElement password = chromeDriver.findElement(By.xpath("//input[@placeholder='Password']"));
		password.sendKeys("Raini@123");
		Thread.sleep(5000);

		WebElement comfirm_password = chromeDriver.findElement(By.xpath("//input[@placeholder='Confirm Password']"));
		comfirm_password.sendKeys("Raini@1234");
		Thread.sleep(5000);
		
		WebElement change_password = chromeDriver.findElement(By.xpath("//button[normalize-space()='Change Password']"));
		change_password.click();
		Thread.sleep(5000);

		// Wait for the page to refresh or navigate
		// Then, re-locate the elements
		password = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@placeholder='Password']")));
		comfirm_password = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@placeholder='Confirm Password']")));
		change_password = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[normalize-space()='Change Password']")));
		
		//correct passwords
		password.sendKeys("Raini@1234");
		Thread.sleep(5000);

		comfirm_password.sendKeys("Raini@1234");
		Thread.sleep(5000);
		change_password.click();
		
	}

}
