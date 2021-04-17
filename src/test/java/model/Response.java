package model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)

public class Response {
    private Coord coord;
    private Main main;
    private Base base;

    public Coord getCoord() {
        return coord;
    }

    public void setCoord(Coord coord) {
        this.coord = coord;
    }

    public Main getMain() {
        return main;

    }

    public void setMain(Main main) {
        this.main = main;

    }

    public Base getBase() {
        return base;

    }

    public void setBase (Base base){
        this.base = base;
    }


    //Coord modelj na kotoruju natjagivajut json
    // nazvanie peremennoj coord dolzno sovpadatj s nazvaniem s jsone
    //getteri setteri vsegda pod peremennoj
}

//1. мы проверяем что вернулась правильная долгота широта lon lat конкретного города
// тестик отправляет запрос в сервис погоды, получаем ответ, его нужно распарсить и сделать проверку
//