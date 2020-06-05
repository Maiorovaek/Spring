package test;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class Zoo {
    private final Animal dog;
    private final Animal cat;
    private final String name;
    private final List<Animal> animals;

    @Autowired
    public Zoo(
            Animal dog,
            Animal cat,
            @Value("${zoo.name}") String name,
            List<Animal> animals
    ) {
        this.dog = dog;
        this.cat = cat;
        this.name = name;
        this.animals = animals;
    }

    public Animal getDog() {
        return dog;
    }

    public Animal getCat() {
        return cat;
    }

    public String getName() {
        return name;
    }

    public List<Animal> getAnimals() {
        return animals;
    }

}
