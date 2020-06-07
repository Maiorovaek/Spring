package test.aspect;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;
import test.Animal;
import test.dto.Food;

import java.time.LocalDateTime;


@Aspect
@Component
public class AnimalAspect {

    @Pointcut("execution(* test.Animal.eat(..))")
    public void eatPoint() {
    }

    @Around(value = "eatPoint() && args(food)")
    public Object validateEatForAnimals(ProceedingJoinPoint proceedingJoinPoint, Food food) throws Throwable {
        boolean isHungry = false;
        if (LocalDateTime.now().isAfter(food.getExpirationDate())) {
            return true;
        }

        String target = proceedingJoinPoint.getTarget().getClass().toString();
        Animal animal = (Animal) proceedingJoinPoint.getTarget();
        if (animal.getPossibleFeedTypes().contains(food.getFoodType())) {
            System.out.println(target + " start eat");
            try {
                isHungry = (boolean) proceedingJoinPoint.proceed();
                System.out.println(target + " eat success");
                System.out.println(target + " end eat");
            } catch (Throwable e) {
                System.out.println(target + " eat failed: " + e.getMessage());
                throw e;
            }
        }
        return isHungry;
    }
}