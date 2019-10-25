package speed.racing;

public class Car {

    private double fuelAmount;
    private double fuelCost;
    private int traveledDistance;

    public Car(double fuelAmount,double fuelCost) {
        this.fuelAmount = fuelAmount;
        this.fuelCost = fuelCost;
        this.traveledDistance = 0;
    }

    public double getFuelAmount() {
        return fuelAmount;
    }

    public void setFuelAmount(int kmAmount) {
        this.fuelAmount -= kmAmount * this.fuelCost;
    }

    public int getTraveledDistance() {
        return traveledDistance;
    }

    public void setTraveledDistance(int traveledDistance) {
        this.traveledDistance += traveledDistance;
    }

    public boolean canDrive (int kmAmount){
        return this.fuelAmount - (kmAmount * this.fuelCost) >= 0;
    }

}
