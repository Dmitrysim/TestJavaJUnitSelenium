import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;

public class HomeWorkWebDriver
{
    @Test
    public void testAllFieldsHello()
    {
        System.setProperty("webdriver.chrome.driver", "drivers\\chromedriver.exe");
        var driver = new ChromeDriver();
        driver.navigate().to("https://lm.skillbox.ru/qa_tester/module02/homework1/");
        driver.findElement(By.name("name")).sendKeys("Ivanov Ivan Ivanovich");
        driver.findElement(By.name("email")).sendKeys("test@mail.ru");
        driver.findElement(By.name("phone")).sendKeys("+7989000000");
        driver.findElement(By.className("button")).click();
        var actualText = driver.findElement(By.className("start-screen__res")).getText();
        var expectedText = "Здравствуйте, Ivanov Ivan Ivanovich.\n" +
                "На вашу почту (test@mail.ru) отправлено письмо.\n" +
                "Наш сотрудник свяжется с вами по телефону: +7989000000.";
        Assert.assertEquals(expectedText, actualText);
        driver.quit();
    }

    @Test
    public void testEmptyFieldsHello()
    {
        System.setProperty("webdriver.chrome.driver", "drivers\\chromedriver.exe");
        var driver = new ChromeDriver();
        driver.navigate().to("https://lm.skillbox.ru/qa_tester/module02/homework1/");
        driver.findElement(By.className("button")).click();
        var actualText = driver.findElement(By.className("start-screen__res")).getText();
        var expectedText = "Здравствуйте, .\n" +
                "На вашу почту () отправлено письмо.\n" +
                "Наш сотрудник свяжется с вами по телефону: .";
        Assert.assertEquals(expectedText, actualText);
        driver.quit();
    }
}
