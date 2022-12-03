import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class PresenterBot {

    public static void present() {

        System.setProperty("webdriver.chrome.driver", "./PresenterBot/selenium/drivers/chromedriver/chromedriver.exe");
        ChromeOptions option = new ChromeOptions();
        option.addArguments("--disable-blink-features=AutomationControlled");
        option.addArguments("--disable-notifications");
        option.setExperimentalOption("excludeSwitches", new String[]{"enable-automation"});
        WebDriver chromeDriver = new ChromeDriver(option);

        chromeDriver.manage().window().maximize();
        chromeDriver.get("https://docs.google.com/presentation/d/1EZjJAcH88PcAIs76V-IQHz97v5Z0JzTJkwWWZP5i3JY/edit?usp=sharing");
        WebElement slideContainer = new WebDriverWait(chromeDriver, Duration.ofSeconds(10))
                .until(ExpectedConditions.elementToBeClickable(By.className("punch-filmstrip-thumbnail-pagenumber")));

        int numberOfSlides = chromeDriver.findElements(By.className("punch-filmstrip-thumbnail-pagenumber")).size();

        WebElement element = new WebDriverWait(chromeDriver, Duration.ofSeconds(10))
                .until(ExpectedConditions.elementToBeClickable(By.tagName("html")));

        String maximizePresentation = Keys.chord(Keys.CONTROL, Keys.F5);
        chromeDriver.findElement(By.tagName("html")).sendKeys(maximizePresentation);

        GoThroughPages(numberOfSlides, element);

        chromeDriver.close();
    }
    private static void GoThroughPages(int numberOfSlides, WebElement element) {
        for (int i = 0; i < numberOfSlides; i++) {
            try {
                Thread.sleep(5000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            element.click();
        }
    }

}
