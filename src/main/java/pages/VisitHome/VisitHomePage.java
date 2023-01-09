/**
 * На главной странице ввести в поле поиска значение и нажать поиск
 */
package pages.VisitHome;

import org.hamcrest.MatcherAssert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import pages.base.BasePage;

import static org.hamcrest.CoreMatchers.containsString;

public class VisitHomePage extends BasePage {
    public VisitHomePage (WebDriver driver) {
        super(driver);
    }
    /**
     * иконка лупы-button[name='s']
     */
    private final By iconSearch = By.cssSelector("div[class='hsMask js-search']");
    /**
     * поле ввода шапка
     */
    private final By inputSearchHead = By.cssSelector("input[class='sText']");
    /**
     * поле поиска Результаты поиска
     */
    private final By inputSearchPage = By.cssSelector("input[class='inpText']");
    /**
     * Нажать на иконку лупы
     */
    public VisitHomePage clickSearch() {
        driver.findElement(iconSearch).click();
        //Вернуть текущий экземпляр
        return this;
    }
    /**
     * Ввести значение в поле ввода поиска
     */
    public VisitHomePage inputSearch() {
        /**
         * Ждем появления поля ввода поиска и заполняем его
         */
        WebElement formInputSearch = driver.findElement(inputSearchHead);
        waitElementIsVisible(formInputSearch).sendKeys("Татарстан");
        return this;
    }
    /**
     * Нажать ввод для поиска
     */
    public VisitHomePage submitSearch() {
        driver.findElement(inputSearchHead).submit();
        return this;
    }
    public VisitHomePage checkTextInput() {
        //Присвоить переменной значение атрибута
        String TextInputHead = driver.findElement(inputSearchHead).getAttribute("placeholder");
        System.out.println("Фактическое значение placeholder: " + TextInputHead);
        //Проверка содержания текста в поле ввода через матчер
        MatcherAssert.assertThat(TextInputHead, containsString("запрос"));
        return this;
    }
}
