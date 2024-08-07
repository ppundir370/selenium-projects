package demo;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeDriverService;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.logging.LogType;
import org.openqa.selenium.logging.LoggingPreferences;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.time.Instant;
import java.time.LocalDate;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
// import io.github.bonigarcia.wdm.WebDriverManager;
import demo.wrappers.Wrappers;

public class TestCases {
    ChromeDriver driver;

    /*
     * TODO: Write your tests here with testng @Test annotation. 
     * Follow `testCase01` `testCase02`... format or what is provided in instructions
     */
    @Test(alwaysRun = true)
    public void testCase01() throws Exception
    {
        driver.get("https://forms.gle/wjPkzeSEk1CM7KgGA");
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        wait.until(ExpectedConditions.urlToBe("https://docs.google.com/forms/d/e/1FAIpQLSep9LTMntH5YqIXa5nkiPKSs283kdwitBBhXWyZdAS-e4CxBQ/viewform"));
        WebElement n = driver.findElement(By.xpath("(//input[@type='text'])[1]"));
        Actions action = new Actions(driver);
        action.moveToElement(n);
        
        action.build().perform();
        Wrappers.getName(n,"Crio Learner");
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//textarea[@aria-label='Your answer']")));
        WebElement practiceAutomation = driver.findElement(By.xpath("//textarea[@aria-label='Your answer']"));
        action.moveToElement(practiceAutomation);
        action.build().perform();
        
        String str = "Aug 08 2024";
        SimpleDateFormat df = new SimpleDateFormat("MMM dd yyyy");
        Date date = df.parse(str);
        long epoch = date.getTime();
        Wrappers.practice(practiceAutomation, "I want to be the best QA Engineer!" + epoch );
        Thread.sleep(2000);
        
        List<WebElement> radioButtons = driver.findElements(By.xpath("//div[@class='nWQGrd zwllIb']"));
        for(WebElement radioButton : radioButtons)
        {
            if(radioButton.getText().equalsIgnoreCase("6 - 10"))
            {
                Wrappers.automationExp(radioButton);
            }
            
        }
        Thread.sleep(2000);
        List<WebElement> learnings = driver.findElements(By.xpath("//div[@class='eBFwI']"));
        for(WebElement learning : learnings)
        {
            if(learning.getText().contains("Java"))
            {
                Wrappers.toolToLearn(learning);
            }
            
            Thread.sleep(2000);
            if(learning.getText().contains("Selenium"))
            {
                Wrappers.toolToLearn(learning);
                
            }
            
            Thread.sleep(2000);
            if(learning.getText().contains("TestNG"))
            {
                Wrappers.toolToLearn(learning);
            }
           
        }
        Thread.sleep(2000);
        WebElement addressedElement = driver.findElement(By.xpath("//div[@role='option']/parent::div[@role='presentation']"));
        action.moveToElement(addressedElement);
        action.build().perform();
        Wrappers.addressed(addressedElement);
        Thread.sleep(2000);
        List<WebElement> msElements = driver.findElements(By.xpath("//span[@class='vRMGwf oJeWuf']"));
        for (WebElement msElement : msElements)
        {
            if(msElement.getText().contains("Ms"))
            {
                Wrappers.ms(msElement);  
            }
           
        }
        Thread.sleep(2000);
        
        LocalDate ld = LocalDate.now();
        ld.toString();
        
        String date1 = "07-08-2024";

        SimpleDateFormat currentdate = new SimpleDateFormat("dd-MM-yyyy");


        Calendar calendar = Calendar.getInstance();

        calendar.setTime(currentdate.parse(date1));

        calendar.add(calendar.DAY_OF_MONTH, -7);
        String  newDate = currentdate.format(calendar.getTime());
        System.out.println(newDate);
       
        WebElement dateElement = driver.findElement(By.xpath("//input[@type='date']"));
        action.moveToElement(dateElement);
        Wrappers.date(dateElement, newDate); 
        action.build().perform();
        Thread.sleep(2000);

        WebElement hour = driver.findElement(By.xpath("//input[@aria-label='Hour']"));
        Thread.sleep(2000);
        WebElement minute = driver.findElement(By.xpath("//input[@aria-label='Minute']"));
        Thread.sleep(2000);
        String currTime = Wrappers.time();
        String[] currentTimeInHHmm =  currTime.split(":");
        String HH = currentTimeInHHmm[0];
        System.out.println(HH);
        String mm = currentTimeInHHmm[1];
        System.out.println(mm);
        Wrappers.date(hour, HH);
        Thread.sleep(2000);
        Wrappers.date(minute, mm);

        WebElement submit = driver.findElement(By.xpath("//span[text()='Submit']"));
        Wrappers.ms(submit);
        Thread.sleep(2000);
        WebElement successElement = driver.findElement(By.xpath("//div[text()='Thanks for your response, Automation Wizard!']"));
        System.out.println(successElement.getText());

       



    }

     
    /*
     * Do not change the provided methods unless necessary, they will help in automation and assessment
     */
    //@SuppressWarnings("deprecation")
    @BeforeTest(alwaysRun = true)
    public void startBrowser()
    {
        System.setProperty("java.util.logging.config.file", "logging.properties");

        // NOT NEEDED FOR SELENIUM MANAGER
        // WebDriverManager.chromedriver().timeout(30).setup();

        ChromeOptions options = new ChromeOptions();
        //options.setBrowserVersion("125");
        LoggingPreferences logs = new LoggingPreferences();

        logs.enable(LogType.BROWSER, Level.ALL);
        logs.enable(LogType.DRIVER, Level.ALL);
        options.setCapability("goog:loggingPrefs", logs);
        options.addArguments("--remote-allow-origins=*");
       // options.setExperimentalOption("debuggerAddress", "127.0.0.1:9222");

        System.setProperty(ChromeDriverService.CHROME_DRIVER_LOG_PROPERTY, "build/chromedriver.log"); 

        driver = new ChromeDriver(options);

        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
    }

    @AfterTest
    public void endTest()
    {
        driver.close();
        driver.quit();

    }
}