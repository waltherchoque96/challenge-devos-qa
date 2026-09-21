package pe.challenge.stepDefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.serenitybdd.model.environment.EnvironmentSpecificConfiguration;
import net.serenitybdd.rest.SerenityRest;
import net.serenitybdd.screenplay.rest.abilities.CallAnApi;
import net.serenitybdd.screenplay.rest.interactions.Get;
import net.thucydides.model.util.EnvironmentVariables;
import pe.challenge.data.Random;
import pe.challenge.tasks.TaskCreateUser;
import pe.challenge.tasks.TaskUpdateUser;

import static net.serenitybdd.screenplay.actors.OnStage.theActorCalled;
import static net.serenitybdd.screenplay.actors.OnStage.theActorInTheSpotlight;
import static org.hamcrest.Matchers.*;

public class ApiSD {

    private EnvironmentVariables environmentVariables;
    String randomName = Random.getName();
    String randomJob = Random.getJob();
    String newName = Random.getName();
    String newJob = Random.getJob();


    @Given("que el usuario prepara la conexión a la API")
    public void prepararConexionApi() {
        String apiUrl = EnvironmentSpecificConfiguration.from(environmentVariables)
                .getProperty("environments.qa.api");

        theActorCalled("UsuarioAPI").whoCan(CallAnApi.at(apiUrl));
    }

    @When("realiza una petición GET para obtener los usuarios de la página {int}")
    public void peticionGetUsuarios(int page) {
        theActorInTheSpotlight().attemptsTo(
                Get.resource("/api/users")
                        .with(request -> request.queryParam("page", page))
        );
    }

    @Then("la respuesta debe ser exitosa y mostrar la página {int}")
    public void validarRespuestaApi(int pageEsperada) {
        SerenityRest.restAssuredThat(response -> response
                .statusCode(200)

                .body("page", equalTo(pageEsperada))
                .body("support.url", notNullValue())
                .body("support.text", containsString("Become a better CTO"))
                .body("_meta.powered_by", equalTo("ReqRes"))
                .body("_meta.context", equalTo("legacy_success"))
        );
    }

    @Given("que el usuario configura el cliente API para gestionar usuarios")
    public void configurarClienteApi() {
        String apiUrl = EnvironmentSpecificConfiguration.from(environmentVariables)
                .getProperty("environments.qa.api");

        theActorCalled("UsuarioAPI").whoCan(CallAnApi.at(apiUrl));
    }

    @When("envía una solicitud POST para crear al usuario")
    public void enviarPostCrearUsuario() {
        theActorInTheSpotlight().attemptsTo(
                TaskCreateUser.withData(randomName, randomJob)
        );
    }

    @When("envía una solicitud para actualizar al usuario con ID {int}")
    public void enviarPutActualizarUsuario(int userId) {
        theActorInTheSpotlight().attemptsTo(
                TaskUpdateUser.withId(userId, newName, newJob)
        );
    }

    @Then("el usuario debe ser creado exitosamente con nombre y cargo")
    public void validarCreacionUsuario() {
        SerenityRest.restAssuredThat(response -> response
                .statusCode(201)

                .body("name", equalTo(randomName))
                .body("job", equalTo(randomJob))
                .body("id", notNullValue())
                .body("createdAt", notNullValue())

                .body("_meta.powered_by", equalTo("ReqRes"))
                .body("_meta.context", equalTo("legacy_success"))
                .body("_meta.docs_url", containsString("documentation"))
                .body("_meta.cta.label", equalTo("See example app"))
        );
    }

    @Then("el usuario debe ser actualizado exitosamente")
    public void validarActualizacionUsuario() {
        SerenityRest.restAssuredThat(response -> response
                .statusCode(200)

                .body("name", equalTo(newName))
                .body("job", equalTo(newJob))
                .body("updatedAt", notNullValue())

                .body("_meta.powered_by", equalTo("ReqRes"))
                .body("_meta.context", equalTo("legacy_success"))
                .body("_meta.docs_url", containsString("documentation"))
                .body("_meta.cta.label", equalTo("See example app"))
                .body("_meta.cta.url", containsString("notes-app"))
        );
    }

}