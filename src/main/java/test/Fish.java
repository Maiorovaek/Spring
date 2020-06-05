package test;

import org.springframework.stereotype.Component;
import test.dto.Food;

@Component
public class Fish implements Animal {
    private boolean angry = true;

    @Override
    public void voice() {
    }

    @Override
    public boolean eat(Food food) {
        angry = false;
        return isAngry();
    }

    @Override
    public boolean isAngry() {
        return angry;
    }
}
