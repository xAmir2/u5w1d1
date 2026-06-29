package amirka.u5w1d1;

import amirka.u5w1d1.config.ConfigClass;
import amirka.u5w1d1.entities.Menu;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

@SpringBootApplication
public class U5w1d1Application {

    public static void main(String[] args) {
        SpringApplication.run(U5w1d1Application.class, args);

        AnnotationConfigApplicationContext context =
                new AnnotationConfigApplicationContext(ConfigClass.class);

        Menu menu = context.getBean(Menu.class);

        menu.printMenu();

        context.close();
    }

}
