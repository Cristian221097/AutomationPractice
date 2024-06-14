package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HomePage extends BasePage{

    private By ContactUsOptionLocator = By.xpath("//a[text()='Contact us']");

    private static final String URL="http://www.automationpractice.pl/index.php";

    private ContactUsPage contactUsPage;
    public HomePage(WebDriver driver) {
        super(driver);
        contactUsPage = new ContactUsPage(driver);
    }


    public void goToPage(){
        go(URL);
    }

    public void selectOptionContactUs(){
        clickElement(ContactUsOptionLocator,"Opcion Contact us");
        isElementVisible(contactUsPage.getTitleForm(),"title form");
    }


}
