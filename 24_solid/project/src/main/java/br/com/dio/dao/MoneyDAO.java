package br.com.dio.dao;

import java.math.BigDecimal;

public class MoneyDAO {
    private BigDecimal money = BigDecimal.ZERO;

    public BigDecimal add(final BigDecimal money) {
        this.money = this.money.add(money);
        return money;
    }

    public BigDecimal getMoney() {
        return money;
    }
}
