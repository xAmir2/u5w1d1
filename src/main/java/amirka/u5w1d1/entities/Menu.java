package amirka.u5w1d1.entities;

import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class Menu {
    private List<Pizza> pizzas;
    private List<Topping> toppings;
    private List<Drink> drinks;

    public Menu(List<Pizza> pizzas, List<Topping> toppings, List<Drink> drinks) {
        this.pizzas = pizzas;
        this.toppings = toppings;
        this.drinks = drinks;
    }

    public void printMenu() {

        System.out.println("----- PIZZAS -----");

        for (Pizza pizza : pizzas) {
            System.out.println(pizza);
        }

        System.out.println();

        System.out.println("----- TOPPINGS -----");

        for (Topping topping : toppings) {
            System.out.println(topping);
        }

        System.out.println();

        System.out.println("----- DRINKS -----");

        for (Drink drink : drinks) {
            System.out.println(drink);
        }
    }
}
