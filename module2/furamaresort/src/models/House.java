package models;

public class House extends Facility {
    private String standardRooms;
    private int numberOfStoreys;

    public House(String standardRooms, int numberOfStoreys) {
        this.standardRooms = standardRooms;
        this.numberOfStoreys = numberOfStoreys;
    }

    public House(String name, double areaUsed, int price, int maximumPeople, String rentType, String standardRooms, int numberOfStoreys) {
        super(name, areaUsed, price, maximumPeople, rentType);
        this.standardRooms = standardRooms;
        this.numberOfStoreys = numberOfStoreys;
    }

    public String getStandardRooms() {
        return standardRooms;
    }

    public void setStandardRooms(String standardRooms) {
        this.standardRooms = standardRooms;
    }

    public int getNumberOfStoreys() {
        return numberOfStoreys;
    }

    public void setNumberOfStoreys(int numberOfStoreys) {
        this.numberOfStoreys = numberOfStoreys;
    }

    @Override
    public String toString() {
        return "House{" + super.toString() +
                "standardRooms='" + standardRooms + '\'' +
                ", numberOfStoreys=" + numberOfStoreys +
                '}';
    }
}
