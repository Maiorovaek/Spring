package test;

import org.springframework.stereotype.Component;
import test.dto.Food;
import test.dto.FoodType;

import java.util.ArrayList;
import java.util.List;

@Component
public class Fish implements Animal {
    private boolean angry = true;

    @Override
    public void voice() {
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
        List<FoodType> foodTypes = new ArrayList<>();
        foodTypes.add(FoodType.WORMS);
        return foodTypes;
    }
}
