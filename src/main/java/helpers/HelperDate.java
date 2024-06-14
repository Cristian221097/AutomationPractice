package helpers;

import basetest.BaseTest;
import org.testng.Assert;
import java.text.SimpleDateFormat;
import java.time.LocalDate;



public class HelperDate {

    SimpleDateFormat simpleDateFormat;
    private static HelperDate instance = null;

    private HelperDate() {
    }

    public static HelperDate getInstance() {
        if (instance == null) {
            instance = new HelperDate();
        }
        return instance;
    }

    public LocalDate getDate() {
        LocalDate currentDay = null;
        try {
            currentDay = LocalDate.now();

        } catch (Exception err) {
            BaseTest.getInstance().createStep("Error al obtener la fecha actual ", false, false);
            Assert.fail();
        }
        return currentDay;
    }

}
