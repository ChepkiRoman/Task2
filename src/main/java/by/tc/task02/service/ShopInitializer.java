package by.tc.task02.service;


import by.tc.task02.dao.EquipmentBuilder;
import by.tc.task02.dao.FileWorker;
import by.tc.task02.dao.impl.FileWorkerImpl;
import by.tc.task02.entity.RentUnit;
import by.tc.task02.entity.Shop;
import by.tc.task02.entity.SportEquipment;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ShopInitializer {
    private Shop shop = new Shop();
    public Shop initializeShop() throws IOException {
        FileWorker fileWorker = new FileWorkerImpl("shop");
        Map<SportEquipment, Integer> goods = new HashMap<SportEquipment, Integer>();
        List<RentUnit> rentUnits = new ArrayList<RentUnit>();

        String line;
        Integer itemAmount;
        while ((line = fileWorker.getStringFromFile()) != null) {
            String[] criterias = line.split(" ");
            itemAmount = Integer.valueOf(criterias[3]);
            goods.put(EquipmentBuilder.buildEquipment(criterias), itemAmount);
        }
        shop.setGoods(goods);
        shop.setRentUnits(rentUnits);
        return shop;
    }


}
