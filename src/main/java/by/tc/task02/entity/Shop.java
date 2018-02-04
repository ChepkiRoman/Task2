package by.tc.task02.entity;


import java.util.List;
import java.util.Map;

public class Shop {
    private Map<SportEquipment, Integer> goods;

    private  List<RentUnit> rentUnits;

    public Map<SportEquipment, Integer> getGoods() {
        return goods;
    }

    public void setGoods(Map<SportEquipment, Integer> goods) {
        this.goods = goods;
    }

    public  List<RentUnit> getRentUnits() {
        return rentUnits;
    }

    public void setRentUnits(List<RentUnit> rentUnits) {
        this.rentUnits = rentUnits;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Shop)) return false;

        Shop shop = (Shop) o;

        if (getGoods() != null ? !getGoods().equals(shop.getGoods()) : shop.getGoods() != null) return false;
        return getRentUnits() != null ? getRentUnits().equals(shop.getRentUnits()) : shop.getRentUnits() == null;
    }

    @Override
    public int hashCode() {
        int result = getGoods() != null ? getGoods().hashCode() : 0;
        result = 31 * result + (getRentUnits() != null ? getRentUnits().hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "Shop{" +
                "goods=" + goods +
                ", rentUnits=" + rentUnits +
                '}';
    }
}
