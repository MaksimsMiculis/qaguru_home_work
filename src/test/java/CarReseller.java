import org.junit.jupiter.api.Test;

public class CarReseller {
    @Test
    public void advertisement() {

        String carName = "Toyota";
        double price = 8500.56;
        int mileage = 213525;

        System.out.println("Продаём машину " + carName + " " + "с пробегом " + mileage + " за " + price + " денег");

    }
}
