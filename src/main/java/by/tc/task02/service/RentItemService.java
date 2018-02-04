package by.tc.task02.service;

import by.tc.task02.dao.impl.FileWorkerImpl;
import by.tc.task02.entity.RentUnit;
import by.tc.task02.entity.Shop;
import by.tc.task02.entity.SportEquipment;
import by.tc.task02.entity.User;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class RentItemService {
    private static final int MAX_AMOUNT_OF_RENT_ITEMS = 3;
    Shop shop = new Shop();
    ShopInitializer shopInitializer = new ShopInitializer();
    FileWorkerImpl fileWorker = new FileWorkerImpl("shop");
    Map<SportEquipment, Integer> goods;

    public RentItemService() throws IOException {
        shop = shopInitializer.initializeShop();
        goods = shop.getGoods();
    }


    public void rentEquipment(SportEquipment equipment, User user) throws IOException {
        if (getRentedUnitsCountByUser(user) < MAX_AMOUNT_OF_RENT_ITEMS) {
            Integer amount = goods.get(equipment);
            rent(equipment, user, amount);
        } else {
            throw new ExceptionInInitializerError("more then three");
        }
    }

    private RentUnit getRentUnitByUser(User user) {
        for (RentUnit unit : shop.getRentUnits()) {
            if (unit.getUser().equals(user)) {
                return unit;

            }
        }
        return null;
    }

    private void rent(SportEquipment equipment, User user, Integer amount) throws IOException {
        if (amount > 0) {
            goods.put(equipment, amount - 1);
            RentUnit userRentUnit = getRentUnitByUser(user);
            if (userRentUnit == null) {
                userRentUnit = new RentUnit();
                userRentUnit.setUser(user);
                Map<SportEquipment, Integer> units = new HashMap<SportEquipment, Integer>();
                units.put(equipment, 1);
                userRentUnit.setUnits(units);
                shop.getRentUnits().add(userRentUnit);
                List<RentUnit> rentUnitsList = shop.getRentUnits();
                fileWorker.writeInFile("rent", rentUnitsList);
            } else {
                Map<SportEquipment, Integer> units = userRentUnit.getUnits();
                if (units.containsKey(equipment)) {
                    units.put(equipment, units.get(equipment) + 1);

                } else {
                    units.put(equipment, 1);
                }
            }
        } else {
            System.out.println(equipment.getTitle() + " is not available");
        }
    }

    private int getRentedUnitsCountByUser(User user) {
        RentUnit userRentUnit = getRentUnitByUser(user);
        if (userRentUnit == null) {
            return 0;
        }
        int rentedUnits = 0;
        for (Integer value : userRentUnit.getUnits().values()) {
            rentedUnits += value;
        }
        return rentedUnits;
    }

}
