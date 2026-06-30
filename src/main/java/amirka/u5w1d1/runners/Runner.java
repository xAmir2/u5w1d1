package amirka.u5w1d1.runners;

import amirka.u5w1d1.entities.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;


@Component
public class Runner implements CommandLineRunner {
    private static final Logger logger = LoggerFactory.getLogger(Runner.class);
    @Autowired
    Menu menu;
    @Autowired
    Pizza margherita;
    @Autowired
    Drink water;
    @Autowired
    Pizza doubleCheese;
    @Autowired
    Drink lemonade;
    @Value("${cover.charge}")
    private double coverCharge;

    @Override
    public void run(String... args) {

        menu.printMenu();

        Table table = new Table(1, 4);

        Order order = new Order(1, table, 2, coverCharge);

        Table table1 = new Table(2, 6);

        Order order1 = new Order(2, table1, 5, coverCharge);

        order.addPizza(margherita);
        order.addDrink(water);
        order1.addPizza(doubleCheese);
        order1.addDrink(lemonade);
        System.out.println("\n");
        logger.info(order.toString());
        System.out.println("\n");
        logger.info((order1.toString()));
    }

}
