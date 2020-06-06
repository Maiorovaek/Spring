package test.service;

import test.Animal;
import test.dto.Food;

import java.util.List;

public interface ZooService {
    List<Animal> feed(Food food);
}
