package amirka.u5w1d1.runners;

import amirka.u5w1d1.entities.*;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;


@Component
@Slf4j
public class Runner implements CommandLineRunner {
    //    private static final Logger logger = LoggerFactory.getLogger(Runner.class);
    @Autowired
    private Drink water;
    @Autowired
    private Pizza doubleCheese;
    @Autowired
    private Drink lemonade;
    @Autowired
    private Menu menu;
    @Autowired
    private Pizza margherita;
    @Value("${cover.charge}")
    private double coverCharge;

    @Override
    public void run(String... args) throws Exception {

        menu.printMenu();

        Table table = new Table(1, 4);

        Order order = new Order(1, table, 2, coverCharge);

        Table table1 = new Table(2, 6);

        Order order1 = new Order(2, table1, 5, coverCharge);

        order.addPizza(margherita);
        order.addPizza(margherita);
        order.addDrink(water);
        order.addDrink(water);
        order1.addPizza(doubleCheese);
        order1.addPizza(margherita);
        order1.addDrink(lemonade);
        order1.addDrink(lemonade);
        order1.addDrink(water);
        System.out.println("\n");
        log.info(order.toString());
        System.out.println("\n");
        log.info((order1.toString()));
    }

}
