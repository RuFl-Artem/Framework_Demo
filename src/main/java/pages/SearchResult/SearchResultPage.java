package pages.SearchResult;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import pages.base.BasePage;;

import static org.testng.Assert.assertEquals;
import static org.assertj.core.api.Assertions.assertThat;

public class SearchResultPage extends BasePage {
    public SearchResultPage(WebDriver driver) {
        super(driver);
    }
    /**
     * Определяем локатор результатов поиска на странице-карточек
     */
    private final By searchResultItem = By.xpath("//li[@class='artItem']");
    /**
     * Текст Результаты поиска
     */
    private final By textResultSearch = By.xpath(".//h1[text()='Результаты поиска']");
    /**
     * Сравниваем фактический результат количества результатов поиска на странице
     */
    public SearchResultPage checkResultSearchItem() {
        int countItem = driver.findElements(searchResultItem).size();
        System.out.println("Фактическое количество на странице: " + countItem);
        assertEquals(countItem, 15, "Фактическое количество элементов больше");
        return this;
    }
    public SearchResultPage checkTextResultSearch() {
        String h1TextResultSearch = driver.findElement(textResultSearch).getText();
        String h1TextExpected = "Результаты поиска";
        //Проверка соответствия текста заголовка через assertj
        assertThat(h1TextResultSearch).as("Текст заголовка не соответствует!").isEqualTo(h1TextExpected);
        return this;
    }
}
