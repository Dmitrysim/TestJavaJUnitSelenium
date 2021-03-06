import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class SeleniumTests
{
    private WebDriver driver;

    @Before
    public void setUp()
    {
        System.setProperty("webdriver.chrome.driver", "drivers\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
    }

    @After
    public void tearDown()
    {
        driver.quit();
    }

    @Test
    public void testHelloVasya()
    {
        driver.navigate().to("https://lm.skillbox.ru/qa_tester/module01/");
        driver.findElement(By.name("name")).sendKeys("Вася");
        driver.findElement(By.className("button")).click();
        var actualResult = driver.findElement(By.className("start-screen__res")).getText();
        var expectedResult = "Привет, Вася!";
        Assert.assertEquals(expectedResult, actualResult);
    }

    @Test
    public void testHelloSemen()
    {
        driver.navigate().to("https://lm.skillbox.ru/qa_tester/module01/");
        driver.findElement(By.name("name")).sendKeys("Semen");
        driver.findElement(By.className("button")).click();
        var actualResult = driver.findElement(By.className("start-screen__res")).getText();
        var expectedResult = "Привет, Vasya!";
        Assert.assertEquals(expectedResult, actualResult);
    }
}
