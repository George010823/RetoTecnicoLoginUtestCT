#Author: joimole1008@gmail.com
Feature: User registration on uTest.com

  Scenario Outline: Create a new user through the registration forms
    Given Juan wants to register on the uTest.com page
    When Juan clicks on the JOIN TODAY option
    And Juan fills out the personal data form with the following information:
      | First Name | Last Name | Email   |
      | <first>    | <last>    | <email> |
    And Juan fills out the birthday data form with the following information:
      | Month   | Day   | Year   |
      | <month> | <day> | <year> |
    And Juan presses the Next Location button
    And Juan fills out the form with his address data:
      | City   | Postal Code |
      | <city> | <postal>    |
    And Juan presses the Next Devices
    And Juan fills out the device data form
    And Juan presses the LastStep
    And Juan fills out the password assignment form with the following information: CosaNostra123*
    Then Juan should be successfully logged in

    Examples:
      | DESCRIPCION     | first |  | last  | email              | month    | day | year | city     | postal       |
      | DATOS DE PRUEBA | John  |  | Smith | jsmith@example.com | February | 10  | 1994 | Medellin | codigoPostal |

