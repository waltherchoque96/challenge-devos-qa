package pe.challenge.ui;

import net.serenitybdd.screenplay.targets.Target;
import org.openqa.selenium.By;

public class SeleniumDevUI {

    public static final Target LBL_HOME = Target.the("Logo de Home").located(By.xpath("//span[@class='navbar-logo']"));
    public static final Target LBL_TITLE = Target.the("Título de Home").located(By.xpath("//h1"));
    public static final Target MENU_DOCUMENTACION = Target.the("Menú Documentación").located(By.xpath("//span[contains(text(), 'Documentation')]"));
    public static final Target BTN_SEARCH = Target.the("Botón Buscar").located(By.xpath("//span[@class='DocSearch-Button-Container']"));
    public static final Target INPUT_SEARCH = Target.the("Input Buscador").located(By.xpath("//input[@id='docsearch-input']"));
    public static final Target TITLE_RESULT = Target.the("Título del resultado de búsqueda")
            .located(By.xpath("//span[@class='DocSearch-Hit-title']"));
}
