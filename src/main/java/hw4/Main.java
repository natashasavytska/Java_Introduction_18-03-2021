package hw4;

import java.util.HashMap;
import java.util.Map;

public class Main {

    public static void main(String[] args) {
        int priceForFuel = Integer.parseInt(args[0]);
        double distanceOdesaKryveOzero = 179.0;
        double distanceKryveOzeroZhashkiv = 153.0;
        double distanceZhashkivKyiv = 150.0;
        double totalFuelConsumption = 0;
        double totalPriceOfTheTrip = 0;
        Map<Integer, Double> distances = new HashMap<>();
        distances.put(1, distanceOdesaKryveOzero);
        distances.put(2, distanceKryveOzeroZhashkiv);
        distances.put(3, distanceZhashkivKyiv);
        Car myCar = new Car(20.0, 2.0, 15.0);
        
        if (myCar.getFuelRemaining() >= (myCar.getFuelRemaining() - distanceOdesaKryveOzero / myCar.getFuelConsumptionFor100km())) {
            System.out.println("===EXTRA STOP===");
            double needToRefuelAtStop = myCar.checkHowMuchNeedToRefuel();
            String refuel = String.format("Need to refuel: %.2f", needToRefuelAtStop);
            System.out.println(refuel);
            double expensesForTheDistance = calculateExpensesForDistance(priceForFuel, needToRefuelAtStop);
            totalFuelConsumption = totalFuelConsumption + needToRefuelAtStop;
            totalPriceOfTheTrip = totalPriceOfTheTrip + expensesForTheDistance;
            myCar.fillTheTank();
        }

        for (int i = 0; i < 3; i++) {
            System.out.println("==== STOP " + (i + 1) + "====");
            double needToRefuelAtStop = calculateFuelConsumptionToTheNextStop(myCar, distances.get(i + 1));
            double expensesForTheDistance = calculateExpensesForDistance(priceForFuel, needToRefuelAtStop);
            totalFuelConsumption = totalFuelConsumption + needToRefuelAtStop;
            totalPriceOfTheTrip = totalPriceOfTheTrip + expensesForTheDistance;
            if (i != 2)
                myCar.fillTheTank();
        }

        String fuelConsumption = String.format("Total fuel consumption: %.2f", totalFuelConsumption);
        System.out.println(fuelConsumption);
        String totalExpenses = String.format("Total expenses for the trip: %.2f", totalPriceOfTheTrip);
        System.out.println(totalExpenses);
        System.out.println("Fuel remaining after finishing trip: " + myCar.getFuelRemaining());
    }

    private static double calculateFuelConsumptionToTheNextStop(Car myCar, double distance) {
        double fuelRemaining = myCar.checkFuelRemaining(distance);
        myCar.setFuelRemaining(fuelRemaining);
        double needToRefuelAtStop = myCar.checkHowMuchNeedToRefuel();
        String refuel = String.format("Need to refuel: %.2f", needToRefuelAtStop);
        System.out.println(refuel);
        return needToRefuelAtStop;
    }

    private static double calculateExpensesForDistance(double priceForFuel, double needToRefuelAtStop) {
        double expensesForTheDistance = needToRefuelAtStop * priceForFuel;
        String pay = String.format("Need to pay: %.2f", expensesForTheDistance);
        System.out.println(pay);
        System.out.println();
        return expensesForTheDistance;
    }
}

