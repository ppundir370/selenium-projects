package demo.wrappers;

import java.time.Instant;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;

public class Wrappers {
    /*
     * Write your selenium wrappers here
     * 
     */
    public static void getName(WebElement n, String name)
    {
        n.click();
        n.clear();
        n.sendKeys(name);
       
    }

    public static boolean practice(WebElement s , String p)
    {
     
        s.click();
        s.clear();
        s.sendKeys(p);
        return true;

    }
    public static boolean automationExp(WebElement s)
    {
        
        s.click();
        return true;
    }
    public static boolean toolToLearn(WebElement e)
    {
        e.click();
        return true;
    }
    public static boolean addressed(WebElement e)
    {
        e.click();
        return true;

    }
    public static boolean ms(WebElement e)
    {
        e.click();
        return true;
    }
    public static void date(WebElement date, String targetDate)
    {
        date.sendKeys(targetDate);;
        
    }

    public static String time()
    {
        LocalDateTime dateTime = LocalDateTime.now();

        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("HH:mm");

        String currentTime = dateTime.format(dtf);

        return currentTime;
    }

}
