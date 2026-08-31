package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;

public class TablesPage extends BasePage {

    private static final String URL =
            "https://qaplayground.com/ui-practice/tables";
    private By categoryDropdown = By.xpath("(//select)[1]");
    private By searchInput =
            By.xpath("(//input[@placeholder='e.g. MacBook'])[1]");
    private By editButton(String productName) {
        return By.xpath(
                "//tr[.//*[contains(normalize-space(),'"
                        + productName + "')]]//button[contains(.,'Edit')]"
        );

    }
    private By priceInput =
            By.xpath("//*[@id='sec-shopping-products']/table/tbody/tr[1]/td[3]/input");
    private By saveButton = By.xpath("//button[contains(text(),'Save')]");
    public TablesPage(WebDriver driver) {
        super(driver);
    }
    public void openTablesPage() {
        openUrl(URL);
    }
    public void selectCategory(String category) {
        Select select = new Select(driver.findElement(categoryDropdown));
        select.selectByVisibleText(category);
    }
    public void searchProduct(String productName) {
        driver.findElement(searchInput).sendKeys(productName);
    }
    public void editProduct(String productName) {
        driver.findElement(editButton(productName)).click();
    }
    public void editPrice(String newPrice) {

        driver.findElement(priceInput).clear();

        driver.findElement(priceInput).sendKeys(newPrice);

        driver.findElement(saveButton).click();
    }
}