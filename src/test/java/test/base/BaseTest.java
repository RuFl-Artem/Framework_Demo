/**
 * От этого класса будут наследоваться все тесты
 * Общая логика для всех тестов
 */
package test.base;

import common.CommonAction;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import pages.SearchResult.SearchResultPage;
import pages.VisitHome.VisitHomePage;
import pages.base.BasePage;

import static common.Config.CLEAR_COOKIES_AND_STORAGE;
import static common.Config.HOLD_BROWSER_OPEN;

public class BaseTest {
    //Получить экземпляр драйвера из класса CommonAction
    protected WebDriver driver = CommonAction.createDriver();
    //Экземпляр базовой страницы получить созданный драйвер
    protected BasePage basePage = new BasePage(driver);
    //Переменная экземпляра домашней страницы
    protected VisitHomePage visitHomePage = new VisitHomePage(driver);
    //Переменная экземпляра страницы результатов поиска
    protected SearchResultPage searchResultPage = new SearchResultPage(driver);
    //После выполнения теста чистим куки браузера, если true
    @AfterTest
    public void clearCookieAndLocalStorage() {
        if (CLEAR_COOKIES_AND_STORAGE) {
            JavascriptExecutor JavascriptExecutor = (org.openqa.selenium.JavascriptExecutor) driver;
            driver.manage().deleteAllCookies();
            JavascriptExecutor.executeScript("window.sessionStorage.clear()");
        }
    }

    //Закрываем браузер, после каждого запуска
    @AfterSuite (alwaysRun = true)
    public void close() {
        if (HOLD_BROWSER_OPEN) {
            driver.quit();
        }
    }
}
