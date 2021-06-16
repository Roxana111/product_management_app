package md.tekwill.entity.product;

import java.time.LocalDate;
import java.util.Objects;

public class Food extends Product {
    private static final double DISCOUNT = 0.8;
    private FoodCategory category;

    public Food(String name, double price, LocalDate bestBefore, FoodCategory category) {
        super(name, price, bestBefore);
        this.category = category;
    }

    public FoodCategory getCategory() {
        return category;
    }

    public void setCategory(FoodCategory category) {
        this.category = category;
    }

    @Override
    public double getPriceOnBill() {


     return (bestBefore.equals(LocalDate.now().plusDays(3)) ||bestBefore.equals(LocalDate.now().plusDays(2))|| bestBefore.equals(LocalDate.now().plusDays(1))||bestBefore.equals(LocalDate.now()) ) ? price * DISCOUNT : price;

    }

    @Override
    public String getPrintText() {
        return" [" + id + "]" + "FOOD:"  + name + " | " + price + " | " + bestBefore + " | " +category;
    }


    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        if (!super.equals(obj)) return false;
        Food food = (Food) obj;
        return Double.compare(food.DISCOUNT, DISCOUNT) == 0 && Objects.equals(category,food.category );
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), DISCOUNT, category);
    }

    @Override
    public String toString(){

        return this.getPrintText();

    }
}
