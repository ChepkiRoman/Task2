package by.tc.task02.dao;


import by.tc.task02.entity.Category;
import by.tc.task02.entity.SportEquipment;
import by.tc.task02.service.validation.Validator;

public class EquipmentBuilder {


    public static SportEquipment buildEquipment(String[] criterias) {
        Category category = Category.valueOf(criterias[0]);
        String title = criterias[1];
        Integer price = Integer.valueOf(criterias[2]);

        if (Validator.isValid(category, title, Integer.valueOf(price))) {
            SportEquipment equipment = new SportEquipment();
            equipment.setCategory(category);
            equipment.setTitle(criterias[1]);
            equipment.setPrice(Integer.valueOf(criterias[2]));
            return equipment;
        } else {
            return null;
        }


    }

    public static SportEquipment buildEquipment(String category, String title, String price) {
        Category category1 = Category.valueOf(category);
        if (Validator.isValid(category1, title, Integer.valueOf(price))) {
            SportEquipment equipment = new SportEquipment();
            equipment.setCategory(category1);
            equipment.setTitle(title);
            equipment.setPrice(Integer.valueOf(price));
            return equipment;
        } else {
            return null;
        }

    }
}

