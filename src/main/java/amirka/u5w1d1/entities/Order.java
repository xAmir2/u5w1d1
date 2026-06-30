package amirka.u5w1d1.entities;

import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

public class Order {
    private int orderNumber;
    private OrderStatus status;
    private int seats;
    private LocalTime orderTime;
    private Table table;

    private List<Pizza> pizzas = new ArrayList<>();
    private List<Drink> drinks = new ArrayList<>();

    private double coverCharge;

    public Order(int orderNumber, Table table, int seats, double coverCharge) {

        this.orderNumber = orderNumber;
        this.table = table;
        this.seats = seats;
        this.coverCharge = coverCharge;

        status = Math.random() < 0.5
                ? OrderStatus.IN_PROGRESS
                : OrderStatus.READY;
        orderTime = LocalTime.now();

        table.setStatus(TableStatus.TAKEN);
    }

    public void addPizza(Pizza pizza) {
        pizzas.add(pizza);
    }

    public void addDrink(Drink drink) {
        drinks.add(drink);
    }

    public double getTotal() {

        double total = seats * coverCharge;

        for (Pizza pizza : pizzas) {
            total += pizza.getPrice();
        }

        for (Drink drink : drinks) {
            total += drink.getPrice();
        }

        return total;
    }

    @Override
    public String toString() {

        return "Order number: " + orderNumber +
                "\nTable: " + table.getTableNumber() +
                "\nOrder Status: " + status +
                "\nSeats: " + seats +
                "\nTime: " + orderTime +
                "\nPizzas: " + pizzas +
                "\nDrinks: " + drinks +
                "\nTotal: €" + String.format("%.2f", getTotal());
    }
}
