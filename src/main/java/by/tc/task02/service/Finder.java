package by.tc.task02.service;

import by.tc.task02.dao.impl.FileWorkerImpl;
import by.tc.task02.entity.Category;
import by.tc.task02.entity.SportEquipment;

import java.io.IOException;

public class Finder {
    public static final SportEquipment find(Category category, String title, int price) throws IOException {
        SportEquipment equipment = new SportEquipment();
        FileWorkerImpl fileWorker = new FileWorkerImpl();
        String line;
        while((line = fileWorker.getStringFromFile())!=null){
                String[] criterias = line.split(" ");




        }
        return equipment;
    }
}
