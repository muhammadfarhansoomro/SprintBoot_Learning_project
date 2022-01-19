Feature: Vehicle Details

  @Int
  Scenario Outline: User can view the details of a Vehicle
    Given a valid User with username <User> and password <Password> logs into Dealercockpit application
    And enters a valid VIN <VALID VIN> to search for the Vehicle
    Then the details of the vehicle are displayed
    Examples:
      |  User          |  Password                | VALID VIN           |
      |  QXZ2DNZ       |  Triplehisback1EXD5uE3yP  | XXXXXXXX           |

  @Int
  Scenario Outline: An error message is shown, if the Vehicle against VIN does not exist
    Given a valid User with username <User> and password <Password> logs into Dealercockpit application
    And enters an invalid VIN <VALID VIN> to search for the Vehicle
    Then the error message is displayed
    Examples:
      |  User          |  Password                 | VALID VIN          |
      |  QXZ2DNZ       |  Triplehisback1EXD5uE3yP  | XXXXXXXX           |