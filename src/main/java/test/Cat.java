package test;

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
        if (isAngry()) {
            setAngry(false);
        }
        return true;
    }

    @Override
    public boolean isAngry() {
        return angry;
    }

    public void setAngry(boolean angry) {
        this.angry = angry;
    }

    @Override
    public List<FoodType> getPossibleFeedTypes() {
        return Arrays.asList(FoodType.MEAT, FoodType.MILK, FoodType.FISH);
    }
}
