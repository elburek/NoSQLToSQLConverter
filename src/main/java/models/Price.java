package models;

import lombok.Data;

import java.math.BigDecimal;

@Data
public class Price {
    BigDecimal value;
    Currency currency;

    public enum Currency {
        GB,
        USD,
        PLN,
        EURO
    }
}
