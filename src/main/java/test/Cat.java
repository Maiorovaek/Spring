package test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.stereotype.Component;
import test.dto.Food;
import test.dto.FoodType;

@Component
public class Cat implements Animal {
    private boolean angry = true;

    public void voice() {
        System.out.println("mi");
    }

    @Override
    public boolean eat(Food food) {
        if(getPossibleFeedTypes().contains(food.getFoodType())){
            angry = false;
        }
        return isAngry();
    }

    @Override
    public boolean isAngry() {
        return angry;
    }

    @Override
    public List<FoodType> getPossibleFeedTypes() {
        return new ArrayList<>(Arrays.asList(FoodType.MEAT, FoodType.MILK, FoodType.FISH));
    }
}
