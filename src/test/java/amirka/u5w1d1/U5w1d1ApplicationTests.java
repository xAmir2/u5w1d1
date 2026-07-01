package amirka.u5w1d1;

import amirka.u5w1d1.entities.*;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
class U5w1d1ApplicationTests {

    @Autowired
    private Topping tomato;

    @Autowired
    private Topping cheese;

    @Value("${cover.charge}")
    private double coverCharge;

    @Test
    void contextLoads() {
    }

    @Test
    @DisplayName("A pizza without toppings costs 4.99€")
    void testPizzaBasePrice() {
        Pizza pizza = new Pizza("Plain");
        assertEquals(4.99, pizza.getPrice());
    }

    @Test
    @DisplayName("Price increase when adding toppings")
    void testPizzaWithToppings() {
        Pizza pizza = new Pizza("Margherita");
        pizza.addTopping(tomato);
        pizza.addTopping(cheese);

        assertEquals(6.18, pizza.getPrice());
    }

    @Test
    @DisplayName("Total pizza calories must be the sum of base calories plus toppings added")
    void testPizzaCalories() {
        Pizza pizza = new Pizza("Margherita");

        pizza.addTopping(tomato);
        pizza.addTopping(cheese);

        assertEquals(1110, pizza.getCalories());
    }

    @Test
    @DisplayName("Creating an order changes the table status to TAKEN")
    void testTableStatus() {
        Table table = new Table(1, 4);
        Order order = new Order(1, table, 2, 2.5);

        assertEquals(TableStatus.TAKEN, table.getStatus());
    }

    @ParameterizedTest
    @CsvSource({"1", "2", "4", "6"})
    @DisplayName("Cover charge is fixed regardless of how many seats")
    void testCoverCharge(int seats) {

        Table table = new Table(1, 6);

        Order order = new Order(1, table, seats, coverCharge);

        assertEquals(2.5, order.getCoverCharge());
    }

}
