package test.dto;

import java.time.LocalDateTime;

public class Food {
    private String foodName;
    private LocalDateTime expirationDate;

    public String getFoodName() {
        return foodName;
    }

    public LocalDateTime getExpirationDate() {
        return expirationDate;
    }

    public void setFoodName(String foodName) {
        this.foodName = foodName;
    }

    public void setExpirationDate(LocalDateTime expirationDate) {
        this.expirationDate = expirationDate;
    }
}
