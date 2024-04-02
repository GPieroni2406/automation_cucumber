package drivers;
import automation.WebAutomator;
import browsers.Browser;
import exceptions.NoValidBrowserException;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class driverFactory {
    private static ThreadLocal <WebAutomator> webAutomator = new ThreadLocal<WebAutomator>();

    public static WebAutomator getAutomator() throws NoValidBrowserException, IOException {
        if (webAutomator.get()==null){
            webAutomator.set(createAutomator());
        }
        else return webAutomator.get();
        return null;
    }


    private static WebAutomator createAutomator() throws NoValidBrowserException, IOException {
        String browser = "CHROME";
        WebAutomator automator = new WebAutomator(Browser.valueOf(getBrowser()),false,false,30);
        return automator;
    }

    public static void clear(){
        webAutomator.get().closeBrowser();
    }

    public static String getBrowser() throws IOException { //OBTIENE EL BROSWER DE LAS PROPERTIES
        String browser = null;
        try {
            browser = null;
            Properties properties = new Properties();
            FileInputStream file = new FileInputStream(System.getProperty("user.dir") + "/src/main/java/properties/config.properties");
            properties.load(file);
            browser = properties.getProperty("browser").trim();
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
        return browser;
    }
}