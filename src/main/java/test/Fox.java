package test;

import org.springframework.stereotype.Component;
import test.dto.Food;
import test.dto.FoodType;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Component
public class Fox implements Animal {
    private boolean angry = true;

    @Override
    public void voice() {
        System.out.println("frr");
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
        return new ArrayList<>(Arrays.asList(FoodType.FISH, FoodType.MEAT));
    }
}
