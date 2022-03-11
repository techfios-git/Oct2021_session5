package variousConcepts;

import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class WindowHandle {
	WebDriver driver;

	@Before
	public void init() {
		System.setProperty("webdriver.chrome.driver", "driver\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().deleteAllCookies();
		driver.manage().window().maximize();
		driver.get("https://www.yahoo.com/");
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}

	@Test
	public void windowHandleTest() throws InterruptedException  {
		System.out.println(driver.getTitle());
		String handle1=driver.getWindowHandle();
		System.out.println(handle1);
		driver.findElement(By.xpath("//input[@id='ybar-sbq']")).sendKeys("xpath");
		driver.findElement(By.xpath("//input[@id='ybar-search']")).click();
		Thread.sleep(3000);
		
		driver.findElement(By.xpath("//*[@id=\"web\"]/ol/li[1]/div/div[1]/h3/a")).click();
		System.out.println(driver.getTitle());
		Set<String> handle2 =driver.getWindowHandles();
		System.out.println(handle2);
		
		for(String item :handle2) {
			System.out.println(item);
			driver.switchTo().window(item);
		}
		System.out.println(driver.getTitle());
		driver.findElement(By.xpath("//*[@id=\"topnav\"]/div/div[1]/a[3]")).click();
		driver.switchTo().window(handle1);
		
		
		
	}

}
