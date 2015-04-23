/**
 * Created by sergey.petrakov on 4/23/2015.
 */
import java.util.concurrent.TimeUnit;
import org.junit.*;
import static org.junit.Assert.*;
import org.openqa.selenium.*;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Mail01 {
    private WebDriver driver;
    private String baseUrl;
    private boolean acceptNextAlert = true;
    private StringBuffer verificationErrors = new StringBuffer();

    @Before
    public void setUp() throws Exception {
    driver = new FirefoxDriver();
    baseUrl = "https://mail.ru/";
    driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
    }

    @Test
    public void testIncorrectLoginAndPassword() throws Exception {
        driver.get(baseUrl + "/");
        driver.findElement(By.id("mailbox__login")).clear();
        driver.findElement(By.id("mailbox__login")).sendKeys("www");
        driver.findElement(By.id("mailbox__password")).clear();
        driver.findElement(By.id("mailbox__password")).sendKeys("www");
        driver.findElement(By.id("mailbox__auth__button")).click();
    }

    @Test
    public void testCorrectLoginAndPassword() throws Exception {
        driver.get(baseUrl);
        driver.findElement(By.id("mailbox__login")).clear();
        driver.findElement(By.id("mailbox__login")).sendKeys("testmail00111");
        driver.findElement(By.id("mailbox__password")).clear();
        driver.findElement(By.id("mailbox__password")).sendKeys("qwerty12345");
        driver.findElement(By.id("mailbox__auth__button")).click();
        driver.findElement(By.xpath("//div[@id='portal-menu']/div[2]/div/div/div[2]/div/span/span[2]/span[2]/a/span[2]/span")).click();
        driver.findElement(By.xpath("//div[@id='portal-menu']/div[2]/div/div/div[2]/div/span/span[2]/span[3]/a/span[2]/span")).click();
    }

    @After
    public void tearDown() throws Exception {
        driver.quit();
        String verificationErrorString = verificationErrors.toString();
        if (!"".equals(verificationErrorString)) {
            fail(verificationErrorString);
        }
    }

    private boolean isElementPresent(By by) {
        try {
            driver.findElement(by);
            return true;
        } catch (NoSuchElementException e) {
            return false;
        }
    }

    private boolean isAlertPresent() {
        try {
            driver.switchTo().alert();
            return true;
        } catch (NoAlertPresentException e) {
            return false;
        }
    }

    private String closeAlertAndGetItsText() {
        try {
            Alert alert = driver.switchTo().alert();
            String alertText = alert.getText();
            if (acceptNextAlert) {
                alert.accept();
            } else {
                alert.dismiss();
            }
            return alertText;
        } finally {
            acceptNextAlert = true;
        }
    }
}


