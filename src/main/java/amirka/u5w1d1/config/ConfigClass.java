package amirka.u5w1d1.config;

import amirka.u5w1d1.entities.Drink;
import amirka.u5w1d1.entities.Menu;
import amirka.u5w1d1.entities.Pizza;
import amirka.u5w1d1.entities.Topping;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.List;

@Configuration
public class ConfigClass {

    @Bean
    public Topping tomato() {
        return new Topping("Tomato", 0.50, 18);
    }

    @Bean
    public Topping cheese() {
        return new Topping("Cheese", 0.92, 69);
    }

    @Bean
    public Topping ham() {
        return new Topping("Ham", 0.99, 35);
    }

    @Bean
    Topping onion() {
        return new Topping("Onions", 0.69, 22);
    }

    @Bean
    public Topping pineapple() {
        return new Topping("Pineapple", 0.79, 24);
    }

    @Bean
    public Topping salami() {
        return new Topping("Salami", 0.99, 86);
    }

    @Bean
    public Drink lemonade() {
        return new Drink("Lemonade (0.33L)", 1.29, 128);
    }

    @Bean
    public Drink water() {
        return new Drink("Water (0.5L)", 1.29, 0);
    }

    @Bean
    public Drink wine() {
        return new Drink("Wine (0.75L, 13%)", 7.49, 607);
    }

    @Bean
    public Pizza margherita(Topping tomato, Topping cheese) {
        Pizza margherita = new Pizza("Pizza Margherita");
        margherita.addTopping(tomato);
        margherita.addTopping(cheese);
        return margherita;
    }

    @Bean
    public Pizza hawaiian(Topping tomato, Topping cheese, Topping ham, Topping pineapple) {
        Pizza hawaiian = new Pizza("Hawaiian Pizza");
        hawaiian.addTopping(tomato);
        hawaiian.addTopping(cheese);
        hawaiian.addTopping(ham);
        hawaiian.addTopping(pineapple);
        return hawaiian;
    }

    @Bean
    public Pizza salamiPizza(Topping tomato, Topping cheese, Topping salami) {
        Pizza salamis = new Pizza("Salami Pizza");
        salamis.addTopping(tomato);
        salamis.addTopping(cheese);
        salamis.addTopping(salami);
        return salamis;
    }

    @Bean
    public Pizza doubleCheese(Topping tomato, Topping cheese) {
        Pizza doubleHam = new Pizza("Double Cheese Pizza");
        doubleHam.addTopping(tomato);
        doubleHam.addTopping(cheese);
        doubleHam.addTopping(cheese);
        return doubleHam;
    }

    @Bean
    public Menu menu(
            Pizza margherita,
            Pizza hawaiian,
            Pizza salamiPizza,
            Pizza doubleCheese,
            Topping tomato,
            Topping cheese,
            Topping ham,
            Topping pineapple,
            Topping salami,
            Topping onion,
            Drink water,
            Drink lemonade,
            Drink wine
    ) {
        return new Menu(
                List.of(margherita, hawaiian, salamiPizza, doubleCheese),
                List.of(tomato, cheese, ham, pineapple, salami, onion),
                List.of(water, lemonade, wine)
        );
    }
}
