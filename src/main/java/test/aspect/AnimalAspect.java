package test.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;
import test.dto.Food;
import test.dto.FoodType;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Objects;

@Aspect
@Component
public class AnimalAspect {

    @Pointcut("execution(* test.Animal.eat(..))")
    public void eatPoint() {
    }

    @Pointcut("within(test.Cat)")
    public void catPoint() {
    }

    @Pointcut("within(test.Dog)")
    public void dogPoint() {
    }

    @Pointcut("within(test.Fox)")
    public void foxPoint() {
    }

    @Pointcut("within(test.Fish)")
    public void fishPoint() {
    }

    public Object eatAroundGeneral(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {
        String target = proceedingJoinPoint.getTarget().getClass().toString();


        System.out.println(target + " start eat");
        try {
            Object result = proceedingJoinPoint.proceed();
            System.out.println(target + " eat success");
            System.out.println(target + " end eat");
            return result;
        } catch (Throwable e) {
            System.out.println(target + " eat failed: " + e.getMessage());
            throw e;
        }
    }

    @Around(value = "eatPoint() && args(food) && fishPoint()")
    public Object validateEatForFish(ProceedingJoinPoint proceedingJoinPoint, Food food) throws Throwable {
        if (LocalDateTime.now().isAfter(food.getExpirationDate())) {
            return false;
        }
        if (Objects.equals(food.getFoodType(), FoodType.MILK)
                || Objects.equals(food.getFoodType(), FoodType.FISH)
                || Objects.equals(food.getFoodType(), FoodType.MEAT)) {
            return false;
        }
        return eatAroundGeneral(proceedingJoinPoint);
    }

    @Around(value = "eatPoint() && args(food) && catPoint()")
    public Object validateEatForCat(ProceedingJoinPoint proceedingJoinPoint, Food food) throws Throwable {
        if (LocalDateTime.now().isAfter(food.getExpirationDate())) {
            return false;
        }
        if ((Objects.equals(food.getFoodType(), FoodType.WORMS))) {
            return false;
        }
        return eatAroundGeneral(proceedingJoinPoint);
    }

    @Around(value = "eatPoint() && args(food) && foxPoint()")
    public Object validateEatForFox(ProceedingJoinPoint proceedingJoinPoint, Food food) throws Throwable {
        if (LocalDateTime.now().isAfter(food.getExpirationDate())) {
            return false;
        }
        if (Objects.equals(food.getFoodType(), FoodType.WORMS)
                || Objects.equals(food.getFoodType(), FoodType.MILK)) {
            return false;
        }
        return eatAroundGeneral(proceedingJoinPoint);
    }

    @Around(value = "eatPoint() && args(food) && dogPoint()")
    public Object validateEatForDog(ProceedingJoinPoint proceedingJoinPoint, Food food) throws Throwable {
        if (LocalDateTime.now().isAfter(food.getExpirationDate())) {
            return false;
        }
        if (Objects.equals(food.getFoodType(), FoodType.WORMS)
                || Objects.equals(food.getFoodType(), FoodType.MILK)
                || Objects.equals(food.getFoodType(), FoodType.FISH)) {
            return false;
        }
        return eatAroundGeneral(proceedingJoinPoint);
    }
}