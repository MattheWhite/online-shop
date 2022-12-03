import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.WebDriver;
import java.time.Duration;
import java.util.concurrent.TimeUnit;

public class PageTesterBot {

    public static void testPage() throws InterruptedException {

        System.setProperty("webdriver.chrome.driver", "./PresenterBot/selenium/drivers/chromedriver/chromedriver.exe");
        ChromeOptions option = setChromeOptions();
        WebDriver chromeDriver = new ChromeDriver(option);
        chromeDriver.manage().window().maximize();
        chromeDriver.get("https://nice-t-shop.herokuapp.com/");

        int shortSleepTime = 2;
        int longSleepTime = 2;
        int durationTime = 10;
        String drinkName = "ACID";
        JavascriptExecutor js = ((JavascriptExecutor) chromeDriver);

        TimeUnit.SECONDS.sleep(shortSleepTime);
        WebElement searchField = new WebDriverWait(chromeDriver, Duration.ofSeconds(10))
                .until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"searchExp\"]")));
        searchField.sendKeys(drinkName);
        TimeUnit.SECONDS.sleep(shortSleepTime);
        js.executeScript("scroll(0,400)");
        TimeUnit.SECONDS.sleep(shortSleepTime);
        js.executeScript("scroll(0,0)");
        searchField.clear();
        searchField.sendKeys(Keys.ENTER);
        TimeUnit.SECONDS.sleep(shortSleepTime);
        js.executeScript("scroll(0,400)");
        TimeUnit.SECONDS.sleep(shortSleepTime);
        selectFilterOptions(chromeDriver, shortSleepTime);
        clickToHome(chromeDriver, durationTime);
        TimeUnit.SECONDS.sleep(longSleepTime);
        clickToCart(chromeDriver, durationTime);
        TimeUnit.SECONDS.sleep(longSleepTime);
        clickToHome(chromeDriver, durationTime);
        clickToProducts(chromeDriver, durationTime);
        TimeUnit.SECONDS.sleep(longSleepTime);
        addElementsToCart(chromeDriver, durationTime);
        TimeUnit.SECONDS.sleep(longSleepTime);
        clickToCart(chromeDriver, durationTime);
        TimeUnit.SECONDS.sleep(longSleepTime);
        js.executeScript("scroll(0,400)");
        TimeUnit.SECONDS.sleep(longSleepTime);
        clickToHome(chromeDriver, durationTime);
        TimeUnit.SECONDS.sleep(longSleepTime);
        clickToLogin(chromeDriver, durationTime);
        TimeUnit.SECONDS.sleep(longSleepTime);
        chromeDriver.close();
    }

    private static ChromeOptions setChromeOptions() {
        ChromeOptions option = new ChromeOptions();
        option.addArguments("--disable-blink-features=AutomationControlled");
        option.addArguments("--disable-notifications");
        option.setExperimentalOption("excludeSwitches", new String[]{"enable-automation"});
        return option;
    }

    private static void selectFilterOptions(WebDriver chromeDriver, int shortSleepTime) throws InterruptedException {
        Select dropdown = new Select(chromeDriver.findElement(By.xpath("//*[@id=\"filter-alcoholic\"]")));
        dropdown.selectByVisibleText("Alcoholic");
        TimeUnit.SECONDS.sleep(shortSleepTime);
        dropdown.selectByVisibleText("Alcohol free");
        TimeUnit.SECONDS.sleep(shortSleepTime);
        dropdown.selectByVisibleText("Optional");
        TimeUnit.SECONDS.sleep(shortSleepTime);
    }

    private static void clickToLogin(WebDriver chromeDriver, int durationTime) {
        WebElement login = new WebDriverWait(chromeDriver, Duration.ofSeconds(durationTime))
                .until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"mainNav\"]/div/form/a")));
        login.click();
    }

    private static void clickToHome(WebDriver chromeDriver, int durationTime) {
        WebElement home = new WebDriverWait(chromeDriver, Duration.ofSeconds(durationTime))
                .until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"mainNav\"]/div/a")));
        home.click();
    }

    private static void clickToProducts(WebDriver chromeDriver, int durationTime) {
        WebElement products = new WebDriverWait(chromeDriver, Duration.ofSeconds(durationTime))
                .until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"navbarResponsive\"]/ul/li[2]/a")));
        products.click();
    }

    private static void clickToCart(WebDriver chromeDriver, int durationTime) {
        WebElement cart = new WebDriverWait(chromeDriver, Duration.ofSeconds(durationTime))
                .until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"navbarResponsive\"]/ul/li[3]/a")));
        cart.click();
    }

    private static void addElementsToCart(WebDriver chromeDriver, int durationTime) {
        WebElement addToCartButton1 = new WebDriverWait(chromeDriver, Duration.ofSeconds(durationTime))
                .until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"products\"]/div[2]/div/div[2]/div[2]/button")));
        addToCartButton1.click();
        WebElement addToCartButton2 = new WebDriverWait(chromeDriver, Duration.ofSeconds(durationTime))
                .until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"products\"]/div[3]/div/div[2]/div[2]/button")));
        addToCartButton2.click();
    }

}
