package test.event;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Service;
import test.Animal;
import test.dto.Food;
import test.dto.FoodType;
import test.service.ZooServiceImpl;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Service
public class EventService {
    private final ZooServiceImpl zooService;

    @Autowired
    public EventService(ZooServiceImpl zooService) {
        this.zooService = zooService;
    }

    @EventListener(ZooEvent.class)
    public void onApplicationEvent(ZooEvent zooEvent) {
        System.out.println(zooEvent.getMessage());
        List<FoodType> foodTypes = new ArrayList<>(Arrays.asList(FoodType.values()));
        List<Animal> angryAnimals = (List<Animal>) zooEvent.getSource();
        for (Animal angryAnimal : angryAnimals) {
            if (angryAnimal.isAngry()) {
                for (FoodType foodType : foodTypes) {
                    System.out.println("========" + foodType + " ========");
                    Food food = new Food();
                    food.setFoodType(foodType);
                    food.setExpirationDate(LocalDateTime.now().plusHours(5));
                    zooService.feed(food);
                }
            }
        }
    }
}
