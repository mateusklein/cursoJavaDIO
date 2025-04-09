package br.com.dio;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.time.LocalDate;

public record Box(long amount, LocalDate validate, BigDecimal price) {
    public BigDecimal unitAmount() {
        return price().divide(new BigDecimal(amount()), RoundingMode.CEILING);
    }

}
