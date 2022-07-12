package services;

import models.Phone;
import exceptions.NotFoundException;
import utils.WriteAndRead;

import java.util.ArrayList;
import java.util.List;

public class PhoneService {
    private static List<Phone> phoneList = new ArrayList<>();
    private static final String path = "D:\\A0222I1-NguyenVanHoangVuong\\module2\\phonemanager\\src\\data\\phones.csv";

    WriteAndRead writeAndRead = new WriteAndRead();

    public PhoneService() {
        phoneList = writeAndRead.read(path);
    }

    public void addPhone(Phone phone) {
        int lastId = 0;
        if (phoneList.size() > 0) {
            lastId = phoneList.get(phoneList.size() - 1).getId();
        }

        phone.setId(lastId + 1);
        phoneList.add(phone);
        writeAndRead.write(phoneList, path, false);
    }

    public List<Phone> display() {
        return phoneList;
    }

    public void delete(int id) throws NotFoundException {
        for (Phone phone : phoneList) {
            if (phone.getId() == id) {
                phoneList.remove(id - 1);
                writeAndRead.write(phoneList, path, false);
                return;
            }
        }
        throw new NotFoundException(id + " is not exists!!!");
    }

    public List<Phone> search(String name) {
        List<Phone> result = new ArrayList<>();

        for (Phone phone : phoneList) {
            if (phone.getName().contains(name)) {
                result.add(phone);
            }
        }
        return result;
    }
}
