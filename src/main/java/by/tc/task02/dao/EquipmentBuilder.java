package by.tc.task02.dao;


import by.tc.task02.entity.Category;
import by.tc.task02.entity.SportEquipment;

public class EquipmentBuilder {
    public static SportEquipment buildEquipment(String[] criterias) {
        SportEquipment equipment = new SportEquipment();
        Category category = Category.valueOf(criterias[0]);
        equipment.setCategory(category);
        equipment.setTitle(criterias[1]);
        equipment.setPrice(Integer.valueOf(criterias[2]));
        return equipment;
    }
}

