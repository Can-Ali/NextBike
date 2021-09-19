@wip
Feature: Frankfurt Feature

  Background:
    When I send a GET request to Frankfurt endpoint
    Then status code should be 200



  Scenario: Checking available stations

    Then following hubs should be available
      | Hauptwache | Fressgasse / Neue Mainzer Str. | Friedberger Platz / Café Harveys |


  Scenario Outline: Checking stations info
    Then following "<stations>" should have following "<id>"

    Examples:
      | stations                         | id                               |
      | Hauptwache                       | fb84608abfd17c82a4e00d406fa6193f |
      | Fressgasse / Neue Mainzer Str.   | 93d295d2c1da4aa73398c30e60917df6 |
      | Friedberger Platz / Café Harveys | 5313c629cc501e6b70f039f2c82593e9 |

