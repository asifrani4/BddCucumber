package StepDefination;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.Date;
import java.util.NoSuchElementException;

import org.apache.commons.io.FileUtils;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.cucumber.java.AfterStep;
import io.cucumber.java.Scenario;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class Login {
	WebDriver driver=null;
	
	
	
	@Given("open login page")
	public void open_login_page() {
		String projectPath=System.getProperty("user.dir");
		System.setProperty("webdriver.firefox.driver", projectPath+"//src//test//resources//drivers//geckodriver.exe");
		driver=new FirefoxDriver();
		driver.get("https://accounts.saucelabs.com/am/XUI/#login/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(30));
	}

	@When("user enter valid username and password")
	public void user_enter_valid_username_and_password() throws InterruptedException {
		Wait<WebDriver> wait=new FluentWait<WebDriver>(driver)
				.withTimeout(Duration.ofSeconds(10))
				.pollingEvery(Duration.ofSeconds(2))
				.withMessage("searchiing elemeent")
				.ignoring(NoSuchElementException.class);
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//input[contains(@name,'callback_0')]"))).sendKeys("asif4224@gmail.com");
		
		//driver.findElement(By.xpath("//input[contains(@name,'callback_0')]")).sendKeys("asif42242gmail.com");
		
		
		WebDriverWait wait1=new WebDriverWait(driver, Duration.ofSeconds(10));
		wait1.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[starts-with(@name,'callback_1')]"))).sendKeys("9835691049");
		//driver.findElement(By.xpath("//input[starts-with(@name,'callback_1')]")).sendKeys("9835691049");
		
	}

	@And("click on login button")
	public void click_on_login_button() {
		driver.findElement(By.xpath("//input[contains(@value,'Log in')]")).click();
		//Assert.assertTrue(false);
	}

	@Then("user navigate to the HomePage")
	public void user_navigate_to_the_home_page() {
		driver.getTitle();
		System.out.println(driver.getCurrentUrl());
		driver.close();
	}
	@AfterStep
	public void addScreenshot(Scenario sc) {
		System.out.println("teardown method executed");
		
//		if(sc.isFailed()==true)
//		{
			Date currentDate=new Date();
			String screenfile=currentDate.toString().replace(" ", "-").replace(":", "-");
		 File srcfile=((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		 try {
			FileUtils.copyFile(srcfile, new File(".//screenshots//"+screenfile+".png"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		}
//	}


}
