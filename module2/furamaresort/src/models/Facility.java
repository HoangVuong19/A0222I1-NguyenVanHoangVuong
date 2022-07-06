package models;

public abstract class Facility {
    private String name;
    private double areaUsed;
    private int price;
    private int maximumPeople;
    private String rentType;

    public Facility() {
    }

    public Facility(String name, double areaUsed, int price, int maximumPeople, String rentType) {
        this.name = name;
        this.areaUsed = areaUsed;
        this.price = price;
        this.maximumPeople = maximumPeople;
        this.rentType = rentType;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getAreaUsed() {
        return areaUsed;
    }

    public void setAreaUsed(double areaUsed) {
        this.areaUsed = areaUsed;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public int getMaximumPeople() {
        return maximumPeople;
    }

    public void setMaximumPeople(int maximumPeople) {
        this.maximumPeople = maximumPeople;
    }

    public String getRentType() {
        return rentType;
    }

    public void setRentType(String rentType) {
        this.rentType = rentType;
    }

    @Override
    public String toString() {
        return "Facility{" +
                "name='" + name + '\'' +
                ", areaUsed=" + areaUsed +
                ", price=" + price +
                ", maximumPeople=" + maximumPeople +
                ", rentType='" + rentType + '\'' +
                '}';
    }
}
