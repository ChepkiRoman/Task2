package by.tc.task02.service;

import by.tc.task02.entity.RentUnit;
import by.tc.task02.entity.Shop;
import by.tc.task02.entity.SportEquipment;

import java.util.List;
import java.util.Map;

public class PrintEquipmentInfo {

    public void rentItemsInfo(Shop shop){
        List<RentUnit> rentUnits= shop.getRentUnits();
        System.out.println(rentUnits);

    }
    public void avalibleItemsInfo(Shop shop){
        Map<SportEquipment,Integer> equipments = shop.getGoods();
        System.out.println(equipments);

    }

}
