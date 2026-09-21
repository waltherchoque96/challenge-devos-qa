# Framework de Automatización Serenity BDD (Web & API) - Devos

## 1. Contexto
Este proyecto es un framework de automatización basado en el patrón **Screenplay** como parte de la prueba técnica para el rol de QA. Está diseñado para cubrir pruebas de doble frente: interfaces de usuario web (Selenium) y servicios REST API (ReqRes), permitiendo ejecutar todo en una sola suite unificada y generar evidencias detalladas de cada validación.

## 2. Prerrequisitos
* **Java JDK** (Versión 17 o superior recomendada).
* **Apache Maven** instalado y configurado en las variables de entorno.
* **IntelliJ IDEA** (u otro IDE compatible) con soporte para Maven y carpetas marcadas como *Sources Root* (`src/main/java` y `src/test/java`).

## 3. Herramientas utilizadas
* **Java**: Lenguaje de programación base.
* **Serenity BDD (v4.0.30)**: Núcleo de automatización, manejo de actores (Screenplay) y generación de reportes.
* **Cucumber (BDD)**: Motor de especificación ejecutable mediante archivos `.feature` (`reqres.feature`, `selenium.feature`)[cite: 3].
* **RestAssured & Serenity Rest**: Módulo para la ejecución e interacción con APIs REST (GET, POST, PUT).
* **Selenium WebDriver**: Automatización de navegadores web bajo una estrategia optimizada (`pageLoadStrategy = "eager"`).
* **JavaFaker**: Generación de datos aleatorios dinámicos para las pruebas.
* **Maven**: Gestor de dependencias y compilación del proyecto.

## 4. Comando para ejecutar
Para ejecutar toda la suite de pruebas (Web y API) de forma unificada y empaquetar los resultados, utiliza el siguiente comando en la raíz del proyecto:

```bash
mvn clean verify

