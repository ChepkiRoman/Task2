package by.tc.task02.main;


import by.tc.task02.entity.Category;
import by.tc.task02.entity.Shop;
import by.tc.task02.entity.SportEquipment;
import by.tc.task02.entity.User;
import by.tc.task02.service.Finder;
import by.tc.task02.service.ShopInitializer;

import java.io.IOException;

public class Main {


    public static void main(String[] args) throws IOException {
        ShopInitializer shopInitializer = new ShopInitializer();

        Shop shop =  shopInitializer.initializeShop();
        System.out.println(shop.getGoods());

        User user = new User();
        user.setId(1);
        user.setName("Roman");
        Category category = Category.TRAINERS;

        SportEquipment equipment;
        equipment = Finder.find(category,"Back",210);
        System.out.println(equipment.getCategory()+" " + equipment.getPrice());

        //RentItemService service = new RentItemService();
        //service.grabItem();



    }


}
