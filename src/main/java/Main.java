import io.github.bonigarcia.wdm.ChromeDriverManager;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeDriverService;
import org.openqa.selenium.chrome.ChromeOptions;

import java.net.MalformedURLException;
import java.net.URL;

import static io.github.bonigarcia.wdm.DriverManagerType.CHROME;

public class Main {

    public static void main(String[] args) throws MalformedURLException {

        ChromeDriverManager.chromedriver();


        String browser = "C:\\work\\lis-parent-pom\\embeddedselenium\\target\\chromium-76.0.3809.87_windows32_client\\cef_binary_76.1.9+g2cf916e+chromium-76.0.3809.87_windows32_client\\Release\\cefclient.exe";

        WebDriverManager webDriverManager = WebDriverManager.getInstance(CHROME).browserPath(browser);

        webDriverManager.setup();


        ChromeOptions options = new ChromeOptions();



        options.setBinary(browser);

        options.addArguments("remote-debugging-port=18098");
        options.addArguments("--headless");
        options.addArguments("--disable-gpu");
        //headless

        WebDriver driver = new ChromeDriver(options);
        driver.get("http://www.google.com/xhtml");
        sleep(3000);
        WebElement searchBox = driver.findElement(By.name("q"));
        searchBox.sendKeys("ChromeDriver");
        searchBox.submit();
        sleep(3000);
        driver.quit();
    }

    static void sleep(int time) {
        try { Thread.sleep(time); } catch (InterruptedException e) {}
    }
}