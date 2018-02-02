package by.tc.task02.entity;


public class SportEquipment {
    private Category category;
    private String title;
    private int price;


    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof SportEquipment)) return false;

        SportEquipment that = (SportEquipment) o;

        if (getPrice() != that.getPrice()) return false;
        if (getCategory() != that.getCategory()) return false;
        return getTitle() != null ? getTitle().equals(that.getTitle()) : that.getTitle() == null;
    }

    @Override
    public int hashCode() {
        int result = getCategory() != null ? getCategory().hashCode() : 0;
        result = 31 * result + (getTitle() != null ? getTitle().hashCode() : 0);
        result = 31 * result + getPrice();
        return result;
    }

    @Override
    public String toString() {
        return "SportEquipment{" +
                "category=" + category +
                ", title='" + title + '\'' +
                ", price=" + price +
                '}';
    }
}
