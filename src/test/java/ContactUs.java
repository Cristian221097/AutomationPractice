import basetest.BaseTest;
import org.testng.annotations.Test;
import pages.ContactUsPage;
import pages.HomePage;

public class ContactUs extends BaseTest {

    private HomePage homePage;
    private ContactUsPage contactUsPage;

    @Test(description = "Send Form")
    public void sendForm(){
        homePage = new HomePage(getDriver());
        contactUsPage = new ContactUsPage(getDriver());
        homePage.goToPage();
        createStep("HomePage",true,true);
        homePage.selectOptionContactUs();
        createStep("Click en la opcion 'Contact us'",true,false);
        createStep("Se muestra el formulario de contacto",true,true);
        contactUsPage.selectSubjectOption("2");
        createStep("Seleccionar opcion 'Customer service'",true,false);
        createStep("Se selecciono la opcion 'Customer service'",true,true);
        contactUsPage.enterEmail("cristian@gmail.com");
        createStep("Ingresar email",true,false);
        createStep("Se ingreso el email 'cristian@gmail.com'",true,true);
        contactUsPage.enterOrderReference("1");
        createStep("Ingresar order reference",true,false);
        createStep("Se ingreso order reference '1'",true,true);
        contactUsPage.uploadDoc();
        createStep("Subir archivo pdf",true,false);
        createStep("Se muestra el archivo cargado",true,true);
        contactUsPage.enterMessage("Test");
        createStep("Ingresar mensaje",true,false);
        createStep("Se ingreso el mensaje Test",true,true);
        contactUsPage.clickButtonSend();
        createStep("Click en el boton 'Send'",true,false);
        contactUsPage.confirmIsVisibleMessageSuccess();
        createStep("Se envia el formulario\n" +
                "Se muestra el mensaje 'Your message has been successfully sent to our team.'",true,true);

    }

    @Test(description = "send form with invalid email")
    public void sendFormWithInvalidEmail(){
        homePage = new HomePage(getDriver());
        contactUsPage = new ContactUsPage(getDriver());
        homePage.goToPage();
        createStep("HomePage",true,true);
        homePage.selectOptionContactUs();
        createStep("Click en la opcion 'Contact us'",true,false);
        createStep("Se muestra el formulario de contacto",true,true);
        contactUsPage.selectSubjectOption("2");
        createStep("Seleccionar opcion 'Customer service'",true,false);
        createStep("Se selecciono la opcion 'Customer service'",true,true);
        contactUsPage.enterEmail("cristian");
        createStep("Ingresar email invalido",true,false);
        createStep("Se ingreso el email 'cristian'",true,true);
        contactUsPage.enterOrderReference("1");
        createStep("Ingresar order reference",true,false);
        createStep("Se ingreso order reference '1'",true,true);
        contactUsPage.uploadDoc();
        createStep("Subir archivo pdf",true,false);
        createStep("Se muestra el archivo cargado",true,true);
        contactUsPage.enterMessage("Test");
        createStep("Ingresar mensaje",true,false);
        createStep("Se ingreso el mensaje Test",true,true);
        contactUsPage.clickButtonSend();
        createStep("Click en el boton 'Send'",true,false);
        contactUsPage.confirmIsVisibleMsjErrorInvalidEmail();
        createStep("Se muestra el mensaje de error 'Invalid email address'",true,true);

    }

    @Test(description = "send form without entering message")
    public void sendFormWithOutMessage(){
        homePage = new HomePage(getDriver());
        contactUsPage = new ContactUsPage(getDriver());
        homePage.goToPage();
        createStep("HomePage",true,true);
        homePage.selectOptionContactUs();
        createStep("Click en la opcion 'Contact us'",true,false);
        createStep("Se muestra el formulario de contacto",true,true);
        contactUsPage.selectSubjectOption("2");
        createStep("Seleccionar opcion 'Customer service'",true,false);
        createStep("Se selecciono la opcion 'Customer service'",true,true);
        contactUsPage.enterEmail("cristian@gmail.com");
        createStep("Ingresar email invalido",true,false);
        createStep("Se ingreso el email 'cristian@gmail.com'",true,true);
        contactUsPage.enterOrderReference("1");
        createStep("Ingresar order reference",true,false);
        createStep("Se ingreso order reference '1'",true,true);
        contactUsPage.uploadDoc();
        createStep("Subir archivo pdf",true,false);
        createStep("Se muestra el archivo cargado",true,true);
        contactUsPage.clickButtonSend();
        createStep("Click en el boton 'Send'",true,false);
        contactUsPage.confirmIsVisibleMsjErrorTextTareaMessage();
        createStep("Se muestra el mensaje de error 'mensaje:The message cannot be blank'",true,true);

    }

