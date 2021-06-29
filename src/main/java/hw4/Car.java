package hw4;

public class Car {
    private double volumeOfTank;
    private double fuelRemaining;
    private double fuelConsumptionFor100km;


    void fillTheTank() {
        this.fuelRemaining = this.volumeOfTank;
    }

    double checkFuelRemaining(double distance) {
        return fuelRemaining - (distance / fuelConsumptionFor100km);
    }

    double checkHowMuchNeedToRefuel() {
        return this.volumeOfTank - this.fuelRemaining;
    }

    public Car(double volumeOfTank, double fuelRemaining, double fuelConsumptionFor100km) {
        this.volumeOfTank = volumeOfTank;
        this.fuelRemaining = fuelRemaining;
        this.fuelConsumptionFor100km = fuelConsumptionFor100km;
    }

    public double getVolumeOfTank() {
        return this.volumeOfTank;
    }

    public void setVolumeOfTank(double volumeOfTank) {
        this.volumeOfTank = volumeOfTank;
    }

    public double getFuelRemaining() {
        return this.fuelRemaining;
    }

    public void setFuelRemaining(double fuelRemaining) {
        this.fuelRemaining = fuelRemaining;
    }

    public double getFuelConsumptionFor100km() {
        return this.fuelConsumptionFor100km;
    }

    public void setFuelConsumptionFor100km(double fuelConsumptionFor100km) {
        this.fuelConsumptionFor100km = fuelConsumptionFor100km;
    }


}
