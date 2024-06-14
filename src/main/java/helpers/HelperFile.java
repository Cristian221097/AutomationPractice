package helpers;
import basetest.BaseTest;
import java.io.File;
import java.io.FileWriter;

public class HelperFile {

    private static HelperFile instance = null;

    private HelperFile() {
    }

    public static HelperFile getInstance() {
        if (instance == null) {
            instance = new HelperFile();
        }
        return instance;
    }

    public boolean isExitFile(String path, String name) {
        boolean result = false;
        try {
            File file = new File(path, name);
            result = file.exists();
        } catch (Exception err) {
            BaseTest.getInstance().createStep("Error al confirmar si el archivo:" + name + " existe" + err.getMessage(), false, false);
        }

        return result;
    }

    public String[] getNameFiles(String path) {
        String[] result = new String[0];
        try {
            File file = new File(path);
            result = file.list();
        } catch (Exception err) {
            BaseTest.getInstance().createStep("Error al confirmar la lista de archivos en la ryta:" + path + " " + err.getMessage(), false, false);
        }
        return result;
    }

    public void createFile(String path, String body, String extension) {
        File file = new File(path + "." + extension);
        try (FileWriter fileWriter = new FileWriter(file)) {
            fileWriter.write(body);
        } catch (Exception err) {
            BaseTest.getInstance().createStep("Error al crear el archivo: " + path + "." + extension + " " + err.getMessage(), false, false);
        }

    }

}
