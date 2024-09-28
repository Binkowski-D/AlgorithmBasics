package utility_tasks;

import java.util.Arrays;
import java.util.Comparator;

public class Car {
    public static void main(String[] args) {

        Car bmw = new Car(280, 3);
        Car fiat = new Car(180, 7);
        Car ferrari = new Car(450, 2);
        Car renault = new Car(240, 4);

        Car[] cars = {bmw, fiat, ferrari, renault};

        try {
            Car theGreatestCar = getMax(cars);
            System.out.println(theGreatestCar);
        } catch (IllegalStateException ex) {
            System.err.println("Error: " + ex.getMessage());
        } catch (RuntimeException ex) {
            System.err.println("Error: " + ex.getMessage());
        }
    }

    public static Car getMax(Car[] cars) {
        if (cars == null || cars.length == 0) {
            throw new IllegalStateException("Input array is null or has zero length");
        }

        Arrays.sort(cars, Comparator.comparingInt((Car car) -> car.maxSpeed)
                .thenComparingInt((Car car) -> car.acceleration).reversed());

        return cars[0];
    }

    int maxSpeed;
    int acceleration;

    public Car(int maxSpeed, int acceleration) {
        this.maxSpeed = maxSpeed;
        this.acceleration = acceleration;
    }

    @Override
    public String toString() {
        return "Car with maxSpeed=" + maxSpeed + " and acceleration=" + acceleration;
    }
}
