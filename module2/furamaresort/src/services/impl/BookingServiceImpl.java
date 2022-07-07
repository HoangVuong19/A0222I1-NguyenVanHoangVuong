package services.impl;

import models.Booking;
import models.Customer;
import models.Facility;
import services.BookingService;
import utils.BookingComparator;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.*;

public class BookingServiceImpl implements BookingService {
    private static final Set<Booking> bookingSet = new TreeSet<>(new BookingComparator());
    private static final Scanner sc = new Scanner(System.in);

    @Override
    public void add() {
        int id = 1;
        if (!bookingSet.isEmpty()) {
            id = bookingSet.size() + 1;
        }
        Customer customer = chooseCustomer();
        Facility facility = chooseFacility();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");

        System.out.println("Nhập ngày bắt đầu thuê: ");
        LocalDate startDate = LocalDate.parse(sc.nextLine(), formatter);
        System.out.println("Nhập ngày kết thúc thuê: ");
        LocalDate endDate = LocalDate.parse(sc.nextLine(), formatter);
        System.out.println("Nhập loại dịch vụ đi kèm: ");
        String serviceType = sc.nextLine();

        Booking booking = new Booking(id, startDate, endDate, customer.getId(), facility.getName(), serviceType);
        bookingSet.add(booking);
        System.out.println("Đã booking thành công!!");
    }

    @Override
    public void displayList() {
        for (Booking b : bookingSet) {
            System.out.println(b.toString());
        }
    }

    public static Customer chooseCustomer() {
        List<Customer> cusService = new CustomerServiceImpl().getCustomerList();
        System.out.println("Danh sách khách hàng: ");
        for (Customer customer : cusService) {
            System.out.println(customer.toString());
        }

        System.out.println("Nhập id khách hàng: ");
        String id = sc.nextLine();

        while (true) {
            for (Customer cus : cusService) {
                if (id.equals(cus.getId())) {
                    return cus;
                }
            }
            System.out.println("Không tìm thấy id, vui lòng nhập lại id!!");
            id = sc.nextLine();
        }
    }

    public static Facility chooseFacility() {
        Map<Facility, Integer> facService = new FacilityServiceImpl().getFacilityIntegerMap();
        System.out.println("Danh sách dịch vụ: ");
        for (Facility fac : facService.keySet()) {
            System.out.println(fac.toString());
        }

        System.out.println("Nhập id dịch vụ: ");
        String id = sc.nextLine();
        while (true) {
            for (Facility key : facService.keySet()) {
                if (id.equals(key.getId())) {
                    return key;
                }
            }
            System.out.println("Không tìm thấy id, vui lòng nhập lại id!!");
            id = sc.nextLine();
        }
    }

    public Set<Booking> getBookingSet(){
        return bookingSet;
    }

}