    @Test(description = "submit form without selecting file")
    public void sendFormWithOutSelectFile(){
        homePage = new HomePage(getDriver());
        contactUsPage = new ContactUsPage(getDriver());
        homePage.goToPage();
        createStep("HomePage",true,true);
        homePage.selectOptionContactUs();
        createStep("Click en la opcion 'Contact us'",true,false);
        createStep("Se muestra el formulario de contacto",true,true);
        contactUsPage.selectSubjectOption("2");
        createStep("Seleccionar opcion 'Customer service'",true,false);
        createStep("Se selecciono la opcion 'Customer service'",true,true);
        contactUsPage.enterEmail("cristian@gmail.com");
        createStep("Ingresar email",true,false);
        createStep("Se ingreso el email 'cristian@gmail.com'",true,true);
        contactUsPage.enterOrderReference("1");
        createStep("Ingresar order reference",true,false);
        createStep("Se ingreso order reference '1'",true,true);
        contactUsPage.enterMessage("Test");
        createStep("Ingresar mensaje",true,false);
        createStep("Se ingreso el mensaje Test",true,true);
        contactUsPage.clickButtonSend();
        createStep("Click en el boton 'Send'",true,false);
        contactUsPage.confirmIsVisibleMsjThereIs1Error();
        createStep("Se muestra el mensaje de error 'Invalid file'",true,true);

    }

    @Test(description = "send form without order reference")
    public void sendFormWithOutOrderReference(){
        homePage = new HomePage(getDriver());
        contactUsPage = new ContactUsPage(getDriver());
        homePage.goToPage();
        createStep("HomePage",true,true);
        homePage.selectOptionContactUs();
        createStep("Click en la opcion 'Contact us'",true,false);
        createStep("Se muestra el formulario de contacto",true,true);
        contactUsPage.selectSubjectOption("2");
        createStep("Seleccionar opcion 'Customer service'",true,false);
        createStep("Se selecciono la opcion 'Customer service'",true,true);
        contactUsPage.enterEmail("cristian@gmail.com");
        createStep("Ingresar email",true,false);
        createStep("Se ingreso el email 'cristian@gmail.com'",true,true);
        contactUsPage.uploadDoc();
        createStep("Subir archivo pdf",true,false);
        createStep("Se muestra el archivo cargado",true,true);
        contactUsPage.enterMessage("Test");
        createStep("Ingresar mensaje",true,false);
        createStep("Se ingreso el mensaje Test",true,true);
        contactUsPage.clickButtonSend();
        createStep("Click en el boton 'Send'",true,false);
        contactUsPage.confirmIsVisibleMsjThereIs1Error();
        createStep("Se muestra el mensaje de error 'Invalid order reference.'",true,true);

    }

    @Test(description = "Send Form without email")
    public void sendFormWithOutEmail(){
        homePage = new HomePage(getDriver());
        contactUsPage = new ContactUsPage(getDriver());
        homePage.goToPage();
        createStep("HomePage",true,true);
        homePage.selectOptionContactUs();
        createStep("Click en la opcion 'Contact us'",true,false);
        createStep("Se muestra el formulario de contacto",true,true);
        contactUsPage.selectSubjectOption("2");
        createStep("Seleccionar opcion 'Customer service'",true,false);
        createStep("Se selecciono la opcion 'Customer service'",true,true);
        contactUsPage.enterOrderReference("1");
        createStep("Ingresar order reference",true,false);
        createStep("Se ingreso order reference '1'",true,true);
        contactUsPage.uploadDoc();
        createStep("Subir archivo pdf",true,false);
        createStep("Se muestra el archivo cargado",true,true);
        contactUsPage.enterMessage("Test");
        createStep("Ingresar mensaje",true,false);
        createStep("Se ingreso el mensaje Test",true,true);
        contactUsPage.clickButtonSend();
        createStep("Click en el boton 'Send'",true,false);
        contactUsPage.confirmIsVisibleMsjErrorInvalidEmail();
        createStep("mensaje: Invalid email address.",true,true);

    }

    @Test(description = "Send Form withOut select subject")
    public void sendFormWithOutSubject(){
        homePage = new HomePage(getDriver());
        contactUsPage = new ContactUsPage(getDriver());
        homePage.goToPage();
        createStep("HomePage",true,true);
        homePage.selectOptionContactUs();
        createStep("Click en la opcion 'Contact us'",true,false);
        createStep("Se muestra el formulario de contacto",true,true);
        contactUsPage.enterEmail("cristian@gmail.com");
        createStep("Ingresar email",true,false);
        createStep("Se ingreso el email 'cristian@gmail.com'",true,true);
        contactUsPage.enterOrderReference("1");
        createStep("Ingresar order reference",true,false);
        createStep("Se ingreso order reference '1'",true,true);
        contactUsPage.uploadDoc();
        createStep("Subir archivo pdf",true,false);
        createStep("Se muestra el archivo cargado",true,true);
        contactUsPage.enterMessage("Test");
        createStep("Ingresar mensaje",true,false);
        createStep("Se ingreso el mensaje Test",true,true);
        contactUsPage.clickButtonSend();
        createStep("Click en el boton 'Send'",true,false);
        contactUsPage.confirmIsVisibleMsjErrorSelectSubject();
        createStep("mensaje:Please select a subject from the list provided. ",true,true);
    }
}
