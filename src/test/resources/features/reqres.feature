@ReqRes @Challenge-devos
Feature: API ReqRes

  @TestCase1_reqres
  Scenario: Verificar el listado de usuarios en ReqRes
    Given que el usuario prepara la conexión a la API
    When realiza una petición GET para obtener los usuarios de la página 1
    Then la respuesta debe ser exitosa y mostrar la página 1


  @TestCase2_reqres
  Scenario: Verificar la creación del usuario en ReqRes
    Given que el usuario configura el cliente API para gestionar usuarios
    When envía una solicitud POST para crear al usuario
    Then el usuario debe ser creado exitosamente con nombre y cargo


  @TestCase3_reqres
  Scenario: Actualizar los datos de un usuario existente
    Given que el usuario configura el cliente API para gestionar usuarios
    When envía una solicitud para actualizar al usuario con ID 3
    Then el usuario debe ser actualizado exitosamente