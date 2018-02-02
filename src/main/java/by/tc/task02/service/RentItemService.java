package by.tc.task02.service;


import by.tc.task02.entity.RentUnit;
import by.tc.task02.entity.Shop;
import by.tc.task02.entity.SportEquipment;
import by.tc.task02.entity.User;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class RentItemService {
    private static final int MAX_AMOUNT_OF_RENT_ITEMS = 3;
    ShopInitializer shopInitializer;
    Shop shop;
    Map<SportEquipment, Integer> goods;
    User user;

    public RentItemService() throws IOException {
        shopInitializer = new ShopInitializer();
        shop = shopInitializer.initializeShop();
        goods = shop.getGoods();
        user = new User();
    }

    public void grabItem(SportEquipment equipment, User user) {
        Integer amount = goods.get(equipment);
        if (user.getAmountRentedItems() < MAX_AMOUNT_OF_RENT_ITEMS && amount > 0) {
            goods.put(equipment, amount - 1);
            RentUnit rentUnit = new RentUnit();
            rentUnit.setUser(user);
            Map<SportEquipment, Integer> rentedUnit = new HashMap<SportEquipment, Integer>();
            rentedUnit.put(equipment, 1);
            rentUnit.setUnits(rentedUnit);
            shop.getRentUnits().add(rentUnit);


        } else {
            System.out.println("There is no item");
        }

    }
}
