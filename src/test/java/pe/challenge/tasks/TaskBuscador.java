package pe.challenge.tasks;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Enter;
import pe.challenge.ui.SeleniumDevUI;

public class TaskBuscador implements Task {

    private String texto;

    public TaskBuscador(String texto){
        this.texto = texto;
    }
    public static TaskBuscador enterText(String texto){
        return Tasks.instrumented(TaskBuscador.class, texto);
    }
    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                Click.on(SeleniumDevUI.INPUT_SEARCH),
                Enter.theValue(texto).into(SeleniumDevUI.INPUT_SEARCH)
        );
    }
}
