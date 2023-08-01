package TestCases;

import PageObjects.PracticeFormPage;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

public class TestCase1_PracticeForm extends BaseClass{
WebDriver driver;

    @Test
    public void fillPracticeForm()
    {
        WebDriverManager.chromedriver().setup();
        driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.get(baseUrl);
        String zoomJS;
        JavascriptExecutor js = (JavascriptExecutor) driver;
        zoomJS = "document.body.style.zoom='1.1'";
        js.executeScript(zoomJS);
    PracticeFormPage practiceFormPage=PageFactory.initElements(driver,PracticeFormPage.class);
    practiceFormPage.submitPracticeForm();
    }
}
