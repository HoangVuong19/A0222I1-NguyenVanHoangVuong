package models;

public class Villa extends Facility{
    private String standardRooms;
    private double areaPool;
    private int numberOfStoreys;

    public Villa(String standardRooms, double areaPool, int numberOfStoreys) {
        this.standardRooms = standardRooms;
        this.areaPool = areaPool;
        this.numberOfStoreys = numberOfStoreys;
    }

    public Villa(String name, double areaUsed, int price, int maximumPeople, String rentType, String standardRooms, double areaPool, int numberOfStoreys) {
        super(name, areaUsed, price, maximumPeople, rentType);
        this.standardRooms = standardRooms;
        this.areaPool = areaPool;
        this.numberOfStoreys = numberOfStoreys;
    }

    public String getStandardRooms() {
        return standardRooms;
    }

    public void setStandardRooms(String standardRooms) {
        this.standardRooms = standardRooms;
    }

    public double getAreaPool() {
        return areaPool;
    }

    public void setAreaPool(double areaPool) {
        this.areaPool = areaPool;
    }

    public int getNumberOfStoreys() {
        return numberOfStoreys;
    }

    public void setNumberOfStoreys(int numberOfStoreys) {
        this.numberOfStoreys = numberOfStoreys;
    }

    @Override
    public String toString() {
        return "Villa{" + super.toString() +
                " standardRooms='" + standardRooms + '\'' +
                ", areaPool=" + areaPool +
                ", numberOfStoreys=" + numberOfStoreys +
                '}';
    }
}
