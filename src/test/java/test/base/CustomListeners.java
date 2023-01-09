package test.base;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import java.io.File;
import java.io.IOException;

public class CustomListeners implements ITestListener {
    @Override
    public void onTestFailure(ITestResult iTestResult) {
        /**
         * из результатов теста получить имя
         * trim - удалить лишние пробелы
         */
        String methodName = iTestResult.getName().trim();
        ITestContext context = iTestResult.getTestContext();
        WebDriver driver = (WebDriver) context.getAttribute("driver");
        theScreenShot(methodName, driver);
    }
    public void theScreenShot (String methodName, WebDriver driver) {
        //Создать файл скриншот в случае ошибки
        File srcFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
        try {
            FileUtils.copyFile(srcFile, new File(methodName + ".jpg"));
        }   catch (IOException e) {
            e.printStackTrace();
        }
    }
}
