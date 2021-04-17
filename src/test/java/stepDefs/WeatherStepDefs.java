package stepDefs;

import com.fasterxml.jackson.core.JsonProcessingException;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import model.Response;
import org.junit.jupiter.api.Assertions;
import requesters.WeatherRequester;

public class WeatherStepDefs {
    private String cityName;
    private String country;
    private Response response;
    //teperj on dostupen na urovne vsego klassa

//    @Given("show test name")
//    public void show_test_name() {
//        System.out.println("Hello, ogurec!");
//    }

    @Given("city {string}")
    public void set_city(String cityName) {
        this.cityName = cityName;
    }

    @Given("country {string}")
    public void set_country(String country) {
        this.country = country;
    }

    @When("we are requesting weather data")
    public void request_weather() throws JsonProcessingException {
        WeatherRequester requester = new WeatherRequester();
        response = requester.requestWeather(cityName, country);
        // System.out.println(response.getCoord().getLat());
        // System.out.println(requester.requestWeather(cityName, country));
    }

    @Then("lon is {float}")
    public void check_lon(float lon) {
        Assertions.assertEquals(lon, response.getCoord().getLon(), "Wrong lon");

    }

    @Then("lat is {float}")
    public void check_lat(float lat) {
        Assertions.assertEquals(lat, response.getCoord().getLat(), "Wrong lat");

    }

    @Then("base is {long}")
    public void check_base(long base){
        Assertions.assertEquals(base, response.getBase().getBase(),"Wrong base");
    }


    @Then("temp is {float}")
    public void check_temp(float temp){
        Assertions.assertEquals(temp, response.getMain().getTemp(), "Wrong temp");

    }

    @Then("pressure is {int}")
    public void check_pressure(int pressure){
        Assertions.assertEquals(pressure, response.getMain().getPressure(), "Wrong pressure");

    }

    @Then("humidity is {int}")
    public void check_humidity(int humidity){
        Assertions.assertEquals(humidity, response.getMain().getHumidity(),"Wrong pressure");
    }

    @Then("temp_min is {float}")
    public void check_temp_min (float temp_min){
        Assertions.assertEquals(temp_min, response.getMain().getTemp_min(),"Wrong temp_min");
    }

    @Then("temp_max is {float}")
    public void check_temp_max(float temp_max){
        Assertions.assertEquals(temp_max, response.getMain().getTemp_max(),"Wrong temp_max");
    }
}