package patient;

import java.util.List;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

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
		//Thread.sleep(10000);

		int no_of_emails = emailText.size();
		
		if(no_of_emails < 1) {
			throw new Exception("No OTP received");
		
		} else {
			String regex = "[^\\d]+";
			String[] arrOTP = emailText.get(no_of_emails-1).split(regex);
			OTP = arrOTP[1];
			System.out.println("OTP is: "+OTP);
		}
		
		
		WebElement verifyOTP = chromeDriver.findElement(By.xpath("//input[@placeholder='OTP']"));
		verifyOTP.sendKeys(OTP);
		Thread.sleep(5000);
		
		WebElement verify = chromeDriver.findElement(By.xpath("//button[normalize-space()='Verify']"));
		verify.click();
		Thread.sleep(5000);
		
		WebElement password = chromeDriver.findElement(By.xpath("//input[@placeholder='Password']"));
		password.sendKeys("Raini@1234");
		Thread.sleep(5000);
		
		WebElement comfirm_password = chromeDriver.findElement(By.xpath("//input[@placeholder='Confirm Password']"));
		comfirm_password.sendKeys("Raini@1234");
		Thread.sleep(5000);
		
		WebElement change_password = chromeDriver.findElement(By.xpath("//button[normalize-space()='Change Password']"));
		change_password.click();
		Thread.sleep(5000);
	}

}
