package tests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;
import pages.TablesPage;

public class TablesTest {

    @Test
    public void tableTest() {

        WebDriver driver = new ChromeDriver();

        TablesPage tablesPage = new TablesPage(driver);

        tablesPage.openTablesPage();
        tablesPage.selectCategory("Laptops");
        tablesPage.searchProduct("MacBook");
        tablesPage.editProduct("MacBook");
        tablesPage.editPrice("1500");
        driver.quit();
    }
}
