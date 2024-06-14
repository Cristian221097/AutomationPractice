package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ContactUsPage extends BasePage {

    private By titleForm = By.xpath("//h1[normalize-space()='Customer service - Contact us']");
    private By selectSubject = By.xpath("//select[@id='id_contact']");
    private By inputEmailAddress = By.xpath("//input[@id='email']");
    private By inputOrderReference = By.xpath("//input[@id='id_order']");
    private By inputFile = By.xpath("//input[@id='fileUpload']");
    private By textareaMessage = By.xpath("//textarea[@id='message']");
    private By buttonSend = By.xpath("//button[@id='submitMessage']");
    private By messageSuccess = By.xpath("//*[text()='Your message has been successfully sent to our team.']");
    private By msjErrorInvalidEmail = By.xpath("//*[text()='Invalid email address.']");
    private By msjErrorSelectSubject = By.xpath("//*[text()='Please select a subject from the list provided. '] ");
    private By msjErrorTextTareaMessage = By.xpath("//*[text()='The message cannot be blank.']");
    private By msjThereIs1Error = By.xpath("//*[text()='There is 1 error']");

    public ContactUsPage(WebDriver driver) {
        super(driver);
    }

    public By getTitleForm() {
        return titleForm;
    }

    public void selectSubjectOption(String value) {
        isElementPresent(selectSubject, "Select subject");
        selectOption(selectSubject, value);
    }

    public void enterEmail(String value) {
        writeField(inputEmailAddress, value, "Email address");
    }

    public void enterOrderReference(String value) {
        writeField(inputOrderReference, value, "Order reference");
        scrollToElement(inputOrderReference);
    }

    public void uploadDoc() {
        String pathDoc = System.getProperty("user.dir");
        upLoadImagenDoc(pathDoc + "\\src\\main\\resources\\Document\\QA Challenge 1.pdf", inputFile, "input file");
        scrollToElement(inputFile);
    }

    public void enterMessage(String value) {
        writeField(textareaMessage, value, "Message");
        scrollToElement(textareaMessage);
    }

    public void clickButtonSend() {
        clickElement(buttonSend, "Button Send");
    }

    public void confirmIsVisibleMessageSuccess() {
        isElementVisible(messageSuccess, "mensaje: Your message has been successfully sent to our team.");
        scrollToElement(titleForm);
    }

    public void confirmIsVisibleMsjErrorInvalidEmail() {
        isElementVisible(msjErrorInvalidEmail, "mensaje: Invalid email address.");
        scrollToElement(titleForm);

    }

    public void confirmIsVisibleMsjErrorSelectSubject() {
        isElementVisible(msjErrorSelectSubject, "mensaje:Please select a subject from the list provided. ");
        scrollToElement(titleForm);

    }

    public void confirmIsVisibleMsjErrorTextTareaMessage() {
        isElementVisible(msjErrorTextTareaMessage, "mensaje:The message cannot be blank.");
        scrollToElement(titleForm);

    }

    public void confirmIsVisibleMsjThereIs1Error() {
        isElementVisible(msjThereIs1Error, "mensaje:There is 1 error");
        scrollToElement(titleForm);

    }

}
