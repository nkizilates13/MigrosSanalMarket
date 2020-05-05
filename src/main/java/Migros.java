import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Migros {

    public static void main(String[] args) {


        try {
            System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") + "/src/main/chromedriver");
            WebDriver driver = new ChromeDriver();

            driver.get("https://www.migros.com.tr/");

            Thread.sleep(1000);

            driver.findElement(By.id("membership-register-link")).click();
            Thread.sleep(2000);
            driver.findElement(By.id("emailInput")).sendKeys("nagehan@nagi.com");
            driver.findElement(By.id("phoneNumberInput")).sendKeys("5555555555");
            driver.findElement(By.xpath("//*[@id=\"registerForm\"]/div[3]/div[1]/label/div/ins")).click();
            driver.findElement(By.xpath("//*[@id=\"registerForm\"]/div[3]/div[2]/label/div/ins")).click();
            driver.findElement(By.xpath("//*[@id=\"registerForm\"]/div[3]/div[3]/label/div/ins")).click();
            driver.findElement(By.id("register-button-submit")).click();
            JavascriptExecutor js = (JavascriptExecutor) driver;
            js.executeScript("document.getElementById('phoneNumberToVerify').setAttribute('value', '123456')");
            driver.findElement(By.id("verifyOtpButton")).click();

            driver.close();

        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

}
