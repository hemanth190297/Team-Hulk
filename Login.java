package demo;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
//import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class Login {

	WebDriver driver;

	@BeforeMethod()
	@Parameters({ "browser" })
	public void navigatingToTrello(@Optional("Chrome") String browser) {
		{
			if (browser.equals("Firefox")) {
				driver = new FirefoxDriver();
			} else {
				driver = new ChromeDriver();
			}
			driver.manage().window().maximize();
			driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
			driver.get("https://trello.com/");
		}
	}

	@BeforeSuite
	public void setDriver() {
		System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver");
		System.setProperty("webdriver.gecko.driver", "/home/qq381/Downloads/geckodriver");

	}

	@Test(priority = 0)
	public void Actions() throws Exception {
		driver.findElement(By.xpath("//a[.='Log in']")).click();
		driver.findElement(By.id("user")).sendKeys("kulkarnirs180397@gmail.com");
		driver.findElement(By.id("login")).click();
		Thread.sleep(5000);
		driver.findElement(By.xpath("//input[@id='password']")).sendKeys("2sd15Me072@");
		driver.findElement(By.xpath("//span[contains(text(),'Log in')]")).click();
		Thread.sleep(3000);
		// driver.navigate().refresh();

		driver.findElement(
				By.xpath("//button[@class='_2Hkk1T39xw4RMQ _3TTqkG5muwOzqZ ZOUktZwsING7-0']/p[text()='Create']"))
				.click();
		driver.findElement(By.xpath("//button[@class='_3Qtx4lodxp9J0E']/span[text()='Create board']")).click();
		driver.findElement(By.xpath("//input[@placeholder='Add board title']")).sendKeys("Goa Trip Preparation");
		driver.findElement(By.xpath("//button[@class='_1q9gQWvu0bw9ph _3TTqkG5muwOzqZ _3Ik0JLsERwh6Ui']")).click();

		driver.findElement(By.name("name")).sendKeys("TO-DO");
		driver.findElement(By.xpath("//input[@value='Add list']")).click();
		

		driver.findElement(By.name("name")).sendKeys("DOING");
		driver.findElement(By.xpath("//input[@value='Add list']")).click();


		driver.findElement(By.name("name")).sendKeys("DONE");
		driver.findElement(By.xpath("//input[@value='Add list']")).click();
		
		WebElement AddACard = driver.findElement(By.className("js-add-a-card"));
		AddACard.click();
		WebElement CardName1 = driver.findElement(By.xpath("//*[@class='list-card-composer-textarea js-card-title']"));
		CardName1.click();
		CardName1.sendKeys("Shopping");
		WebElement Card1 = driver
				.findElement(By.xpath("//*[@class='nch-button nch-button--primary confirm mod-compact js-add-card']"));
		Card1.click();
		System.out.println("Shopping card added");

		WebElement CardName2 = driver.findElement(By.xpath("//*[@placeholder='Enter a title for this card…']"));
		CardName2.click();
		CardName2.sendKeys("Booking Ticktes");
		WebElement AddCard2 = driver
				.findElement(By.xpath("//*[@class='nch-button nch-button--primary confirm mod-compact js-add-card']"));
		AddCard2.click();
		System.out.println("Booking tickets card added");

		WebElement CardName3 = driver.findElement(By.xpath("//*[@placeholder='Enter a title for this card…']"));
		CardName3.click();
		CardName3.sendKeys("Booking Hotels");
		WebElement AddCard3 = driver
				.findElement(By.xpath("//*[@class='nch-button nch-button--primary confirm mod-compact js-add-card']"));
		AddCard3.click();
		System.out.println("Booking Hotels card added");

		Actions builder = new Actions(driver);
		WebElement from = driver.findElement(By.xpath("//*[@class='list-card-title js-card-name']"));
		WebElement to = driver.findElement(By.xpath("(//*[@class='open-card-composer js-open-card-composer'])[1]"));
		builder.dragAndDrop(from, to).perform();
		

		Actions builder1 = new Actions(driver);
		WebElement from1 = driver.findElement(By.xpath("(//*[@class='list-card-title js-card-name'])[1]"));
		WebElement to1 = driver.findElement(By.xpath("(//*[@class='open-card-composer js-open-card-composer'])[1]"));
		builder1.dragAndDrop(from1, to1).perform();
	

		Actions builder2 = new Actions(driver);
		WebElement from2 = driver.findElement(By.xpath("(//*[@class='list-card-title js-card-name'])[1]"));
		WebElement to2 = driver.findElement(By.xpath("(//*[@class='open-card-composer js-open-card-composer'])[1]"));
		builder2.dragAndDrop(from2, to2).perform();
		

		Actions builder3 = new Actions(driver);
		WebElement from3 = driver.findElement(By.xpath("(//*[@class='list-card-title js-card-name'])[1]"));
		WebElement to3 = driver.findElement(By.xpath("(//*[@class='open-card-composer js-open-card-composer'])[2]"));
		builder3.dragAndDrop(from3, to3).perform();
	

		Actions builder4 = new Actions(driver);
		WebElement from4 = driver.findElement(By.xpath("(//*[@class='list-card-title js-card-name'])[1]"));
		WebElement to4 = driver.findElement(By.xpath("(//*[@class='open-card-composer js-open-card-composer'])[2]"));
		builder4.dragAndDrop(from4, to4).perform();


		Actions builder5 = new Actions(driver);
		WebElement from5 = driver.findElement(By.xpath("(//*[@class='list-card-title js-card-name'])[1]"));
		WebElement to5 = driver.findElement(By.xpath("(//*[@class='open-card-composer js-open-card-composer'])[2]"));
		builder5.dragAndDrop(from5, to5).perform();
		
	}
	@AfterTest
	public void closeBrowser() {
	 driver.close();
	driver.quit();
	}

}
