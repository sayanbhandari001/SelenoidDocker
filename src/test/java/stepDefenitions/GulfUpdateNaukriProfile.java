package stepDefenitions;

import java.time.Duration;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.utility.BrowserUtility;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class GulfUpdateNaukriProfile {

	WebDriver driver;

	@Given("^I have logged in setup and logged in to gulfNaukri website$")
	public void i_have_logged_in_setup_and_logged_in_to_gulf_naukri_website() {
		driver = BrowserUtility.supplyDriver("chrome");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5000));

		// Opening Browser
		driver.get("https://www.naukrigulf.com/");

		// click on login Button
		driver.findElement(By.xpath("//a[contains(@href,'.naukrigulf.com/jobseeker/login')]")).click();

	}

	@Given("have my gulfprofile section open with {string} login and {string}")
	public void have_my_gulfprofile_section_open_with_login_and(String username, String password) throws Throwable {

		// Type into on username Button
		WebElement jobSeekerLogin = driver.findElement(By.xpath("//input[@id='loginModalLoginEmail']"));
		jobSeekerLogin.clear();
		jobSeekerLogin.sendKeys(username);

		// Type into on Password Button
		WebElement jobSeekerPassword = driver.findElement(By.xpath("//input[@id='loginPassword']"));
		jobSeekerPassword.clear();
		jobSeekerPassword.sendKeys(password);

		// click on Innerlogin Button
		driver.findElement(By.xpath("//button[@id='loginModalLoginSubmit']")).click();

		// Validate Title of page
		String ActualTitle = driver.getTitle();
		String ExpectedTitle = "Jobs in Gulf - Jobs in Middle East - Job Search - Job Vacancies - Naukrigulf.com";
		Assert.assertEquals(ActualTitle, ExpectedTitle);
		if (ActualTitle.equals(ExpectedTitle)) {
			System.out.println("--------------System logged in successfully, Automating further--------------");
		} else {
			System.out.println("Opps!!! ----   Sorry Couldn't login   --- Failure");
		}

		// Redirecting to profile page page
		driver.get("https://www.naukrigulf.com/mnj/userProfile/myCV?source=gnbHeader");

		// click cv headline
		WebElement cvheadlineEditButton = driver.findElement(By
				.xpath("//section[@id='cvHeadline']//button[@class='ng-link edit-cta fr'][normalize-space()='Edit']"));
		cvheadlineEditButton.click();
		Thread.sleep(5000);
	}

	@When("^I check for gulfprofile section and validate whether updated$")
	public void i_check_for_gulfprofile_section_and_validate_whether_updated() {

		// validate text
		String cvHeadline = "6 Years Exp. with Manual and Automation with Selenium- Java, API testing & DB";
		String receivedHeadline = driver.findElement(By.xpath("//textarea[@id='cvHeadline']")).getText();
		System.out.println(receivedHeadline);

		// WebElement of TextBox of cv update
		WebElement updateHeadline = driver.findElement(By.xpath("//textarea[@id='cvHeadline']"));

		if (cvHeadline.equals(receivedHeadline)) {
			updateHeadline.click();
			updateHeadline.clear();
			updateHeadline.sendKeys("6 Years Exp. with Manual and Automation with Selenium- Java, API testing & DB.");
		}  
		else if (!cvHeadline.equals(receivedHeadline)) 
				{
			updateHeadline.click();
			updateHeadline.clear();
			updateHeadline.sendKeys("6 Years Exp. with Manual and Automation with Selenium- Java, API testing & DB");
		}
		else 
		{
			throw new RuntimeException("Test Entering Failed//Validation failed");
		}

	}

	@Then("^I update gulfbio with new data$")
	public void i_update_gulfbio_with_new_data() {
		driver.findElement(By.xpath("//button[normalize-space()='Save']")).click();
		WebElement toastmessage = driver.findElement(By.xpath("//span[@class='Toaster__manager-top-right']"));
		toastmessage.getText();
		Assert.assertNotNull(toastmessage);
		WebElement toastPanelReceivedMessage = driver.findElement(By.xpath(
				"//div[@class='Toaster__message-wrapper']//h4[@class='title no-message'][normalize-space()='Profile updated successfully']"));
		String toastPanelReceivedMessageValidation = toastPanelReceivedMessage.getText();
		System.out.println();

		String toastPanelExpectedMessage = "Profile updated successfully";

		Assert.assertEquals(toastPanelReceivedMessageValidation, toastPanelExpectedMessage);

		if (toastPanelReceivedMessageValidation.equals(toastPanelExpectedMessage)) {
			System.out.println("-----------------Save Successfull------------------------");

		} else {
			System.out.println("-----------------Save unSuccessfull------------------------");
		}

	}

	@Then("^check whether my gulfprofile is updated as of today$")
	public void check_whether_my_gulfprofile_is_updated_as_of_today() {
		System.out.println("''''''''''''''''''''''''No more action Pending '''''''''''''''''' \n"
				+ "\n Quiting the System Automation" + "\n Thanks and goodbye");
		driver.quit();
	}

}
