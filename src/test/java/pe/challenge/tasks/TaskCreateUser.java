package pe.challenge.tasks;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.rest.interactions.Post;
import pe.challenge.models.User;

import static net.serenitybdd.screenplay.Tasks.instrumented;

public class TaskCreateUser implements Task {

    private final User userRequest;
    public TaskCreateUser(User userRequest) {
        this.userRequest = userRequest;
    }

    public static TaskCreateUser withData(String name, String job) {
        return instrumented(TaskCreateUser.class, new User(name, job));
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                Post.to("/api/users")
                        .with(request -> request
                                .header("Content-Type", "application/json")
                                .body(userRequest)
                        )
        );
    }
}