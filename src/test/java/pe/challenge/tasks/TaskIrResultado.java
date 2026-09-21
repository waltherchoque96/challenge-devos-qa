package pe.challenge.tasks;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.actions.Click;
import pe.challenge.ui.SeleniumDevUI;

public class TaskIrResultado implements Task {
    public TaskIrResultado(){
    }
    public static TaskIrResultado go(){
        return Tasks.instrumented(TaskIrResultado.class);
    }
    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                Click.on(SeleniumDevUI.TITLE_RESULT)
        );
    }
}

