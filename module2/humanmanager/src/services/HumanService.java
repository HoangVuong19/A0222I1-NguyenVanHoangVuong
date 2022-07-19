package services;

import exceptions.NotFoundException;
import models.Human;
import utils.WriteOrReadFile;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class HumanService {
    private static List<Human> humanList = new ArrayList<>();
    public static final String path = "D:\\A0222I1-NguyenVanHoangVuong\\module2\\humanmanager\\src\\data\\personal_records.csv";

    WriteOrReadFile writeOrReadFile = new WriteOrReadFile();

    public HumanService() {
        humanList = writeOrReadFile.read(path);
    }

    public void addHuman(Human human) {
        humanList.add(human);
        Collections.sort(humanList);
        writeOrReadFile.write(humanList, path, false);
    }

    public List<Human> display() {
        return humanList = writeOrReadFile.read(path);
    }

    public void delete(String id) throws NotFoundException {
        for (Human human : humanList) {
            if (human.getId().equals(id)) {
                humanList.remove(human);
                writeOrReadFile.write(humanList, path, false);
                return;
            }
        }
        throw new NotFoundException(id + " is not exists!!!");
    }

}
