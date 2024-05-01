package hiber;

import hiber.config.AppConfig;
import hiber.model.Car;
import hiber.model.User;
import hiber.service.UserService;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.sql.SQLException;
import java.util.Collections;
import java.util.List;

public class MainApp {
    public static void main(String[] args) throws SQLException {
        AnnotationConfigApplicationContext context =
                new AnnotationConfigApplicationContext(AppConfig.class);

        UserService userService = context.getBean(UserService.class);

        userService.add(new User("Just", "Ivan", "Ivan@mail.ru",
                new Car("VAZ_NE_VEDRO", 2106)));
        userService.add(new User("Alexey", "Ovsyannikov", "Alex@mail.ru",
                new Car("MAZDA", 6)));
        userService.add(new User("Robert", "Robertov", "Rob@mail.ru",
                new Car("RENAULT", 5)));
        userService.add(new User("Michael", "Schumaher", "Mik@mail.ru",
                new Car("BMW", 4)));


        List<User> use = userService.listUsers();
        for (User user : use) {
            System.out.println("Id = " + user.getId());
            System.out.println("First Name = " + user.getFirstName());
            System.out.println("Last Name = " + user.getLastName());
            System.out.println("Email = " + user.getEmail());
            System.out.println("Model car = " + user.getCar().getModel());
            System.out.println("Number series = " + user.getCar().getModel());

            System.out.println();
        }
       List<User> users = userService.getUserByCarAndModel("MAZDA", 6);
      for (User user : users) {
        System.out.println("Id = "+user.getId());
        System.out.println("First Name = "+user.getFirstName());
        System.out.println("Last Name = "+user.getLastName());
        System.out.println("Email = "+user.getEmail());
         System.out.println(user.getCar().toString());
        }
        context.close();
    }
}
