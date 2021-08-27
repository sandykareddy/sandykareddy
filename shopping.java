package homedepot;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

public class shopping {

	public static void main(String[] args) {

		System.setProperty("webdriver.chrome.driver",
				"C:\\Users\\kvish\\Downloads\\chromedriver_win32\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("http://automationpractice.com");
		driver.manage().window().maximize();
		Actions actions = new Actions(driver);
		// Menu options
		WebElement menuOption = driver.findElement(By.className("sf-with-ul"));
		actions.moveToElement(menuOption).perform();

		// summer dresses
		driver.findElement(By.xpath("//a[@title='Summer Dresses']")).click();

		// performing quick view
		WebElement printedSummerDresses = driver.findElement(By.className("product-container"));
		actions.moveToElement(printedSummerDresses).perform();
		driver.findElement(By.className("quick-view")).click();

		// implicit wait
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

		// frame operating
		driver.switchTo().frame(driver.findElement(By.className("fancybox-iframe")));
		Select size = new Select(driver.findElement(By.id("group_1")));
		size.selectByVisibleText("S");
		driver.findElement(By.name("Submit")).click();

		// switch to default driver
		driver.switchTo().defaultContent();

		// continue shopping
		driver.findElement(By.xpath("//i[@class='icon-chevron-left left']")).click();

		// view cart
		WebElement cart = driver.findElement(By.xpath("//a[@title='View my shopping cart']"));

		// profile details
		actions.moveToElement(cart).perform();
		driver.findElement(By.xpath("//i[@class='icon-chevron-right right']")).click();
		driver.findElement(By.xpath("//*[@id=\"center_column\"]/p[2]/a[1]/span")).click();
		driver.findElement(By.xpath("//input[@id='email_create']")).sendKeys("sandeepreddy@gmail.com");
		driver.findElement(By.xpath("//button[@id='SubmitCreate']")).click();
		driver.findElement(By.xpath("//input[@name='id_gender']")).click();
		driver.findElement(By.xpath("//input[@name='customer_firstname']")).sendKeys("Sandeep");
		driver.findElement(By.xpath("//input[@name='customer_lastname']")).sendKeys("Reddy");
		driver.findElement(By.xpath("//input[@name='passwd']")).sendKeys("Sandeep@7");
		driver.findElement(By.xpath("//input[@name='address1']")).sendKeys("kennedy rd");
		driver.findElement(By.xpath("//input[@name='city']")).sendKeys("toronto");

		// state selection
		Select state = new Select(driver.findElement(By.xpath("//select[@name='id_state']")));
		state.selectByVisibleText("Alaska");

		driver.findElement(By.xpath("//input[@name='postcode']")).sendKeys("00000");

		// select country
		Select country = new Select(driver.findElement(By.xpath("//select[@name='id_country']")));
		country.selectByVisibleText("United States");

		driver.findElement(By.xpath("//input[@name='phone_mobile']")).sendKeys("098765432");
		driver.findElement(By.xpath("//input[@name='alias']")).sendKeys("scarborough");
		driver.findElement(By.xpath("//button[@name='submitAccount']")).click();
		driver.findElement(By.xpath("//button[@name='processAddress']")).click();

		// agree terms
		driver.findElement(By.xpath("//input[@name='cgv']")).click();
		driver.findElement(By.xpath("//button[@name='processCarrier']")).click();

	}

}
