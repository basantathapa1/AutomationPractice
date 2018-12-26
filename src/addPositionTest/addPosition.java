package addPositionTest;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.chrome.ChromeDriver;

public class addPosition {
	public static void main(String[] args) throws InterruptedException {
		String url = "https://d2airr4tk971v6.cloudfront.net/";
		String Location = System.getProperty("user.dir");
		
		String username = "recruitertester2@hiupapp.com";
		String password = "Test12345";
		String company = "Company 3b";
		
		System.setProperty("webdriver.gecko.driver", Location +"lib/geckodriver/geckodriver-v0.23.0-linux64.tar.gz");
		System.setProperty("webdriver.chrome.driver", "/usr/lib/chromium-browser/chromedriver");
		
		WebDriver driver = new ChromeDriver();
		driver.get(url);
		
		//login tests
		Thread.sleep(2000);
		driver.findElement(By.xpath("//*[@id=\"root\"]/div/div/div[1]/div/div/div[2]/div[1]/span/input")).sendKeys(username);
		driver.findElement(By.xpath("//*[@id=\"root\"]/div/div/div[1]/div/div/div[2]/div[2]/span/input")).sendKeys(password);
		driver.findElement(By.xpath("//*[@id=\"root\"]/div/div/div[1]/div/div/div[3]/button")).click();
		
		Thread.sleep(4000);
		driver.findElement(By.xpath("//*[@id=\"position-nav-dropdown\"]")).click();
		driver.findElement(By.xpath("//*[@id=\"root\"]/div/div/div[1]/div/nav/div/div[2]/ul[1]/li[3]/ul/li[5]/a/a")).click();
		
		//filling the form
		WebElement recruitingCompany = driver.findElement(By.id("formHorizontalRecruiterCompanyId"));
		WebElement targetCompany = driver.findElement(By.id("formHorizontalRecruitingCompanyId"));
		
		Thread.sleep(4000);
		//creating a Select Object - recruiting Company
		Select select_recruitingCompany = new Select(recruitingCompany);
		select_recruitingCompany.selectByVisibleText(company);
		
		Thread.sleep(3000);
		// creating a Select Object - target Company
		Select select_targetCompany = new Select(targetCompany);
		select_targetCompany.selectByVisibleText(company);
		
		driver.findElement(By.xpath("//*[@id=\"formHorizontalNoPositions\"]")).sendKeys("4");
		Thread.sleep(4000);
		//start date
		driver.findElement(By.id("formHorizontalStartDate")).click(); Thread.sleep(2000);
		WebElement startDate = driver.findElement(By.className("text-primary"));
		startDate.click();	
		int start_date = Integer.parseInt(startDate.getText());
		System.out.println(startDate.getText() + " : Start Date");
		
		
		//closing date
		driver.findElement(By.id("formHorizontalClosingDate")).click(); Thread.sleep(2000);
		driver.findElement(By.className("pull-right")).click();
		Thread.sleep(3000);
		WebElement closeDate = driver.findElement(By.xpath("//td[text()='"+start_date+"']"));
		closeDate.click();
		System.out.println(closeDate.getText() + " : Close Date");
		
		//How long is it for?
		Thread.sleep(2000);
		driver.findElement(By.id("formHorizontalDuration")).sendKeys("24 months");
		
		//Where will they be working?
		Thread.sleep(2000);
		WebElement workingLocation =  driver.findElement(By.id("formHorizontalWorkingLocation"));
		Select select_workingLocation = new Select(workingLocation);
		select_workingLocation.selectByVisibleText("Chabahil");
		
		//How much will they be paid per hour?
		driver.findElement(By.id("formHorizontalHourlyPay")).sendKeys("25");
		
		//Where might they be interviewed?
		Thread.sleep(2000);
		WebElement interviewLocation = driver.findElement(By.id("formHorizontalInterview"));
		Select select_interviewLocation = new Select(interviewLocation);
		select_interviewLocation.selectByVisibleText("Chabahil");
		
		//What kind of role?
		Thread.sleep(1000);
		driver.findElement(By.xpath("//*[@placeholder='Search for a role...']")).sendKeys("nurse");
		Thread.sleep(5000);
		driver.findElement(By.xpath("//*[@id=\"root\"]/div/div/div[1]/section/div/div[2]/div[2]/div[2]/div/div/ul/li/a/div/span")).click();
		
		//Region job is visible to
		Thread.sleep(2000);
		driver.findElement(By.xpath("//*[@id=\"root\"]/div/div/div[1]/section/div/div[2]/div[2]/div[4]/div/div/div")).click();
		driver.findElement(By.xpath("//*[@id=\"root\"]/div/div/div[1]/section/div/div[2]/div[2]/div[4]/div/div/ul/li[1]/a/span")).click();	
		
		//What other documentation or certification is applicable?
		Thread.sleep(2000);
		driver.findElement(By.xpath("//*[@id=\"root\"]/div/div/div[1]/section/div/div[2]/div[2]/div[9]/div/div/div/div/input")).sendKeys("2018");
		Thread.sleep(5000);
		driver.findElement(By.xpath("//*[@id=\"root\"]/div/div/div[1]/section/div/div[2]/div[2]/div[9]/div/div/ul/li[1]/a/div/span[1]")).click();
		
		//Description
		Thread.sleep(2000);
		WebElement description = driver.findElement(By.id("formHorizontalDescription"));
		description.sendKeys("This is the description of the position Added.\nFeel free to contact in case of any queries.");
		
		//Save position
		Thread.sleep(1000);
		driver.findElement(By.xpath("//*[@class='btn btn-primary'][text()='Save Position']")).sendKeys(Keys.RETURN);
		System.out.println("Successful..!!!");
		
		
	}
}













