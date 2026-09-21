package pe.challenge.conf;

import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.core.webdriver.driverproviders.ProvidedDriverCapabilities;
import net.serenitybdd.screenplay.actors.OnStage;
import net.serenitybdd.screenplay.actors.OnlineCast;
import net.thucydides.model.environment.SystemEnvironmentVariables;
import net.thucydides.model.util.EnvironmentVariables;
import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

public class Hooks extends PageObject {

    public static WebDriver getWebDriver(boolean console) throws IOException {

            System.out.println("Iniciando prueba en navegador Chrome");
            EnvironmentVariables environmentVariables = SystemEnvironmentVariables.createEnvironmentVariables();
            ChromeOptions options = new ChromeOptions();
            ProvidedDriverCapabilities providedDriverCapabilities = new ProvidedDriverCapabilities(environmentVariables);
            options.merge(providedDriverCapabilities.getCapabilities());

            if (console){
                System.out.println("Iniciando Chrome en modo consola");
                options.addArguments("--headless=new");
                options.addArguments("--disable-gpu");
                options.addArguments("--no-sandbox");
                options.addArguments("--disable-dev-shm-usage");
            }

            WebDriver driver = new ChromeDriver(options);
            driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
            driver.manage().window().maximize();
            ((JavascriptExecutor) driver).executeScript("document.body.style.transform='scale(0.75)';");
            ((JavascriptExecutor) driver).executeScript("document.body.style.transformOrigin='0 0';");
            return driver;
    }

    @Before
    public void setStage() {
        OnStage.setTheStage(new OnlineCast());
    }

    @After
    public void tearDown() {
        OnStage.drawTheCurtain();
    }

}