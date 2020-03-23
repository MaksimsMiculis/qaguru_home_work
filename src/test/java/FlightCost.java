import org.junit.jupiter.api.Test;

public class FlightCost {
    @Test
    public void calculation() {

        double fuelPrice = 3.57;
        int fuelConsumptionPer100km = 305;
        int mileageInKm = 5500;
        double flightCost = ((mileageInKm / 100) * fuelConsumptionPer100km) * fuelPrice;

        System.out.println(flightCost + " евро ушло на перелёт");

    }
}

//2600l per hour
//850 km/h
//100 - ?
//      2. Зная, что 1 литр топлива стоит 3.57 евро, написать метод, который принимает
// расход самолёта на 100 км и растояние пройдениое им и в консоле
// напишет сколько денег ушло на топливо на конкретный перелёт