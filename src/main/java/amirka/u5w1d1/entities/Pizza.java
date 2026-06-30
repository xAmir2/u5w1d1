package amirka.u5w1d1.entities;

import java.util.ArrayList;
import java.util.List;

public class Pizza {
    private String name;
    private List<Topping> toppings = new ArrayList<>();

    public Pizza(String name) {
        this.name = name;
    }

    public void addTopping(Topping topping) {
        toppings.add(topping);
    }


    public double getPrice() {
        double totalPrice = 4.99;

        for (Topping t : toppings) {
            totalPrice += t.getPrice();
        }
        return totalPrice;
    }

    public int getCalories() {
        int totalCalories = 1000;

        for (Topping t : toppings) {
            totalCalories += t.getCalories();
        }

        return totalCalories;
    }

    @Override
    public String toString() {
        return "Pizza: " +
                name +
                ", toppings = " + toppings.stream()
                .map(Topping::getName)
                .toList() +
                ", calories = " + getCalories() +
                ", price= " + String.format("%.2f", getPrice());
    }
}
