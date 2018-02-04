package by.tc.task02.entity;


import java.util.Map;

public class RentUnit {
    private Map<SportEquipment, Integer> units;

    private User user;

    public Map<SportEquipment, Integer> getUnits() {
        return units;
    }

    public void setUnits(Map<SportEquipment, Integer> units) {
        this.units = units;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof RentUnit)) return false;

        RentUnit rentUnit = (RentUnit) o;

        if (getUnits() != null ? !getUnits().equals(rentUnit.getUnits()) : rentUnit.getUnits() != null) return false;
        return getUser() != null ? getUser().equals(rentUnit.getUser()) : rentUnit.getUser() == null;
    }

    @Override
    public int hashCode() {
        int result = getUnits() != null ? getUnits().hashCode() : 0;
        result = 31 * result + (getUser() != null ? getUser().hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "RentUnit{" +
                "units=" + units +
                ", user=" + user +
                '}';
    }
}
