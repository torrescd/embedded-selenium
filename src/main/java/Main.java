import io.github.bonigarcia.wdm.ChromeDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class Main {

    public static void main(String[] args) {

        ChromeDriverManager.chromedriver();

        ChromeOptions options = new ChromeOptions();

        options.setBinary("c:/temp/cef_binary_3.2171.1979_windows32_client/Release/cefclient.exe");

        options.addArguments("remote-debugging-port=12345");

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