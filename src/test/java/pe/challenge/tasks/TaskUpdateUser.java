package pe.challenge.tasks;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.rest.interactions.Put;
import pe.challenge.models.User;

import static net.serenitybdd.screenplay.Tasks.instrumented;

public class TaskUpdateUser implements Task {

    private final int userId;
    private final User userRequest;

    public TaskUpdateUser(int userId, User user) {
        this.userId = userId;
        this.userRequest = user;
    }

    public static TaskUpdateUser withId(int userId, String name, String job) {
        return instrumented(TaskUpdateUser.class, userId, new User(name, job));
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                Put.to("/api/users/{id}")
                        .with(request -> request
                                .pathParam("id", userId)
                                .header("Content-Type", "application/json")
                                .body(userRequest)
                        )
        );
    }

}