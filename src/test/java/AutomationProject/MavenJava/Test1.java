package AutomationProject.MavenJava;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

import org.openqa.selenium.chrome.ChromeDriver;

public class Test1 {
	
	//To get a extent report
	
	ExtentReports extent;
	
	@BeforeTest
	
	public void config()
	{
		//Classes ExtentReports ExtentSparkReporter
		//create a path dynamically
		
		String path=System.getProperty("user.dir")+"\\reports\\index.html";
		
		ExtentSparkReporter report= new ExtentSparkReporter(path); // expects path 
		
		report.config().setReportName("Automation results");
		report.config().setDocumentTitle("TestResults");
		
		extent= new ExtentReports();
		
		extent.attachReporter(report); //attach the obj of ExtentSparkReporter class
		
		extent.setSystemInfo("Tester", "Mrunali");
	}
	
	@Test
	
	public void function1()
	
	{
		extent.createTest("function1");
		
		System.setProperty("webdriver.chrome.driver", "/Users/mrunaligaikwad/Downloads/chromedriver_old");
		WebDriver driver=new ChromeDriver();
		driver.get("https://www.google.com");
		System.out.println(driver.getTitle());
		
		extent.flush();
						
				
	}

}
