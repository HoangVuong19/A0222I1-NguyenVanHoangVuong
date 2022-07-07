package services.impl;

import models.Booking;
import models.Contract;
import services.ContractService;

import java.util.*;

public class ContractServiceImpl implements ContractService {
    private static final List<Contract> contractList = new ArrayList<>();
    private static final Scanner sc = new Scanner(System.in);

    @Override
    public void display() {
        for (Contract c : contractList) {
            System.out.println(c.toString());
        }
    }

    @Override
    public void add() {
        Set<Booking> bookingSet = new BookingServiceImpl().getBookingSet();
        Queue<Booking> bookingQueue = new LinkedList<>(bookingSet); // replace for loop

        while (!bookingQueue.isEmpty()) {
            Booking booking = bookingQueue.poll();
            String customerId = booking.getCustomerId();

            System.out.println("Đang tạo hợp đồng cho Booking có thông tin: " + booking);
            System.out.println("Đang tạo hợp đồng cho khách hàng có mã id: " + customerId);
            System.out.println("Nhập id hợp đồng: ");
            String contractId = sc.nextLine();
            System.out.println("Nhập số tiền trả trước: ");
            double downPayment = Double.parseDouble(sc.nextLine());
            System.out.println("Nhập tổng tiền trả: ");
            double totalPayment = Double.parseDouble(sc.nextLine());

            Contract contract = new Contract(contractId, booking.getId(), downPayment, totalPayment, customerId);
            contractList.add(contract);
            System.out.println("Đã tạo hợp đồng thành công!!");
        }
    }

    @Override
    public void edit() {
        System.out.println("Nhập id hợp đồng muốn sửa: ");
        String id = sc.nextLine();
        int checkId = 0;

        for (Contract contract : contractList) {
            if (contract.getContractId().equals(id)) {
                System.out.println("Nhập id booking: ");
                int bookingId = Integer.parseInt(sc.nextLine());
                System.out.println("Nhập số tiền trả trước: ");
                double downPayment = Double.parseDouble(sc.nextLine());
                System.out.println("Nhập tổng tiền trả: ");
                double totalPayment = Double.parseDouble(sc.nextLine());
                System.out.println("Nhập id khách hàng: ");
                String customerId = sc.nextLine();

                contract.setBookingId(bookingId);
                contract.setDownPayment(downPayment);
                contract.setTotalPayment(totalPayment);
                contract.setCustomerId(customerId);
                System.out.println("Cập nhập thành công!!");

                checkId++;
            }
        }
        if (checkId == 0){
            System.out.println("Không tìm thấy id!!");
        }
    }

}
