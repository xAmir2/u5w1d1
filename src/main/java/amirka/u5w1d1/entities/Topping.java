package amirka.u5w1d1.entities;

public class Topping {
    private String name;
    private double price;
    private int calories;

    public Topping(String name, double price, int calories) {
        this.name = name;
        this.price = price;
        this.calories = calories;
    }

    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }

    public int getCalories() {
        return calories;
    }

    @Override
    public String toString() {
        return "Topping: " +
                "name = '" + name + '\'' +
                ", price = " + price +
                ", calories = " + calories;
    }
}
