package OnlineShopingTest;

//import org.openqa.selenium.WebElement;
//import org.openqa.selenium.chrome.ChromeDriver;
//import org.testng.annotations.Test;
import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.ITestResult;



import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;
import org.openqa.selenium.OutputType;

public class OnlineShopingTest {
	WebDriver driver= null;
	ExtentReports extent=null;
	ExtentHtmlReporter htmlReporter=null;
	ExtentTest logger=null;
  @Test(priority=1)
  public void testRegistration() throws InterruptedException {
 System.setProperty("webdriver.chrome.driver", "C:\\Users\\A07208TRNG_B4A.04.27\\Desktop\\Browser Drivers\\chromedriver_win32\\chromedriver.exe");
	  
	  driver= new ChromeDriver();
	  driver.get("https://10.232.237.143:443/TestMeApp/fetchcat.htm");
	  driver.manage().window().maximize();
	  Thread.sleep(5000);
	  driver.findElement(By.xpath("//*[@id=\"details-button\"]")).click();
	  driver.findElement(By.xpath("//*[@id=\"proceed-link\"]")).click();
	  Thread.sleep(5000);
	  System.out.println("the page title is"+driver.getTitle());
	  driver.findElement(By.xpath("//*[contains(text(),'SignUp')]")).click();
	  driver.findElement(By.id("userName")).sendKeys("Krishna1234");
	  driver.findElement(By.id("firstName")).sendKeys("kabir");
	  driver.findElement(By.id("lastName")).sendKeys("Singh");
	  driver.findElement(By.id("password")).sendKeys("Krishna1997");
	  driver.findElement(By.id("pass_confirmation")).sendKeys("Krishna1997");
	  WebElement radio=driver.findElement(By.xpath("//*[@id=\"gender\"]"));
	  radio.click();
	  driver.findElement(By.id("emailAddress")).sendKeys("prabirsingh73@gmail.com");
	  driver.findElement(By.id("mobileNumber")).sendKeys("7684925272");
	  driver.findElement(By.xpath("//*[@id=\"dob\"]")).sendKeys("28/03/1997");
	  driver.findElement(By.id("address")).sendKeys("Bengaluru,Karnatak,560017");
	  Select question=new Select (driver.findElement(By.id("securityQuestion")));
	  Thread.sleep(5000);
	  question.selectByIndex(3);
	  driver.findElement(By.id("answer")).sendKeys("Krishna");
	  driver.findElement(By.xpath("/html/body/main/div/div/form/fieldset/div/div[13]/div/input[1]")).click();
	 
  }
  @Test(priority=2)
  public void testLogin() {
	  driver.findElement(By.xpath("//*[@id=\"userName\"]")).sendKeys("lalitha");
	  driver.findElement(By.xpath("//*[@id=\"password\"]")).sendKeys("password123");
	  driver.findElement(By.xpath("/html/body/main/div/div/div/form/fieldset/div[4]/div/input[1]")).click();
  }
  @Test(priority=3)
  public void testChart() throws InterruptedException {
	  Actions act1=new Actions(driver);
	  Thread.sleep(2000);
	  act1.moveToElement(driver.findElement(By.xpath("//*[@id=\"menu3\"]/li[2]/a/span"))).perform();
	  act1.moveToElement(driver.findElement(By.xpath("//*[@id=\"menu3\"]/li[2]/ul/li[1]/a/span"))).click().perform();
	  Thread.sleep(5000);
	  act1.moveToElement(driver.findElement(By.xpath("//*[@id=\"submenuul11290\"]/li[1]/a/span"))).click().perform();
	  driver.findElement(By.xpath("/html/body/section/div/div/div[2]/div/div/div/div[2]/center/a")).click();
	  
  }
  @Test(priority=4)
  public void testPayment() throws InterruptedException {
	  driver.findElement(By.xpath("//*[@id=\"header\"]/div[1]/div/div/div[2]/div/a[2]")).click();
	  driver.findElement(By.xpath("//*[@id=\"cart\"]/tfoot/tr[2]/td[5]/a"));
	  driver.findElement(By.xpath("//*[text()='Checkout ']")).click();
	  driver.findElement(By.xpath("/html/body/b/div/div/div[1]/div/div[2]/div[3]/div/form[2]/input")).click();
	  Thread.sleep(5000);
	  WebElement radio1=driver.findElement(By.xpath("//*[@id=\"swit\"]/div[8]/div/label/i"));
	  radio1.click();
	  driver.findElement(By.xpath("//*[@id=\"btn\"]")).click();
	  driver.findElement(By.xpath("//*[@id=\"horizontalTab\"]/div[2]/div/div/div/div/form/input[1]")).sendKeys("lalitha");
	  driver.findElement(By.xpath("//*[@id=\"horizontalTab\"]/div[2]/div/div/div/div/form/input[2]")).sendKeys("password123");
	  driver.findElement(By.xpath("//*[@id=\"horizontalTab\"]/div[2]/div/div/div/div/form/div/div[3]/input")).click();
	  
  }
  
  @AfterMethod
  public void getResultAfterMethod(ITestResult result) throws IOException {
	  if(result.getStatus()==ITestResult.FAILURE) {
		  logger.log(Status.FAIL, MarkupHelper.createLabel(result.getName() + "- Test Case failed",ExtentColor.RED));
		  TakesScreenshot snapshot=(TakesScreenshot)driver;
		  File src=snapshot.getScreenshotAs(OutputType.FILE);
		  String path="C:\\\\Users\\\\A07208trng_b4a.04.27\\\\Desktop\\Snapshot.png";
		  FileUtils.copyFile(src,new File(path));
		  logger.addScreenCaptureFromPath(path,result.getName());
		  logger.log(Status.FAIL, MarkupHelper.createLabel(result.getThrowable() +" -Test Case Fail", ExtentColor.RED));
	  }else if(result.getStatus() == ITestResult.SKIP)
	  {
		  logger.log(Status.SKIP, MarkupHelper.createLabel(result.getThrowable() +" -Test Case Fail", ExtentColor.ORANGE));
	  }
  }
  @BeforeTest
  public void startReportBeforeTest() {
	  htmlReporter = new ExtentHtmlReporter("C:\\Users\\A07208trng_b4a.04.27\\Desktop\\Report2.html");
	  extent =new ExtentReports();
	  logger = extent.createTest("start report");
	  extent.attachReporter(htmlReporter);
	  extent.setSystemInfo("Host Namre","GFT NextGen Testing Stream");
	  extent.setSystemInfo("Enviornment","Automation Testing. Selenium");
	  extent.setSystemInfo("User Name","lalitha");
	  htmlReporter.config().setDocumentTitle("Title of the report comes here");
	  htmlReporter.config().setReportName("Name Of the reports comes here");
	  htmlReporter.config().setTheme(Theme.STANDARD);
  }
 
 
@AfterTest
 public void endReportAfterTestMethod() {
	//ExtentReports Extent = new ExtentReports();
	logger=extent.createTest("end Report");
	extent.flush();
	driver.close();
 }

  
}
