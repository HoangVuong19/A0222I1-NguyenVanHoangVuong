package models;

public class Room extends Facility {
    private String freeService;

    public Room(String freeService) {
        this.freeService = freeService;
    }

    public Room(String name, double areaUsed, int price, int maximumPeople, String rentType, String freeService) {
        super(name, areaUsed, price, maximumPeople, rentType);
        this.freeService = freeService;
    }

    public String getFreeService() {
        return freeService;
    }

    public void setFreeService(String freeService) {
        this.freeService = freeService;
    }

    @Override
    public String toString() {
        return "Room{" +
                "freeService='" + freeService + '\'' +
                '}' + super.toString();
    }
}
