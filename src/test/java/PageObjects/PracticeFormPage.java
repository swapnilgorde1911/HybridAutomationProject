package PageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class PracticeFormPage {
    WebDriver driver;
public PracticeFormPage(WebDriver driver){
    this.driver=driver;
}

    @FindBy(xpath="//div[text()='Forms']") WebElement expandForm;
    @FindBy(xpath="//div[text()='Practice Form']") WebElement practiceForm;
    @FindBy(xpath="//input[@id='firstName']") WebElement firstName;
    @FindBy(xpath="//input[@id='lastName']") WebElement lastName;
    @FindBy(xpath="//input[@id='userEmail']") WebElement email;
    @FindBy(xpath="//input[@id='gender-radio-1']//following-sibling::label") WebElement genderMale;
    @FindBy(xpath="//input[@id='userNumber']") WebElement mobileNumber;
    @FindBy(xpath="//input[@id='dateOfBirthInput']") WebElement dateofbirth;
    @FindBy(xpath="//div[@id='subjectsWrapper']") WebElement subjects;
    @FindBy(xpath="//input[@id='hobbies-checkbox-1']//following-sibling::label") WebElement hobbiesSport;
    @FindBy(xpath="//input[@id='hobbies-checkbox-2']//following-sibling::label") WebElement hobbiesReading;
    @FindBy(xpath="//input[@id='hobbies-checkbox-3']//following-sibling::label") WebElement hobbiesMusic;
    @FindBy(xpath="//input[@id='currentAddress']") WebElement currentAddress;
    @FindBy(xpath="//div[@id='stateCity-wrapper']//child::div[2]") WebElement state;
    @FindBy(xpath="//div[@id='stateCity-wrapper']//child::div[3]") WebElement city;
    @FindBy(xpath="//button[@id='submit']") WebElement submit;


    public void submitPracticeForm(){
        firstName.sendKeys("ABCD");
        lastName.sendKeys("XYZ");
        email.sendKeys("abc@xyz.com");
//        genderMale.click();
        mobileNumber.sendKeys("1122334455");

//        dateofbirth.sendKeys("01 Jan 2001");
//        subjects.sendKeys("Testing");
//        state.sendKeys("NCR");
//        city.sendKeys("Delhi");

//        hobbiesSport.click();
//        hobbiesMusic.click();
//        currentAddress.sendKeys("India India");
        submit.click();
    }
}
