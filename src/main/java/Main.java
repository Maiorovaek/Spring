import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import test.Animal;
import test.configuration.AnnotationConfiguration;
import test.dto.Food;
import test.dto.FoodType;
import test.event.ZooEvent;
import test.service.ZooService;

import java.time.LocalDateTime;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        ApplicationContext context = getAnnotationContext();
        feedAnimal(context);
    }

    public static void feedAnimal(ApplicationContext context) {
        ZooService service = context.getBean(ZooService.class);
        Food food = new Food();
        food.setFoodType(FoodType.WORMS);
        food.setExpirationDate(LocalDateTime.now().plusHours(2));
        List<Animal> angryAnimals = service.feed(food);
        if (!angryAnimals.isEmpty()) {
            eventAngryAnimals(context, angryAnimals);
        }
    }

    public static ApplicationContext getAnnotationContext() {
        return new AnnotationConfigApplicationContext(AnnotationConfiguration.class);
    }

    private static void eventAngryAnimals(ApplicationContext context, List<Animal> angryAnimals) {
        ZooEvent zooEvent = new ZooEvent(angryAnimals, "Angry animals in zoo");
        context.publishEvent(zooEvent);
    }
}