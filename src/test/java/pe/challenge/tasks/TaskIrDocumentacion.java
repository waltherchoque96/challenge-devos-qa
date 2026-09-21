package pe.challenge.tasks;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.actions.Click;
import pe.challenge.ui.SeleniumDevUI;

public class TaskIrDocumentacion implements Task {
    public TaskIrDocumentacion(){
    }
    public static TaskIrDocumentacion go(){
        return Tasks.instrumented(TaskIrDocumentacion.class);
    }
    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                Click.on(SeleniumDevUI.MENU_DOCUMENTACION)
        );
    }
}
