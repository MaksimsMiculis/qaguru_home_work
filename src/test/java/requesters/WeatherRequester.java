package requesters;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import model.Response;
import org.springframework.web.client.RestTemplate;

public class WeatherRequester {
    private final String PREFIX = "https://samples.openweathermap.org/data/2.5/weather?q=";
    private final String POSTFIX = "&appid=439d4b804bc8187953eb36d2a8c26a02";

    public Response requestWeather(String city, String country) throws JsonProcessingException {
        RestTemplate restTemplate = new RestTemplate();
        String url = PREFIX + city + "," + country.toLowerCase() + POSTFIX;

        String jsonToParse = restTemplate.getForEntity(url, String.class).getBody();

        //get zapros получить погоду
//getForEntity potomu 4to get zaapros. polu4aem string

        ObjectMapper objectMapper = new ObjectMapper();
        return objectMapper.readValue(jsonToParse, Response.class);//iz json v responce zamapitj

        //posle ljubojo objecta dolzen bitj .class int.class string.class
        //hotim polu4itj object stringovij, toljko telo objecta bez vsjakoj sluzebnoj informacii (sam json v tele nahoditsa)
        //restTeamplate ot springa kak Webdriver on seleniuma
        //getForEntity eto zapros za kakojto suwnostju/edinicej
        //object responce mi sodali dlja togo 4tobi informaciju polu4atj ne vvide stroki a objecta,

    }
}