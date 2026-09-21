@SeleniumDev @Challenge-devos
Feature: Selenium Dev

  @TestCase1_seleniumdev
  Scenario: Verificar la carga inicial de la página Selenium Dev
    Given ingresa a la página de Selenium Dev
    When carga el home de la página
    Then se debe mostrar el título esperado "Selenium automates browsers. That's it!"


  @TestCase2_seleniumdev
  Scenario: Verificar el acceso al apartado de Documentación
    Given ingresa a la página de Selenium Dev
    When accede al menú de Documentación
    Then se debe mostrar la página de Documentación "The Selenium Browser Automation Project"


  @TestCase3_seleniumdev
  Scenario Outline: Verificar la busqueda de items en el sitio de Selenium Dev
    Given ingresa a la página de Selenium Dev
    When accede al buscador de la página
    And ingresa el dato "<data>" para buscar
    Then se debe mostrar el resultado según el criterio especificado "<data>"
    And se debe acceder y verificar la redirección al resultado "<data>"

    Examples:
         | data |
         | Test Practices |