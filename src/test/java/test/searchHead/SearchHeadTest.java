/**
 * Метод-сценарий тестирования
 */
package test.searchHead;

import org.testng.annotations.Test;
import test.base.BaseTest;
import static constants.Constant.Urls.VISIT_HOME_PAGE;

/**
 * Наследуемся от базового теста
 */
public class SearchHeadTest extends BaseTest {
    //Тест выполняется не более 15 сек
    @Test(timeOut = 15000)
    public void checkResultSearch () {
        //Открыть страницу
        basePage.open(VISIT_HOME_PAGE);
        //Через переменную из базового теста вызываем методы
        visitHomePage
                //Метод-Нажать на иконку лупы
                .clickSearch()
                //Метод-проверить текст в поле ввода
                .checkTextInput()
                //Метод-Ввести значение в поле ввода поиска
                .inputSearch()
                //Метод-Нажать ввод для поиска
                .submitSearch();
        //Проверяем количества результатов поиска на странице
        searchResultPage
                //Метод-проверить количество карточек-результатов
                .checkResultSearchItem()
                //Метод-проверка текста заголовка
                .checkTextResultSearch();
    }
}