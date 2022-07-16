package services.impl;

import models.Facility;
import models.House;
import models.Room;
import models.Villa;
import services.FacilityService;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class FacilityServiceImpl implements FacilityService {
    private static final Map<Facility, Integer> facilityIntegerMap = new LinkedHashMap<>();
    private static final Scanner sc = new Scanner(System.in);

    @Override
    public void display() {
        for (Map.Entry<Facility, Integer> element : facilityIntegerMap.entrySet()) {
            System.out.println("Service: " + element.getKey() + " số lần sử dụng " + element.getValue());
        }
    }

    @Override
    public void displayMaintenance() {
        for (Map.Entry<Facility, Integer> element : facilityIntegerMap.entrySet()) {
            if (element.getValue() >= 5) {
                System.out.println("Service: " + element.getKey() + " đang bảo trì");
            }
        }
    }

    @Override
    public void addNewVilla() {
        System.out.println("Nhập id Villa: ");
        String id = sc.nextLine();
        System.out.println("Nhập tên Villa: ");
        String name = sc.nextLine();
        System.out.println("Nhập diện tích sử dụng: ");
        double areaUsed = Double.parseDouble(sc.nextLine());
        System.out.println("Nhập giá: ");
        int price = Integer.parseInt(sc.nextLine());
        System.out.println("Nhập số người ở tối đa: ");
        int maximumPeople = Integer.parseInt(sc.nextLine());
        System.out.println("Nhập kiểu thuê: ");
        String rentType = sc.nextLine();
        System.out.println("Nhập tiêu chuẩn phòng: ");
        String standardRooms = sc.nextLine();
        System.out.println("Nhập diện tích hồ bơi: ");
        double areaPool = Double.parseDouble(sc.nextLine());
        System.out.println("Nhập số tầng: ");
        int numberOfStoreys = Integer.parseInt(sc.nextLine());

        Villa villa = new Villa(id, name, areaUsed, price, maximumPeople, rentType, standardRooms, areaPool, numberOfStoreys);
        facilityIntegerMap.put(villa, 0);

        System.out.println("Thêm villa thành công!!");
    }

    @Override
    public void addNewHouse() {
        System.out.println("Nhập id House: ");
        String id = sc.nextLine();
        System.out.println("Nhập tên House: ");
        String name = sc.nextLine();
        System.out.println("Nhập diện tích sử dụng: ");
        double areaUsed = Double.parseDouble(sc.nextLine());
        System.out.println("Nhập giá: ");
        int price = Integer.parseInt(sc.nextLine());
        System.out.println("Nhập số người ở tối đa: ");
        int maximumPeople = Integer.parseInt(sc.nextLine());
        System.out.println("Nhập kiểu thuê: ");
        String rentType = sc.nextLine();
        System.out.println("Nhập tiêu chuẩn phòng: ");
        String standardRooms = sc.nextLine();
        System.out.println("Nhập số tầng: ");
        int numberOfStoreys = Integer.parseInt(sc.nextLine());

        House house = new House(id, name, areaUsed, price, maximumPeople, rentType, standardRooms, numberOfStoreys);
        facilityIntegerMap.put(house, 0);

        System.out.println("Thêm House thành công!!");
    }

    @Override
    public void addNewRoom() {
        System.out.println("Nhập id Room: ");
        String id = sc.nextLine();
        System.out.println("Nhập tên Room: ");
        String name = sc.nextLine();
        System.out.println("Nhập diện tích sử dụng: ");
        double areaUsed = Double.parseDouble(sc.nextLine());
        System.out.println("Nhập giá: ");
        int price = Integer.parseInt(sc.nextLine());
        System.out.println("Nhập số người ở tối đa: ");
        int maximumPeople = Integer.parseInt(sc.nextLine());
        System.out.println("Nhập kiểu thuê: ");
        String rentType = sc.nextLine();
        System.out.println("Nhập dịch vụ miễn phí đi kèm: ");
        String freeService = sc.nextLine();

        Room room = new Room(id, name, areaUsed, price, maximumPeople, rentType, freeService);
        facilityIntegerMap.put(room, 0);

        System.out.println("Thêm Room thành công!!");
    }

    public Map<Facility, Integer> getFacilityIntegerMap() {
        return facilityIntegerMap;
    }
}
