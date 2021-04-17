Feature: Weather

#  Scenario: Check correct Weather data
#    Given show test name

  Scenario: Checking coordinates for city
    Given city "London"
    And country "UK"

    When we are requesting weather data

    Then lon is -0.13
    And lat is 51.51

#    Then weather id is 300
#    And main weather is "Drizzle"
#    And detailed description is "light intensity drizzle"
#    And number of drizzle weather icon is 09d

    Then base is "stations"

    Then temp is 280.32
    And pressure is 1012
    And humidity is 81
    And temp_min is 279.15
    And temp_max is 281.15
