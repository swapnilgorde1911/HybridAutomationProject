package TestCases;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

public class BaseClass {
    static public  WebDriver driver;
    public String baseUrl="https://demoqa.com/automation-practice-form";
    String username="";
    String password="";

    @BeforeClass
    public void setup(){
//        WebDriverManager.chromedriver().setup();
//        driver=new ChromeDriver();
//        driver.manage().window().maximize();
    }

    @AfterClass
    public void tearDown(){
//        driver.close();
    }
}
