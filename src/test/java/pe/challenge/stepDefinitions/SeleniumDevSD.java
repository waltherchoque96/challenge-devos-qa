package pe.challenge.stepDefinitions;

import io.cucumber.java.Before;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.serenitybdd.model.environment.EnvironmentSpecificConfiguration;
import net.serenitybdd.screenplay.actors.OnlineCast;
import net.thucydides.model.util.EnvironmentVariables;
import pe.challenge.questions.TextToValidate;
import pe.challenge.tasks.*;
import pe.challenge.ui.SeleniumDevUI;

import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;
import static net.serenitybdd.screenplay.actors.OnStage.*;
import static net.serenitybdd.screenplay.actors.OnStage.theActorInTheSpotlight;
import static net.serenitybdd.screenplay.questions.page.TheWebPage.currentUrl;
import static org.hamcrest.Matchers.equalTo;
import static pe.challenge.ui.SeleniumDevUI.LBL_TITLE;

public class SeleniumDevSD {

    private EnvironmentVariables environmentVariables;

    @Before
    public void configuracionInicial() {
        setTheStage(new OnlineCast());
    }

    @Given("ingresa a la página de Selenium Dev")
    public void goToSeleniumDev() {
        String baseUrl = EnvironmentSpecificConfiguration.from(environmentVariables)
                .getProperty("environments.qa.selenium");

        theActorCalled("Usuario").wasAbleTo(
                TaskAbrirPagina.open(baseUrl, false)
        );
    }

    @When("accede al menú de Documentación")
    public void goToDocumentation() {
        theActorInTheSpotlight().attemptsTo(TaskIrDocumentacion.go());
    }

    @When("accede al buscador de la página")
    public void goToSearch() {
        theActorInTheSpotlight().attemptsTo(TaskAbrirBuscador.on());
    }

    @And("ingresa el dato {string} para buscar")
    public void enterTextToSearch(String item) {
        theActorInTheSpotlight().attemptsTo(TaskBuscador.enterText(item));
    }

    @When("carga el home de la página")
    public void waitUntilPageLoaded() {
        theActorInTheSpotlight().attemptsTo(
                WaitForLoad.page(15)
        );
    }

    @Then("se debe mostrar el resultado según el criterio especificado {string}")
    public void verifyResults(String texto){
        theActorInTheSpotlight().should(
                seeThat(TextToValidate.located(SeleniumDevUI.TITLE_RESULT), equalTo(texto))
        );
    }

    @And("se debe acceder y verificar la redirección al resultado {string}")
    public void accessToResult(String data){
        theActorInTheSpotlight().attemptsTo(TaskIrResultado.go());

        theActorInTheSpotlight().should(
                seeThat(TextToValidate.located(SeleniumDevUI.LBL_TITLE), equalTo(data))
        );
    }


    @Then("se debe mostrar el título esperado {string}")
    public void verifyTitle(String title){
        theActorInTheSpotlight().should(
                seeThat(TextToValidate.located(SeleniumDevUI.LBL_TITLE), equalTo(title))
        );
    }

    @Then("se debe mostrar la página de Documentación {string}")
    public void verifyDocumentationPage(String title){
        theActorInTheSpotlight().should(
                seeThat(currentUrl(), equalTo("https://www.selenium.dev/documentation/"))
        );
        theActorInTheSpotlight().should(
                seeThat(TextToValidate.located(LBL_TITLE), equalTo(title))
        );
    }
}