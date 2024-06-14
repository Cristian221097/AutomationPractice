package Utils;

import org.testng.*;
import org.testng.annotations.Listeners;

@Listeners({Listener.class})
public class Listener  implements ITestListener{

    @Override
    public void onTestStart(ITestResult result){
        System.out.println("Prueba iniciada: " + result.getName());

    }

    @Override
    public void onTestSuccess(ITestResult result) {
        System.out.println("Prueba exitosa: " + result.getName());
    }

    @Override
    public void onTestFailure(ITestResult result) {
        System.out.println("Prueba fallida: " + result.getName());
    }


    @Override
    public void onTestSkipped(ITestResult result) {
        System.out.println("Prueba omitida: " + result.getName());
    }

}
