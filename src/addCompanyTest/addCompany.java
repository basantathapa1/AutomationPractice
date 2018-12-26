package addCompanyTest;

import java.util.concurrent.TimeUnit;

//import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
//import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
//import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
public class addCompany {
	
	public static void main(String[] args) throws InterruptedException   {
		
		String company_name = "Company 3h";
		String company_location = "Chabahil";
		String url = "https://d2airr4tk971v6.cloudfront.net/";
		String Location = System.getProperty("user.dir");	
		
		System.setProperty("webdriver.gecko.driver", Location +"lib/geckodriver/geckodriver-v0.23.0-linux64.tar.gz");
		System.setProperty("webdriver.chrome.driver", "/usr/lib/chromium-browser/chromedriver");
		
		WebDriver driver = new ChromeDriver();
		driver.get(url);
		
		//login tests
		Thread.sleep(2000);
		driver.findElement(By.xpath("//*[@id=\"root\"]/div/div/div[1]/div/div/div[2]/div[1]/span/input")).sendKeys("recruitertester2@hiupapp.com");
		driver.findElement(By.xpath("//*[@id=\"root\"]/div/div/div[1]/div/div/div[2]/div[2]/span/input")).sendKeys("Test12345");
		driver.findElement(By.xpath("//*[@id=\"root\"]/div/div/div[1]/div/div/div[3]/button")).click();
	
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.findElement(By.xpath("//*[@id=\"company-nav-dropdown\"]")).click();
		
		driver.findElement(By.xpath("/html/body/div[1]/div/div/div/div[1]/div/nav/div/div[2]/ul[1]/li[1]/ul/li[3]/a")).click();
		
		//filling the form
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.findElement(By.id("formHorizontalEmail")).sendKeys(company_name);
		Thread.sleep(3000);
		driver.findElement(By.xpath("/html/body/div[2]/div/div[2]/div/div/div[2]/div[2]/div[1]/div/div[1]/form/div[2]/div/button")).click();

		Thread.sleep(4000);
		driver.findElement(By.cssSelector("button[class='btn btn-default']")).click();
				
		Thread.sleep(3000);
		driver.findElement(By.xpath("//*[@class=\"btn btn-default\"]")).click();
		Thread.sleep(3000);
		driver.findElement(By.xpath("//*[@placeholder=\"Address Name\"]")).sendKeys(company_location);

		Thread.sleep(3000);
		driver.findElement(By.xpath("//*[@class=\"btn btn-primary\"][@style =\"margin-left: 1.5em;\"]")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//*[@class=\"btn btn-primary\"][@style =\"margin-left: 1.5em;\"]")).click();
		
		Thread.sleep(7000);
		driver.findElement(By.xpath("//*[@class=\"btn btn-primary\"][@style =\"margin-left: 1.5em;\"] [text() = 'Close']")).click();
		System.out.println("Successful Added Company " + company_name + " !!!");
		//driver.quit();
	}
}
