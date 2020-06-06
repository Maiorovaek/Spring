package test;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
import test.dto.Food;
import test.dto.FoodType;

import java.util.ArrayList;
import java.util.List;

import static org.springframework.beans.factory.config.BeanDefinition.SCOPE_PROTOTYPE;

@Component
@Scope(value = SCOPE_PROTOTYPE)
public class Dog implements Animal {
    private boolean angry = true;

    public void voice() {
        System.out.println("gav");
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
        foodTypes.add(FoodType.MEAT);
        return foodTypes;
    }
}
