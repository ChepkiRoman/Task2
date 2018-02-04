package by.tc.task02.main;


import by.tc.task02.dao.EquipmentBuilder;
import by.tc.task02.entity.SportEquipment;
import by.tc.task02.entity.User;
import by.tc.task02.service.RentItemService;

import java.io.IOException;

public class Main {


    public static void main(String[] args) throws IOException {
        User user = new User();
        user.setName("Roman");
        user.setId(1);
        User user2 = new User();
        user2.setId(2);
        user2.setName("Vova");
        SportEquipment equipment = EquipmentBuilder.buildEquipment("SHOES", "Man", "30");
        SportEquipment equipment1 = EquipmentBuilder.buildEquipment("SHOES", "Woman", "30");
        SportEquipment equipment2 = EquipmentBuilder.buildEquipment("SWIMMING", "Glasses", "20");
        SportEquipment equipment3 = EquipmentBuilder.buildEquipment("FITNESS", "Mat", "25");
        RentItemService service = new RentItemService();
        service.rentEquipment(equipment, user);
        service.rentEquipment(equipment1, user);
        service.rentEquipment(equipment2, user2);
        service.rentEquipment(equipment3, user);






    }


}
