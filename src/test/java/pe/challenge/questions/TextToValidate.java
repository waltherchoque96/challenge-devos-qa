package pe.challenge.questions;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;
import net.serenitybdd.screenplay.questions.Text;
import net.serenitybdd.screenplay.targets.Target;

public class TextToValidate implements Question<String> {
    private final Target target;

    public TextToValidate(Target target) {
        this.target = target;
    }

    public static TextToValidate located(Target target) {
        return new TextToValidate(target);
    }

    @Override
    public String answeredBy(Actor actor) {
        return Text.of(target).answeredBy(actor);
    }

}
