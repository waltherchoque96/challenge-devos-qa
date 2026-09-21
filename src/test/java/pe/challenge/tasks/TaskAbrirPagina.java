package pe.challenge.tasks;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.abilities.BrowseTheWeb;
import net.serenitybdd.screenplay.actions.Open;
import org.openqa.selenium.WebDriver;
import pe.challenge.conf.Hooks;

import java.io.IOException;

public class TaskAbrirPagina implements Task {

    private String url;
    private boolean console;

    public TaskAbrirPagina(String url, boolean console) {
        this.url = url;
        this.console=console;

    }

    public static TaskAbrirPagina open(String url, boolean console) {
        return new TaskAbrirPagina(url,console);
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        WebDriver driver = null;
        try {
            System.out.println("Iniciando WebDriver");
            driver = Hooks.getWebDriver(console);
        } catch (IOException e) {
            System.out.println("Error al obtener el WebDriver: " + e.getMessage());
            throw new RuntimeException(e);
        }
        actor.can(BrowseTheWeb.with(driver));
        actor.attemptsTo(
                Open.url(url)
        );

    }
}
