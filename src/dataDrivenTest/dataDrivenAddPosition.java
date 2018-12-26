package dataDrivenTest;

//import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import org.testng.asserts.Assertion;

import lib.ExcelDataConfig;

public class dataDrivenAddPosition {
	
	String url = "https://d2airr4tk971v6.cloudfront.net/";
	String Location = System.getProperty("user.dir");
	static int count = 0;
	
	WebDriver driver;
	
	@BeforeClass
		public void startBrowser() {
			System.out.println(Location);
			//System.setProperty("webdriver.gecko.driver", Location +"lib/geckodriver/geckodriver-v0.23.0-linux64.tar.gz");
			System.setProperty("webdriver.chrome.driver", "/usr/lib/chromium-browser/chromedriver");
			driver = new ChromeDriver();

			System.out.println("Browser Started");
		}

@Test(description="This is the navigating to the url", priority=1)
public void startApp() {
	System.out.println("Into the startApp() function.....");
	driver.get(url);
	String currentURL = driver.getCurrentUrl();
	Assert.assertTrue(currentURL.contains("/login"));
	System.out.println("URL opened successfully!!!!");
}

@Test(description="This is the test case for login", dataProvider = "loginCredentials", priority=2)
public void loginApp(String username, String password) throws InterruptedException, IOException {
	System.out.println("Into the LoginApp() function.....");
//	WebDriverWait wait = new WebDriverWait(driver,30);
//	wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"root\"]/div/div/div[1]/div/div/div[2]/div[1]/span[1]/input")));
	driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	WebElement uName = driver.findElement(By.xpath("//*[@placeholder='Enter email here']"));
	WebElement pWord = driver.findElement(By.xpath("//*[@placeholder='Enter password here']"));
	uName.clear();
	pWord.clear();
	uName.sendKeys(username);
	pWord.sendKeys(password);
	driver.findElement(By.xpath("//*[@id=\"root\"]/div/div/div[1]/div/div/div[3]/button")).click();
	Thread.sleep(5000);
	
//	String currentURL = driver.getCurrentUrl();
	try {
		System.out.println(">>>>Inside the try block<<<<<");
		Assert.assertTrue(driver.findElement(By.className("navbar-brand")).isDisplayed(), "Successful");
		
		System.out.println("I'm below Assert and I'm executed... My count is " + count);
		
		ExcelDataConfig.sheet1.getRow(count).createCell(2).setCellValue("Pass");
		FileOutputStream fout = new FileOutputStream(Location+"/TestData/inputData.xlsx");
		ExcelDataConfig.wb.write(fout);
		
		//sign out
		driver.findElement(By.xpath("//*[@id=\"root\"]/div/div/div[1]/div/nav/div/div[2]/ul[2]/li[2]/a")).click();
		count++;
	}
	catch(Exception e){
		System.out.println("<<<<Inside the catch block>>>>");
		ExcelDataConfig.sheet1.getRow(count).createCell(2).setCellValue("FAIL!!");
		FileOutputStream fout = new FileOutputStream(Location+"/TestData/inputData.xlsx");
		ExcelDataConfig.wb.write(fout);
		count++;
		Assert.fail();
	}
	System.out.println("Username and password correct. Logged in successfully!!");
}

@DataProvider(name = "loginCredentials")
public Object[][] passData() throws InterruptedException{
	ExcelDataConfig config = new ExcelDataConfig(Location+"/TestData/inputData.xlsx");
	System.out.println("Into the Object[][] passData() function.....");
	int rows = config.getRowCount(0); // (sheetIndex)
	int columns = ExcelDataConfig.getColumnCount(0);
	Thread.sleep(5000);
	Object[][] data = new Object[rows][columns];
	
	for(int i=0; i < rows; i++) {
		data[i][0] = config.getData(0, i, 0);
		data[i][1] = config.getData(0, i, 1);
	}
	System.out.println("DATA is : " +data);
	return data;

}

@AfterClass
public void tearDown() {
	driver.quit();
}

}




