package pe.challenge.tasks;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.actions.Click;
import pe.challenge.ui.SeleniumDevUI;

public class TaskAbrirBuscador implements Task {

    public TaskAbrirBuscador(){
    }
    public static TaskAbrirBuscador on(){
        return Tasks.instrumented(TaskAbrirBuscador.class);
    }
    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                Click.on(SeleniumDevUI.BTN_SEARCH)
        );
    }
}
