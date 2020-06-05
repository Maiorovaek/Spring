package test;

import test.dto.Food;

public interface Animal {
    void voice();

    boolean eat(Food food);

    boolean isAngry();
}
