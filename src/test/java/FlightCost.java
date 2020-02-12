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

