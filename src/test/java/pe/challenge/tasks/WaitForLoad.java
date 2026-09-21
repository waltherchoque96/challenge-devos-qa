package pe.challenge.tasks;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.waits.WaitUntil;
import pe.challenge.ui.SeleniumDevUI;

import static net.serenitybdd.screenplay.Tasks.instrumented;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isVisible;

public class WaitForLoad implements Task {

    private final int timeoutInSeconds;

    public WaitForLoad(int timeoutInSeconds) {
        this.timeoutInSeconds = timeoutInSeconds;
    }

    public static WaitForLoad page(int timeoutInSeconds) {
        return instrumented(WaitForLoad.class, timeoutInSeconds);
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                WaitUntil.the(SeleniumDevUI.LBL_HOME, isVisible())
        );
    }

}