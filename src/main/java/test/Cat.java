package test;

import org.springframework.stereotype.Component;
import test.dto.Food;

@Component
public class Cat implements Animal {
    private boolean angry = true;

    public void voice() {
        System.out.println("mi");
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
