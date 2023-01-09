package common;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import java.util.concurrent.TimeUnit;
import static common.Config.PLATFORM_AND_BROWSER;
import static constants.Constant.TimeoutVariable.IMPLICIT_WAIT;

public class CommonAction {
    //По умолчанию драйвер пустой
    public static WebDriver createDriver() {
        WebDriver driver = null;
        //Если драйвера не существует, то создаем с такими параметрами
        switch (PLATFORM_AND_BROWSER) {
            case "win_chrome":
                //Проинициализируем WebDriverManager
                WebDriverManager.chromedriver().setup();
                //подключаем драйвер
                driver = new ChromeDriver();
                break;
            default:
                Assert.fail("Некорректная платформа либо браузер: " + PLATFORM_AND_BROWSER);
        }
        //Установим максимальный размер окна по умолчанию
        driver.manage().window().maximize();
        //Неявное ожидание 3 секунды до появления элемента
        driver.manage().timeouts().implicitlyWait(IMPLICIT_WAIT, TimeUnit.SECONDS);
        //Возвращаем созданный или существующий драйвер
        return driver;
    }
}