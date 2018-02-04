package by.tc.task02.service;

import by.tc.task02.dao.EquipmentBuilder;
import by.tc.task02.dao.impl.FileWorkerImpl;
import by.tc.task02.entity.Category;
import by.tc.task02.entity.SportEquipment;
import by.tc.task02.service.validation.Validator;

import java.io.IOException;

public class Finder {
    String[] criterias;


    public final SportEquipment find(Category category, String title, int price) throws IOException {

        if (Validator.isValid(category, title, price)) {
            SportEquipment equipment = new SportEquipment();
            FileWorkerImpl fileWorker = new FileWorkerImpl("shop");
            String line;

            while ((line = fileWorker.getStringFromFile()) != null) {
                criterias = line.split(" ");
                if (criterias[0].equals(category.name()) && criterias[1].equals(title) && criterias[2].equals(String.valueOf(price))) {
                    equipment = EquipmentBuilder.buildEquipment(criterias);
                }
            }
            return equipment;
        }
        return null;


    }


}
